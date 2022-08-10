package sapo;

public class PessoaController {
	private PessoaRepository pr;
	
	public PessoaController() {
		this.pr = new PessoaRepository();
	}
	
	public void cadastrarPessoa(String cpf, String nome, String[] habilidades) {
		Pessoa pessoa = new Pessoa(cpf, nome, habilidades);
		pr.cadastrarPessoa(pessoa, cpf);
	}
	
	public String exibirPessoa(String cpf) {
		Pessoa pessoa = pr.getPessoa(cpf);
		return pessoa.toString();
	}
	
	public void alterarNomePessoa(String cpf, String novoNome) {
		Pessoa pessoa = pr.getPessoa(cpf);
		pessoa.alterarNome(novoNome);
	}
	
	public void alterarHabilidadesPessoa(String cpf, String[] novasHabilidades) {
		Pessoa pessoa = pr.getPessoa(cpf);
		pessoa.alterarHabilidades(novasHabilidades);
	}
	
	public void removerPessoa(String cpf) {
		pr.removerPessoa(cpf);
	}
	
	public void adicionarComentarioPessoa(String cpf, String comentario, String autorCpf) {
		Pessoa pessoa = pr.getPessoa(cpf);
		pessoa.AdicionarComentario(pr.getPessoas(), comentario, autorCpf);
	}
	
	public String listarComentariosPessoa(String cpf) {
		Pessoa pessoa = pr.getPessoa(cpf);
		return pessoa.listarComentarios(pr.getPessoas());
	}
}
