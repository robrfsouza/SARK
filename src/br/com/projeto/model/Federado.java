package br.com.projeto.model;

public class Federado extends Membros {
	private int idFederecao;
	private String nomeFederacao;
	private String registro;
	private int anoRegistro;
	private int anuidade;
	private String status;
	private String numeroRegistro;
	private int idFederado;
	//Generate Getters and Setters

	public int getIdFederado() {
		return idFederado;
	}
	public void setIdFederado(int idFederado) {
		this.idFederado = idFederado;
	}
	
	public String getNumeroRegistro() {
		return numeroRegistro;
	}
	public void setNumeroRegistro(String numeroRegistro) {
		this.numeroRegistro = numeroRegistro;
	}

	public int getIdFederecao() {
		return idFederecao;
	}
	public void setIdFederecao(int idFederecao) {
		this.idFederecao = idFederecao;
	}
	public String getNomeFederacao() {
		return nomeFederacao;
	}
	public void setNomeFederacao(String nomeFederacao) {
		this.nomeFederacao = nomeFederacao;
	}
	public String getRegistro() {
		return registro;
	}
	public void setRegistro(String registro) {
		this.registro = registro;
	}
	public int getAnoRegistro() {
		return anoRegistro;
	}
	public void setAnoRegistro(int anoRegistro) {
		this.anoRegistro = anoRegistro;
	}
	public int getAnuidade() {
		return anuidade;
	}
	public void setAnuidade(int anuidade) {
		this.anuidade = anuidade;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return idFederecao + " - " + nomeFederacao ;
	}
	
	
}
