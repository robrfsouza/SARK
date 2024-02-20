package br.com.projeto.model;

public class RepresentanteFederacao extends Federacao{

	private int idRepresentante;
	private String representante;
	private String funcao;
	private String status;
	private int ano;
	private String emailRepresentante;
	private String telefoneRepresentante;
	
	//Constructor que chama o constructor da classe mae (Federacao)
	public RepresentanteFederacao() {
		super(); // chama o constructor da classe mae
	}

	//Generate Getters and Setters
	public int getIdRepresentante() {
		return idRepresentante;
	}
	public void setIdRepresentante(int idRepresentante) {
		this.idRepresentante = idRepresentante;
	}
	public String getRepresentante() {
		return representante;
	}
	public void setRepresentante(String representante) {
		this.representante = representante;
	}
	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getEmailRepresentante() {
		return emailRepresentante;
	}
	public void setEmailRepresentante(String emailRepresentante) {
		this.emailRepresentante = emailRepresentante;
	}
	public String gettelefoneRepresentante() {
		return telefoneRepresentante;
	}
	public void settelefoneRepresentante(String telefoneRepresentante) {
		this.telefoneRepresentante = telefoneRepresentante;
	}

	@Override
	public String toString() {
		return representante;
	}
	
	
}
