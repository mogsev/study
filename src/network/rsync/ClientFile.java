package network.rsync;

import java.io.Serializable;

/**
 * Created by zhenya on 09.02.2015.
 */
public class ClientFile implements Serializable {

    public static final long serialVersionUID = 49832L;

    private String nameFile;

    /**
     *
     * @param nameFile
     */
    public ClientFile(String nameFile) {
        this.nameFile = nameFile;
    }

    /**
     * Return name file
     * @return
     */
    public String getNameFile() {
        return this.nameFile;
    }
}
