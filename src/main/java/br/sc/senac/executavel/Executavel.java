package br.sc.senac.executavel;

import javax.swing.JOptionPane;

import br.sc.senac.model.dao.Banco;

public class Executavel {

	public static void main(String[] args) {
		
		//System.out.println("Teste");
		//System.out.println("Teste de edição pelo git");

	
		//JOptionPane.showMessageDialog(null, "Testeee");
		
		Banco.getConnection();
		// System.out.println ("COnectado");
		
	}

}
