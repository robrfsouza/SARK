package br.com.projeto.model;

public class Federacao {
	
	private int idFederacao;
	private String nome;
	private String endereco;
	private String cep;
	private String bairro;
	private int numero;
	private String cidade;
	private String estado;
	private String email;
	private String telefone;
	private String pix;

	//Generate Getters and Setters
	public int getIdFederacao() {
		return idFederacao;
	}
	public void setIdFederacao(int idFederacao) {
		this.idFederacao = idFederacao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getPix() {
	return pix;
	}
	
	public void setPix(String pix) {
		this.pix = pix;
	}
	@Override
	public String toString() {
		return  idFederacao + " - " + nome;
	}
	
	//Metodo toString
	
}
