package network.rsync;

import java.io.*;
import java.net.Socket;

/**
 * Created by zhenya on 06.02.2015.
 */
public class InputFile implements Runnable {

    private final Socket socket;

    /**
     *
     * @param socket
     */
    public InputFile(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        File file = null;
        FileOutputStream fileOutputStream = null;
        try {
            //Create object input stream
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            ClientFile clientFile = (ClientFile) objectInputStream.readObject();
            System.out.println(clientFile.getNameFile());
            //Create file
            file = new File(RemoteSyncConfig.dir+"/"+clientFile.getNameFile());
            //Create data input stream
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            //Create file output stream
            fileOutputStream = new FileOutputStream(file);
            // Receive and write data file
            int count = 0;
            byte[] bytes = new byte[1024];
            while ((count = dataInputStream.read(bytes)) != -1) {
                fileOutputStream.write(bytes, 0, count);
                fileOutputStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                RemoteSync.addFiles(file);
                fileOutputStream.flush();
                fileOutputStream.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
