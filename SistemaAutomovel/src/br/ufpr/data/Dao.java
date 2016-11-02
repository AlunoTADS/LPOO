package br.ufpr.data;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Giovanni
 */
public abstract class Dao<T> {

    public static Connection con;
    PreparedStatement stmt;
    ResultSet rs;
    CallableStatement call;

    private final String URL = "jdbc:sqlite:src/br/ufpr/data/db/database.db";

    public void open() throws Exception {
        if (con == null || con.isClosed()) {
            con = DriverManager.getConnection(URL);
        }
    }

    protected void close() {
        try {
            rs.close();
        } catch (Exception e) {
        }

        try {
            stmt.close();
        } catch (Exception e) {
        }

        try {
            con.close();
        } catch (Exception e) {
        }
    }
}
