package br.com.wrs.jdbc.teste;

import br.com.wrs.jdbc.dao.UsuarioDao;
import br.com.wrs.modelo.Usuario;

public class TestaUsuarioDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		UsuarioDao udao = new UsuarioDao();
		Usuario user =	udao.listaUsuario("luciana@gmail.com", "123456");
		System.out.println(user.getEmail()); 
		
	}

}
