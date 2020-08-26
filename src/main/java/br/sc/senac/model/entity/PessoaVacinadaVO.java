package br.sc.senac.model.entity;

import java.time.LocalDate;

public class PessoaVacinadaVO extends PessoaVO {
	
	private char reacao;
	private LocalDate dataVacinacao;
	
	public PessoaVacinadaVO(String nome, String cpf, char sexo, LocalDate dataNascimento, boolean voluntario,
			char reacao, LocalDate dataVacinacao) {
		super(nome, cpf, sexo, dataNascimento, voluntario);
		this.reacao = reacao;
		this.dataVacinacao = dataVacinacao;
	}

	public PessoaVacinadaVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public char getReacao() {
		return reacao;
	}

	public void setReacao(char reacao) {
		this.reacao = reacao;
	}

	public LocalDate getDataVacinacao() {
		return dataVacinacao;
	}

	public void setDataVacinacao(LocalDate dataVacinacao) {
		this.dataVacinacao = dataVacinacao;
	}
	

}
