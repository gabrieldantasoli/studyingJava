package sapo;

import java.util.ArrayList;
import java.util.HashMap;

public class AtividadeController {
	private AtividadeRepository attRep;
	
	public AtividadeController() {
		this.attRep = new AtividadeRepository(); 
	}
	
	public String cadastrarAtividade(String nome, String descricao, String cpf) {
		Atividade atividade = new Atividade(nome, descricao, cpf, this.attRep.numeroAttCadastradas());
		attRep.cadastrarAtividade(atividade.getCodigo(), atividade);
		return atividade.getCodigo();
	}
	
	public void encerrarAtividade(String atividadeId) {
		checkAtributo(atividadeId,"ID da atividade");
		Atividade atividade = attRep.getAtividade(atividadeId);
		atividade.encerrarAtividade();
	}
	 
	public void desativarAtividade(String atividadeId) {
		checkAtributo(atividadeId,"ID da atividade");
		Atividade atividade = attRep.getAtividade(atividadeId);
		atividade.desativarAtividade();
	}
	
	public void reabrirAtividade(String atividadeId) {
		checkAtributo(atividadeId,"ID da atividade");
		Atividade atividade = attRep.getAtividade(atividadeId);
		atividade.reabrirAtividade();
	}
	
	public String exibirAtividade(String atividadeId, HashMap<String, Tarefa> tarefas, String responsavel) {
		checkAtributo(atividadeId,"ID da atividade");
		Atividade atividade = attRep.getAtividade(atividadeId);
		return atividade.toString(tarefas, responsavel);
	}
	
	public void alterarDescricaoAtividade(String atividadeId, String descricao) {
		checkAtributo(atividadeId,"ID da atividade");
		checkAtributo(descricao,"descrição");
		Atividade atividade = attRep.getAtividade(atividadeId);
		atividade.alterarDescricaoAtividade(descricao);
	}
	
	public void alterarResponsavelAtividade(String atividadeId, String cpf) {
		checkAtributo(atividadeId,"ID da atividade");
		Atividade atividade = attRep.getAtividade(atividadeId);
		atividade.alterarResponsavelAtividade(cpf);
	}
	
	private boolean checkAtributo(String atributo, String nomeAtributo) {
		if (atributo.trim().equals("")) {
			throw new IllegalArgumentException("O/A " + nomeAtributo.toUpperCase() + " da atividade não pode ser vazio!");
		}
		
		return true;
	}
	
	public String getNome(String idAtividade) {
		return this.attRep.getAtividade(idAtividade).getNome();
	}
	
	public String getStatusTarefa(String atividadeId) {
		return this.attRep.getAtividade(atividadeId).getStatus();
	}
	
	public String getResponsavel(String atividadeId) {
		if (this.attRep.getAtividade(atividadeId).getResponsavel().equals("")) {
			return "";
		}
		return this.attRep.getAtividade(atividadeId).getResponsavel();
	}
	
	public HashMap<String, ArrayList<String>> getMetadados() {
		return this.attRep.getMetadados();
	}
}
