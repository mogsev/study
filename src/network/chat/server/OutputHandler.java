package network.chat.server;

import network.chat.Client;
import network.chat.Message;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.Socket;
import java.net.SocketException;
import java.util.Iterator;
import java.util.Map;

/**
 * Design output handler
 * Created by zhenya on 03.02.2015.
 */
public class OutputHandler implements Runnable {

    @Override
    public void run() {
        Message message = null;
        while (true) {
            if (!ServerChat.outputMessages.isEmpty() && !ServerChat.cache.isEmpty()) {
                Iterator<Message> messageIterator = ServerChat.outputMessages.iterator();
                while (messageIterator.hasNext()) {
                    message = messageIterator.next();
                    if (message.getClient().getLogin().equals("server")) {
                        for (Map.Entry<Client, ObjectOutputStream> entry : ServerChat.cache.entrySet()) {
                            //new Thread(new SenderMessage(entry.getValue(), message)).start();
                            try {
                                entry.getValue().writeObject(message);
                                entry.getValue().flush();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        messageIterator.remove();
                    }
                }
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
