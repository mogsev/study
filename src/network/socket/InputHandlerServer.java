package network.socket;

import network.chat.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * Created by zhenya on 05.02.2015.
 */
public class InputHandlerServer implements Runnable {
    private Socket socket;

    public InputHandlerServer(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {

            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            while(true) {
                Message message = (Message) objectInputStream.readObject();
                System.out.println(message);
            }

        } catch (IOException e) {
            e.printStackTrace();
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
