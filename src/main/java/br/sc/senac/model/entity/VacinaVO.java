package br.sc.senac.model.entity;

import java.time.LocalDate;

public class VacinaVO {
	
	private int id;
	private String nomeVacina;
	private String estagioPesquisa;
	private String origem;
	private String nomePesquisador;
	private String nomeVoluntario;
	private LocalDate dataInicio;
	
	public VacinaVO(int id, String nomeVacina, String estagioPesquisa, String origem, String nomePesquisador, String nomeVoluntario,
			LocalDate dataInicio) {
		super();
		this.id = id;
		this.nomeVacina = nomeVacina;
		this.estagioPesquisa = estagioPesquisa;
		this.origem = origem;
		this.nomePesquisador = nomePesquisador;
		this.nomeVoluntario = nomeVoluntario;
		this.dataInicio = dataInicio;
	}

	public VacinaVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getEstagioPesquisa() {
		return estagioPesquisa;
	}

	public void setEstagioPesquisa(String estagioPesquisa) {
		this.estagioPesquisa = estagioPesquisa;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getNomePesquisador() {
		return nomePesquisador;
	}

	public void setNomePesquisador(String nomePesquisador) {
		this.nomePesquisador = nomePesquisador;
	}

	public String getNomeVoluntario() {
		return nomeVoluntario;
	}

	public void setNomeVoluntario(String nomeVoluntario) {
		this.nomeVoluntario = nomeVoluntario;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getNomeVacina() {
		return nomeVacina;
	}

	public void setNomeVacina(String nomeVacina) {
		this.nomeVacina = nomeVacina;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	
}
