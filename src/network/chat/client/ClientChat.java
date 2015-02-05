package network.chat.client;

import network.chat.Client;
import network.chat.Message;
import network.chat.SocketMessenger;
import network.chat.server.*;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by zhenya on 02.02.2015.
 */
public class ClientChat {

    private static ArrayList<Client> listClients = new ArrayList<Client>();
    private static ArrayList<Message> inputMessages = new ArrayList<Message>();
    private static ArrayList<Message> outputMessages = new ArrayList<Message>();

    public ClientChat() {
        initComponents();
    }

    private void initComponents() {

    }

    public static void addInputMessage(Object message) {
        inputMessages.add((Message) message);
    }

    public static void addOutputMessage(Message message) {
        outputMessages.add(message);
    }

    public static Message getOutputMessage() {
        return outputMessages.remove(0);
    }

    public static boolean isEmptyOutputMessage() {
        return outputMessages.isEmpty();
    }

    public static void main(String[] args) {
        try {
            //Create Client
            final Client client = new Client("test3", "test4  full name", InetAddress.getLocalHost().getHostAddress());
            //Create Socket
            final Socket socket = new Socket(ConfigClient.serverAddress, ConfigClient.serverPort);
            socket.setKeepAlive(true);
            //Create SocketMessenger
            //SocketMessenger socketMessenger = new SocketMessenger(socket);

            //Create thread for input messages
            //Runnable inputHandler = new InputHandler(client, socket);
            //Thread threadInput = new Thread(inputHandler);
            //threadInput.setDaemon(true);
            //threadInput.start();

            Runnable outputHandler = new OutputHandler(socket);
            Thread threadOutput = new Thread(outputHandler);
            //threadOutput.setDaemon(true);
            threadOutput.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


            while (socket.isConnected()) {
                String line = reader.readLine();
                if (line.equals("quit")) {
                    break;
                }
                Message message = new Message(client, line);
                addOutputMessage(message);
                //socketMessenger.sendMessage(ClientChat.getOutputMessage());
                /**
                 if (socket.isConnected()) {
                 Message message = new Message(client, line);
                 socketMessenger.sendMessage(message);
                 }
                 */


            }
        } catch (SocketException ex) {
            System.out.println("Connection reset by peer: socket write error");
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

