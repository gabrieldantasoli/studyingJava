package sapo;

import java.util.ArrayList;

public class Pessoa {
	private String cpf;
	private String nome;
	private String[] habilidades;
	private ArrayList<Comentario> comentarios;
	
	public Pessoa(String cpf, String nome, String[] habilidades) {
		checkAtributo(cpf);
		checkAtributo(nome);
		
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
	
	public void AdicionarComentario(String descricao, String cpfAutor) {
		// checar se a pessoa existe
		checkAtributo(descricao);
		checkAtributo(cpfAutor);
		
		Comentario comentario = new Comentario(descricao, cpfAutor);
		this.comentarios.add(comentario);
	}
	
	public String listarComentarios() {
		String exibicao = "";
		exibicao += this.nome + " - " + this.cpf + "\n";
		exibicao += "Comentários:\n";
		for (int index = 0; index < this.comentarios.size(); index++) {
			// pegar o nome da pessoa
			exibicao += "-- " + this.comentarios.get(index) + "Nome da pessoa" + "\n";
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
		if (nome.trim().equals("")) {
			throw new IllegalArgumentException("O/A " + atributo.toUpperCase() + " da pessoa não pode ser vazio!");
		}
		return true;
	}
	
}
