package sapo;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.NoSuchElementException;

public class PessoaRepository {
	private HashMap<String, Pessoa> pessoas;
	
	public PessoaRepository() {
		this.pessoas = new HashMap<String, Pessoa>();
	}
	
	public void cadastrarPessoa(Pessoa pessoa, String cpf) {
		this.pessoas.put(cpf, pessoa);
	}
	
	public void removerPessoa(String cpf) {
		boolean encontrado = false;
		for(Entry<String, Pessoa> entry: this.pessoas.entrySet()) {
			if (entry.getKey().equals(cpf)) {
				for(Entry<String, Pessoa> entry1: this.pessoas.entrySet()) {
					entry1.getValue().removerComentarios(cpf);
				}
				this.pessoas.remove(cpf);
				encontrado = true;
				break;
			}
        }
		if (!encontrado) {
			throw new NoSuchElementException("Pessoa não encontrada no banco de dados!");
		}
	}
	
	public Pessoa getPessoa(String cpf) {
		for(Entry<String, Pessoa> entry: this.pessoas.entrySet()) {
			if (entry.getKey().equals(cpf)) {
				return this.pessoas.get(cpf);
			}
        }
		throw new NoSuchElementException("Pessoa não encontrada no banco de dados!");
	}
	
	public HashMap<String, Pessoa> getPessoas() {
		return this.pessoas;
	}
}
