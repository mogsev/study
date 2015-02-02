package net.chat.server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by zhenya on 02.02.2015.
 */
public class ClientThread extends Thread {
    private Socket socket;
    private Message message;
    private String login;

    public ClientThread(Socket socket) {
        this.socket = socket;
        this.start();
    }
/**
    public void run() {
        try {
            //create stream input for socket
            final ObjectInputStream inputStream = new ObjectInputStream(this.socket.getInputStream());
            //create stream output for socket
            final ObjectOutputStream outputStream = new ObjectOutputStream(this.socket.getOutputStream());
            //read Message from stream
            this.message = (Message) inputStream.readObject();
            this.login = this.message.getLogin();


        } catch () {

        }

    }

    private void broadcast(ArrayList<Client> clients, Message message) {
        try {
            for (Client client : clients) {

            }
        } catch () {

        }
    }*/
}
