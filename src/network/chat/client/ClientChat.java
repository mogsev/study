package network.chat.client;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by zhenya on 02.02.2015.
 */
public class ClientChat {
    public static void main(String[] args) {
        int port = 6666;
        String address = "127.0.0.1";
        try {
            InetAddress ipAddress = InetAddress.getByName(address);
            Socket socket = new Socket(ipAddress, port);
            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();
            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String line = null;

            while (true) {
                line = reader.readLine();
                out.writeUTF(line);
                out.flush();
                line = in.readUTF();
                System.out.println("Server: " + line);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
