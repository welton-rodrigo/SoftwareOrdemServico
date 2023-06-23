package br.com.wrs.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory2 {
	private static Connection conn = null;
	
	public static Connection getConnection() throws ClassNotFoundException {
		try {
			if (conn == null || conn.isClosed()) {

				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "admin");
				return conn;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
