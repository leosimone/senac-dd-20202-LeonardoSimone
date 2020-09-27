package br.sc.senac.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.sc.senac.model.entity.PesquisadorVO;

/**
 * 
 * @author Leo
 *
 */

public class PesquisadorDAO {

	public PesquisadorVO inserir(PesquisadorVO novoPesquisador) {

		try {
			Connection conexao = Banco.getConnection();
			// NOME, CPF, SEXO, DATENASCIMENTO, VOLUNTATIO
			String sql = " INSERT INTO PESQUISADOR (NOME, CPF, SEXO, DATANASCIMENTO, VOLUNTARIO, INSTITUICAO) " + " VALUES (?,?,?,?,?,?) ";

			PreparedStatement query = Banco.getPreparedStatementWithGeneratedKeys(conexao, sql);
			query.setString(1, novoPesquisador.getNome());
			query.setString(2, novoPesquisador.getCpf());
			query.setString(3, novoPesquisador.getSexo());
			query.setString(4, novoPesquisador.getDataNascimento());
			query.setBoolean(5, novoPesquisador.isVoluntario());
			query.setString(6, novoPesquisador.getInstituicao());

			int codigoRetorno = query.executeUpdate();

			if (codigoRetorno == Banco.CODIGO_RETORNO_SUCESSO) {
				ResultSet resultado = query.getGeneratedKeys();
				int chaveGerada = resultado.getInt("ID");
				novoPesquisador.setId(chaveGerada);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao cadastrar novo(a) pesquisador(a).\n Causa" + e.getMessage());
		}

		return novoPesquisador;
	}

	public boolean alterar(PesquisadorVO pesquisadorAtualizado) {
		Connection conexao = Banco.getConnection();
		// NOME, CPF, SEXO, DATENASCIMENTO, VOLUNTATIO
		String sql = " UPDATE INTO PESQUISADOR (NOME=?, CPF=?, SEXO=?, DATANASCIMENTO=?, VOLUNTARIO=?, INSTITUICAO=?) " + " WHERE ID=? ";

		boolean alterou = false;
		try {
			PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
			query.setString(1, pesquisadorAtualizado.getNome());
			query.setString(2, pesquisadorAtualizado.getCpf());
			query.setString(3, pesquisadorAtualizado.getSexo());
			query.setString(4, pesquisadorAtualizado.getDataNascimento());
			query.setBoolean(5, pesquisadorAtualizado.isVoluntario());
			query.setString(6, pesquisadorAtualizado.getInstituicao());
			query.setInt(7, pesquisadorAtualizado.getId());

			int codigoRetorno = query.executeUpdate();
			alterou = (codigoRetorno == Banco.CODIGO_RETORNO_SUCESSO);

		} catch (SQLException e) {
			System.out.println("Erro ao atualizar pesquisador(a).\n Causa" + e.getMessage());
		}

		return alterou;
	}

	public boolean excluir(int id) {
		Connection conexao = Banco.getConnection();
		// NOME, CPF, SEXO, DATENASCIMENTO, VOLUNTATIO
		String sql = "DELETE FROM PESQUISADOR WHERE ID=? ";

		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		boolean excluiu = false;
		try {
			query.setInt(1, id);

			int codigoRetorno = query.executeUpdate();
			excluiu = (codigoRetorno == Banco.CODIGO_RETORNO_SUCESSO);

		} catch (SQLException e) {
			System.out.println("Erro ao excluir pesquisador(a) (pesquisador(a) " + id + ").\n Causa" + e.getMessage());
		}

		return excluiu;
	}

	public PesquisadorVO pesquisarPorId(int id) {
		Connection conexao = Banco.getConnection();
		String sql = " SELECT * FROM PESQUISADOR WHERE ID=?";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		
		PesquisadorVO pesquisadorBuscado = null;
		
		try {
			
			query.setInt(1, id);
			ResultSet conjuntoResultante = query.executeQuery();
				if(conjuntoResultante.next()) {
					pesquisadorBuscado = new PesquisadorVO();
					pesquisadorBuscado.setId(conjuntoResultante.getInt("id"));
					pesquisadorBuscado.setNome(conjuntoResultante.getString("nome"));
					pesquisadorBuscado.setCpf(conjuntoResultante.getString("CPF"));
					pesquisadorBuscado.setSexo(conjuntoResultante.getString("sexo"));
					pesquisadorBuscado.setDataNascimento(conjuntoResultante.getString("dataNascimento"));
					pesquisadorBuscado.setVoluntario(conjuntoResultante.getBoolean("voluntario"));
					pesquisadorBuscado.setInstituicao(conjuntoResultante.getString("instituicao"));
				}
			
		} catch (SQLException e) {
			System.out.println("Erro ao consultar pesquisador(a) (pesquisador(a) " + id + ").\n Causa" + e.getMessage());
		}
		
		
		return pesquisadorBuscado;
	}

	public List<PesquisadorVO> pesquisarTodas() {

		Connection conexao = Banco.getConnection();
		String sql = " SELECT * FROM PESQUISADOR ";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		
		List<PesquisadorVO> pesquisadoresBuscados = new ArrayList<PesquisadorVO>();
		
		try {
			
			
			ResultSet conjuntoResultante = query.executeQuery();
				while(conjuntoResultante.next()) {
					PesquisadorVO pesquisadorBuscado = new PesquisadorVO();
					pesquisadorBuscado.setId(conjuntoResultante.getInt("id"));
					pesquisadorBuscado.setNome(conjuntoResultante.getString("nome"));
					pesquisadorBuscado.setCpf(conjuntoResultante.getString("CPF"));
					pesquisadorBuscado.setSexo(conjuntoResultante.getString("sexo"));
					pesquisadorBuscado.setDataNascimento(conjuntoResultante.getString("dataNascimento"));
					pesquisadorBuscado.setVoluntario(conjuntoResultante.getBoolean("voluntario"));
					//pesquisador.setId(Integer.parseInt(resultado.getString("PESQUISADOR")));
					pesquisadorBuscado.setInstituicao(conjuntoResultante.getString("nome"));
					
					pesquisadoresBuscados.add(pesquisadorBuscado);
				}
			
		} catch (SQLException e) {
			System.out.println("Erro ao consultar pesquisadores.\n Causa" + e.getMessage());
		}
		
		
		return pesquisadoresBuscados;
	}
}
