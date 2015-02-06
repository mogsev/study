package network.chat.server;

import network.chat.Client;
import network.chat.Message;
import network.chat.MessageMulticast;

import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by zhenya on 06.02.2015.
 */
public class ListClients implements Runnable{

    private ArrayList<Client> listClients = new ArrayList<Client>();

    private void recreateListClients() {
        listClients.clear();
        if (!ServerChat.cacheClient.isEmpty()) {
            for (Map.Entry<Client, ObjectOutputStream> entry : ServerChat.cacheClient.entrySet()) {
                listClients.add(entry.getKey());
            }
        }
    }

    private void sendListClients() {
        if (!listClients.isEmpty()) {
            MessageMulticast mm = new MessageMulticast(new Client("server"), listClients);
            ServerChat.outputMessages.add(mm);
        }
    }

    @Override
    public void run() {
        while (true) {
            recreateListClients();
            sendListClients();
            try {
                Thread.sleep(30000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
