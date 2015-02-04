package network.chat;

import java.io.Closeable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by zhenya on 03.02.2015.
 */
public class SocketMessenger implements AutoCloseable, Closeable {

    private final Socket socket;
    private final Client client;

    public SocketMessenger(Client client, Socket socket) {
        this.client = client;
        this.socket = socket;
    }

    public void sendClientInfo() throws IOException {
        System.out.println("Send client info");
        ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
        outputStream.writeObject(this.client);
        outputStream.flush();
    }

    public void sendMessage(Object message) throws IOException {
        System.out.println("Send message:" + message);
        ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
        outputStream.writeObject(message);
        outputStream.flush();
    }

    public Object receiveMessage() throws IOException, ClassNotFoundException {
        ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
        Object message = inputStream.readObject();
        System.out.println("Receive message: " + message);
        return message;
    }

    @Override
    public void close() throws IOException {
        socket.close();
    }
}
