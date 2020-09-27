package br.sc.senac.model.bo;

import br.sc.senac.model.dao.PessoaDAO;
import br.sc.senac.model.entity.PessoaVO;
import br.sc.senac.model.exception.CpfInvalidoException;
import br.sc.senac.model.exception.PessoaSemNomeException;

public class PessoaBO {

	private PessoaDAO pessoa = new PessoaDAO();

	public PessoaVO salvar(PessoaVO novaPessoa) throws PessoaSemNomeException, CpfInvalidoException {

				
		if(pessoa.cpfJaCadastrado(novaPessoa.getCpf())) {
			throw new CpfInvalidoException("o CPF informado (" + novaPessoa.getCpf() + ") já está cadastrado");
			
		}
		
		this.pessoa.inserir(novaPessoa);

		return novaPessoa;
	}
}
