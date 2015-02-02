package net.chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

/**
 * Created by zhenya on 02.02.2015.
 */
public class ServerChat {
    public static void main(String[] args) {
        try {
            ServerSocket socketListener = new ServerSocket(ConfigServer.PORT);
            while (true) {
                Socket client = null;
                while (client == null) {
                    client = socketListener.accept();
                }
                new ClientThread(client);
            }
        } catch (SocketException ex) {
            System.err.println("Socket exception");
            ex.printStackTrace();
        } catch (IOException ex) {
            System.err.println("I/O exception");
            ex.printStackTrace();
        }
    }
}
