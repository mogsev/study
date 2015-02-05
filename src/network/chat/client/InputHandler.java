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
            Object message = null;
            while (socket.isConnected()) {
                //Create input stream
                socketMessenger = new SocketMessenger(socket);
                message = socketMessenger.receiveMessage();
                ClientChat.addInputMessage(message);
                System.out.println("Receive message: " + message.toString());
                //send message
                if (!ClientChat.isEmptyOutputMessage()) {
                    socketMessenger.sendMessage(ClientChat.getOutputMessage());
                }
            }
        } catch (StreamCorruptedException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
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
