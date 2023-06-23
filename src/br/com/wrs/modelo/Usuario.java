package br.com.wrs.modelo;

public class Usuario {
	private int idUsuario;
	private String nomeUsuario;
	private String email;
	private String senha;
	private int empresaDominio;
	
	
	
	public int getEmpresaDominio() {
		return empresaDominio;
	}
	public void setEmpresaDominio(int empresaDominio) {
		this.empresaDominio = empresaDominio;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	
}
