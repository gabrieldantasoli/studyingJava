package sapo;

public class Facade {
	
	private PessoaController pessoaControler ;
	
	public Facade() {
		this.pessoaControler = new PessoaController();
	}
	
	public void cadastrarPessoa(String cpf, String nome, String[] habilidades) {
		this.pessoaControler.cadastrarPessoa(cpf, nome, habilidades);
	}
	
	public void exibirPessoa(String cpf) {
		this.pessoaControler.exibirPessoa(cpf);
	}
	
	public void alterarNomePessoa(String cpf, String novoNome) {
		this.pessoaControler.alterarNomePessoa(cpf, novoNome);
	}
	
	public void alterarHabilidadesPessoa(String cpf, String[] novasHabilidades) {
		this.pessoaControler.alterarHabilidadesPessoa(cpf, novasHabilidades);
	}
	
	public void removerPessoa(String cpf) {
		this.pessoaControler.removerPessoa(cpf);
	}
	
	public void adicionarComentarioPessoa(String cpf, String comentario, String autorCpf) {
		this.pessoaControler.adicionarComentarioPessoa(cpf, comentario, autorCpf);
	}
	
	public String listarComentariosPessoa(String cpf) {
		return this.pessoaControler.listarComentariosPessoa(cpf);
	}
}