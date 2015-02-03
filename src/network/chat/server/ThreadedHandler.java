package network.chat.server;

import network.chat.Message;

import java.io.*;
import java.net.Socket;
import java.util.Objects;
import java.util.Scanner;

/**
 * Created by zhenya on 03.02.2015.
 */
public class ThreadedHandler implements Runnable {
    private Socket socket;

    /**
     * Design handler
     * @param socket
     */
    public ThreadedHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            try {
                final ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                //final ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                Message message = null;
                while (true) {
                    message = (Message) inputStream.readObject();
                    System.out.println("Echo: " + message.getMessage());
                }
                // Close Streams
                //inputStream.close();
                //outputStream.close();
            } catch (EOFException ex) {
                System.out.println("Close InputStream");
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                socket.close();
            }
        }  catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
