package network.chat;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by zhenya on 03.02.2015.
 */
public class Message implements Serializable {
    public static final long serialVersionUID = 1L;

    private String login;
    private String message;
    private Date time;

    public Message () {
        time = Calendar.getInstance().getTime();
    }

    public Message(String message) {
        this();
        this.message = message;
    }

    public Message(String login, String message) {
        this();
        this.login = login;
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public String getLogin() {
        return this.login;
    }

    public Date getTime() {
        return this.time;
    }

}
