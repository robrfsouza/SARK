package br.com.projeto.model;

import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.caelum.stella.validation.CNPJValidator;
import br.com.caelum.stella.validation.CPFValidator;

public class Utilitarios {

	public void LimparTela(JPanel container) {
		Component components[] = container.getComponents();
		for (Component component : components) {
			if (component instanceof JTextField) {
				((JTextField) component).setText(null);
			}
		}
	}

	public static String AtualizaDataHora() {
		Date agora = new Date();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy \n HH:mm:ss");
		return formato.format(agora);

	}
	
	public static String DataAtual() {
		Date agora = new Date();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		return formato.format(agora);
	}
	
	public boolean validaCpf(String cpf) {
		CPFValidator cpfValidador = new CPFValidator();
		try{
			cpfValidador.assertValid(cpf);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
			}
		}
	public boolean validaCnpj(String cnpj) {
		CNPJValidator cnpjValidador = new CNPJValidator();
		try{
			cnpjValidador.assertValid(cnpj);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
			}
		}

	//formatar data no formato dd/MM/yyyy
	public String formatarDataParaExibicao(String data) {
	    if (data != null && !data.trim().isEmpty()) {
	        try {
	            // Converter a string de data para o formato desejado
	            SimpleDateFormat inputDateFormat = new SimpleDateFormat("MM-dd-yyyy");
	            Date date = inputDateFormat.parse(data);
	            return new SimpleDateFormat("MM-dd-yyyy").format(date);
	        } catch (ParseException ex) {
	            ex.printStackTrace();
	            // Lide com a exceção de parsing de data, se necessário
	        }
	    }
	    return ""; // se a data estiver vazia ou não puder ser convertida
	}
}	

	
