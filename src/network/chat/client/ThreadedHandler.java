package network.chat.client;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.Socket;
import java.net.SocketException;

/**
 * Created by zhenya on 03.02.2015.
 */
public class ThreadedHandler implements Runnable {

    private final Socket socket;

    /**
     * Design handler
     * @param socket
     */
    public ThreadedHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        int i = 0;
        try {
            try {
                while (socket.isConnected()) {
                    i++;
                    System.out.println(i);
                    //Create input stream
                    //final ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                    //Create output stream
                    final ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                    //read message
                    //Object message = inputStream.readObject();
                    //System.out.println(message.toString());
                    if (!ClientChat.isEmptyOutputMessage()) {
                        outputStream.writeObject(ClientChat.getOutputMessage());
                        outputStream.flush();
                    }
                    Thread.sleep(2000);
                }
            } catch (BindException ex) {
                System.out.println("Server is running");
                ex.printStackTrace();
            } catch (SocketException ex) {
                System.out.println("Connection reset");
                ex.printStackTrace();
            } catch (EOFException ex) {
                System.out.println("Close InputStream");
                ex.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                //Close socket
                socket.close();
            }
        }  catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
