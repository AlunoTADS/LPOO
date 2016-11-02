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
public class Dao {
    	public static Connection con;
	PreparedStatement stmt;
	ResultSet rs;
	CallableStatement call;
	
//	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
//	private final String USER = "system";
//	private final String PASS = "admin";
	
	public void open() throws Exception {
            if(con == null || con.isClosed()) {
//                Class.forName("oracle.jdbc.OracleDriver");
//		con = DriverManager.getConnection(URL, USER, PASS);
            }
	}
        
	protected void close() throws Exception {
            if(rs != null)
                rs.close();
            if(stmt != null)
                stmt.close();
            if(con != null)
                con.close();
	}
}
