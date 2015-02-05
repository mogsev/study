package network.chat.server;

import network.chat.Client;
import network.chat.Message;

import java.io.*;
import java.net.BindException;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 * Created by zhenya on 03.02.2015.
 */
public class ThreadedHandler implements Runnable {

    private final Socket socket;

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
                while (socket.isConnected()) {
                    //Create input stream
                    final ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                    //Create output stream
                    final ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                    //read message
                    Object message = inputStream.readObject();
                    System.out.println(message.toString());
                    outputStream.writeObject(message);
                    outputStream.flush();

                }
            } catch (BindException ex) {
                System.out.println("Server is running");
                ex.printStackTrace();
            } catch (SocketException ex) {
                System.out.println("Connection reset");
                ex.printStackTrace();
            } catch (EOFException ex) {
                System.out.println("Close InputStream");
                ex.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                //Close socket
                socket.close();
            }
        }  catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
