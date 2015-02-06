package network.chat.client;

import network.chat.Client;
import network.chat.Message;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;

/**
 * Created by zhenya on 02.02.2015.
 */
public class ClientChat {

    private String login;
    private Client client;
    private Socket socket;

    private static ArrayList<Client> listClients = new ArrayList<Client>();
    private static ArrayList<Message> inputMessages = new ArrayList<Message>();
    private static ArrayList<Message> outputMessages = new ArrayList<Message>();

    public ClientChat(String login) {
        this.login = login;
        initComponents();
    }

    private void initComponents() {
        try {
            //Create Client
            client = new Client(login);
            //Create Socket
            socket = new Socket(ConfigClient.serverAddress, ConfigClient.serverPort);
            socket.setKeepAlive(true);

            //Create thread for output messages
            addOutputMessage(new Message(client));
            Runnable outputHandlerClient = new OutputHandlerClient(socket);
            Thread threadOutput = new Thread(outputHandlerClient);
            threadOutput.setDaemon(true);
            threadOutput.start();

            //Create thread for input messages
            Runnable inputHandlerClient = new InputHandlerClient(socket);
            Thread threadInput = new Thread(inputHandlerClient);
            threadInput.setDaemon(true);
            threadInput.start();

            //Input user messages
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            Message message = null;
            while (socket.isConnected()) {
                String line = reader.readLine();
                if (line.equals("quit")) {
                    break;
                }
                message = new Message(client, line);
                addOutputMessage(message);
            }
        } catch (SocketException ex) {
            System.out.println("Connection reset by peer: socket write error");
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized static void addInputMessage(Object message) {
        inputMessages.add((Message) message);
    }

    public synchronized static void addOutputMessage(Message message) {
        outputMessages.add(message);
    }

    public synchronized static Message getOutputMessage() {
        return outputMessages.remove(0);
    }

    public synchronized static boolean isEmptyOutputMessage() {
        return outputMessages.isEmpty();
    }

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Please input login:");
            String login = reader.readLine();
            new ClientChat(login);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

