package sapo;

import java.util.HashMap;
import java.util.Map.Entry;

public class Atividade {
	private String nome;
	private String descricao;
	private String cpfResponsavel;
	private String codigoAtt;
	private String status;
	
	
	public Atividade(String nome, String descricao, String cpf, int attIndex) {
		checkAtributo(nome,"nome");
		checkAtributo(descricao,"descrição"); 
		checkAtributo(cpf,"cpf");
		this.nome = nome;
		this.descricao = descricao;
		this.cpfResponsavel = cpf;
		this.codigoAtt = gerarCodigo(this.nome) + "-" + attIndex;
		this.status = "aberta";
	}
	
	public void encerrarAtividade() {
		if (this.status == "aberta") {
			this.status = "encerrada";
		}else {
			throw new IllegalArgumentException("A tarefa não está aberta !");
		}
	}

	public void desativarAtividade() {
		if (this.status == "aberta") {
			this.status = "desativada";
		}else {
			throw new IllegalArgumentException("A tarefa não está aberta !");
		}
	}

	public void reabrirAtividade() {
		if (this.status == "aberta") {
			throw new IllegalArgumentException("A tarefa já estava aberta !");
		}else {
			this.status = "aberta";
		}
	}

	public String toString(HashMap<String, Tarefa> tarefas) {
		String sobreAtt = "";
		sobreAtt += this.codigoAtt + this.nome + "/n";
		if (this.cpfResponsavel != null) {
			sobreAtt += "Responsável: " + "nome do responsavel" + " - " + this.cpfResponsavel + "/n";
		}
		sobreAtt += "===/n" + this.descricao + "/n===/n"; 
		int tarefasRealisadas = 0;
		for(Entry<String, Tarefa> entry: tarefas.entrySet()) {
			if (entry.getValue().getStatus().equals("concluida")) {
				tarefasRealisadas += 1;
			}
        }
		sobreAtt += "Tarefas: " + tarefasRealisadas + "/" + tarefas.size() + "/";
		int total = 0;
		for(Entry<String, Tarefa> entry: tarefas.entrySet()) {
			if (!entry.getValue().getStatus().equals("concluida")) {
				sobreAtt += "- " + entry.getValue().getNome() + entry.getKey();
				total += 1;
				if (total == 3) break;
			}
		}
		return sobreAtt;
	}

	public void alterarDescricaoAtividade(String descricao) {
		this.descricao = descricao;
	}

	public void alterarResponsavelAtividade(String cpf) {
		this.cpfResponsavel = cpf;
	}
	
	public String getCodigo() {
		return this.codigoAtt;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	private String gerarCodigo(String nome) {
		nome = nome.toUpperCase();
		String codigo = "";
		
		int letras = 0;
		for (int index = 0; index < nome.length(); index++) {
			String letra = nome.substring(index, index + 1);
			if (!"AEIOU".contains(letra)) {
				letras += 1; 
				codigo += letra;
				if (letras == 3) break;
			}
		}
		while (letras < 3) {
			codigo += "X";
			letras += 1;
		}
		
		return codigo;
	}
	
	private boolean checkAtributo(String atributo, String nomeAtributo) {
		if (atributo.trim().equals("")) {
			throw new IllegalArgumentException("O/A " + nomeAtributo.toUpperCase() + " da pessoa não pode ser vazio!");
		}
		
		return true;
	}
}
