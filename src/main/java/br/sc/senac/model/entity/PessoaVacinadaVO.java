package br.sc.senac.model.entity;

public class PessoaVacinadaVO extends PessoaVO {
	
	private char reacao;
	private String dataVacinacao;
	
	public PessoaVacinadaVO(String nome, String cpf, String sexo, String dataNascimento, boolean voluntario,
			char reacao, String dataVacinacao) {
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

	public String getDataVacinacao() {
		return dataVacinacao;
	}

	public void setDataVacinacao(String dataVacinacao) {
		this.dataVacinacao = dataVacinacao;
	}
	

}
