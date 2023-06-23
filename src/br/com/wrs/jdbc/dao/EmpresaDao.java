package br.com.wrs.jdbc.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.wrs.jdbc.ConnectionFactory;
import br.com.wrs.modelo.Empresa;

public class EmpresaDao {

	// a conexão com o banco de dados
		private Connection connection;
	
		public EmpresaDao(){
			//this.connection = new ConnectionFactory().;
			try {
				connection = ConnectionFactory.getInstancia().getConnection();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//metodo adiciona contato
		public void adiciona(Empresa empresa) {
			String sql = "insert into Empresa " + "(nome_empresa)" + " values (?)";

			try {
				// prepared statement para inserção
				PreparedStatement stmt = connection.prepareStatement(sql);
				// seta os valores
				stmt.setString(1, empresa.getNomeEmpresa());
				// executa
				stmt.execute();
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}

		//metodo lista contato
		public List<Empresa> getLista() {
			try {
				List<Empresa> empresa = new ArrayList<Empresa>();
				PreparedStatement stmt = this.connection.prepareStatement("select * from empresa");
				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {
					// criando o objeto Contato
					Empresa emp = new Empresa();
					emp.setIdEmpresa(rs.getInt("idempresa"));
					emp.setNomeEmpresa(rs.getString("nome_empresa"));
					
					// adicionando o objeto à lista
					empresa.add(emp);
				}
				rs.close();
				stmt.close();
				connection.close();
				return empresa;
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
		//metodo atualiza contato
		public void altera(Empresa empresa) {
		     String sql = "update empresa set nome_empresa=?"+
		             		" where id=?";
		 
		     try {
		         PreparedStatement stmt = connection
		                 .prepareStatement(sql);
		         stmt.setString(1, empresa.getNomeEmpresa());
		         stmt.setInt(2, empresa.getIdEmpresa());
		         stmt.execute();
		         stmt.close();
		         connection.close();
		     } catch (SQLException e) {
		         throw new RuntimeException(e);
		     }
		 }
		
		//metodo remove contato
		public void remove(Empresa empresa) {
		     try {
		         PreparedStatement stmt = connection
		                 .prepareStatement("delete from empresa where id=?");
		         stmt.setInt(1, empresa.getIdEmpresa());
		         stmt.execute();
		         stmt.close();
		         connection.close();
		     } catch (SQLException e) {
		         throw new RuntimeException(e);
		     }
		 }
		
}
