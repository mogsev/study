package network.chat.client;

import network.chat.Client;
import network.chat.Message;
import network.chat.SocketMessenger;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;

/**
 * Created by zhenya on 02.02.2015.
 */
public class ClientChat {

    private ArrayList<Client> listClients = new ArrayList<Client>();

    public static void main(String[] args) {
        try {
            //Create Client
            Client client = new Client("test", "test4  full name", InetAddress.getLocalHost().getHostAddress());
            //Create Socket
            final Socket socket = new Socket(ConfigClient.serverAddress, ConfigClient.serverPort);
            socket.setKeepAlive(true);
            //Create SocketMessenger
            SocketMessenger socketMessenger = new SocketMessenger(client, socket);


            //Create thread for input messages
            //Runnable inputHandler = new InputHandler(client, socket);
            //Thread thread = new Thread(inputHandler);
            //thread.setDaemon(true);
            //thread.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (socket.isConnected()) {
                String line = reader.readLine();
                if (line.equals("quit")) {
                    break;
                }
                if (socket.isConnected()) {
                    Message message = new Message("zhenya", line);
                    socketMessenger.sendMessage(message);
                }
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

