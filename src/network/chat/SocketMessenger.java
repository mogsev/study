package network.chat;

import java.io.Closeable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by zhenya on 03.02.2015.
 */
public class SocketMessenger implements AutoCloseable, Closeable {
    private final Socket socket;

    public SocketMessenger(Socket socket) {
        this.socket = socket;
    }

    public void sendMessage(Message message) throws IOException {
        System.out.println("Send message:" + message);
        ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
        outputStream.writeObject(message);
        outputStream.flush();
    }

    public Message receiveMessage() throws IOException, ClassNotFoundException {
        ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
        Message message = (Message) inputStream.readObject();
        System.out.println("Receive message: " + message);
        return message;
    }

    @Override
    public void close() throws IOException {
        socket.close();
    }
}
