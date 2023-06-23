package br.com.wrs.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.wrs.jdbc.dao.UsuarioDao;
import br.com.wrs.modelo.Usuario;

/**
 * Servlet implementation class LoginAtendimento
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		if (request.getSession().isNew() == false) {
			// request.getSession().invalidate();
			request.getSession(true);
			String email = request.getParameter("txt_email");
			String senha = request.getParameter("txt_senha");

			Usuario usuario = new Usuario();
			UsuarioDao dao = new UsuarioDao();

			usuario = dao.listaUsuario(email, senha);

			if (usuario != null) {

				request.getSession().setAttribute("usuario_sessao", usuario.getIdUsuario());
				request.getSession().setAttribute("usuario_nome_sessao", usuario.getNomeUsuario());
				response.sendRedirect("/SoftwareLoja1/ListaTicket");

			} else {

				response.sendRedirect("login.jsp");
				request.setAttribute("mensagem_sessao", "Verifique dados. Erro ao realizar o login!");

			}
		}
	}
}
