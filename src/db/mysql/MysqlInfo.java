package db.mysql;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * This class receive information about DB, JDBC-driver, tables and fields
 * Created by zhenya on 05.02.2015.
 */
public class MysqlInfo {

    public static void main(String[] args) {
        Connection conn = null; //JDBC-connect with server DB
        try {
            //Search file "db.conf" properties
            Properties props = new Properties();
            try {
                props.load(MysqlInfo.class.getResourceAsStream("db.conf"));
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
               //receive values
            String driver = props.getProperty("driver");
            String server = props.getProperty("server", "");
            String user = props.getProperty("user", "");
            String password = props.getProperty("password", "");
            String database = props.getProperty("database", "");
            String table = props.getProperty("table", "");

            if (args.length > 0) {
                for (int i = 0; i < args.length; i++) {
                    if (args[i].equals("-d")) { //-d <driver>
                        driver = args[++i];
                    } else if (args[i].equals("-s")) { //-s <server>
                        server = args[++i];
                    } else if (args[i].equals("-u")) { //-u <User>
                        user = args[++i];
                    } else if (args[i].equals("-p")) { //-p <password>
                        password = args[++i];
                    } else if (args[i].equals("-D")) { //-D <database>
                        database = args[++i];
                    } else if (args[i].equals("-t")) { //-t <table>
                        table = args[++i];
                    } else throw new IllegalArgumentException("Unknown argumet " + args[i]);
                }
            //Check argument server and databese
                if (server.length() == 0) {
                    throw new IllegalArgumentException("Unknown server name ");
                }
                if (database.length() == 0) {
                    throw new IllegalArgumentException("Unknown database name ");
                }
            }
                //Load driver
                if (driver != null) {
                    Class.forName(driver);
                }
                //Open connection
                conn = DriverManager.getConnection(server + database, user, password);
                //Receive DatabaseMetaData this connection
                DatabaseMetaData md = conn.getMetaData();
                //Print information
                System.out.println(md.getDatabaseProductName() + " " + md.getDatabaseProductVersion());
                System.out.println(md.getDriverName() + " " + md.getDriverVersion());
                System.out.println(md.getURL());
                System.out.println(md.getUserName());
                if (table == null) {
                    System.out.println("Tables:");
                    ResultSet res = md.getTables("", "", "%", null);
                    while (res.next()) {
                        System.out.println("\t" + res.getString(3));
                    }
                } else {
                    System.out.println("Fields table: " + table);
                    ResultSet res = md.getColumns("", "", table, "%");
                    while (res.next()) {
                        System.out.println("\t" + res.getString(4));
                    }
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
        } finally {
            try {
                conn.close();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}


