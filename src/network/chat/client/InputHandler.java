package network.chat.client;

import network.chat.Client;
import network.chat.Message;
import network.chat.SocketMessenger;

import java.io.IOException;
import java.io.StreamCorruptedException;
import java.net.Socket;

/**
 * Created by zhenya on 04.02.2015.
 */
public class InputHandler implements Runnable {

    private final Socket socket;
    private Client client;

    public InputHandler(Client client, Socket socket) {
        this.socket = socket;
        this.client = client;
    }

    @Override
    public void run() {
        try {
            SocketMessenger socketMessenger = null;
            Object message = new Object();
            while (socket.isConnected()) {
                //Create input stream
                socketMessenger = new SocketMessenger(client, socket);
                try {
                    message = socketMessenger.receiveMessage();
                    if (message instanceof Client) {
                        System.out.println("Client");
                        Client client = (Client) message;
                        System.out.println(client.toString());
                    }
                    if (message instanceof Message) {
                        Message mes = (Message) message;
                        System.out.println("Receive message: " + mes);
                    }
                } catch (StreamCorruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
