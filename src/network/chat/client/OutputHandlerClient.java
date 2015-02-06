package network.chat.client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by zhenya on 05.02.2015.
 */
public class OutputHandlerClient implements Runnable {

    private final Socket socket;

    public OutputHandlerClient(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            final ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            while (socket.isConnected()) {
                if (!ClientChat.isEmptyOutputMessage()) {
                    objectOutputStream.writeObject(ClientChat.getOutputMessage());
                    objectOutputStream.flush();
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
