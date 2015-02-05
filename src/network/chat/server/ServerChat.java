package network.chat.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by zhenya on 02.02.2015.
 */
public class ServerChat extends Thread {

    private Socket socket;
    public static CacheMessage cacheMessage = new CacheMessage();

    public ServerChat() {
    }

    @Override
    public void run() {
        //Create server socket
        try {
            ServerSocket serverSocket = new ServerSocket(ConfigServer.serverPort);
            int numberConnections = 1; //number connection
            //Begin listening connections
            while (true) {
                socket = serverSocket.accept();
                if (socket.isConnected()) {
                    System.out.println("Number connections: " + numberConnections);
                    socket.setKeepAlive(true);
                    Runnable socketThread = new ThreadedHandler(socket);
                    Thread thread = new Thread(socketThread);
                    thread.setDaemon(true);
                    thread.start();
                    numberConnections++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ServerChat serverChat = new ServerChat();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            while (true) {
                System.out.println("0 - Exit,\t 1 - Start server");
                System.out.println("Enter value:");
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
                                System.out.println("Server is running");
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
