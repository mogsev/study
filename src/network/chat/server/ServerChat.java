package network.chat.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by zhenya on 02.02.2015.
 */
public class ServerChat {

    public static void main(String[] args) {
        try {
            //Create server socket
            ServerSocket serverSocket = new ServerSocket(ConfigServer.serverPort);
            Socket socket = serverSocket.accept();

            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();
            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);

            String line = null;

            while (true) {
                line = in.readUTF();
                System.out.println("Client send: " + line);
                out.writeUTF(line);
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
