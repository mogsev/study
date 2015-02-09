package network.rsync;

import java.io.Serializable;

/**
 * Created by zhenya on 09.02.2015.
 */
public class ClientFile implements Serializable {

    public static final long serialVersionUID = 49832L;

    private String nameFile;


    public ClientFile(String nameFile) {
        this.nameFile = nameFile;
    }

    public String getNameFile() {
        return this.nameFile;
    }
}
