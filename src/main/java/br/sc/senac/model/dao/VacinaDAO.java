package br.sc.senac.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.sc.senac.model.entity.PesquisadorVO;
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
	
	public VacinaVO alterar(VacinaVO vacinaAtualizada) {

		try {
			Connection conexao = Banco.getConnection();
			// NOME, CPF, SEXO, DATENASCIMENTO, VOLUNTATIO
			String sql = " UPDATE INTO VACINA (NOMEVACINA, ESTAGIOPESQUISA, ORIGEM, NOMEPESQUISADOR, NOMEVOLUNTARIO, DATAINICIO) " 
			+ " VALUES (?,?,?,?,?,?,?) ";

			PreparedStatement query = Banco.getPreparedStatementWithGeneratedKeys(conexao, sql);
			
			query.setString(1, vacinaAtualizada.getNomeVacina());
			query.setString(2, vacinaAtualizada.getEstagioPesquisa());
			query.setString(3, vacinaAtualizada.getOrigem());
			query.setString(4, vacinaAtualizada.getNomePesquisador());
			query.setString(5, vacinaAtualizada.getNomeVoluntario());
			query.setDate(6, java.sql.Date.valueOf(vacinaAtualizada.getDataInicio()));

			int codigoRetorno = query.executeUpdate();

			if (codigoRetorno == Banco.CODIGO_RETORNO_SUCESSO) {
				ResultSet resultado = query.getGeneratedKeys();
				int chaveGerada = resultado.getInt("ID");
				vacinaAtualizada.setId(chaveGerada);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao cadastrar nova vacina.\n Causa" + e.getMessage());
		}

		return vacinaAtualizada;
	}
	
	public VacinaVO pesquisarPorId(int id) {
		Connection conexao = Banco.getConnection();
		String sql = " SELECT * FROM VACINA WHERE ID=?";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		
		VacinaVO vacinaBuscada = null;
		
		try {
			
			/*
			query.setDate(6, java.sql.Date.valueOf(vacinaAtualizada.getDataInicio()));*/
			
			query.setInt(1, id);
			ResultSet conjuntoResultante = query.executeQuery();
				if(conjuntoResultante.next()) {
					vacinaBuscada = new VacinaVO();
					vacinaBuscada.setId(conjuntoResultante.getInt("id"));
					vacinaBuscada.setNomeVacina(conjuntoResultante.getString("nome"));
					vacinaBuscada.setEstagioPesquisa(conjuntoResultante.getString("estagioPesquisa"));
					vacinaBuscada.setOrigem(conjuntoResultante.getString("origem"));
					vacinaBuscada.setNomePesquisador(conjuntoResultante.getString("nomePesquisador"));
					vacinaBuscada.setNomeVoluntario(conjuntoResultante.getString("voluntario"));
					//vacinaBuscada.setDataInicio(java.sql.Date.valueOf(conjuntoResultante.getDate("instituicao")));
				}
			
		} catch (SQLException e) {
			System.out.println("Erro ao consultar vacina " + id + ").\n Causa" + e.getMessage());
		}
		
		
		return vacinaBuscada;
	}
	public List<VacinaVO> pesquisarTodas() {

		Connection conexao = Banco.getConnection();
		String sql = " SELECT * FROM VACINA ";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		
		List<VacinaVO> vacinasBuscadas = new ArrayList<VacinaVO>();
		
		try {
						
			ResultSet conjuntoResultante = query.executeQuery();
				while(conjuntoResultante.next()) {
					VacinaVO vacinaBuscada = new VacinaVO();
					vacinaBuscada.setId(conjuntoResultante.getInt("id"));
					vacinaBuscada.setNomeVacina(conjuntoResultante.getString("nome"));
					vacinaBuscada.setEstagioPesquisa(conjuntoResultante.getString("estagioPesquisa"));
					vacinaBuscada.setOrigem(conjuntoResultante.getString("origem"));
					vacinaBuscada.setNomePesquisador(conjuntoResultante.getString("nomePesquisador"));
					vacinaBuscada.setNomeVoluntario(conjuntoResultante.getString("voluntario"));
					//vacinaBuscada.setDataInicio(java.sql.Date.valueOf(conjuntoResultante.getDate("instituicao")));
					
					vacinasBuscadas.add(vacinaBuscada);
				}
			
		} catch (SQLException e) {
			System.out.println("Erro ao consultar vacinass.\n Causa" + e.getMessage());
		}
		
		
		return vacinasBuscadas;
	}	

	public boolean excluir(int id) {
		Connection conexao = Banco.getConnection();
		// NOME, CPF, SEXO, DATENASCIMENTO, VOLUNTATIO
		String sql = "DELETE FROM VACINA WHERE ID=? ";

		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		boolean excluiu = false;
		try {
			query.setInt(1, id);

			int codigoRetorno = query.executeUpdate();
			excluiu = (codigoRetorno == Banco.CODIGO_RETORNO_SUCESSO);

		} catch (SQLException e) {
			System.out.println("Erro ao excluir vacina " + id + ").\n Causa" + e.getMessage());
		}

		return excluiu;
	}
	
}
