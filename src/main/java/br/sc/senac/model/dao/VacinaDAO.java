package br.sc.senac.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import br.sc.senac.model.entity.PessoaVO;
import br.sc.senac.model.entity.VacinaVO;

public class VacinaDAO {
	
	/*	private String nomeVacina;
	private String estagioPesquisa;
	private String origem;
	private String nomePesquisador;
	private String nomeVoluntario;
	private LocalDate dataInicio;*/
	
	public VacinaVO inserir(VacinaVO novaVacina) {

		try {
			Connection conexao = Banco.getConnection();
			// NOME, CPF, SEXO, DATENASCIMENTO, VOLUNTATIO
			String sql = " INSERT INTO VACINA (NOMEVACINA, ESTAGIOPESQUISA, ORIGEM, NOMEPESQUISADOR, NOMEVOLUNTARIO, DATAINICIO) " 
			+ " VALUES (?,?,?,?,?,?,?) ";

			PreparedStatement query = Banco.getPreparedStatementWithGeneratedKeys(conexao, sql);
			
			query.setString(1, novaVacina.getNomeVacina());
			query.setString(2, novaVacina.getEstagioPesquisa());
			query.setString(3, novaVacina.getOrigem());
			query.setString(4, novaVacina.getNomePesquisador());
			query.setString(5, novaVacina.getNomeVoluntario());
			query.setDate(6, java.sql.Date.valueOf(novaVacina.getDataInicio()));

			int codigoRetorno = query.executeUpdate();

			if (codigoRetorno == Banco.CODIGO_RETORNO_SUCESSO) {
				ResultSet resultado = query.getGeneratedKeys();
				int chaveGerada = resultado.getInt("ID");
				novaVacina.setId(chaveGerada);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao cadastrar nova vacina.\n Causa" + e.getMessage());
		}

		return novaVacina;
	}

}
