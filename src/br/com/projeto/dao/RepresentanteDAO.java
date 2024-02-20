package br.com.projeto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.model.RepresentanteFederacao;

public class RepresentanteDAO {

	public Connection con;

	public RepresentanteDAO() {
		this.con = new ConnectionFactory().getConnection();
	}

	// método cadastrar representante
	public void cadastrarRepresentante(RepresentanteFederacao representante) {
		try {
			// criar comando sql
			String sql = "insert into tbl_representante_federacao (federacao_id, funcao, status, ano,"
					+ " telefone, email, nome_representante) values (?,?,?,?,?,?,?)";

			// conectar o banco de dados, organizar comando sql
			try (PreparedStatement smtp = con.prepareStatement(sql)) {
				smtp.setInt(1, representante.getIdFederacao());
				smtp.setString(2, representante.getFuncao());
				smtp.setString(3, representante.getStatus());
				smtp.setInt(4, representante.getAno());
				smtp.setString(5, representante.gettelefoneRepresentante());
				smtp.setString(6, representante.getEmailRepresentante());
				smtp.setString(7, representante.getRepresentante());

				// executar o comando sql
				int opcao = JOptionPane.showConfirmDialog(null,
						"Você tem certeza de que deseja incluir o representante?", "Confirmação",
						JOptionPane.YES_NO_OPTION);
				if (opcao == JOptionPane.YES_OPTION) {
					smtp.execute();
					JOptionPane.showMessageDialog(null, "Dados do representante inseridos!");
				} else {
					JOptionPane.showMessageDialog(null, "Inclusão cancelada pelo usuário!");
				}
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao incluir representante: " + e.getMessage());
			// TODO: handle exception
		}

	}

	// metodo alterar representante

	public void alterarRepresentante(RepresentanteFederacao representante) {
		try {
			// criar o comando sql
			String sql ="UPDATE tbl_representante_federacao SET funcao=?, status=?, "
					+ "ano=?, telefone=?, email=?, nome_representante=? WHERE (id_representante=?)";
					
			// conectar o banco de dados, organizar comando sql
			try (PreparedStatement smtp = con.prepareStatement(sql)) {
				smtp.setString(1, representante.getFuncao());
				smtp.setString(2, representante.getStatus());
				smtp.setInt(3, representante.getAno());
				smtp.setString(4, representante.gettelefoneRepresentante());
				smtp.setString(5, representante.getEmailRepresentante());
				smtp.setString(6, representante.getRepresentante());
				smtp.setInt(7, representante.getIdRepresentante());

				// executar o comando sql
				int opcao = JOptionPane.showConfirmDialog(null,
						"Você tem certeza de que deseja alterar o representante?", "Confirmação",
						JOptionPane.YES_NO_OPTION);
				if (opcao == JOptionPane.YES_OPTION) {
					smtp.executeUpdate();
					JOptionPane.showMessageDialog(null, "Dados do representante alterado!");
				} else {
					JOptionPane.showMessageDialog(null, "Exclusão cancelada pelo usuário!");
				}
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao alterar o representante= " + e.getMessage());
			System.out.println(e.getMessage());
		}
	}

	// metodo excluir representante

	public void excluirRepresentante(RepresentanteFederacao representante) {
		// criar o comando sql

		String sql = "delete from tbl_representante_federacao where id_representante=?";

		try {
			// conectar o banco de dados, organizar comando sql
			try (PreparedStatement smtp = con.prepareStatement(sql)) {
				smtp.setInt(1, representante.getIdRepresentante());

				// executar o comando sql
				int opcao = JOptionPane.showConfirmDialog(null,
						"Você tem certeza de que deseja excluir o representante?", "Confirmação",
						JOptionPane.YES_NO_OPTION);
				if (opcao == JOptionPane.YES_OPTION) {
					smtp.execute();
					JOptionPane.showMessageDialog(null, "Dados do representante excluídos!");
				} else {
					JOptionPane.showMessageDialog(null, "Exclusão cancelada pelo usuário!");
				}
			}
		} catch (

		SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao excluir representante: " + e.getMessage());
			System.out.println(e.getMessage());
		}
	}
	
	// metodo de consultar representante, a pesquisa é feita pelo id do representante
	public RepresentanteFederacao consultaRepresentante(int idRepresentante) {
		if (con == null) {
			JOptionPane.showMessageDialog(null, "Conexão com o banco de dados não está disponível.");
			return null;
		}
		String sql = "select * from tbl_representante_federacao where id_representante = ?";
		try {
			try (PreparedStatement smtp = con.prepareStatement(sql)) {
				smtp.setInt(1, idRepresentante);
				RepresentanteFederacao representante = new RepresentanteFederacao();

				try (ResultSet resultset = smtp.executeQuery()) {
					if (resultset.next()) {
						representante.setIdFederacao(resultset.getInt("federacao_id"));
						representante.setIdRepresentante(resultset.getInt("id_representante"));
						representante.setFuncao(resultset.getString("funcao"));
						representante.setStatus(resultset.getString("status"));
						representante.setAno(resultset.getInt("ano"));
						representante.settelefoneRepresentante(resultset.getString("telefone"));
						representante.setEmail(resultset.getString("email"));
						representante.setRepresentante(resultset.getString("nome_representante"));
						return representante;
					} else {
						return null;
					}
				}
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Não foi possível fazer a consulta no Banco de Dados: " + e.getMessage());
			return null;
		}
	}

	// metodo faz uma consulta através do nome do representante
	public RepresentanteFederacao consultaRepresentantePorNome(String nome) {
		if (con == null) {
			JOptionPane.showMessageDialog(null, "Conexão com o banco de dados não está disponível.");
			return null;
		}
		String sql = "select * from tbl_representante_federacao where nome_representante = ?";
		try {
			try (PreparedStatement smtp = con.prepareStatement(sql)) {
				smtp.setNString(1, nome);

				try (ResultSet resultset = smtp.executeQuery()) {
					RepresentanteFederacao representante = new RepresentanteFederacao();
					if (resultset.next()) {
						representante.setIdFederacao(resultset.getInt("federacao_id"));
						representante.setIdRepresentante(resultset.getInt("id_representante"));
						representante.setFuncao(resultset.getString("funcao"));
						representante.setStatus(resultset.getString("status"));
						representante.setAno(resultset.getInt("ano"));
						representante.settelefoneRepresentante(resultset.getString("telefone"));
						representante.setEmailRepresentante(resultset.getString("email"));
						representante.setRepresentante(resultset.getString("nome_representante"));
						return representante;
					} else {
						return null;
					}
				}
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Não foi possível fazer a consulta no Banco de Dados: " + e.getMessage());
			return null;
		}
	}

	//cria uma lista contendo os dados do representante, incluindo o nome e o id da federacao
	public List<RepresentanteFederacao> listarRepresentante() {
		List<RepresentanteFederacao> lista = new ArrayList<>();

		try {
			// criar o comando sql
			String sql = "SELECT rf.*, f.nome AS nome_federacao, f.pix " + "FROM tbl_representante_federacao rf "
					+ "JOIN tbl_federacao f ON rf.federacao_id = f.id_federacao";

			// conectar o banco de dados e preparar o sql
			try (PreparedStatement smtp = con.prepareStatement(sql); ResultSet resultset = smtp.executeQuery()) {

				while (resultset.next()) {

					// criar um federacao set federacao
					RepresentanteFederacao representante = new RepresentanteFederacao();

					// preencher os campos da tbl_representante_federacao
					representante.setIdFederacao(resultset.getInt("federacao_id"));
					representante.setIdRepresentante(resultset.getInt("id_representante"));
					representante.setRepresentante(resultset.getString("nome_representante"));
					representante.setFuncao(resultset.getString("funcao"));
					representante.setStatus(resultset.getString("status"));
					representante.setAno(resultset.getInt("ano"));
					representante.settelefoneRepresentante(resultset.getString("telefone"));
					representante.setEmailRepresentante(resultset.getString("email"));

					// preencher os campos da tbl_federacao
					representante.setNome(resultset.getString("nome_federacao"));
					representante.setPix(resultset.getString("pix"));
					// adicionar a federacao na lista
					lista.add(representante);
				}
			}
			return lista;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return null;
		}
	}

}
