package sapo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Map.Entry;

public class AtividadeRepository {
	private HashMap<String, Atividade> atividades;
	
	public AtividadeRepository() {
		this.atividades = new HashMap<String, Atividade>();
	}
	
	public void cadastrarAtividade(String id, Atividade atividade) {
		this.atividades.put(id, atividade); 
	}
	
	public int numeroAttCadastradas() {
		return this.atividades.size();
	} 
	
	public Atividade getAtividade(String id) {
		for(Entry<String, Atividade> entry: this.atividades.entrySet()) {
			if (entry.getKey().equals(id)) {
				return this.atividades.get(id);
			}
        }
		throw new NoSuchElementException("Atividade não encontrada no banco de dados!");
	}
	
	public HashMap<String, Atividade> getAtividades() {
		return this.atividades;
	}
	
	public HashMap<String, ArrayList<String>> getMetadados() {
		HashMap<String, ArrayList<String>> metadados = new HashMap<String, ArrayList<String>>();
		for(Entry<String, Atividade> entry: this.atividades.entrySet()) {
			metadados.put(entry.getKey(), entry.getValue().getMetadados());
        }
		return metadados;
	}
}
