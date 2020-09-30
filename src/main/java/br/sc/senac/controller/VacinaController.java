package br.sc.senac.controller;

import br.sc.senac.model.dao.VacinaDAO;
import br.sc.senac.model.entity.VacinaVO;

public class VacinaController {

	private String msg = "";
	public String cadastroVacina(VacinaVO vacinaNova) {

		if (validarPais(vacinaNova) && validarDataInicioPesquisa(vacinaNova) && validarEstagio(vacinaNova)
				&& validarPesquisador(vacinaNova) && validarNomeVacina(vacinaNova) && validarNomeVoluntario(vacinaNova)) {
			
			VacinaDAO vacinaDAO = new VacinaDAO();
			vacinaDAO.inserir(vacinaNova);

			msg = "Cadastro de vacina efetuado";

		
		}
		return msg;

	}

	private boolean validarNomeVoluntario(VacinaVO vacinaNova) {
		if(vacinaNova.getNomeVoluntario() == "") {
			msg = "Falta o nome do voluntário";
			return false;
		}
		return true;
	}

	private boolean validarNomeVacina(VacinaVO vacinaNova) {
		if(vacinaNova.getNomeVacina() == "") {
			msg = "Falta o nome da Vacina";
			return false;
		}
		return true;
	}

	private boolean validarPesquisador(VacinaVO vacinaNova) {
		if(vacinaNova.getNomePesquisador() == "") {
			msg = "Falta o nome do Pesquisador";
			return false;
		}
		return true;
	}

	private boolean validarEstagio(VacinaVO vacinaNova) {
		if(vacinaNova.getEstagioPesquisa() == "") {
			msg = "Falta o Estágio da vacina";
			return false;
		}
		return true;
	}

	private boolean validarPais(VacinaVO vacinaNova) {
		if(vacinaNova.getOrigem() == "") {
			msg = "Falta o país de Origem";
			return false;
		}
		
		return true;
	}

	private boolean validarDataInicioPesquisa(VacinaVO vacinaNova) {
		if(vacinaNova.getDataInicio() == null) {
			
			msg = "Data de ínicio incompleta";
			return false;
		}
		return true;
	}
}
