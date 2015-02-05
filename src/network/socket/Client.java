package network.socket;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by zhenya on 05.02.2015.
 */
public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 9999);
            Thread input = new Thread(new InputHandlerClient(socket));
            input.start();
            Thread output = new Thread(new OutputHandlerClient(socket));
            output.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
