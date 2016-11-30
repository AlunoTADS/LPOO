package br.ufpr.data.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Lucas
 */
public class ConnectionFactory {
    public static Connection getConnection() throws SQLException {
        ConnectionProperties cp = new ConnectionProperties();
        return DriverManager.getConnection(cp.getURL(), cp.getUser(), cp.getPassword());
    }
}
