package network.chat.server;

import network.chat.Client;
import network.chat.Message;

import java.io.*;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Server chat
 * Created by zhenya on 02.02.2015.
 */
public class ServerChat extends Thread {

    private Socket socket;

    public static List outputMessages = Collections.synchronizedList(new ArrayList<Object>());
    public static List inputMessages = Collections.synchronizedList(new ArrayList<Object>());
    public static volatile ConcurrentHashMap<Client, ObjectOutputStream> cacheClient = new ConcurrentHashMap<Client, ObjectOutputStream>();

    public ServerChat() {
        initComponents();
    }

    private void initComponents() {
        //Create thread for clients list
        Thread listClients = new Thread(new ListClients());
        listClients.setDaemon(true);
        listClients.start();
    }

    @Override
    public void run() {
        //Create server socket
        try {
            ServerSocket serverSocket = new ServerSocket(ConfigServer.serverPort);
            int numberConnections = 1; //number connection

            //Create thread output handler
            Runnable outputHandler = new OutputHandler();
            Thread output = new Thread(outputHandler);
            output.setDaemon(true);
            output.start();

            //Begin listening connections
            while (true) {
                socket = serverSocket.accept();
                if (socket.isConnected()) {
                    System.out.println("Number connections: " + numberConnections);
                    socket.setKeepAlive(true);
                    //Create input handler client
                    Runnable inputHandlerServer = new InputHandlerServer(socket);
                    Thread input = new Thread(inputHandlerServer);
                    input.setDaemon(true);
                    input.start();
                    numberConnections++;
                }
            }
        } catch (BindException ex) {
            System.out.println("Address already in use");
            ex.printStackTrace();
            System.exit(1);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ServerChat serverChat = new ServerChat();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            while (true) {
                System.out.println("Enter value:\t0 - Exit,\t1 - Start server,\t2 - Send test message,\t3 - List clients");
                try {
                    Integer integer = Integer.parseInt(reader.readLine());
                    switch (integer) {
                        case 0:
                            System.exit(1);
                            break;
                        case 1:
                            if (serverChat.isAlive()) {
                                System.out.println("Server is running");
                            } else {
                                serverChat.start();
                                System.out.println("Server running...");
                            }
                            break;
                        case 2:
                            outputMessages.add(new Message(new Client("server"), "server test message"));
                            break;
                        case 3:
                            if (!cacheClient.isEmpty()) {
                                for (Map.Entry<Client, ObjectOutputStream> entry : cacheClient.entrySet()) {
                                    System.out.println(entry.getKey().toString());
                                }
                            }
                            break;
                        default:
                            System.out.println("Unknown command");
                            break;
                    }
                } catch (NumberFormatException ex) {
                    System.out.println("Exception... please enter number:");
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
