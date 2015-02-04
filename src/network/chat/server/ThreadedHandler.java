package network.chat.server;

import network.chat.Client;
import network.chat.Message;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 * Created by zhenya on 03.02.2015.
 */
public class ThreadedHandler implements Runnable {

    private Socket socket;
    private Client client;

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

                    Object message = inputStream.readObject();
                    if (message instanceof Client) {
                        client = (Client) message;
                        CacheSocket.addConnection(client, socket);
                        ArrayList<Client> clients = CacheSocket.getListClient();
                        for (Client cl : clients) {
                            outputStream.writeObject(cl);
                            System.out.println(cl.toString());
                        }
                    } else if (message instanceof Message) {
                        System.out.println(message.toString());
                        outputStream.writeObject(message);
                        outputStream.flush();
                    }

                }
            } catch (SocketException ex) {
                System.out.println("Connection reset");
            } catch (EOFException ex) {
                System.out.println("Close InputStream");
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                //Remove client from cache
                CacheSocket.removeConnection(client);
                //Close socket
                socket.close();
            }
        }  catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
