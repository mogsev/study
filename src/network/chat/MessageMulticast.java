package network.chat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhenya on 04.02.2015.
 */
public class MessageMulticast extends Message implements Serializable {

    public static final long serialVersionUID = 324578L;
    private ArrayList<Client> listClients;

    /**
     *
     * @param client
     * @param listClients
     */
    public MessageMulticast(Client client, ArrayList<Client> listClients) {
        super(client);
        this.listClients = listClients;
    }

    /**
     *
     * @param client
     * @param message
     * @param listClients
     */
    public MessageMulticast(Client client, String message, ArrayList<Client> listClients) {
        super(client, message);
        this.listClients = listClients;
    }

    /**
     *
     * @return
     */
    public ArrayList<Client> getListClients() {
        return this.listClients;
    }

    @Override
    public String toString() {
        return this.toString() + this.listClients.toString();
    }

}
