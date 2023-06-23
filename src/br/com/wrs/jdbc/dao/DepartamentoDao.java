package br.com.wrs.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.wrs.jdbc.ConnectionFactory;
import br.com.wrs.modelo.Departamento;


public class DepartamentoDao {

	// a conexão com o banco de dados
			private Connection connection;
		
			public DepartamentoDao(){
				//this.connection = new ConnectionFactory().;
				try {
					connection = ConnectionFactory.getInstancia().getConnection();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			//metodo adiciona contato
			public void adiciona(Departamento departamento) {
				String sql = "insert into departamento " + "(nome_departamento,empresa_idempresa)" + " values (?,?)";

				try {
					// prepared statement para inserção
					PreparedStatement stmt = connection.prepareStatement(sql);
					// seta os valores
					stmt.setString(1, departamento.getNomeDepartamento());
					stmt.setInt(2, departamento.getIdEmpresa());
					// executa
					stmt.execute();
					stmt.close();
					connection.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}

			//metodo lista contato
			public List<Departamento> getLista() {
				try {
					List<Departamento> departamentos = new ArrayList<Departamento>();
					PreparedStatement stmt = this.connection.prepareStatement("select * from departamento");
					ResultSet rs = stmt.executeQuery();

					while (rs.next()) {
						// criando o objeto Contato
						Departamento departamento = new Departamento();
						departamento.setIdDepartamento(rs.getInt("iddepartamento"));
						departamento.setNomeDepartamento(rs.getString("nome_departamento"));
						
						// adicionando o objeto à lista
						departamentos.add(departamento);
					}
					rs.close();
					stmt.close();
					connection.close();
					return departamentos;
					
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
			
			
			
			//metodo atualiza contato
			public void altera(Departamento departamento) {
			     String sql = "update departamento set nome_departamento=?"+
			             		" where id=?";
			 
			     try {
			         PreparedStatement stmt = connection
			                 .prepareStatement(sql);
			         stmt.setString(1, departamento.getNomeDepartamento());
			         stmt.setInt(2, departamento.getIdDepartamento());
			         stmt.execute();
			         stmt.close();
			         connection.close();
			     } catch (SQLException e) {
			         throw new RuntimeException(e);
			     }
			 }
			
			//metodo remove contato
			public void remove(Departamento departamento) {
			     try {
			         PreparedStatement stmt = connection
			                 .prepareStatement("delete from departamento where id=?");
			         stmt.setInt(1, departamento.getIdDepartamento());
			         stmt.execute();
			         stmt.close();
			         connection.close();
			     } catch (SQLException e) {
			         throw new RuntimeException(e);
			     }
			 }
	
	
}
