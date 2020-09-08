package br.sc.senac.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
			//NOME, CPF, SEXO, DATENASCIMENTO, VOLUNTATIO
			String sql = " INSERT INTO PESSOA (NOME, CPF, SEXO, DATANASCIMENTO, VOLUNTARIO) "
					+ " VALUES (?,?,?,?,?) ";
			
			PreparedStatement query = Banco.getPreparedStatementWithGeneratedKeys(conexao, sql);
			query.setString(1,  novaPessoa.getNome());
			query.setString(2,  novaPessoa.getCpf());
			query.setString(3,  novaPessoa.getSexo());
			query.setString(4,  novaPessoa.getDataNascimento());
			query.setBoolean(5,  novaPessoa.isVoluntario());
			
			int codigoRetorno = query.executeUpdate();
			
			if(codigoRetorno ==  Banco.CODIGO_RETORNO_SUCESSO) {
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
			//NOME, CPF, SEXO, DATENASCIMENTO, VOLUNTATIO
			String sql = " UPDATE INTO PESSOA (NOME=?, CPF=?, SEXO=?, DATANASCIMENTO=?, VOLUNTARIO=?) "
					+ " WHERE ID=? ";
			
			boolean alterou = false;			
			try {
			PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
			query.setString(1,  pessoaAtualizada.getNome());
			query.setString(2,  pessoaAtualizada.getCpf());
			query.setString(3,  pessoaAtualizada.getSexo());
			query.setString(4,  pessoaAtualizada.getDataNascimento());
			query.setBoolean(5,  pessoaAtualizada.isVoluntario());
			query.setInt(6,  pessoaAtualizada.getId());
			
			int codigoRetorno = query.executeUpdate();
			alterou = (codigoRetorno == Banco.CODIGO_RETORNO_SUCESSO);
			
			
		} catch (SQLException e) {
			System.out.println("Erro ao atualiza pessoa.\n Causa" + e.getMessage());
		}
		
		
		return alterou;
	}
	
	public boolean excluir(int id) {
		//TODO
		
		return false;
	}
	
	public PessoaVO pesquisarPorId(int id) {
		//TODO
		return null;
	}
	
	public List<PessoaVO> pesquisarTodas(){
		
		return null;
	}
}

