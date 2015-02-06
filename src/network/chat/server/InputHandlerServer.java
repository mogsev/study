package network.chat.server;

import network.chat.Client;
import network.chat.Message;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.Socket;
import java.net.SocketException;

/**
 * Created by zhenya on 03.02.2015.
 */
public class InputHandlerServer implements Runnable {

    private final Socket socket;
    private Client client;

    /**
     * Design handler
     * @param socket
     */
    public InputHandlerServer(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            try {
                //Create input stream
                final ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                Message info = (Message) inputStream.readObject();
                client = info.getClient();
                final ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                ServerChat.cacheClient.put(client, outputStream);
                while (socket.isConnected()) {
                    //read message
                    if (outputStream != null) {
                        Object message = inputStream.readObject();
                        System.out.println(message.toString());
                        ServerChat.inputMessages.add(message);
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } catch (BindException ex) {
                System.out.println("Server is running");
                ex.printStackTrace();
            } catch (SocketException ex) {
                System.out.println("Connection reset by client");
                ex.printStackTrace();
            } catch (EOFException ex) {
                System.out.println("Close InputStream");
                ex.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                //remove client
                ServerChat.cacheClient.remove(client);
                //Close socket
                socket.close();
            }
        }  catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
