package sapo;

import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Map.Entry;

public class TarefaRepository {
	private HashMap<String, HashMap<String, Tarefa>> tarefas;
	
	public TarefaRepository() {
		this.tarefas = new HashMap<String, HashMap<String, Tarefa>>(); 
	} 
	
	public String cadastrarTarefa(String codigo, Tarefa tarefa) {
		checaAtividade(codigo);
		checaExisteTarefa(codigo, codigo + "-" + this.tarefas.get(codigo).size());
		this.tarefas.get(codigo).put(codigo + "-" + this.tarefas.get(codigo).size(), tarefa);
		return codigo + "-" + (this.tarefas.get(codigo).size() - 1);
	}
	
	public boolean removerTarefa(String codigo) {
		checaAtividade(codigo.substring(0, codigo.length() -2));
		checaExisteTarefa(codigo);
		this.tarefas.get(codigo.substring(0, codigo.length() -2)).remove(codigo);
		return true;
	}
	
	public Tarefa getTarefa(String codigo) {
		checaAtividade(codigo.substring(0, codigo.length() -2));
		checaExisteTarefa(codigo);
		return this.tarefas.get(codigo.substring(0, codigo.length() -2)).get(codigo);
	}
	
	public HashMap<String, Tarefa> getTarefas(String id) {
		return this.tarefas.get(id);
	}
	
	public int getQtdAtividades(String codigo) {
		return this.tarefas.get(codigo).size();
	}
	
	private boolean checaExisteTarefa(String codigo1, String codigo2) {
		if (this.tarefas.get(codigo1).containsKey(codigo2) == true) {
			throw new NoSuchElementException("A atividade já existe!");
		}
		return false;
	}
	
	private boolean checaExisteTarefa(String codigo1) {
		if (this.tarefas.get(codigo1.substring(0, codigo1.length() -2)).containsKey(codigo1) == true) {
			return true;
		}
		throw new NoSuchElementException("A Tarefa não existe!");
	}
	
	private boolean checaAtividade(String codigo1) {
		if (this.tarefas.containsKey(codigo1) == false) {
			throw new NoSuchElementException("A atividade não existe!");
		}
		return this.tarefas.containsKey(codigo1);
	}
	
	public boolean checkTarefasPendentes(String codigo) {
		for(Entry<String, Tarefa> entry: this.tarefas.get(codigo).entrySet()) {
			if (!entry.getValue().getStatus().equals("concluida")) {
				return true;
			}
		}
		return false;
	}
}
