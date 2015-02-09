package network.rsync;

import java.io.*;
import java.net.Socket;
import java.nio.file.Files;

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
        FileOutputStream fileOutputStream = null;
        try {
            ObjectInputStream objectInputStream = (ObjectInputStream) socket.getInputStream();
            ClientFile clientFile = (ClientFile) objectInputStream.readObject();

            File file = new File(RemoteSyncConfig.dir+"/"+clientFile.getNameFile());

            int count = 0;
            byte[] bytes = new byte[1024];

            fileOutputStream = new FileOutputStream(file);
            InputStream dataInputStream = socket.getInputStream();
            while ((count = dataInputStream.read(bytes)) != -1) {
                dataInputStream.read(bytes);
                fileOutputStream.write(bytes, 0, count);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.flush();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
