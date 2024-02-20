package br.com.projeto.jdbc;

import javax.swing.JOptionPane;

public class TestaConexao {
	
	public static void main(String[] args) {
		try {
			new ConnectionFactory().getConnection();
			JOptionPane.showMessageDialog(null,"Conexao com sucesso");

		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Conexao falhou: " + e.getMessage());
					}
	}

}
