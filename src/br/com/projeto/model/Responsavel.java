package br.com.projeto.model;

public class Responsavel extends Membros{
	private String nomeResponsavel;
	private String parentesco;
	private String telefone;
	private String email;
	private int idResponsavel;
	
	//Metodos Getters e Setters
	
	public int getIdResponsavel() {
		return idResponsavel;
	}
	public void setIdResponsavel(int idResponsavel) {
		this.idResponsavel = idResponsavel;
	}
	public String getNomeResponsavel() {
		return nomeResponsavel;
	}
		public void setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
	}
	public String getParentesco() {
		return parentesco;
	}
	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
}
