package network.rsync;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * Created by zhenya on 06.02.2015.
 */
public class InputFile implements Runnable {

    private final Socket socket;

    public InputFile(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream dataInputStream = socket.getInputStream();
            int i = dataInputStream.available();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
