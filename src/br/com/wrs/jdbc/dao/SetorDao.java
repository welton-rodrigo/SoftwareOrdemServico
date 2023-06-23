package br.com.wrs.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.wrs.jdbc.ConnectionFactory;
import br.com.wrs.modelo.Setor;

public class SetorDao {

	// a conexão com o banco de dados
				private Connection connection;
			
				public SetorDao(){
					//this.connection = new ConnectionFactory().;
					try {
						connection = ConnectionFactory.getInstancia().getConnection();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				//metodo adiciona contato
				public void adiciona(Setor setor) {
					String sql = "insert into setor " + "(nome_setor)" + " values (?)";

					try {
						// prepared statement para inserção
						PreparedStatement stmt = connection.prepareStatement(sql);
						// seta os valores
						stmt.setString(1, setor.getNomeSetor());
						
						// executa
						stmt.execute();
						stmt.close();
						connection.close();
					} catch (SQLException e) {
						throw new RuntimeException(e);
					}
				}

				//metodo lista contato
				public List<Setor> getLista() {
					try {
						List<Setor> setores = new ArrayList<Setor>();
						PreparedStatement stmt = this.connection.prepareStatement("select * from setor");
						ResultSet rs = stmt.executeQuery();

						while (rs.next()) {
							// criando o objeto Contato
							Setor setor = new Setor();
							setor.setIdSetor(rs.getInt("idsetor"));
							setor.setNomeSetor(rs.getString("nome_setor"));
							
							// adicionando o objeto à lista
							setores.add(setor);
						}
						rs.close();
						stmt.close();
						connection.close();
						return setores;
						
					} catch (SQLException e) {
						throw new RuntimeException(e);
					}
				}
				
				
				
				//metodo atualiza contato
				public void altera(Setor setor) {
				     String sql = "update setor set nome_setor=?"+
				             		" where id=?";
				 
				     try {
				         PreparedStatement stmt = connection
				                 .prepareStatement(sql);
				         stmt.setString(1, setor.getNomeSetor());
				         stmt.setInt(2, setor.getIdSetor());
				         stmt.execute();
				         stmt.close();
				         connection.close();
				     } catch (SQLException e) {
				         throw new RuntimeException(e);
				     }
				 }
				
				//metodo remove contato
				public void remove(Setor setor) {
				     try {
				         PreparedStatement stmt = connection
				                 .prepareStatement("delete from setor where id=?");
				         stmt.setInt(1, setor.getIdSetor());
				         stmt.execute();
				         stmt.close();
				         connection.close();
				     } catch (SQLException e) {
				         throw new RuntimeException(e);
				     }
				 }
		
}
