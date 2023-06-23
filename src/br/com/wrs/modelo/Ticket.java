package br.com.wrs.modelo;

import java.util.Calendar;

public class Ticket {
	private int idTicket;
	private String assunto;
	private String mensagem;
	private int idSetor;
	private int idUsuario;
	private String nomeUsuario;
	private String nomeSetor;
	private int categoria;
	private String nomeCategoria;
	private Calendar dataCriacao;
	private Calendar dataAlteracao;
	
		
	
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	public Calendar getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Calendar dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public Calendar getDataAlteracao() {
		return dataAlteracao;
	}
	public void setDataAlteracao(Calendar dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}
	public String getNomeCategoria() {
		return nomeCategoria;
	}
	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}
	public int getIdcategoria() {
		return categoria;
	}
	public void setIdcategoria(int categoria) {
		this.categoria = categoria;
	}
	public void setIdcategoria(Categoria categoria) {
		this.categoria = categoria.getIdCategoria();
	}
	
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public String getNomeSetor() {
		return nomeSetor;
	}
	public void setNomeSetor(String nomeSetor) {
		this.nomeSetor = nomeSetor;
	}
	public int getIdTicket() {
		return idTicket;
	}
	public void setIdTicket(int idTicket) {
		this.idTicket = idTicket;
	}
	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public int getIdSetor() {
		return idSetor;
	}
	public void setIdSetor(Setor setor) {
		this.idSetor = setor.getIdSetor();
	}
	
	public void setIdSetor(int setor) {
		this.idSetor = setor;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Usuario usuario) {
		this.idUsuario = usuario.getIdUsuario();
	}
	public void setIdUsuario(int usuario) {
		this.idUsuario = usuario;
	}
	
	
}
