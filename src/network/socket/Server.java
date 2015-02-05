package network.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by zhenya on 05.02.2015.
 */
public class Server {
    private static ArrayList<Object> list = new ArrayList<Object>();



    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9999);

            while (serverSocket.isBound()) {
                Socket socket = serverSocket.accept();
                Thread output = new Thread(new OutputHandlerSever(socket));
                output.start();
                Thread input = new Thread(new InputHandlerServer(socket));
                input.start();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
