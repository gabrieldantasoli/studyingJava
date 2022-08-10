package sapo;

import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Map.Entry;

public class Pessoa {
	private String cpf;
	private String nome;
	private String[] habilidades;
	private HashMap<String, Comentario> comentarios;
	
	public Pessoa(String cpf, String nome, String[] habilidades) {
		checkAtributo(cpf);
		checkAtributo(nome);
		this.comentarios = new HashMap<String, Comentario>();
		
		this.cpf = cpf;
		this.nome = nome;
		this.habilidades = habilidades;
	}
	
	public boolean alterarNome(String novoNome) {
		checkAtributo(novoNome);
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
		
		checkAtributo(descricao);
		checkAtributo(cpfAutor);
		
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
			exibicao += "-- " + this.comentarios.get(info[0]) + "(" + pessoas.get(entry.getKey()).getNome() + ")" + "\n";
		}
		
		return exibicao;
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
	
	private boolean checkAtributo(String atributo) {
		if (atributo.trim().equals("")) {
			throw new IllegalArgumentException("O/A " + atributo.toUpperCase() + " da pessoa não pode ser vazio!");
		}
		
		return true;
	}
	
	public String getNome() {
		return this.nome;
	}
	
}
