package network.rsync;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by zhenya on 06.02.2015.
 */
public class InputHandler implements Runnable {

    final ServerSocket serverSocket;

    /**
     *
     * @param serverSocket
     */
    public InputHandler(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    @Override
    public void run() {
        //Begin listening connections
        while(true) {
            try {
                Socket socket = serverSocket.accept();
                socket.setKeepAlive(true);
                Runnable inputFile = new InputFile(socket);
                Thread input = new Thread(inputFile);
                input.setDaemon(true);
                input.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
