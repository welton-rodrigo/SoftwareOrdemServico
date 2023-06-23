package br.com.wrs.modelo;

public class Departamento {

	private int idDepartamento;
	private String nomeDepartamento;
	private int idEmpresa;
	
	public int getIdDepartamento() {
		return idDepartamento;
	}
	public void setIdDepartamento(int idDepartamento) {
		this.idDepartamento = idDepartamento;
	}
	public String getNomeDepartamento() {
		return nomeDepartamento;
	}
	public void setNomeDepartamento(String nomeDepartamento) {
		this.nomeDepartamento = nomeDepartamento;
	}
	public int getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(Empresa idEmpresa) {
		this.idEmpresa = idEmpresa.getIdEmpresa();
	}
	
	
}
