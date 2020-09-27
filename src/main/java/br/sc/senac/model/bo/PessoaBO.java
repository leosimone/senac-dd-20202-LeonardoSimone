package br.sc.senac.model.bo;

import br.sc.senac.model.dao.PessoaDAO;
import br.sc.senac.model.entity.PessoaVO;
import br.sc.senac.model.exception.CpfInvalidoException;
import br.sc.senac.model.exception.PessoaSemNomeException;

public class PessoaBO {

	private PessoaDAO pessoaDAO = new PessoaDAO();

	public PessoaVO salvar(PessoaVO novaPessoa) throws PessoaSemNomeException, CpfInvalidoException {

		String pessoaSemNome = novaPessoa.getNome();
		if (pessoaSemNome == null) {
			throw new PessoaSemNomeException("Pessoa deve possuir nome ou nome maior que 3 letras");
		} else if (pessoaSemNome.length() <= 3) {
			throw new PessoaSemNomeException("Pessoa deve possuir nome ou nome maior que 3 letras");
		}

		PessoaDAO novaPessoaDAO = new PessoaDAO();
		
		if(novaPessoaDAO.cpfJaCadastrado(novaPessoa.getCpf())) {
			throw new CpfInvalidoException("o CPF informado (" + novaPessoa.getCpf() + ") já está cadastrado");
			
		}
		
		this.pessoaDAO.inserir(novaPessoa);

		return novaPessoa;
	}
}
