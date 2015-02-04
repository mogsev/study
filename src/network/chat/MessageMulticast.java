package network.chat;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by zhenya on 04.02.2015.
 */
public class MessageMulticast extends Message implements Serializable{

    public static final long serialVersionUID = 951753124578L;
    private ArrayList<String> listUsers;

    public MessageMulticast() {

    }

    @Override
    public String toString() {
        return this.toString() + this.listUsers.toString();
    }

}
