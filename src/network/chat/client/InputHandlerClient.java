package network.chat.client;

import network.chat.Message;
import network.chat.MessageMulticast;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.StreamCorruptedException;
import java.net.Socket;

/**
 * Created by zhenya on 04.02.2015.
 */
public class InputHandlerClient implements Runnable {

    private final Socket socket;

    public InputHandlerClient(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            Object message = null;
            //Create input stream
            final ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            while (socket.isConnected()) {
                if (objectInputStream != null) {
                    message = objectInputStream.readObject();
                    if (message instanceof MessageMulticast) {
                        MessageMulticast mm = (MessageMulticast) message;
                        ClientChat.listClients.clear();
                        ClientChat.listClients.addAll(mm.getListClients());
                    } else if (message instanceof Message) {
                        ClientChat.addInputMessage(message);
                        System.out.println("Receive message: " + message.toString());
                    }
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (StreamCorruptedException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
