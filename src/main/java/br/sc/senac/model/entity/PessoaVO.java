package br.sc.senac.model.entity;

import java.time.LocalDate;

public class PessoaVO {

	private String nome;
	private String cpf;
	private char sexo;
	private LocalDate dataNascimento;
	private boolean voluntario;
	public PessoaVO(String nome, String cpf, char sexo, LocalDate dataNascimento, boolean voluntario) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.voluntario = voluntario;
	}
	public PessoaVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public boolean isVoluntario() {
		return voluntario;
	}
	public void setVoluntario(boolean voluntario) {
		this.voluntario = voluntario;
	}
	
}
