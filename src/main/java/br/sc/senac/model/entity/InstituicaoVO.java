package br.sc.senac.model.entity;

public class InstituicaoVO {

	private String pais;
	private String nomeVacina;
	
	public InstituicaoVO(String pais, String nomeVacina) {
		super();
		this.pais = pais;
		this.nomeVacina = nomeVacina;
	}

	public InstituicaoVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getNomeVacina() {
		return nomeVacina;
	}

	public void setNomeVacina(String nomeVacina) {
		this.nomeVacina = nomeVacina;
	}
	
	
}
