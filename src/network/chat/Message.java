package network.chat;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by zhenya on 03.02.2015.
 */
public class Message implements Serializable {

    public static final long serialVersionUID = 14589L;

    private final Client client;
    private String message;
    private Date time;

    public Message(Client client) {
        this.client = client;
        setDate();
    }

    public Message(Client client, String message) {
        this.client = client;
        this.message = message;
        setDate();
    }

    public String getMessage() {
        return this.message;
    }

    public Client getClient() {
        return this.client;
    }

    private void setDate() {
        this.time = Calendar.getInstance().getTime();
    }

    public Date getTime() {
        return this.time;
    }

    @Override
    public String toString() {
        return this.time + ":\t" + this.client.getLogin() + ": " + this.message;
    }

}
