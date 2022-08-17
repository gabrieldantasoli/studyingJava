package sapo;

import java.util.HashMap; 

public class TarefaController {
	private TarefaRepository tarefaRepository;
	
	public TarefaController() {
		this.tarefaRepository = new TarefaRepository();  
	} 
	
	public String cadastrarTarefa(String atividadeId, String nome, String nomeAtividade, String[] habilidades) {
		String codigo = atividadeId + "-" + this.tarefaRepository.getQtdAtividades(atividadeId);
		Tarefa tarefa = new Tarefa(nome, habilidades, nomeAtividade, codigo);
		return this.tarefaRepository.cadastrarTarefa(atividadeId, tarefa);
	}
	
	public void alterarNomeTarefa(String idTarefa, String novoNome) {
		this.tarefaRepository.getTarefa(idTarefa).alterarNomeTarefa(novoNome);
	}
	
	public void alterarHabilidadesTarefa(String idTarefa, String[] novasHabilidades) {
		this.tarefaRepository.getTarefa(idTarefa).alterarHabilidadesTarefa(novasHabilidades);
	}
	
	public void adicionarHorasTarefa(String idTarefa, int horas) {
		this.tarefaRepository.getTarefa(idTarefa).adicionarHorasTarefa(horas);
	}
	
	public void removerHorasTarefa(String idTarefa, int horas) {
		this.tarefaRepository.getTarefa(idTarefa).adicionarHorasTarefa(horas);
	}
	
	public void concluirTarefa(String idTarefa) {
		this.tarefaRepository.getTarefa(idTarefa).concluirTarefa();
	}
	
	public void removerTarefa(String idTarefa) {
		this.tarefaRepository.removerTarefa(idTarefa);
	}
	
	public String exibirTarefa(String idTarefa, HashMap<String, Pessoa> pessoas) {
		return this.tarefaRepository.getTarefa(idTarefa).toString(pessoas);
	}
	 
	public void associarPessoaTarefa(String cpf, String idTarefa) {
		this.tarefaRepository.getTarefa(idTarefa).associarPessoaTarefa(cpf);
	}
	
	public void removerPessoaTarefa(String cpf, String idTarefa) {
		this.tarefaRepository.getTarefa(idTarefa).removerPessoaTarefa(cpf);
	}
	
	public boolean checkTarefasPendentes(String codigo) {
		return this.tarefaRepository.checkTarefasPendentes(codigo);
	}
	
	public HashMap<String, Tarefa> getTarefas(String id) {
		return this.tarefaRepository.getTarefas(id);
	}
}
