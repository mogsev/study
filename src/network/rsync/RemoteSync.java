package network.rsync;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;

/**
 * Created by zhenya on 06.02.2015.
 */
public class RemoteSync {



    public RemoteSync() {
        initComponent();
    }

    private void initComponent() {
        try {
            //Create input thread
            final ServerSocket serverSocket = new ServerSocket(RemoteSyncConfig.serverPort);
            Runnable inputHandler = new InputHandler(serverSocket);
            Thread input = new Thread(inputHandler);
            input.setDaemon(true);
            input.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {


        File file = new File(RemoteSyncConfig.dir);

    }
}
