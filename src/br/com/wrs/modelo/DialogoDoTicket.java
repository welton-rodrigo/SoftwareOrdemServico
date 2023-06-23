package br.com.wrs.modelo;

public class DialogoDoTicket {

	private int iddialogodoticket;
	private int fkidusuario;
	private String textodialogo;
	private int fkdonochamado;
	
	
	
	
	public int getFkdonochamado() {
		return fkdonochamado;
	}
	public void setFkdonochamado(int fkdonochamado) {
		this.fkdonochamado = fkdonochamado;
	}
	
	public void setFkdonochamado(Usuario fkdonochamado) {
		this.fkdonochamado = fkdonochamado.getIdUsuario();
	}
	
	public int getIddialogodoticket() {
		return iddialogodoticket;
	}
	public void setIddialogodoticket(int iddialogodoticket) {
		this.iddialogodoticket = iddialogodoticket;
	}
	
	public void setIddialogodoticket(Ticket t) {
		this.iddialogodoticket = t.getIdTicket();
	}
	
	public int getFkidusuario() {
		return fkidusuario;
	}
	public void setFkidusuario(int fkidusuario) {
		this.fkidusuario = fkidusuario;
	}
	
	public void setFkidusuario(Usuario user) {
		this.fkidusuario = user.getIdUsuario();
	}
	
	public String getTextodialogo() {
		return textodialogo;
	}
	public void setTextodialogo(String textodialogo) {
		this.textodialogo = textodialogo;
	}
	
	
	
}
