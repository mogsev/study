package network.chat.server;

import network.chat.Message;

import java.util.ArrayList;

/**
 * Created by zhenya on 05.02.2015.
 */
public class CacheMessage {

    private ArrayList<Message> listInputMessages = new ArrayList<Message>();

    public synchronized void addMessage(Object message) {
        listInputMessages.add((Message) message);
    }

    public synchronized ArrayList<Message> getAllMessages() {
        return listInputMessages;
    }
}
