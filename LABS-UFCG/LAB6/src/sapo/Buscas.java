package sapo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Collections;

public class Buscas {
	private ArrayList<String[]> buscas;
	private ArrayList<String> indicesBuscas;
	
	public Buscas() {
		this.buscas = new ArrayList<String[]>();
		this.indicesBuscas = new ArrayList<String>();
	}
	
	public String[] buscarPessoas(String[] consulta, HashMap<String, ArrayList<String>> metadados) {
		ArrayList<String> pessoasEncontradas = new ArrayList<String>();
		for(Entry<String, ArrayList<String>> entry: metadados.entrySet()) {
			boolean satisfaz = true;
			for (String str : consulta) {
				if (!entry.getValue().contains(str.toLowerCase())) {
					satisfaz = false;
					break;
				}
			}
			if (satisfaz) {
				pessoasEncontradas.add(entry.getValue().get(0));
			}
        }
		String[] pessoas = new String[pessoasEncontradas.size()];
		for (int index = 0; index < pessoasEncontradas.size(); index++) {
			pessoas[index] = pessoasEncontradas.get(index);
		}
		Arrays.sort(pessoas);
		this.buscas.add(pessoas);
		this.indicesBuscas.add("PESSOA");
		return pessoas;
	}
	
	public String[] buscarAtividades(String[] consulta, HashMap<String, ArrayList<String>> metadados) {
		ArrayList<String> atividadesEncontradas = new ArrayList<String>();
		for(Entry<String, ArrayList<String>> entry: metadados.entrySet()) {
			boolean satisfaz = true;
			for (String str : consulta) {
				if (!entry.getValue().contains(str.toLowerCase())) {
					satisfaz = false;
					break;
				}
			}
			if (satisfaz) {
				atividadesEncontradas.add(entry.getValue().get(0));
			}
        }
		String[] atividades = new String[atividadesEncontradas.size()];
		for (int index = 0; index < atividadesEncontradas.size(); index++) {
			atividades[index] = atividadesEncontradas.get(index);
		}
		Arrays.sort(atividades);
		this.buscas.add(atividades);
		this.indicesBuscas.add("ATIVIDADE");
		return atividades;
	}
	
	public String[] buscarTarefas(String nome, HashMap<String, ArrayList<String>> tarefas) {
		ArrayList<String> dados = new ArrayList<String>();
		for(Entry<String, ArrayList<String>> entry: tarefas.entrySet()) {
			for (String s : entry.getValue()) {
				if (s.contains(nome)) {
					dados.add(s);
				}	
			}
		}
		String[] retorno = new String[dados.size()];
		for (int index = 0; index < dados.size(); index++) {
			retorno[index] = dados.get(index);
		}
		this.buscas.add(retorno);
		this.indicesBuscas.add("TAREFA");
		return retorno;
	}
	
	public String[] buscarTarefas(String idAtividade, String nome, HashMap<String, ArrayList<String>> tarefas) {
		ArrayList<String> dados = new ArrayList<String>();
		if (tarefas.containsKey(idAtividade)) {
			for (String s : tarefas.get(idAtividade)) {
				if (s.contains(nome)) {
					dados.add(s);
				}
			}
		}
		String[] retorno = new String[dados.size()];
		for (int index = 0; index < dados.size(); index++) {
			retorno[index] = dados.get(index);
		}
		this.buscas.add(retorno);
		this.indicesBuscas.add("TAREFA");
		return retorno;
	}
	
	public String[] sugerirTarefas(Pessoa pessoa, HashMap<String, String[]> metadados) { 
		String[] habilidades = pessoa.getHabilidades();
		HashMap<String, Integer> habilidadesComuns = new HashMap<String, Integer>();
		HashMap<String, Integer> pessoasAssociadas = new HashMap<String, Integer>();
		for(Entry<String, String[]> entry: metadados.entrySet()) {
			int total = 0;
			for (String str1 : entry.getValue()) {
				for (String str2 : habilidades) {
					if (str1.equals(str2)) {
						total += 1;
						break;
					}
				}
			}
			habilidadesComuns.put(entry.getKey(), total);
			pessoasAssociadas.put(entry.getKey(), Integer.parseInt(entry.getValue()[entry.getValue().length-1]));
		}
		ArrayList<String> tarefasSugeridas = new ArrayList<String>();
		int i = 0;
		while (habilidadesComuns.size() > i) {
			int maior = Integer.MIN_VALUE;
			String codigoMaior = "";
			int PAM = 0;
			int index = 0;
			for(Entry<String, Integer> entry: habilidadesComuns.entrySet()) {
				if (entry.getValue() > maior) {
					maior = entry.getValue();
					codigoMaior = entry.getKey();
					PAM = pessoasAssociadas.get(codigoMaior);
					index += 1;
				}else if (entry.getValue() == maior) {
					if (pessoasAssociadas.get(entry.getKey()) > PAM) {
						maior = entry.getValue();
						codigoMaior = entry.getKey();
						PAM = pessoasAssociadas.get(codigoMaior);
						index += 1;
					}
				}
			}
			tarefasSugeridas.add(codigoMaior);
			habilidadesComuns.put(codigoMaior, Integer.MIN_VALUE);
			i += 1;
		}
		String[] retorno = new String[tarefasSugeridas.size()];
		for (int a = 0; a < tarefasSugeridas.size(); a++) {
			retorno[a] = tarefasSugeridas.get(a); 
		}
		
		this.buscas.add(retorno);
		this.indicesBuscas.add("SUGESTÃO");
		return retorno;
	}
	
	public String[] buscasMaisRecentes(int nBuscas) {
		if (nBuscas > this.buscas.size() || nBuscas < 0) {
			throw new IllegalArgumentException("Indice invalido!");
		}
		String[] historico = new String[nBuscas];
		int indice = 0;
		int remove = 1;
		while (nBuscas > indice) {
			historico[indice] = this.indicesBuscas.get(nBuscas-remove);
			indice += 1;
			remove += 1;
		}
		return historico;
	}
	
	public String[] exibirHistóricoBusca(int indexBusca) {
		if (indexBusca > this.buscas.size() || indexBusca <= 0) {
			throw new IllegalArgumentException("Indice não encontrado!");
		}
		String[] historico = new String[this.buscas.get(this.buscas.size()-indexBusca).length+1];
		historico[0] = this.indicesBuscas.get(this.buscas.size()-indexBusca);
		for (int i = 0; i < this.buscas.get(this.buscas.size()-indexBusca).length; i++) {
			historico[i+1] = this.buscas.get(this.buscas.size()-indexBusca)[i];
		}
		return historico;
	}
}
