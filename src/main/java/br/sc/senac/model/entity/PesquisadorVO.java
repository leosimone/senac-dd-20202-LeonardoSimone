package br.sc.senac.model.entity;


public class PesquisadorVO extends PessoaVO {
	
	private String instituicao;

	public PesquisadorVO(String nome, String cpf, String sexo, String dataNascimento, boolean voluntario,
			String instituicao) {
		super(nome, cpf, sexo, dataNascimento, voluntario);
		this.instituicao = instituicao;
	}

	public PesquisadorVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}
	

}
