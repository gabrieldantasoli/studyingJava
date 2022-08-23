package sapo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Map.Entry;

public class TarefaRepository {
	private HashMap<String, HashMap<String, Tarefa>> tarefas;
	private ArrayList atividades;
	
	public TarefaRepository() {
		this.tarefas = new HashMap<String, HashMap<String, Tarefa>>(); 
		this.atividades = new ArrayList<>();
	} 
	
	public void adicionarAtividade(String codigo) {
		this.atividades.add(codigo);
	}
	
	public String cadastrarTarefa(String codigo, Tarefa tarefa) {
		checaAtividade(codigo);
		if (this.tarefas.containsKey(codigo)) {
			checaExisteTarefa(codigo, codigo + "-" + this.tarefas.get(codigo).size());
		}
		if (this.tarefas.containsKey(codigo)) {
			this.tarefas.get(codigo).put(codigo + "-" + this.tarefas.get(codigo).size(), tarefa);
		}else {
			HashMap novaAtt = new HashMap<String, Tarefa>();
			novaAtt.put(codigo + "-" + "0", tarefa);
			this.tarefas.put(codigo, novaAtt);
		}
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
		if (!this.tarefas.containsKey(codigo)) {
			return 0;
		}
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
		throw new NoSuchElementException("A Tarefa já existe!");
	}
	
	private boolean checaAtividade(String codigo1) {
		if (this.atividades.contains(codigo1)) return true;
		throw new NoSuchElementException("A atividade não existe!");
	}
	
	public boolean checkTarefasPendentes(String codigo) {
		if (this.tarefas.containsKey(codigo)) {
			for(Entry<String, Tarefa> entry: this.tarefas.get(codigo).entrySet()) {
				if (entry.getValue().getStatus().equals("aberta")) {
					return true; 
				}
			}
		} 
		return false;
	}
	
	public HashMap<String, ArrayList<String>> getMetadados() {
		HashMap<String, ArrayList<String>> dados = new HashMap<String, ArrayList<String>>();
		
		for(Entry<String, HashMap<String, Tarefa>> entry: this.tarefas.entrySet()) {
			ArrayList<String> keys = new ArrayList<String>();
			for(Entry<String, Tarefa> entry1: entry.getValue().entrySet()) {
				keys.add(entry1.getKey());
			} 
			dados.put(entry.getKey(), keys);
		}
		return dados;
	}
	
	public HashMap<String, String[]> getMetadadosHabilidades() {
		HashMap<String, String[]> habilidades = new HashMap<String, String[]>();
		for(Entry<String, HashMap<String, Tarefa>> entry: this.tarefas.entrySet()) {
			for(Entry<String, Tarefa> entry1: entry.getValue().entrySet()) {
				habilidades.put(entry1.getKey(), entry1.getValue().getHabilidades());
			}
		}
		return habilidades;
	}
	
}
