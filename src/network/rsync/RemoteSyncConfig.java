package network.rsync;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by zhenya on 02.02.2015.
 */
public class RemoteSyncConfig {
    
    private static final String PROPERTIES_FILE = "remotesync.conf";
    public static String serverIP;
    public static int serverPort;
    public static int time;
    public static String dir;

    static {
        Properties properties = new Properties();
        FileInputStream propertiesFile = null;
        try {
            propertiesFile = new FileInputStream(PROPERTIES_FILE);
            properties.load(propertiesFile);

            serverIP = properties.getProperty("SERVER");
            serverPort = Integer.parseInt(properties.getProperty("PORT"));
            time = Integer.parseInt(properties.getProperty("TIME"));
            dir = properties.getProperty("TIME");

        } catch (FileNotFoundException ex) {
            System.err.println("Config file not found");
            ex.printStackTrace();
        } catch (IOException ex) {
            System.err.println("Error while reading file");
            ex.printStackTrace();
        } finally {
            try {
                propertiesFile.close();
            } catch (IOException ex) {
                System.err.println("Error while closing file");
                ex.printStackTrace();
            }
        }
    }
}
