package network.socket;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by zhenya on 05.02.2015.
 */
public class OutputHandlerClient implements Runnable {

        private Socket socket;

        public OutputHandlerClient(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            int i = 1;
            try {

                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                while(true) {

                    i++;
                    objectOutputStream.writeObject("client" + i);
                    objectOutputStream.flush();
                    Thread.sleep(3000);
                    System.out.println(i);
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


