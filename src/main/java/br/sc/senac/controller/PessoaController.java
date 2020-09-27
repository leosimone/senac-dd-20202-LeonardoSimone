package br.sc.senac.controller;

import br.sc.senac.model.bo.PessoaBO;
import br.sc.senac.model.dao.PessoaDAO;
import br.sc.senac.model.entity.PessoaVO;
import br.sc.senac.model.exception.CpfInvalidoException;
import br.sc.senac.model.exception.PessoaSemNomeException;

public class PessoaController {

	private PessoaBO bo = new PessoaBO(); 
	
	
	public String salvar(PessoaVO pessoaNova) {
		String mensagem = "";
		
		try {
			this.validarCPF(pessoaNova.getCpf());
			pessoaNova = bo.salvar(pessoaNova);
		} catch (CpfInvalidoException | PessoaSemNomeException excecao) {
			mensagem = excecao.getMessage();
		} 
		
		mensagem = "Pessoa salva com sucesso! \nId gerado: " + pessoaNova.getId();
		
		return mensagem;
	}
	
	
	public String validarCPF(String cpf) throws CpfInvalidoException{
		
		String mensagem = "";
		
		if(cpf == null || cpf.isEmpty()
				|| cpf.length() != 11) {
			throw new CpfInvalidoException(mensagem +"CPF deve possuir tamanho 11");
		}
		
		try {
			Integer.parseInt(cpf);
		} catch (NumberFormatException ex) {
			throw new CpfInvalidoException(mensagem + "CPF deve possuir tamanho 11 e somente números");
		
		}
		return mensagem;
		
	}
	
}
