package br.com.wrs.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.wrs.jdbc.dao.DialogoDoTicketDao;
import br.com.wrs.modelo.DialogoDoTicket;

/**
 * Servlet implementation class SalvarDialogoTextoServlet
 */
@WebServlet("/SalvarDialogoTextoServlet")
public class SalvarDialogoTextoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SalvarDialogoTextoServlet() {
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String p_txt_mensagem = request.getParameter("txt_mensagem");
		Integer p_usuario_sessao = (Integer) request.getSession().getAttribute("usuario_sessao");
		Integer p_idrow = (Integer) request.getSession().getAttribute("idrow");
		String ps_idrow = Integer.toString(p_idrow);
		System.out.println(p_txt_mensagem);
		System.out.println(p_usuario_sessao);
		System.out.println(p_idrow);

		DialogoDoTicket d1 = new DialogoDoTicket();
		d1.setIddialogodoticket(p_idrow);
		d1.setFkidusuario(p_usuario_sessao);
		d1.setTextodialogo(p_txt_mensagem);
		d1.setFkdonochamado(p_usuario_sessao);

		DialogoDoTicketDao dao = new DialogoDoTicketDao();
		dao.adiciona(d1);

		response.sendRedirect("AbrirTicketServlet?idTicketRow=" + ps_idrow + "");

	}

}
