package br.com.wrs.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.wrs.jdbc.ConnectionFactory;
import br.com.wrs.modelo.Usuario;

public class UsuarioDao {

	// a conex�o com o banco de dados
	private Connection connection;
	
	//Construtor
	public UsuarioDao() {
		// this.connection = new ConnectionFactory().;
		try {
			connection = ConnectionFactory.getInstancia().getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// metodo adiciona usuario
	public void adiciona(Usuario usuario) {
		String sql = "insert into usuario " + "(nomeUsuario,emailUsuario,empresaDominio)" + " values (?,?,?)";

		try {
			
			// prepared statement para inser��o
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			// seta os valores
			stmt.setString(1, usuario.getNomeUsuario());
			stmt.setString(2, usuario.getEmail());
			stmt.setInt(3, usuario.getEmpresaDominio());
			
			stmt.execute();
			stmt.close();
			connection.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// metodo lista todos usuarios
	public List<Usuario> getLista() {
		try {
			List<Usuario> usuario = new ArrayList<Usuario>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from usuario");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto Contato
				Usuario user = new Usuario();
				user.setIdUsuario(rs.getInt("idUsuario"));
				user.setNomeUsuario(rs.getString("nomeUsuario"));
				user.setEmail(rs.getString("emailUsuario"));
				user.setSenha(rs.getString("senhaUsuario"));
				// adicionando o objeto � lista
				usuario.add(user);
			}
			rs.close();
			stmt.close();
			connection.close();
			return usuario;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// metodo atualiza apenas um usuario
	public Usuario listaUsuario(String email, String senha) {
		
		String sql = "select * from mydb.usuario where email = ? and senha = ?;";
		Usuario usuario = null;
		
		try {
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, email);
			stmt.setString(2, senha);
			
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				
				Usuario user = new Usuario();
				
				user.setIdUsuario(rs.getInt("idUsuario"));
				user.setNomeUsuario(rs.getString("nomeUsuario"));
				user.setEmail(rs.getString("emailUsuario"));
				user.setSenha(rs.getString("senhaUsuario"));
				user.setEmpresaDominio(rs.getInt("empresaDominio"));
				
				usuario = user;
				
				}
			
			rs.close();
			stmt.close();
			connection.close();
			connection = null;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return usuario;

	}

	// metodo atualiza Usuario
	public Usuario listaUsuarioLoginU(String email, String senha) {
		
		String sql = "select email,senha,departamento_iddepartamento from mydb.usuario where email = ? and senha = ?;";

		try {

			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, email);
			stmt.setString(2, senha);
			
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				
				Usuario user = new Usuario();
				
				user.setNomeUsuario(rs.getString("nomeUsuario"));
				user.setEmail(rs.getString("emailUsuario"));
				user.setSenha(rs.getString("senhaUsuario"));
				user.setEmpresaDominio(rs.getInt("empresaDominio"));
				

				if ((user.getEmail().equals(email) && (user.getSenha().equals(senha)))) {
					
					return user;
				}

			}
			// stmt.execute();
			rs.close();
			stmt.close();
			connection.close();
			connection = null;
			
		} catch (SQLException e) {
			
			throw new RuntimeException(e);
			
		}
		return null;
	}

	// metodo atualiza Usuario
	public void altera(Usuario usuario) {
		
		String sql = "update usuario set nomeUsuario=?" + " where idUsuario=?";

		try {
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, usuario.getNomeUsuario());
			stmt.setInt(2, usuario.getIdUsuario());
			
			stmt.execute();
			stmt.close();
			
			connection.close();
			
		} catch (SQLException e) {
			
			throw new RuntimeException(e);
			
		}
	}

	// metodo remove Usuario
	public void remove(Usuario usuario) {
		try {
			
			PreparedStatement stmt = connection.prepareStatement("delete from usuario where id=?");
			stmt.setInt(1, usuario.getIdUsuario());
			stmt.execute();
			stmt.close();
			connection.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
