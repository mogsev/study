package network.chat.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by zhenya on 02.02.2015.
 */
public class ServerChat {

    public static void main(String[] args) {
        try {
            //Create server socket
            ServerSocket serverSocket = new ServerSocket(ConfigServer.serverPort);
            int i = 1; //number connection
            //Begin listening connections
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Num: " + i);
                Runnable socketThread = new ThreadedHandler(socket);
                Thread thread = new Thread(socketThread);
                thread.start();
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
