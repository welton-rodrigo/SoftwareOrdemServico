package br.com.wrs.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.wrs.jdbc.dao.DialogoDoTicketDao;
import br.com.wrs.jdbc.dao.TicketDao;
import br.com.wrs.modelo.DialogoDoTicket;
import br.com.wrs.modelo.Ticket;

/**
 * Servlet implementation class AbrirTicketServlet
 */
@WebServlet("/AbrirTicketServlet")
public class AbrirTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AbrirTicketServlet() {
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

		try {
			int usuario_sessao = (Integer) request.getSession().getAttribute("usuario_sessao");
			System.out.println("var Usuario_sessao = " + usuario_sessao);
			
			String id = request.getParameter("idTicketRow");
			System.out.println("var parametro idTicketTabela = " + id);
			
			int cid = Integer.parseInt(id);
			DialogoDoTicketDao dao = new DialogoDoTicketDao();
			List<DialogoDoTicket> dialogos = dao.getLista(cid);
			
			if (dialogos.size()!=0) {
				int donochamado = dialogos.get(0).getFkdonochamado();
				
				System.out.println("var donochamado = " + donochamado);
				
				if (donochamado == usuario_sessao) {
					TicketDao tdao = new TicketDao();
					List<Ticket> listatickets = tdao.getListaPorTicket(cid);
					String assunto = listatickets.get(0).getAssunto();
					String setor = listatickets.get(0).getNomeSetor();
					String categoria = listatickets.get(0).getNomeCategoria();
					
					request.setAttribute("assunto", assunto);
					request.setAttribute("setor", setor);
					request.setAttribute("categoria", categoria);
					request.getSession().setAttribute("idrow", cid);
					
					request.setAttribute("lista", dialogos);
					
					RequestDispatcher view = request.getRequestDispatcher("/AbrirTicket.jsp");
					view.forward(request, response);
				}
			} else {
				TicketDao tdao = new TicketDao();
				List<Ticket> listatickets = tdao.getListaPorTicket(cid);
				String assunto = listatickets.get(0).getAssunto();
				String setor = listatickets.get(0).getNomeSetor();
				String categoria = listatickets.get(0).getNomeCategoria();
				String mensagem = listatickets.get(0).getMensagem();
				
				request.setAttribute("assunto", assunto);
				request.setAttribute("setor", setor);
				request.setAttribute("categoria", categoria);
				request.getSession().setAttribute("idrow", cid);
				request.setAttribute("mensagem", mensagem);
				
				RequestDispatcher view = request.getRequestDispatcher("/AbrirTicket.jsp");
				view.forward(request, response);
			}
		} catch (Exception e) {
			System.out.println("Erro na execução do servlet AbrirTicketServlet {....}"+e);
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
