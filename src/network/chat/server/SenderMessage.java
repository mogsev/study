package network.chat.server;

import network.chat.Message;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by zhenya on 06.02.2015.
 */
public class SenderMessage implements Runnable {

    //private final Socket socket;
    private final ObjectOutputStream objectOutputStream;
    private Message message;

    public SenderMessage(ObjectOutputStream objectOutputStream, Message message) {
        //this.socket = socket;
        this.objectOutputStream = objectOutputStream;
        this.message = message;
    }

    @Override
    public void run() {
        try {
            //ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(message);
            objectOutputStream.flush();
            //objectOutputStream.reset();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
