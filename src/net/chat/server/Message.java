package net.chat.server;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by zhenya on 02.02.2015.
 */
public class Message implements Serializable {

    private String login;
    private String message;
    private String[] onlineUsers;
    private Date time;

    public Message(String login, String message) {
        this.login = login;
        this.message = message;
        this.time = Calendar.getInstance().getTime();
    }

    public Message(String login, String message, String[] onlineUsers) {
        this.login = login;
        this.message = message;
        this.time = Calendar.getInstance().getTime();
        this.onlineUsers = onlineUsers;
    }

    /**
    public void setOnlineUsers(String[] onlineUsers) {
        this.onlineUsers = onlineUsers;
    }*/

    public String getLogin() {
        return this.login;
    }

    public String getMessage() {
        return this.message;
    }

    public String getDate() {
        return this.time.toString();
    }
}
