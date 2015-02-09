package network.rsync;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by zhenya on 06.02.2015.
 */
public class RemoteSync {

    private ArrayList<Path> listFiles;
    public static boolean stopped = false;

    public RemoteSync() {
        initComponent();
    }

    /**
     * Initialize components
     */
    private void initComponent() {
        initListFiles(RemoteSyncConfig.dir);
    }

    /**
     * Flag for stop thread
     */
    public void stop() {
        this.stopped = true;
    }

    /**
     * Initialize list files on directory
     * @param dir
     */
    private void initListFiles(String dir) {
        Path path = new File(dir).toPath();
        try (DirectoryStream<Path> entries = Files.newDirectoryStream(path)) {
            for (Path entry : entries) {
                listFiles.add(entry);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
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
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("0 - exit;\t1 - show dir;\t2 - start;\t3 - stop;");
        File file = new File(RemoteSyncConfig.dir);
        RemoteSync remoteSync = new RemoteSync();

        //Create thread for input handler
        InputHandler inputHandler = new InputHandler();
        Thread thread = new Thread(inputHandler);
        thread.setDaemon(true);

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            System.out.println("0 - exit;\t1 - show dir;\t2 - start;\t3 - stop;");
            int intLine = scanner.nextInt();
            switch (intLine) {
                case 0:
                    System.exit(1);
                    break;
                case 1:
                    remoteSync.showDir(RemoteSyncConfig.dir);
                    break;
                case 2:
                    System.out.println("RemoteSync running...");
                    thread.start();
                    break;
                case 3:
                    System.out.println("RemoteSync stopping...");
                    try {
                        remoteSync.stop();
                        thread.join();
                        System.out.println("RemoteSync stopped");
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    break;
                default:
                    System.out.println("Unknown command, enter number...");
            }
        }
    }
}
