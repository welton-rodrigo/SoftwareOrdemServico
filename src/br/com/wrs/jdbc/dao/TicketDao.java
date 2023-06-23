package br.com.wrs.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import br.com.wrs.jdbc.ConnectionFactory;
import br.com.wrs.modelo.Ticket;


public class TicketDao {

	// a conex�o com o banco de dados
	private Connection connection;

	public TicketDao(){
		//this.connection = new ConnectionFactory().;
		try {
			connection = ConnectionFactory.getInstancia().getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// metodo adiciona contato
	public void adiciona(Ticket ticket) {
		String sql = "insert into ticket " + "(assunto,mensagem,setor,usuario,categoria,ticket_data_criacao)"
				+ " values (?,?,?,?,?,?)";

		try {
			// prepared statement para inser��o
			PreparedStatement stmt = connection.prepareStatement(sql);
			// seta os valores
			stmt.setString(1, ticket.getAssunto());
			stmt.setString(2, ticket.getMensagem());
			stmt.setInt(3, ticket.getIdSetor());
			stmt.setInt(4, ticket.getIdUsuario());
			stmt.setInt(5, ticket.getIdcategoria());
			stmt.setDate(6, new Date(ticket.getDataCriacao().getTimeInMillis()));
			// executa
			stmt.execute();
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
	} 

	// metodo lista contato
	public List<Ticket> getLista(int departamento) {
		try {
			List<Ticket> tickets = new ArrayList<Ticket>();
			String sql = "SELECT ticket.idticket, usuario.nome_usuario, setor.nome_setor, ticket.assunto, ticket.mensagem, categoria.nome_categoria, ticket.ticket_data_criacao "+
			"FROM ticket "+
			"INNER JOIN usuario, setor, categoria "+
			"WHERE ticket.setor = setor.idsetor and ticket.Usuario=usuario.idUsuario and ticket.Categoria=categoria.idCategoria and usuario.departamento_iddepartamento = ?";
			
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, departamento);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto Contato
				Ticket t = new Ticket();

				t.setIdTicket(rs.getInt("idticket"));
				t.setNomeUsuario(rs.getString("nome_usuario"));
				t.setNomeSetor(rs.getString("nome_setor"));
				t.setAssunto(rs.getString("assunto"));
				t.setMensagem(rs.getString("mensagem"));
				t.setNomeCategoria(rs.getString("nome_categoria"));
				// montando a data através do Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("ticket_data_criacao"));
				t.setDataCriacao(data);
				
				// adicionando o objeto � lista
				tickets.add(t);
			}
			rs.close();
			stmt.close();
			connection.close();
			connection = null;
			return tickets;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// metodo lista contato
		public List<Ticket> getListaPorTicket(int ticket) {
			try {
				List<Ticket> tickets = new ArrayList<Ticket>();
				String sql = "SELECT ticket.idticket, usuario.nome_usuario, setor.nome_setor, ticket.assunto, ticket.mensagem, categoria.nome_categoria, ticket.ticket_data_criacao "+
				"FROM ticket "+
				"INNER JOIN usuario, setor, categoria "+
				"WHERE ticket.setor = setor.idsetor and ticket.Usuario=usuario.idUsuario and ticket.Categoria=categoria.idCategoria and ticket.idticket = ?";
				
				PreparedStatement stmt = this.connection.prepareStatement(sql);
				stmt.setInt(1, ticket);
				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {
					// criando o objeto Contato
					Ticket t = new Ticket();

					t.setIdTicket(rs.getInt("idticket"));
					t.setNomeUsuario(rs.getString("nome_usuario"));
					t.setNomeSetor(rs.getString("nome_setor"));
					t.setAssunto(rs.getString("assunto"));
					t.setMensagem(rs.getString("mensagem"));
					t.setNomeCategoria(rs.getString("nome_categoria"));
					// montando a data atrav�s do Calendar
					Calendar data = Calendar.getInstance();
					data.setTime(rs.getDate("ticket_data_criacao"));
					t.setDataCriacao(data);
					
					// adicionando o objeto � lista
					tickets.add(t);
				}
				rs.close();
				stmt.close();
				connection.close();
				connection = null;
				return tickets;

			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	
	// metodo atualiza contato
	public void altera(Ticket t) {
		String sql = "update ticket set assunto=?" + " where idTicket=?";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, t.getAssunto());
			stmt.setInt(2, t.getIdTicket());
			stmt.execute();
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// metodo remove contato
	public void remove(Ticket t) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from ticket where idTicket=?");
			stmt.setInt(1, t.getIdTicket());
			stmt.execute();
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
