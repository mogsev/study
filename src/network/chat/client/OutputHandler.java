package network.chat.client;

import network.chat.Message;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by zhenya on 05.02.2015.
 */
public class OutputHandler implements Runnable {

    private final Socket socket;

    public OutputHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            while (socket.isConnected()) {
                try {
                    final ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                    if (!ClientChat.isEmptyOutputMessage()) {
                        objectOutputStream.writeObject(ClientChat.getOutputMessage());
                        objectOutputStream.flush();
                    }
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
