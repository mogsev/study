package network.rsync;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by zhenya on 06.02.2015.
 */
public class InputHandler implements Runnable {

    @Override
    public void run() {
        //Begin listening connections
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(RemoteSyncConfig.serverPort);
            while (serverSocket.isBound()) {
                if (!RemoteSync.stopped) {
                    Socket socket = serverSocket.accept();
                    socket.setKeepAlive(true);
                    Runnable inputFile = new InputFile(socket);
                    Thread input = new Thread(inputFile);
                    input.setDaemon(true);
                    input.start();
                } else {
                    break;
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                serverSocket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
