package br.com.wrs.jdbc.teste;

import br.com.wrs.jdbc.dao.EmpresaDao;
import br.com.wrs.modelo.Empresa;

public class InsereEmpresa {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub

		Empresa emp = new Empresa();
		emp.setNomeEmpresa("Marcos Internet Via Radio");
		
		EmpresaDao edao = new EmpresaDao();
		edao.adiciona(emp);
		System.out.println("Empresa "+emp.getNomeEmpresa()+" foi adicionada com sucesso!");
		
		
	}

}
