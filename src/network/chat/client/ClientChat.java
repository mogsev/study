package network.chat.client;

import network.chat.Message;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by zhenya on 02.02.2015.
 */
public class ClientChat {

    public static void main(String[] args) {
        try {
            InetAddress ipAddress = InetAddress.getByName(ConfigClient.serverAddress);
            final Socket socket = new Socket(ipAddress, ConfigClient.serverPort);

            //final ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            final ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Input Login: ");
            String login = reader.readLine();
            System.out.println("Input Login: " + login);
            String line = "";
            //Message message = null;
            while (true) {
                line = reader.readLine();
                if (!line.equals("EXIT")) {
                    outputStream.writeObject(new Message(login, line));
                    outputStream.flush();
                    //Message message = (Message) inputStream.readObject();
                    //System.out.println(message.getLogin() + ": " + message.getMessage() + ", " + message.getTime().toString());
                } else {
                    break;
                }
            }

            outputStream.flush();
            outputStream.close();
            socket.close();

        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
