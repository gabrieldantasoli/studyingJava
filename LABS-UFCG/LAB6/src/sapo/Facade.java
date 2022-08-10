package sapo;

public class Facade {
	
	private PessoaController pessoaControler ;
	
	public Facade() {
		this.pessoaControler = new PessoaController();
	}
	
	// Métodos para as classes relacionadas a pessoas começam aqui. 
	
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
	
	// Métodos para as classes relacionadas a pessoas terminam aqui. 
	
	// Métodos para as classes relacionadas a Atividades começam aqui. 
	
	public String cadastrarAtividade(String nome, String descricao, String cpf) {
		return "";
	}
		
	public void encerrarAtividade(String atividadeId) {

	}

	public void desativarAtividade(String atividadeId) {

	}

	public void reabrirAtividade(String atividadeId) {

	}

	public String exibirAtividade(String atividadeId) {
		return "";
	}

	public void alterarDescricaoAtividade(String atividadeId, String descricao) {

	}

	public void alterarResponsavelAtividade(String atividadeId, String cpf) {

	}
	
	// Métodos para as classes relacionadas a Atividades terminam aqui. 

}