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
 * Created by zhenya on 03.02.2015.
 */
public class OutputHandler implements Runnable {


    /**
     * Design output handler
     */

    @Override
    public void run() {
        Message message = null;
        while (true) {
            if (!ServerChat.outputMessages.isEmpty() && !ServerChat.cacheMap.isEmpty()) {
                Iterator<Message> messageIterator = ServerChat.outputMessages.iterator();
                while (messageIterator.hasNext()) {
                    message = messageIterator.next();
                    if (message.getClient().getLogin().equals("server")) {
                        for (Map.Entry<Client, Socket> entry : ServerChat.cacheMap.entrySet()) {
                            new Thread(new SenderMessage(entry.getValue(), message)).start();
                        }
                        messageIterator.remove();
                    }
                }
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
