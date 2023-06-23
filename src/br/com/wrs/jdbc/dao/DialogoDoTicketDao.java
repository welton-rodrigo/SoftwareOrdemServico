package br.com.wrs.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.wrs.jdbc.ConnectionFactory;
import br.com.wrs.modelo.DialogoDoTicket;

public class DialogoDoTicketDao {

	// a conex�o com o banco de dados
	private Connection connection;

	public DialogoDoTicketDao() {
		// this.connection = new ConnectionFactory().;
		try {
			connection = ConnectionFactory.getInstancia().getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// metodo lista contato
	public List<DialogoDoTicket> getLista(int idTicket) {
		try {
			String sql = "select * from dialogodoticket where iddialogodoticket = ?;";

			List<DialogoDoTicket> lista = new ArrayList<DialogoDoTicket>();
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, idTicket);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto Contato
				DialogoDoTicket dialogo = new DialogoDoTicket();
				dialogo.setIddialogodoticket(rs.getInt("iddialogodoticket"));
				dialogo.setFkidusuario(rs.getInt("fk_id_usuario"));
				dialogo.setTextodialogo(rs.getString("texto_dialogo"));
				dialogo.setFkdonochamado(rs.getInt("fk_dono_chamado"));

				// adicionando o objeto � lista
				lista.add(dialogo);
			}
			rs.close();
			stmt.close();
			connection.close();
			return lista;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// metodo adiciona dialogo testo
	public void adiciona(DialogoDoTicket dialogo) {
		String sql = "insert into dialogodoticket " + "(iddialogoDoTicket,fk_id_usuario,texto_dialogo,fk_dono_chamado)"
				+ " values (?,?,?,?)";

		try {
			// prepared statement para inser��o
			PreparedStatement stmt = connection.prepareStatement(sql);
			// seta os valores
			stmt.setInt(1, dialogo.getIddialogodoticket());
			stmt.setInt(2, dialogo.getFkidusuario());
			stmt.setString(3, dialogo.getTextodialogo());
			stmt.setInt(4, dialogo.getFkdonochamado());
			// executa
			stmt.execute();
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

}
