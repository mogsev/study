package network.chat.server;

import network.chat.Client;

import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by zhenya on 04.02.2015.
 */
public class CacheSocket {

    private static volatile ConcurrentHashMap<Client, Socket> cacheMap = new ConcurrentHashMap<Client, Socket>();

    public synchronized static void addConnection(Client client, Socket socket) {
        cacheMap.put(client, socket);
    }

    public static ArrayList<Client> getListClient() {
        ArrayList<Client> result = new ArrayList<Client>();
        result = Collections.list(cacheMap.keys());
        return result;
    }


}
