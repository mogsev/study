package network.rsync;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/**
 * Created by zhenya on 06.02.2015.
 */
public class RemoteSync {

    public RemoteSync() {
        initComponent();
    }

    /**
     * Initialize components
     */
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

    /**
     * Show list all files on directory
     * @param dir
     */
    private void showDir(String dir) {
        System.out.println("Show list all files on directory: " + dir);
        Path path = new File(dir).toPath();
        try (DirectoryStream<Path> entries = Files.newDirectoryStream(path)) {
            for (Path entry : entries) {
                System.out.println(entry.getFileName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("0 - exit;\t1 - show dir;");
        File file = new File(RemoteSyncConfig.dir);
        RemoteSync remoteSync = new RemoteSync();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            System.out.println("0 - exit;\t1 - show dir;");
            int intLine = scanner.nextInt();
            switch (intLine) {
                case 0:
                    System.exit(1);
                    break;
                case 1:
                    remoteSync.showDir(RemoteSyncConfig.dir);
                    break;
            }
        }
    }
}
