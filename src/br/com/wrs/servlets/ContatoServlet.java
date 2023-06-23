package br.com.wrs.servlets;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.wrs.jdbc.dao.TicketDao;
import br.com.wrs.modelo.Ticket;

/**
 * l2 * Servlet implementation class ContatoServlet
 */
@WebServlet("/ContatoServlet")
public class ContatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ContatoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			Integer departamento = (Integer) request.getSession().getAttribute("departamento_sessao");
			
			if (departamento == null || departamento == 0) {
				response.sendRedirect("/SoftwareLoja1/login.jsp");
				
			} else {
				
				String assunto = request.getParameter("txt_assunto");
				int setor = Integer.parseInt(request.getParameter("setor"));
				int categoria = Integer.parseInt(request.getParameter("categoria"));
				String mensagem = request.getParameter("txt_mensagem");
				int usuario_sessao = (Integer) request.getSession().getAttribute("usuario_sessao");
				
				Ticket t = new Ticket();
				t.setAssunto(assunto);
				t.setIdSetor(setor);
				t.setIdcategoria(categoria);
				t.setMensagem(mensagem);
				t.setIdUsuario(usuario_sessao);
				t.setDataCriacao(Calendar.getInstance());
				TicketDao dao = new TicketDao();
				dao.adiciona(t);
				response.sendRedirect("ListaTicket");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
