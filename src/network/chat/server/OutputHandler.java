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
        Object message = null;
        while (true) {
            //Send all messages from server
            if (!ServerChat.outputMessages.isEmpty() && !ServerChat.cacheClient.isEmpty()) {
                Iterator<Object> messageIterator = ServerChat.outputMessages.iterator();
                while (messageIterator.hasNext()) {
                    message = messageIterator.next();
                    for (ObjectOutputStream outputStream : ServerChat.cacheClient.values()) {
                        try {
                            outputStream.writeObject(message);
                            outputStream.flush();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    messageIterator.remove();
                }
            }
            //Send all messages from client
            if (!ServerChat.inputMessages.isEmpty() && !ServerChat.cacheClient.isEmpty()) {
                Iterator<Object> messageIterator = ServerChat.inputMessages.iterator();
                while (messageIterator.hasNext()) {
                    message = messageIterator.next();
                    for (ObjectOutputStream outputStream : ServerChat.cacheClient.values()) {
                        try {
                            outputStream.writeObject(message);
                            outputStream.flush();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    messageIterator.remove();
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
