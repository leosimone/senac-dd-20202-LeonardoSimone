package br.sc.senac.model.entity;


public class PesquisadorVO extends PessoaVO {
	
	private InstituicaoVO instituicao;

	public PesquisadorVO(int id, String nome, String cpf, String sexo, String dataNascimento, boolean voluntario,
			InstituicaoVO instituicao) {
		super(id, nome, cpf, sexo, dataNascimento, voluntario);
		this.setInstituicao(instituicao);
	}

	public PesquisadorVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InstituicaoVO getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(InstituicaoVO instituicao) {
		this.instituicao = instituicao;
	}


	

}
