package br.com.wrs.jdbc.teste;

import java.util.List;

import br.com.wrs.jdbc.dao.DepartamentoDao;
import br.com.wrs.jdbc.dao.EmpresaDao;
import br.com.wrs.modelo.Departamento;
import br.com.wrs.modelo.Empresa;

public class InsereDepartamento {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		EmpresaDao Empresadao = new EmpresaDao();
		DepartamentoDao depdao = new DepartamentoDao();
		List<Empresa> departamentos = Empresadao.getLista();
		Empresa emp = departamentos.get(1);
		System.out.println(emp.getNomeEmpresa());
		
		Departamento dep = new Departamento();
		dep.setNomeDepartamento("Informática");
		dep.setIdEmpresa(emp);
		
		depdao.adiciona(dep);
		System.out.println("Departamento : " + dep.getNomeDepartamento() + "adicionado com sucesso!");
		
		
	}

}
