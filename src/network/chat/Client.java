package network.chat;

import java.io.Serializable;

/**
 * Created by zhenya on 04.02.2015.
 */
public class Client implements Serializable {

    private String login;
    private String name;
    private String ipHost;

    public Client(String login, String name, String ipHost) {
        this.login = login;
        this.name = name;
        this.ipHost = ipHost;
    }

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public String getIpHost() {
        return ipHost;
    }

    @Override
    public String toString() {
        return this.ipHost + "\t" + this.login + "\t" + this.name;
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
