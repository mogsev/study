package net.chat.client;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by zhenya on 02.02.2015.
 */
public class ConfigClient {
    private static final String PROPERTIES_FILE = "client.conf";
    public static int PORT;

    static {
        Properties properties = new Properties();
        FileInputStream propertiesFile = null;
        try {
            propertiesFile = new FileInputStream(PROPERTIES_FILE);
            properties.load(propertiesFile);
            PORT = Integer.parseInt(properties.getProperty("PORT"));
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