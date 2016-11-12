package br.ufpr.data;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Giovanni
 * @param <T>
 */
public abstract class Dao<T> {

    public static Connection con;
    PreparedStatement stmt;
    ResultSet rs;
    CallableStatement call;

    private final String URL = "jdbc:sqlite:src/br/ufpr/data/db/database.db";

    public void open() throws Exception {
        close();
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

    public Integer getNextId() throws Exception {
        open();
        String sql = "SELECT valor FROM Sequence WHERE id = ?";
        String seqName = String.format("seq_%s", this.getClass().getSimpleName().toLowerCase());
        stmt = con.prepareStatement(sql);
        stmt.setString(1, seqName);
        rs = stmt.executeQuery();
        Integer id = null;
        if (rs.next()) {
            id = rs.getInt("valor");
            sql = "UPDATE Sequence set valor = ? WHERE id = ?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id + 1);
            stmt.setString(2, seqName);
            stmt.execute();
        }
        close();
        return id;
    }

    
    @Override
    public void finalize() throws Throwable {
        try {
            close();
        } finally {
            super.finalize();
        }
    }
}
