package network.chat.server;

import network.chat.Message;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by zhenya on 05.02.2015.
 */
public class CacheMessage {

    private ArrayList<Message> inputMessages = (ArrayList<Message>) Collections.synchronizedList(new ArrayList<Message>());
    private ArrayList<Message> outputMessages = (ArrayList<Message>) Collections.synchronizedList(new ArrayList<Message>());


    public synchronized void addInputMessage(Object message) {
        inputMessages.add((Message) message);
    }

    public synchronized void addOutputMessage(Object message) {
        outputMessages.add((Message) message);
    }

    public synchronized Message getInputMessage() {
        return null;
    }

    public synchronized Message getOutputMessage() {
            return outputMessages.remove(0);
    }

    public synchronized boolean isEmptyOutputMessage() {
        return outputMessages.isEmpty();
    }

    public synchronized boolean isEmptyInputMessage() {
        return inputMessages.isEmpty();
    }

    public synchronized ArrayList<Message> getAllInputMessage() {
        return inputMessages;
    }

}
