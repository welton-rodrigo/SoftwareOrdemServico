package br.com.wrs.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.wrs.jdbc.ConnectionFactory;
import br.com.wrs.modelo.Categoria;

public class CategoriaDao {
	// a conexão com o banco de dados
				private Connection connection;
				public CategoriaDao() {
					//this.connection = new ConnectionFactory().;
					try {
						connection = ConnectionFactory.getInstancia().getConnection();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		
				
				//metodo adiciona contato
				public void adiciona(Categoria categoria) {
					String sql = "insert into categoria " + "(nome_categoria,setor_idsetor)" + " values (?,?)";

					try {
						// prepared statement para inserção
						PreparedStatement stmt = connection.prepareStatement(sql);
						// seta os valores
						stmt.setString(1, categoria.getNomeCategoria());
						stmt.setInt(2, categoria.getSetor());
						// executa
						stmt.execute();
						stmt.close();
						connection.close();
						System.out.println("ADICIONADA CATEGORIA");
					} catch (SQLException e) {
						throw new RuntimeException(e);
					}
				}

				//metodo lista contato
				public List<Categoria> getLista() {
					try {
						List<Categoria> categorias = new ArrayList<Categoria>();
						PreparedStatement stmt = this.connection.prepareStatement("select * from categoria");
						ResultSet rs = stmt.executeQuery();

						while (rs.next()) {
							// criando o objeto Contato
							Categoria categoria = new Categoria();
							categoria.setIdCategoria(rs.getInt("idCategoria"));
							categoria.setNomeCategoria(rs.getString("nome_categoria"));
							
							// adicionando o objeto à lista
							categorias.add(categoria);
						}
						rs.close();
						stmt.close();
						connection.close();
						return categorias;
						
					} catch (SQLException e) {
						throw new RuntimeException(e);
					}
				}
				
				
				
				//metodo atualiza contato
				public void altera(Categoria categoria) {
				     String sql = "update categoria set nome_categoria=?"+
				             		" where idCategoria=?";
				 
				     try {
				         PreparedStatement stmt = connection
				                 .prepareStatement(sql);
				         stmt.setString(1, categoria.getNomeCategoria());
				         stmt.setInt(2, categoria.getIdCategoria());
				         stmt.execute();
				         stmt.close();
				         connection.close();
				     } catch (SQLException e) {
				         throw new RuntimeException(e);
				     }
				 }
				
				//metodo remove contato
				public void remove(Categoria categoria) {
				     try {
				         PreparedStatement stmt = connection
				                 .prepareStatement("delete from categoria where idCategoria=?");
				         stmt.setInt(1, categoria.getIdCategoria());
				         stmt.execute();
				         stmt.close();
				         connection.close();
				     } catch (SQLException e) {
				         throw new RuntimeException(e);
				     }
				 }
		
}
