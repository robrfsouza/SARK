package br.com.projeto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.model.Federado;

public class FederadosDAO {
	public Connection con;

	public FederadosDAO() {
		this.con = new ConnectionFactory().getConnection();
	}

	// listar Federados
	public List<Federado> listarFederado() {
		List<Federado> lista = new ArrayList<>();

		try {
			// criar o comando sql
			String sql = "select tbl_federado.*, tbl_membros.nome as nome_membro , tbl_federacao.nome as nome_federacao "
					+ "from tbl_federado " 
					+ "join tbl_membros on tbl_federado.id_membro = tbl_membros.matricula "
					+ "join tbl_federacao on tbl_federado.id_federacao = tbl_federacao.id_federacao";

			// conectar o banco de dados e preparar o sql
			try (PreparedStatement smtp = con.prepareStatement(sql); ResultSet resultset = smtp.executeQuery()) {

				while (resultset.next()) {

					// criar um federacao set federacao
					Federado federado = new Federado();

					federado.setMatricula(resultset.getInt("id_membro"));
					federado.setIdFederecao(resultset.getInt("id_federacao"));
					federado.setRegistro(resultset.getString("registro"));
					federado.setAnoRegistro(resultset.getInt("ano_registro"));
					federado.setAnuidade(resultset.getInt("anuidade"));
					federado.setStatus(resultset.getString("situacao_anuidade"));
					federado.setNumeroRegistro(resultset.getString("numero_registro"));
					federado.setNome(resultset.getString("nome_membro"));
					federado.setNomeFederacao(resultset.getString("nome_federacao"));
					federado.setIdFederado(resultset.getInt("id_federado"));

					// adicionar a federacao na lista
					lista.add(federado);
				}
			}
			return lista;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return null;
		}

	}

	// Pesquisar Federado pelo nome
	public List<Federado> pesquisarNomeFederado(String nome) {
		// criar lista
		List<Federado> lista = new ArrayList<>();
		if (con == null) {
			JOptionPane.showMessageDialog(null, "Conexão com o banco de dados não está disponível.");
			return null;
		}
		String sql = "select tbl_federado.*, tbl_membros.nome as nome_membro , tbl_federacao.nome as nome_federacao "
			    + "from tbl_federado "
			    + "join tbl_membros on tbl_federado.id_membro = tbl_membros.matricula "
			    + "join tbl_federacao on tbl_federado.id_federacao = tbl_federacao.id_federacao "
			    + "where tbl_membros.nome like ?";
		try (PreparedStatement smtp = con.prepareStatement(sql)) {
			smtp.setNString(1, nome);
			try (ResultSet resultset = smtp.executeQuery()) {
				while (resultset.next()) {
					Federado federado = new Federado();
					federado.setMatricula(resultset.getInt("id_membro"));
					federado.setIdFederecao(resultset.getInt("id_federacao"));
					federado.setRegistro(resultset.getString("registro"));
					federado.setAnoRegistro(resultset.getInt("ano_registro"));
					federado.setAnuidade(resultset.getInt("anuidade"));
					federado.setStatus(resultset.getString("situacao_anuidade"));
					federado.setNumeroRegistro(resultset.getString("numero_registro"));
					federado.setNome(resultset.getString("nome_membro"));
					federado.setNomeFederacao(resultset.getString("nome_federacao"));
					federado.setIdFederado(resultset.getInt("id_federado"));

					lista.add(federado);
				}
				return lista;
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
				return null;
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Não foi possível fazer a consulta no Banco de Dados: " + e.getMessage());
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// Consultar Federados
	public Federado consultarIdFederado(int matricula, int id_federacao, int anuidade) {
		if (con == null) {
			JOptionPane.showMessageDialog(null, "Conexão com o banco de dados não está disponível.");
			return null;
		}
		String sql = "select * from tbl_federado where id_membro=? and anuidade=?  and id_federacao=?";
		try {
			try (PreparedStatement smtp = con.prepareStatement(sql)) {
				smtp.setInt(1, matricula);
				smtp.setInt(2, anuidade);
				smtp.setInt(3, id_federacao);
				Federado federado = new Federado();
				try (ResultSet resultset = smtp.executeQuery()) {
					if (resultset.next()) {
						// criar um federacao set federacao

						federado.setIdFederado(resultset.getInt("id_federado"));
						return federado;
					} else {
						return null;
					}
				}
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Não foi possível fazer a consulta no Banco de Dados: " + e.getMessage());
			e.printStackTrace();
			return null;
		}

	}

	// incluir Federados
	public void incluirFederado(Federado federado) {
		try {
			String sql = "insert into tbl_federado (id_membro, id_federacao, registro, "
					+ "ano_registro, anuidade, situacao_anuidade, numero_registro, id_federado) "
					+ "values (?,?,?,?,?,?,?,?)";
			// conectar o banco de dados, organizar comando sql
			try (PreparedStatement smtp = con.prepareStatement(sql)) {
				smtp.setInt(1, federado.getMatricula());
				smtp.setInt(2, federado.getIdFederecao());
				smtp.setString(3, federado.getRegistro());
				smtp.setInt(4, federado.getAnoRegistro());
				smtp.setInt(5, federado.getAnuidade());
				smtp.setString(6, federado.getStatus());
				smtp.setString(7, federado.getNumeroRegistro());
				smtp.setInt(8, federado.getIdFederado());

				// executar o comando sql
				int opcao = JOptionPane.showConfirmDialog(null, "Você tem certeza de que deseja incluir novo federado?",
						"Confirmação", JOptionPane.YES_NO_OPTION);
				if (opcao == JOptionPane.YES_OPTION) {
					smtp.execute();
					JOptionPane.showMessageDialog(null, "Novo federado inserido!");
				} else {
					JOptionPane.showMessageDialog(null, "Inclusão cancelada pelo usuário!");
				}
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao incluir novo federado: " + e.getMessage());
			// TODO: handle exception
		}

	}

	// alterar Federados
	public void alterarFederado(Federado federado) {
		try {
			String sql = "update tbl_federado "
					+ "set registro=?, ano_registro=?, anuidade=?, situacao_anuidade=?, numero_registro=? "
					+ "where id_membro=? and id_federacao=? and id_federado=?";
			// conectar o banco de dados, organizar comando sql
			try (PreparedStatement smtp = con.prepareStatement(sql)) {
				smtp.setString(1, federado.getRegistro());
				smtp.setInt(2, federado.getAnoRegistro());
				smtp.setInt(3, federado.getAnuidade());
				smtp.setString(4, federado.getStatus());
				smtp.setString(5, federado.getNumeroRegistro());
				smtp.setInt(6, federado.getMatricula());
				smtp.setInt(7, federado.getIdFederecao());
				smtp.setInt(8, federado.getIdFederado());

				// executar o comando sql
				int opcao = JOptionPane.showConfirmDialog(null, "Você tem certeza de que deseja alterar federado?",
						"Confirmação", JOptionPane.YES_NO_OPTION);
				if (opcao == JOptionPane.YES_OPTION) {
					smtp.executeUpdate();
					JOptionPane.showMessageDialog(null, "Federado alterado!");
				} else {
					JOptionPane.showMessageDialog(null, "Inclusão cancelada pelo usuário!");
				}
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao alterar federado: " + e.getMessage());
			// TODO: handle exception
		}

	}

	// excluir Federados
	public void excluirFederado(Federado federado) {
		try {
			// criar o comando sql
			String sql = "delete from tbl_federado where id_membro=? and id_federacao=? and id_federado=?";

			// conectar o banco de dados e organizar o comando sql
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, federado.getMatricula());
			stmt.setInt(2, federado.getIdFederecao());
			stmt.setInt(3, federado.getIdFederado());

			// executar o comando sql
			stmt.execute();
			stmt.close();
			JOptionPane.showMessageDialog(null, "Graducação excluído com sucesso!");

		} catch (SQLException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

	}

}
