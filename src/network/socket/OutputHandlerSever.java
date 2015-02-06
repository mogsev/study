package network.socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by zhenya on 05.02.2015.
 */
public class OutputHandlerSever implements Runnable {

        private Socket socket;

        public OutputHandlerSever(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            int i = 1;
            try {

                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                while(true) {
                    i = i + 1;
                    objectOutputStream.writeObject("server"+i);
                    objectOutputStream.flush();
                    Thread.sleep(3000);
                }

            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


