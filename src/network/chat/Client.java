package network.chat;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by zhenya on 04.02.2015.
 */
public class Client implements Serializable {

    public static final long serialVersionUID = 1L;

    private String login;
    private String name;
    private String ipHost;
    private boolean exist = true;

    public Client(String login) {
        this.login = login;
        this.name = login;
        setIpHost();
    }

    public Client(String login, String name) {
        this.login = login;
        this.name = name;
        setIpHost();
    }

    public String getLogin() {
        return this.login;
    }

    public String getName() {
        return this.name;
    }

    private void setIpHost() {
        try {
            this.ipHost = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public String getIpHost() {
        return this.ipHost;
    }

    public boolean isExist() {
        return this.exist;
    }

    public void setExist(boolean exist) {
        this.exist = exist;
    }

    @Override
    public String toString() {
        return this.ipHost + "\t" + this.login + "\t" + this.name + "\t" + this.exist;
    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (ipHost != null ? ipHost.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;

        Client client = (Client) o;

        if (ipHost != null ? !ipHost.equals(client.ipHost) : client.ipHost != null) return false;
        if (login != null ? !login.equals(client.login) : client.login != null) return false;
        if (name != null ? !name.equals(client.name) : client.name != null) return false;

        return true;
    }
}
