package br.com.wrs.modelo;

public class Categoria {
	private int idCategoria;
	private String nomeCategoria;
	private int setor;
	
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getNomeCategoria() {
		return nomeCategoria;
	}
	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}
	public int getSetor() {
		return setor;
	}
	public void setSetor(int setor) {
		this.setor = setor;
	}
	public void setSetor(Setor setor) {
		this.setor = setor.getIdSetor();
	}
	
	
	
	
	
	
	
}
