package sapo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Map.Entry;

public class Tarefa {
	private int duracao;
	private String nome;
	private String[] habilidades;
	private ArrayList<String> pessoasAssociadas;  
	private String codigoTarefa; 
	private String status;
	private String descricao;
	
	public Tarefa(String nome, String[] habilidades, String descricao, String codigo) {
		this.nome = nome;
		this.habilidades = habilidades;
		this.pessoasAssociadas = new ArrayList<String>();
		this.codigoTarefa = codigo;
		this.status = "aberta";
		this.descricao = descricao;
	}
	
	public void alterarNomeTarefa(String nome) {
		checkAtributo(nome);
		this.nome = nome;
	}
	
	public void alterarHabilidadesTarefa(String[] novasHabilidades) {
		this.habilidades = novasHabilidades;
	}
	
	public void adicionarHorasTarefa(int horas) {
		checkAcao();
		this.duracao += horas;
	}
	
	public void removerHorasTarefa(int horas) {
		checkAcao();
		checkCanRemove(horas);
		this.duracao -= horas;
	}
	
	public void concluirTarefa() { 
		if (this.status.equals("concluida")) {
			throw new IllegalStateException("A tarefa já estava concluida!");
		}
		this.status = "concluida";
	}
	
	public String toString(HashMap<String, Pessoa> pessoas) {
		String exibicao = "";
		exibicao += this.nome + " - " + this.codigoTarefa + "/n- " + this.descricao + "/n";
		for (int index = 0; index < this.habilidades.length; index++) {
			exibicao += this.habilidades[index];
			if (index < this.habilidades.length - 1) {
				exibicao += ", ";
			}
		}
		exibicao += "/n(" + this.duracao + "hora(s) executada(s))" + "/n===/nEquipe:/n";
		
		for(Entry<String, Pessoa> entry: pessoas.entrySet()) {
			exibicao += entry.getValue().getNome() + " - " + entry.getValue() + "/n";
        }
		
		return exibicao;
	}
	
	public void associarPessoaTarefa(String cpf) {
		checkAcao();
		checkAtributo(cpf);
		this.pessoasAssociadas.add(cpf);
	}
	
	public void removerPessoaTarefa(String cpf) {
		checkAcao();
		checkAtributo(cpf);
		checkPessoaAssociada(cpf); 
		this.pessoasAssociadas.remove(cpf);
	}
	
	public String getStatus() {
		return this.getStatus();
	}
	
	public String getNome() {
		return this.nome;
	}
	
	private boolean checkPessoaAssociada(String cpf) {
		for (String pessoa : this.pessoasAssociadas) {
			if (pessoa.equals(cpf)) {
				return true;
			}
		}
		throw new NoSuchElementException("A pessoa não está associada à essa tarefa!");
	}
	
	private void checkAcao() {
		if (this.status.equals("concluida")) {
			throw new IllegalStateException("Açaõ inválida : A tarefa já foi concluída!");
		}
	}
	
	private void checkCanRemove(int horas) {
		if (this.duracao - horas < 0) {
			throw new IllegalArgumentException("Ação inválida : A tempo passado não pode ser menor que o tempo total da atividade!");
		}
	}
	
	private boolean checkAtributo(String atributo) {
		if (atributo.trim().equals("")) {
			throw new IllegalArgumentException("O/A " + atributo.toUpperCase() + " não pode ser vazio(a)!");
		}
		
		return true;
	}
}
