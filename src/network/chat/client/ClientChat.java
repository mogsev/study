package network.chat.client;

import network.chat.Client;
import network.chat.Message;
import network.chat.SocketMessenger;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * Created by zhenya on 02.02.2015.
 */
public class ClientChat {

    public static void main(String[] args) {
        try {
            //Create Client
            Client client = new Client("zhenya", "zhenya full name", InetAddress.getLocalHost().getHostAddress());
            //Create Socket
            Socket socket = new Socket(ConfigClient.serverAddress, ConfigClient.serverPort);
            socket.setKeepAlive(true);
            //Create SocketMessenger
            SocketMessenger socketMessenger = new SocketMessenger(client, socket);
            socketMessenger.sendClientInfo();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                String line = reader.readLine();
                if (line.equals("quit")) {
                    break;
                }
                if (socket.isConnected()) {
                    Message message = new Message("zhenya", line);
                    socketMessenger.sendMessage(message);
                    socketMessenger.receiveMessage();
                }
            }
        } catch (SocketException ex) {
            System.out.println("Connection reset by peer: socket write error");
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

