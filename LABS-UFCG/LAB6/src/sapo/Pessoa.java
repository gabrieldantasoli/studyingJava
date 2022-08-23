package sapo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Map.Entry;

public class Pessoa {
	private String cpf;
	private String nome;
	private String[] habilidades;
	private HashMap<String, Comentario> comentarios;
	
	public Pessoa(String cpf, String nome, String[] habilidades) {
		checkAtributo(cpf,"cpf");
		checkAtributo(nome,"nome");
		this.comentarios = new HashMap<String, Comentario>();
		
		this.cpf = cpf;
		this.nome = nome;
		this.habilidades = habilidades;
	}
	
	public boolean alterarNome(String novoNome) {
		checkAtributo(novoNome,"novo nome");
		this.nome = novoNome;
		return true;
	}
	
	public void alterarHabilidades(String[] novasHabilidades) {
		this.habilidades = novasHabilidades;
	}
	
	public void AdicionarComentario(HashMap<String, Pessoa> pessoas, String descricao, String cpfAutor) {
		boolean encontrado = false;
		for(Entry<String, Pessoa> entry: pessoas.entrySet()) {
			if (entry.getKey().equals(cpfAutor)) {
				encontrado = true;
				break;
			}
        }
		
		if (!encontrado) {
			throw new NoSuchElementException("CPF do autor não encontrada no banco de dados!");
		}
		
		checkAtributo(descricao,"comentario");
		checkAtributo(cpfAutor,"cpf do autor");
		
		Comentario comentario = new Comentario(descricao, cpfAutor);
		this.comentarios.put(cpfAutor, comentario);
	}
	
	public void removerComentarios(String cpfAutor) {
		for(Entry<String, Comentario> entry: this.comentarios.entrySet()) {
			if (entry.getKey().equals(cpfAutor)) {
				this.comentarios.remove(cpfAutor);
			}
        }
	}
	
	public String listarComentarios(HashMap<String, Pessoa> pessoas) {
		String exibicao = "";
		exibicao += this.nome + " - " + this.cpf + "\n";
		exibicao += "Comentários:\n";
		for(Entry<String, Comentario> entry: this.comentarios.entrySet()) {
			String[] info = entry.getValue().getInfo();
			exibicao += "-- " + this.comentarios.get(pessoas.get(entry.getKey()).getCPF()).getInfo()[0] + " (" + pessoas.get(entry.getKey()).getNome() + ")" + "\n";
		}
		
		return exibicao;
	}
	
	public String getCPF() {
		return this.cpf;
	}
	
	@Override
	public String toString() {
		String exibicao = "";
		exibicao += this.nome + " - " + this.cpf + "\n";
		for (String habilidade : this.habilidades) {
			exibicao += "- " + habilidade + "\n";
		}
		return exibicao;
	}
	
	private boolean checkAtributo(String atributo, String nomeAtributo) {
		if (atributo.trim().equals("")) {
			throw new IllegalArgumentException("O/A " + nomeAtributo.toUpperCase() + " da pessoa não pode ser vazio!");
		}
		return true;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public ArrayList<String> getMetadados() {
		ArrayList<String> metadados = new ArrayList<String>();
		metadados.add(this.nome.toLowerCase());
		metadados.add(this.cpf.toLowerCase());
		for (String str : this.habilidades) {
			metadados.add(str.toLowerCase());
		}
		return metadados;
	}
	
	public String[] getHabilidades() {
		return this.habilidades;
	}
}
