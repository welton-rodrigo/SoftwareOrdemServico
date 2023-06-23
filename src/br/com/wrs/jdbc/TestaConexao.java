package br.com.wrs.jdbc;


import java.sql.Connection;
import java.sql.SQLException;

public class TestaConexao {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Connection connection;
		connection = ConnectionFactory.getInstancia().getConnection();
		System.out.println("Conexao aberta!");
		connection.close();
		
	}

}
