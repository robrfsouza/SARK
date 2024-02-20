package br.com.projeto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.model.Membros;
import br.com.projeto.model.WebServiceCep;

public class MembrosDAO {
	public Connection con;

	public MembrosDAO() {
		this.con= new ConnectionFactory().getConnection();
	}
	
	
	
	//metodo buscaCep
	public Membros buscacep(String cep) {
		WebServiceCep webServiceCep = WebServiceCep.searchCep(cep);

		Membros membros = new Membros();

		if (webServiceCep.wasSuccessful()) {
			membros.setEndereco(webServiceCep.getLogradouroFull());
			membros.setCidade(webServiceCep.getCidade());
			membros.setBairro(webServiceCep.getBairro());
			return membros;
		} else {
			JOptionPane.showMessageDialog(null, "Erro numero: " + webServiceCep.getResulCode());
			JOptionPane.showMessageDialog(null, "Descrição do erro: " + webServiceCep.getResultText());
			return null;
		}


	}
	
	//Pesquisar membros por nome
	public List<Membros> pesquisarNomeMembros(String nome) {
		// criar lista
		List<Membros> lista = new ArrayList<>();
		if (con == null) {
			JOptionPane.showMessageDialog(null, "Conexão com o banco de dados não está disponível.");
			return null;
		}
		String sql = "select * from tbl_membros where nome like ?";
		try (PreparedStatement smtp = con.prepareStatement(sql)) {
			smtp.setNString(1, nome);
			try (ResultSet resultset = smtp.executeQuery()) {
				while (resultset.next()) {
					Membros membros = new Membros();

					membros.setMatricula(resultset.getInt("matricula"));
					membros.setNome(resultset.getString("nome"));
					membros.setCpf(resultset.getString("cpf"));
					membros.setDtNascimento(resultset.getString("dt_nascimento"));
					membros.setDtMatricula(resultset.getString("dt_matricula"));
					membros.setDtValidade(resultset.getString("dt_validade"));
					membros.setObservacao(resultset.getString("observacao"));
					membros.setTpMembro(resultset.getString("tipo_membro"));
					membros.setStatus(resultset.getString("status"));
					membros.setIdAcademia(resultset.getInt("id_academia"));
					membros.setCep(resultset.getString("cep"));
					membros.setEndereco(resultset.getString("endereco"));
					membros.setBairro(resultset.getString("bairro"));
					membros.setCidade(resultset.getString("cidade"));
					membros.setNumero(resultset.getInt("numero"));
					membros.setEmail(resultset.getString("email"));
					membros.setCelular(resultset.getString("celular"));
					membros.setComplemento(resultset.getString("complemento"));

					// adicionar a federacao na lista
					lista.add(membros);
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

	
	//metodo listar membros
	
	public List<Membros> listarMembros() {
		List<Membros> lista = new ArrayList<>();

		try {
			// criar o comando sql
			String sql = "select * from tbl_membros";

			// conectar o banco de dados e preparar o sql
			try (PreparedStatement smtp = con.prepareStatement(sql); ResultSet resultset = smtp.executeQuery()) {

				while (resultset.next()) {

					// criar um federacao set federacao
					Membros membros = new Membros();

					membros.setMatricula(resultset.getInt("matricula"));
					membros.setNome(resultset.getString("nome"));
					membros.setCpf(resultset.getString("cpf"));
					membros.setDtNascimento(resultset.getString("dt_nascimento"));
					membros.setDtMatricula(resultset.getString("dt_matricula"));
					membros.setDtValidade(resultset.getString("dt_validade"));
					membros.setObservacao(resultset.getString("observacao"));
					membros.setTpMembro(resultset.getString("tipo_membro"));
					membros.setStatus(resultset.getString("status"));
					membros.setIdAcademia(resultset.getInt("id_academia"));
					membros.setCep(resultset.getString("cep"));
					membros.setEndereco(resultset.getString("endereco"));
					membros.setBairro(resultset.getString("bairro"));
					membros.setCidade(resultset.getString("cidade"));
					membros.setNumero(resultset.getInt("numero"));
					membros.setEmail(resultset.getString("email"));
					membros.setCelular(resultset.getString("celular"));
					membros.setComplemento(resultset.getString("complemento"));

					// adicionar a federacao na lista
					lista.add(membros);
				}
			}
			return lista;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return null;
		}
	}

	//metodo selecionar membros
	
	public Membros consultaMembros (int matricula) {
		if (con == null) {
	        JOptionPane.showMessageDialog(null, "Conexão com o banco de dados não está disponível.");
	        return null;
		}
		String sql = "select * from tbl_membros where matricula=?";
		try {
			try(PreparedStatement smtp = con.prepareStatement(sql)){
				smtp.setInt(1, matricula);
				Membros membros = new Membros();
				try(ResultSet resultset = smtp.executeQuery()){
					if(resultset.next()) {
						membros.setMatricula(resultset.getInt("matricula"));
						
						membros.setNome(resultset.getString("nome"));
						membros.setCpf(resultset.getString("cpf"));
						membros.setDtNascimento(resultset.getString("dt_nascimento"));
						membros.setDtMatricula(resultset.getString("dt_matricula"));
						membros.setDtValidade(resultset.getString("dt_validade"));
						membros.setObservacao(resultset.getString("observacao"));
						membros.setTpMembro(resultset.getString("tipo_membro"));
						membros.setStatus(resultset.getString("status"));
						membros.setIdAcademia(resultset.getInt("id_academia"));
						membros.setCep(resultset.getString("cep"));
						membros.setEndereco(resultset.getString("endereco"));
						membros.setBairro(resultset.getString("bairro"));
						membros.setCidade(resultset.getString("cidade"));
						membros.setNumero(resultset.getInt("numero"));
						membros.setEmail(resultset.getString("email"));
						membros.setCelular(resultset.getString("celular"));
						membros.setComplemento(resultset.getString("complemento"));

						return membros;
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

	
	//metodo inserir membros
	public void cadastrarMembros(Membros membros) {
		try {
			// criar o comando sql
			String sql = "insert into tbl_membros(nome, cpf, dt_nascimento, dt_matricula, dt_validade, "
					+ "observacao, tipo_membro, status, id_academia, cep, endereco, bairro, cidade, numero, email, "
					+ "celular, complemento) "
					+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			// conectar o banco de dados, organizar comando sql
			try (PreparedStatement smtp = con.prepareStatement(sql)) {
				smtp.setString(1, membros.getNome());
				smtp.setString(2, membros.getCpf());
				smtp.setString(3, membros.getDtNascimento());
				smtp.setString(4, membros.getDtMatricula());
				smtp.setString(5, membros.getDtValidade());
				smtp.setString(6, membros.getObservacao());
				smtp.setString(7, membros.getTpMembro());
				smtp.setString(8, membros.getStatus());
				smtp.setInt(9, membros.getIdAcademia());
				smtp.setString(10, membros.getCep());
				smtp.setString(11, membros.getEndereco());
				smtp.setString(12, membros.getBairro());
				smtp.setString(13, membros.getCidade());
				smtp.setInt(14, membros.getNumero());
				smtp.setString(15, membros.getEmail());
				smtp.setString(16, membros.getCelular());
				smtp.setString(17, membros.getComplemento());

				// executar o comando sql
				smtp.execute();
				JOptionPane.showMessageDialog(null, "Cadastro efetuado!");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			// TODO: handle exception
		}
	}
	
	//metodo alterar membros
	public void alterarMembros(Membros membros) {
		try {
			// criar o comando sql
			String sql = "update tbl_membros set nome=?, cpf=?, dt_nascimento=?, dt_matricula=?, dt_validade=?, "
					+ "observacao=?, tipo_membro=?, status=?, id_academia=?, cep=?, endereco=?, bairro=?, "
					+ "cidade=?, numero=?, email=?, celular=?, complemento=? where matricula=?";

			// conectar o banco de dados, organizar comando sql
			try (PreparedStatement smtp = con.prepareStatement(sql)) {
				smtp.setString(1, membros.getNome());
				smtp.setString(2, membros.getCpf());
				smtp.setString(3, membros.getDtNascimento());
				smtp.setString(4, membros.getDtMatricula());
				smtp.setString(5, membros.getDtValidade());
				smtp.setString(6, membros.getObservacao());
				smtp.setString(7, membros.getTpMembro());
				smtp.setString(8, membros.getStatus());
				smtp.setInt(9, membros.getIdAcademia());
				smtp.setString(10, membros.getCep());
				smtp.setString(11, membros.getEndereco());
				smtp.setString(12, membros.getBairro());
				smtp.setString(13, membros.getCidade());
				smtp.setInt(14, membros.getNumero());
				smtp.setString(15, membros.getEmail());
				smtp.setString(16, membros.getCelular());
				smtp.setString(17, membros.getComplemento());
				smtp.setInt(18, membros.getMatricula());

				// executar o comando sql
				smtp.executeUpdate();
				JOptionPane.showMessageDialog(null, "Alteracao concluída!");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	//metodo excluir membros
	public void excluirMembros(Membros membros) {
		try {
			// criar o comando sql
			String sql = "delete from tbl_membros where matricula=?";

			// conectar o banco de dados e organizar o comando sql
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, membros.getMatricula());
			

			// executar o comando sql
			stmt.execute();
			stmt.close();
			JOptionPane.showMessageDialog(null, "Membro excluído com sucesso!");

		} catch (SQLException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

	}

}
