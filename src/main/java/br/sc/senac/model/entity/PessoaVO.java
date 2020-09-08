package br.sc.senac.model.entity;

import java.sql.Date;
import java.time.LocalDate;

public class PessoaVO {

	private int id;
	private String nome;
	private String cpf;
	private String sexo;
	private String dataNascimento;
	private boolean voluntario;
	public PessoaVO(String nome, String cpf, String sexo, String dataNascimento, boolean voluntario) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.voluntario = voluntario;
	}
	public PessoaVO(int id) {
		super();
		this.id = id;
	}
	public PessoaVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public boolean isVoluntario() {
		return voluntario;
	}
	public void setVoluntario(boolean voluntario) {
		this.voluntario = voluntario;
	}
	
	
}
