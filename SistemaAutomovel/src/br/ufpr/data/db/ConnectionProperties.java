package br.ufpr.data.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Lucas
 */
public class ConnectionProperties {

    Properties prop = new Properties();
    String fileFullName = "src/br/ufpr/data/db/connection.properties";

    public ConnectionProperties() {

        InputStream input = null;

        try {
            input = new FileInputStream(fileFullName);

            prop.load(input);

            // get the property value and print it out
            System.out.println(prop.getProperty("database"));
            System.out.println();
            System.out.println(prop.getProperty("dbpassword"));

        } catch (IOException ex) {
            ex.printStackTrace();;
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public String getUser() {
        return prop.getProperty("usr");
    }

    public String getPassword() {
        return prop.getProperty("pwd");
    }

    public String getURL() {
        return prop.getProperty("url");
    }
}
