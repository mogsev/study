package network.chat.server;

import network.chat.Client;

import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by zhenya on 04.02.2015.
 */
public class CacheClient {

    private static volatile ConcurrentHashMap<Client, Socket> cacheMap = new ConcurrentHashMap<Client, Socket>();

    public synchronized static void addConnection(Client client, Socket socket) {
        cacheMap.put(client, socket);
    }

    public synchronized static void removeConnection(Client client) {
        cacheMap.remove(client);
    }

    public synchronized static ArrayList<Client> getListClient() {
        return Collections.list(cacheMap.keys());
    }


}
