package br.com.wrs.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private ConnectionFactory(){}
	
	private static Connection conn = null;
	private static ConnectionFactory instancia = null;
	
	public static synchronized ConnectionFactory getInstancia() throws ClassNotFoundException {
		
			if (instancia == null) {
				
				instancia = new ConnectionFactory();
				System.out.println("criada instancia ConnectionFactory ....");
			}
			
		return instancia;
	}
	
	public Connection getConnection(){
		try {
			if(conn == null || conn.isClosed()){
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "admin");
				System.out.println("criada conexao conn ....");
			}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public void closeDataBase() throws Exception  
    {  
        if ( conn != null)  
        {  
            conn.close(); 
            conn = null;
        }  
        
    }
	
}
