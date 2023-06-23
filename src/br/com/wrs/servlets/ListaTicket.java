package br.com.wrs.servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.wrs.jdbc.dao.TicketDao;
import br.com.wrs.modelo.Ticket;

/**
 * Servlet implementation class ListaTicket
 */
@WebServlet("/ListaTicket")
public class ListaTicket extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListaTicket() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		Integer EmpresaDominio = (Integer) request.getSession().getAttribute("EmpresaDominio");
		//buscar objetos em sessao e jogar no if
		
		if (EmpresaDominio == null || EmpresaDominio == 0) {
			response.sendRedirect("/SoftwareLoja1/login.jsp");
		} else {
			System.out.println("em sessao " + EmpresaDominio);
			TicketDao tdao = new TicketDao();
			List<Ticket> ticket = tdao.getLista(EmpresaDominio);
			request.setAttribute("lista", ticket);
			RequestDispatcher view = request.getRequestDispatcher("/ListarTickets.jsp");
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
