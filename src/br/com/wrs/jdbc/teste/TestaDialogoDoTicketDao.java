package br.com.wrs.jdbc.teste;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.wrs.jdbc.dao.DialogoDoTicketDao;
import br.com.wrs.modelo.DialogoDoTicket;

public class TestaDialogoDoTicketDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<DialogoDoTicket> lista = new ArrayList<DialogoDoTicket>();
		DialogoDoTicketDao d = new DialogoDoTicketDao();
		lista = d.getLista(1);
		Iterator<DialogoDoTicket> it = lista.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
			
		}
	}

}
