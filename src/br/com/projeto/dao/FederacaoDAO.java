package br.com.projeto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.model.Federacao;
import br.com.projeto.model.WebServiceCep;

public class FederacaoDAO {

	public Connection con;

	public FederacaoDAO() {
		this.con = new ConnectionFactory().getConnection();
	}

	// Metodo Cadastrar Federacao
	public void cadastrarFederacao(Federacao federacao) {
		try {
			// criar o comando sql
			String sql = "insert into tbl_federacao(nome, email, telefone, endereco, "
					+ "numero, bairro, cep, cidade, estado, pix) " + "values (?,?,?,?,?,?,?,?,?,?)";

			// conectar o banco de dados, organizar comando sql
			try (PreparedStatement smtp = con.prepareStatement(sql)) {
				smtp.setString(1, federacao.getNome());
				smtp.setString(2, federacao.getEmail());
				smtp.setString(3, federacao.getTelefone());
				smtp.setString(4, federacao.getEndereco());
				smtp.setInt(5, federacao.getNumero());
				smtp.setString(6, federacao.getBairro());
				smtp.setString(7, federacao.getCep());
				smtp.setString(8, federacao.getCidade());
				smtp.setString(9, federacao.getEstado());
				smtp.setString(10, federacao.getPix());

				// executar o comando sql
				smtp.execute();
				JOptionPane.showMessageDialog(null, "Cadastro efetuado!");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			// TODO: handle exception
		}
	}

	// Metodo Alterar Federacao
	public void alterarFederacao(Federacao federacao) {
		try {
			// criar o comando sql
			String sql = "update tbl_federacao set nome=?, email=?, telefone=?, endereco=?, "
					+ "numero=?, bairro=?, cep=?, cidade=?, estado=?, pix=? where id_federacao=?";

			// conectar o banco de dados, organizar comando sql
			try (PreparedStatement smtp = con.prepareStatement(sql)) {
				smtp.setString(1, federacao.getNome());
				smtp.setString(2, federacao.getEmail());
				smtp.setString(3, federacao.getTelefone());
				smtp.setString(4, federacao.getEndereco());
				smtp.setInt(5, federacao.getNumero());
				smtp.setString(6, federacao.getBairro());
				smtp.setString(7, federacao.getCep());
				smtp.setString(8, federacao.getCidade());
				smtp.setString(9, federacao.getEstado());
				smtp.setString(10, federacao.getPix());
				smtp.setInt(11, federacao.getIdFederacao());

				// executar o comando sql
				smtp.executeUpdate();
				JOptionPane.showMessageDialog(null, "Alteracao concluída!");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	// metodo listar federacao
	public List<Federacao> listarFederacao() {
		List<Federacao> lista = new ArrayList<>();

		try {
			// criar o comando sql
			String sql = "select * from tbl_federacao";

			// conectar o banco de dados e preparar o sql
			try (PreparedStatement smtp = con.prepareStatement(sql); ResultSet resultset = smtp.executeQuery()) {

				while (resultset.next()) {

					// criar um federacao set federacao
					Federacao federacao = new Federacao();

					federacao.setIdFederacao(resultset.getInt("id_federacao"));
					federacao.setNome(resultset.getString("nome"));
					federacao.setEmail(resultset.getString("email"));
					federacao.setTelefone(resultset.getString("telefone"));
					federacao.setEndereco(resultset.getString("endereco"));
					federacao.setNumero(resultset.getInt("numero"));
					federacao.setBairro(resultset.getString("bairro"));
					federacao.setCep(resultset.getString("cep"));
					federacao.setCidade(resultset.getString("cidade"));
					federacao.setEstado(resultset.getString("estado"));
					federacao.setPix(resultset.getString("pix"));

					// adicionar a federacao na lista
					lista.add(federacao);
				}
			}
			return lista;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return null;
		}
	}
	
	public Federacao ConsultaFederacao (int idFederacao) {
		if (con == null) {
	        JOptionPane.showMessageDialog(null, "Conexão com o banco de dados não está disponível.");
	        return null;
		}
		String sql = "select * from tbl_federacao where id_federacao=?";
		try {
			try(PreparedStatement smtp = con.prepareStatement(sql)){
				smtp.setInt(1, idFederacao);
				Federacao federacao = new Federacao();
				try(ResultSet resultset = smtp.executeQuery()){
					if(resultset.next()) {
						federacao.setIdFederacao(resultset.getInt("id_federacao"));
						federacao.setNome(resultset.getString("nome"));
						federacao.setEmail(resultset.getString("email"));
						federacao.setTelefone(resultset.getString("telefone"));
						federacao.setEndereco(resultset.getString("endereco"));
						federacao.setNumero(resultset.getInt("numero"));
						federacao.setBairro(resultset.getString("bairro"));
						federacao.setCep(resultset.getString("cep"));
						federacao.setCidade(resultset.getString("cidade"));
						federacao.setEstado(resultset.getString("estado"));
						federacao.setPix(resultset.getString("pix"));
						return federacao;
					}
					else {
						return null;
					}
				}
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Não foi possível fazer a consulta no Banco de Dados: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	// busca cep
	public Federacao buscaCep(String cep) {

		WebServiceCep webServiceCep = WebServiceCep.searchCep(cep);

		Federacao federacao = new Federacao();

		if (webServiceCep.wasSuccessful()) {
			federacao.setEndereco(webServiceCep.getLogradouroFull());
			federacao.setCidade(webServiceCep.getCidade());
			federacao.setBairro(webServiceCep.getBairro());
			federacao.setEstado(webServiceCep.getUf());
			return federacao;
		} else {
			JOptionPane.showMessageDialog(null, "Erro numero: " + webServiceCep.getResulCode());
			JOptionPane.showMessageDialog(null, "Descrição do erro: " + webServiceCep.getResultText());
			return null;
		}

	}

}
