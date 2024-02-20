package br.com.projeto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.model.Graduacao;

public class GraduacaoDAO {
	public Connection con;

	public GraduacaoDAO() {
		this.con = new ConnectionFactory().getConnection();

	}

	// listar graduados pelo nome
	public List<Graduacao> pesquisarNomeFederado(String nome) {
		// criar lista
		List<Graduacao> lista = new ArrayList<>();

		try {
			// criar o comando sql
			String sql = "select g.*, m.nome As nome_membro " + "from tbl_graduacao g "
					+ "join tbl_membros m on g.id_membro = m.matricula " + "where m.nome like ?";

			// conectar o banco de dados e preparar o sql
			try (PreparedStatement smtp = con.prepareStatement(sql)) {

				smtp.setNString(1, nome);
				try (ResultSet resultset = smtp.executeQuery()) {
					while (resultset.next()) {

						// criar um federacao set federacao
						Graduacao graduacao = new Graduacao();

						graduacao.setFaixa(resultset.getString("faixa"));
						graduacao.setGraduacao(resultset.getString("graduacao"));
						graduacao.setAno(resultset.getInt("ano"));
						graduacao.setSemestre(resultset.getInt("semestre"));
						graduacao.setMatricula(resultset.getInt("id_membro"));
						graduacao.setNome(resultset.getString("nome_membro"));

						// adicionar a federacao na lista
						lista.add(graduacao);
					}
				}
				return lista;
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
				return null;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro geral: " + e.getMessage());
			e.printStackTrace(); // Adicionei esta linha para registrar a exceção no console

			return null;
		}
	}

	// listar graduacao individual
	public List<Graduacao> listarGraduacaoIndividual(int matricula) {
		List<Graduacao> lista = new ArrayList<>();

		try {
			// criar o comando sql
			String sql = "select g.*, m.nome As nome_membro " 
					+ "from tbl_graduacao g "
					+ "join tbl_membros m on g.id_membro = m.matricula " 
					+ "where id_membro=?";

			// conectar o banco de dados e preparar o sql
			try (PreparedStatement smtp = con.prepareStatement(sql)) {

				smtp.setInt(1, matricula);
				try (ResultSet resultset = smtp.executeQuery()) {
					while (resultset.next()) {

						// criar um federacao set federacao
						Graduacao graduacao = new Graduacao();

						graduacao.setFaixa(resultset.getString("faixa"));
						graduacao.setGraduacao(resultset.getString("graduacao"));
						graduacao.setAno(resultset.getInt("ano"));
						graduacao.setSemestre(resultset.getInt("semestre"));
						graduacao.setMatricula(resultset.getInt("id_membro"));
						graduacao.setNome(resultset.getString("nome_membro"));

						// adicionar a federacao na lista
						lista.add(graduacao);
					}
				}
				return lista;
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
				return null;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro geral: " + e.getMessage());
			e.printStackTrace(); // Adicionei esta linha para registrar a exceção no console

			return null;
		}
	}

	// listar graduacao
	public List<Graduacao> listarGraducaoMembros() {
		List<Graduacao> lista = new ArrayList<>();

		try {
			// criar o comando sql
			String sql = "SELECT g.*, m.nome AS nome_membro, a.nome AS nome_academia " +
                    "FROM tbl_graduacao g " +
                    "JOIN tbl_membros m ON g.id_membro = m.matricula " +
                    "JOIN tbl_academia a ON m.id_academia = a.id_academia "+
                    "WHERE (g.id_membro, g.ano) IN " +
                    "(SELECT id_membro, MAX(ano) FROM tbl_graduacao GROUP BY id_membro)";

			// conectar o banco de dados e preparar o sql
			try (PreparedStatement smtp = con.prepareStatement(sql); ResultSet resultset = smtp.executeQuery()) {

				while (resultset.next()) {

					// criar um federacao set federacao
					Graduacao graduacao = new Graduacao();

					graduacao.setFaixa(resultset.getString("faixa"));
					graduacao.setGraduacao(resultset.getString("graduacao"));
					graduacao.setAno(resultset.getInt("ano"));
					graduacao.setSemestre(resultset.getInt("semestre"));
					graduacao.setMatricula(resultset.getInt("id_membro"));
					graduacao.setNome(resultset.getString("nome_membro"));
					graduacao.setNomeAcademia(resultset.getString("nome_academia"));
					
					// adicionar a federacao na lista
					lista.add(graduacao);
				}
			}
			return lista;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return null;
		}
	}

	// incluir graduacao
	public void incluirGraduacao(Graduacao graduacao) {
		try {
			String sql = "insert into tbl_graduacao (id_membro, faixa, graduacao, ano, semestre) "
					+ "values (?,?,?,?,?)";
			// conectar o banco de dados, organizar comando sql
			try (PreparedStatement smtp = con.prepareStatement(sql)) {
				smtp.setInt(1, graduacao.getMatricula());
				smtp.setString(2, graduacao.getFaixa());
				smtp.setString(3, graduacao.getGraduacao());
				smtp.setInt(4, graduacao.getAno());
				smtp.setInt(5, graduacao.getSemestre());

				// executar o comando sql
				int opcao = JOptionPane.showConfirmDialog(null,
						"Você tem certeza de que deseja incluir nova graduacao?", "Confirmação",
						JOptionPane.YES_NO_OPTION);
				if (opcao == JOptionPane.YES_OPTION) {
					smtp.execute();
					JOptionPane.showMessageDialog(null, "Nova graduação inserida!");
				} else {
					JOptionPane.showMessageDialog(null, "Inclusão cancelada pelo usuário!");
				}
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao incluir nova graduação: " + e.getMessage());
			// TODO: handle exception
		}

	}

	// alterar graduacao
	public void alterarGraduacao(Graduacao graduacao) {
		try {
			String sql = "update tbl_graduacao " + "set faixa=?, ano=?, semestre=? "
					+ "where graduacao=? and id_membro=?";
			// conectar o banco de dados, organizar comando sql
			try (PreparedStatement smtp = con.prepareStatement(sql)) {
				smtp.setString(1, graduacao.getFaixa());
				smtp.setInt(2, graduacao.getAno());
				smtp.setInt(3, graduacao.getSemestre());
				smtp.setString(4, graduacao.getGraduacao());
				smtp.setInt(5, graduacao.getMatricula());

				// executar o comando sql
				int opcao = JOptionPane.showConfirmDialog(null, "Você tem certeza de que deseja alterar graduacao?",
						"Confirmação", JOptionPane.YES_NO_OPTION);
				if (opcao == JOptionPane.YES_OPTION) {
					smtp.execute();
					JOptionPane.showMessageDialog(null, "Graduação alterada!");
				} else {
					JOptionPane.showMessageDialog(null, "Alteração cancelada pelo usuário!");
				}
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao alterar graduação: " + e.getMessage());
			// TODO: handle exception
		}

	}

	// excluir graduacao
	public void excluirGraduacao(Graduacao graduacao) {
		try {
			// criar o comando sql
			String sql = "delete from tbl_membros where id_membro=? and graduacao=?";

			// conectar o banco de dados e organizar o comando sql
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, graduacao.getMatricula());
			stmt.setString(2, graduacao.getGraduacao());

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
