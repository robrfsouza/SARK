package br.com.projeto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.model.Academia;
import br.com.projeto.model.WebServiceCep;

public class AcademiaDAO {

	public Connection con;

	public AcademiaDAO() {
		this.con = new ConnectionFactory().getConnection();
	}

	// método incluir
	public void incluirAcademia(Academia academia) {
		try {
			// criar o comando sql
			String sql = "insert into tbl_academia (nome, telefone, cep, numero, email, endereco, cidade, bairro, celular)"
					+ "values (?,?,?,?,?,?,?,?,?)";
			try (PreparedStatement smtp = con.prepareStatement(sql)) {
				smtp.setString(1, academia.getNomeAcademia());
				smtp.setString(2, academia.getTelefone());
				smtp.setString(3, academia.getCep());
				smtp.setInt(4, academia.getNumero());
				smtp.setString(5, academia.getEmail());
				smtp.setString(6, academia.getEndereco());
				smtp.setString(7, academia.getCidade());
				smtp.setString(8, academia.getBairro());
				smtp.setString(9, academia.getCelular());

				// executar o comando sql
				int opcao = JOptionPane.showConfirmDialog(null,
						"Você tem certeza de que deseja incluir o representante?", "Confirmação",
						JOptionPane.YES_NO_OPTION);
				if (opcao == JOptionPane.YES_OPTION) {
					smtp.execute();
					JOptionPane.showMessageDialog(null, "Academia incluída!");
				} else {
					JOptionPane.showMessageDialog(null, "Inclusão cancelada pelo usuário!");
				}

			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao incluir o representante= " + e.getMessage());
		}
	}

	// método alterar
	public void alterarAcademia(Academia academia) {
		try {
			String sql = "update tbl_academia set nome=?, telefone=?, cep=?, numero=?, email=?, endereco=?, cidade=?, "
					+ "bairro=?, celular=? where id_academia=?";
			try (PreparedStatement smtp = con.prepareStatement(sql)) {
				smtp.setString(1, academia.getNomeAcademia());
				smtp.setString(2, academia.getTelefone());
				smtp.setString(3, academia.getCep());
				smtp.setInt(4, academia.getNumero());
				smtp.setString(5, academia.getEmail());
				smtp.setString(6, academia.getEndereco());
				smtp.setString(7, academia.getCidade());
				smtp.setString(8, academia.getBairro());
				smtp.setString(9,  academia.getCelular());
				smtp.setInt(10, academia.getId());
				// executar o comando sql
				int opcao = JOptionPane.showConfirmDialog(null,
						"Você tem certeza de que deseja alterar os dados da academia?", "Confirmação",
						JOptionPane.YES_NO_OPTION);
				if (opcao == JOptionPane.YES_OPTION) {
					smtp.executeUpdate();
					JOptionPane.showMessageDialog(null, "Dados da academia alterado!");
				} else {
					JOptionPane.showMessageDialog(null, "Exclusão cancelada pelo usuário!");
				}
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao alterar a academia: " + e.getMessage());
			System.out.println(e.getMessage());
		}
	}

	// método listar a tabela
	public List<Academia> listarAcademia() {
		List<Academia> lista = new ArrayList<>();
		try {
			String sql = "select * from tbl_academia";
			try (PreparedStatement smtp = con.prepareStatement(sql); ResultSet resultset = smtp.executeQuery()) {
				while (resultset.next()) {
					// criar um academia set academia
					Academia academia = new Academia();
					academia.setId(resultset.getInt("id_academia"));
					academia.setEndereco(resultset.getString("endereco"));
					academia.setCep(resultset.getString("cep"));
					academia.setBairro(resultset.getString("bairro"));
					academia.setCidade(resultset.getString("cidade"));
					academia.setNomeAcademia(resultset.getString("nome"));
					academia.setTelefone(resultset.getString("telefone"));
					academia.setCelular(resultset.getString("celular"));
					academia.setEmail(resultset.getString("email"));
					academia.setNumero(resultset.getInt("numero"));

					lista.add(academia);
				}
			}
			return lista;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return null;
		}
	}

	// método de consulta

	public Academia consultarAcademia(int id) {
		if (con == null) {
			JOptionPane.showMessageDialog(null, "Conexão com o banco de dados não está disponível.");
			return null;
		}
		String sql = "select * from tbl_academia where id_academia = ?";
		try {
			try(PreparedStatement smtp = con.prepareStatement(sql)){
				smtp.setInt(1, id);
				Academia academia = new Academia();
				try(ResultSet resultset = smtp.executeQuery()){
					if (resultset.next()) {
						academia.setId(resultset.getInt("id_academia"));
						academia.setEndereco(resultset.getString("endereco"));
						academia.setCep(resultset.getString("cep"));
						academia.setBairro(resultset.getString("bairro"));
						academia.setCidade(resultset.getString("cidade"));
						academia.setNomeAcademia(resultset.getString("nome"));
						academia.setTelefone(resultset.getString("telefone"));
						academia.setCelular(resultset.getString("celular"));
						academia.setEmail(resultset.getString("email"));
						academia.setNumero(resultset.getInt("numero"));
						
						return academia;
					}
					else return null;
				}
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Não foi possível fazer a consulta no Banco de Dados: " + e.getMessage());
			return null;
		}
	}

	// metodo busca cep
	public Academia buscaCep(String cep) {

		WebServiceCep webServiceCep = WebServiceCep.searchCep(cep);

		Academia academia = new Academia();

		if (webServiceCep.wasSuccessful()) {
			academia.setEndereco(webServiceCep.getLogradouroFull());
			academia.setCidade(webServiceCep.getCidade());
			academia.setBairro(webServiceCep.getBairro());
			return academia;
		} else {
			JOptionPane.showMessageDialog(null, "Erro numero: " + webServiceCep.getResulCode());
			JOptionPane.showMessageDialog(null, "Descrição do erro: " + webServiceCep.getResultText());
			return null;
		}

	}

}
