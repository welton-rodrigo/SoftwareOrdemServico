package br.com.wrs.jdbc.teste;

import java.sql.SQLException;

import br.com.wrs.jdbc.dao.CategoriaDao;
import br.com.wrs.modelo.Categoria;

public class TestaCategoria {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Categoria c = new Categoria();
		c.setNomeCategoria("teste2");
		c.setSetor(2);
		
		CategoriaDao cdao1 = new CategoriaDao();
		cdao1.adiciona(c);
	
		
	}

}
