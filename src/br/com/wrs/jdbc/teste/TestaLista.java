package br.com.wrs.jdbc.teste;

import java.util.List;


import br.com.wrs.jdbc.dao.TicketDao;

import br.com.wrs.modelo.Ticket;

public class TestaLista {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		
		TicketDao dao = new TicketDao();
		List<Ticket> tickets = dao.getLista(2);
		
		for (Ticket ticket : tickets) {
			  System.out.println("id: " + ticket.getIdTicket());
			  System.out.println("Solicitante: " + ticket.getNomeUsuario());
			  System.out.println("categoria" + ticket.getNomeCategoria());
			  
			}
		
	}

}
