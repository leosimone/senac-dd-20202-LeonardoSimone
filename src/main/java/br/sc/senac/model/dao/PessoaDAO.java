package br.sc.senac.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.sc.senac.model.entity.PessoaVO;

/**
 * 
 * @author Leo
 *
 */

public class PessoaDAO {

	public PessoaVO inserir(PessoaVO novaPessoa) {

		try {
			Connection conexao = Banco.getConnection();
			// NOME, CPF, SEXO, DATENASCIMENTO, VOLUNTATIO
			String sql = " INSERT INTO PESSOA (NOME, CPF, SEXO, DATANASCIMENTO, VOLUNTARIO) " + " VALUES (?,?,?,?,?) ";

			PreparedStatement query = Banco.getPreparedStatementWithGeneratedKeys(conexao, sql);
			query.setString(1, novaPessoa.getNome());
			query.setString(2, novaPessoa.getCpf());
			query.setString(3, novaPessoa.getSexo());
			query.setString(4, novaPessoa.getDataNascimento());
			query.setBoolean(5, novaPessoa.isVoluntario());

			int codigoRetorno = query.executeUpdate();

			if (codigoRetorno == Banco.CODIGO_RETORNO_SUCESSO) {
				ResultSet resultado = query.getGeneratedKeys();
				int chaveGerada = resultado.getInt("ID");
				novaPessoa.setId(chaveGerada);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao cadastrar nova pessoa.\n Causa" + e.getMessage());
		}

		return novaPessoa;
	}

	public boolean alterar(PessoaVO pessoaAtualizada) {
		Connection conexao = Banco.getConnection();
		// NOME, CPF, SEXO, DATENASCIMENTO, VOLUNTATIO
		String sql = " UPDATE INTO PESSOA (NOME=?, CPF=?, SEXO=?, DATANASCIMENTO=?, VOLUNTARIO=?) " + " WHERE ID=? ";

		boolean alterou = false;
		try {
			PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
			query.setString(1, pessoaAtualizada.getNome());
			query.setString(2, pessoaAtualizada.getCpf());
			query.setString(3, pessoaAtualizada.getSexo());
			query.setString(4, pessoaAtualizada.getDataNascimento());
			query.setBoolean(5, pessoaAtualizada.isVoluntario());
			query.setInt(6, pessoaAtualizada.getId());

			int codigoRetorno = query.executeUpdate();
			alterou = (codigoRetorno == Banco.CODIGO_RETORNO_SUCESSO);

		} catch (SQLException e) {
			System.out.println("Erro ao atualizar pessoa.\n Causa" + e.getMessage());
		}

		return alterou;
	}

	public boolean excluir(int id) {
		Connection conexao = Banco.getConnection();
		// NOME, CPF, SEXO, DATENASCIMENTO, VOLUNTATIO
		String sql = "DELETE FROM PESSOA WHERE ID=? ";

		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		boolean excluiu = false;
		try {
			query.setInt(1, id);

			int codigoRetorno = query.executeUpdate();
			excluiu = (codigoRetorno == Banco.CODIGO_RETORNO_SUCESSO);

		} catch (SQLException e) {
			System.out.println("Erro ao excluir pessoa (pessoa " + id + ").\n Causa" + e.getMessage());
		}

		return excluiu;
	}

	public PessoaVO pesquisarPorId(int id) {
		Connection conexao = Banco.getConnection();
		String sql = " SELECT * FROM PESSOA WHERE ID=?";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		
		PessoaVO pessoaBuscada = null;
		
		try {
			
			query.setInt(1, id);
			ResultSet conjuntoResultante = query.executeQuery();
				if(conjuntoResultante.next()) {
					pessoaBuscada = new PessoaVO();
					pessoaBuscada.setId(conjuntoResultante.getInt("id"));
					pessoaBuscada.setNome(conjuntoResultante.getString("nome"));
					pessoaBuscada.setCpf(conjuntoResultante.getString("CPF"));
					pessoaBuscada.setSexo(conjuntoResultante.getString("sexo"));
					pessoaBuscada.setDataNascimento(conjuntoResultante.getString("dataNascimento"));
					pessoaBuscada.setVoluntario(conjuntoResultante.getBoolean("voluntario"));
				}
			
		} catch (SQLException e) {
			System.out.println("Erro ao consultar pessoa (pessoa " + id + ").\n Causa" + e.getMessage());
		}
		
		
		return pessoaBuscada;
	}

	public List<PessoaVO> pesquisarTodas() {

		Connection conexao = Banco.getConnection();
		String sql = " SELECT * FROM PESSOA ";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		
		List<PessoaVO> pessoasBuscadas = new ArrayList<PessoaVO>();
		
		try {
			
			
			ResultSet conjuntoResultante = query.executeQuery();
				while(conjuntoResultante.next()) {
					PessoaVO pessoaBuscada = new PessoaVO();
					pessoaBuscada.setId(conjuntoResultante.getInt("id"));
					pessoaBuscada.setNome(conjuntoResultante.getString("nome"));
					pessoaBuscada.setCpf(conjuntoResultante.getString("CPF"));
					pessoaBuscada.setSexo(conjuntoResultante.getString("sexo"));
					pessoaBuscada.setDataNascimento(conjuntoResultante.getString("dataNascimento"));
					pessoaBuscada.setVoluntario(conjuntoResultante.getBoolean("voluntario"));
					
					pessoasBuscadas.add(pessoaBuscada);
				}
			
		} catch (SQLException e) {
			System.out.println("Erro ao consultar pessoas.\n Causa" + e.getMessage());
		}
		
		
		return pessoasBuscadas;
	}
}
