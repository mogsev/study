package network.chat.server;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by zhenya on 02.02.2015.
 */
public class ConfigServer {
    
    private static final String PROPERTIES_FILE = "server.conf";
    public static int serverPort;

    static {
        Properties properties = new Properties();
        FileInputStream propertiesFile = null;
        try {
            propertiesFile = new FileInputStream(PROPERTIES_FILE);
            properties.load(propertiesFile);
            serverPort = Integer.parseInt(properties.getProperty("SERVER_PORT"));
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
