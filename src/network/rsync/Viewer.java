package network.rsync;

import java.io.*;
import java.net.Socket;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by zhenya on 10.02.2015.
 */
public class Viewer implements Runnable{

    @Override
    public void run() {
        System.out.println("start viewer");
        Path path = new File(RemoteSyncConfig.dir).toPath();
        boolean isFound = false;
        while (true) {
            try (DirectoryStream<Path> entries = Files.newDirectoryStream(path)) {
                for (Path entry : entries) {
                    isFound = false;
                    System.out.println(entry.getFileName());
                    for (String entrylist: RemoteSync.listFiles) {
                        if (entry.getFileName().toString().equals(entrylist)) {
                            isFound = true;
                            break;
                        }
                    }
                    if (!isFound) {
                        Socket socket = new Socket(RemoteSyncConfig.serverIP, RemoteSyncConfig.serverPort);
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                        objectOutputStream.writeObject(new ClientFile(entry.getFileName().toString()));
                        objectOutputStream.flush();

                        FileInputStream fileInputStream = new FileInputStream(entry.toFile());
                        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                        int count = 0;
                        byte[] bytes = new byte[1024];
                        while ((count = fileInputStream.read(bytes)) != -1) {
                            dataOutputStream.write(bytes, 0, count);
                            dataOutputStream.flush();
                        }
                        dataOutputStream.flush();
                        fileInputStream.close();
                        socket.close();
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            try {
                Thread.sleep(60000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
