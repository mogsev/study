package network.chat.client;

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
            while (socket.isConnected()) {
                //Create input stream
                final ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                message = objectInputStream.readObject();
                ClientChat.addInputMessage(message);
                System.out.println("Receive message: " + message.toString());
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
