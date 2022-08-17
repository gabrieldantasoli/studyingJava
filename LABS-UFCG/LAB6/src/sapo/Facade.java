package sapo;

public class Facade {
	
	private PessoaController pessoaControler ;
	private AtividadeController atividadeControler;
	private TarefaController tarefaController;
	
	public Facade() {
		this.pessoaControler = new PessoaController();
		this.atividadeControler = new AtividadeController(); 
		this.tarefaController = new TarefaController();
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
		String codigo = this.atividadeControler.cadastrarAtividade(nome, descricao, cpf);
		return codigo;
	}
		
	public void encerrarAtividade(String atividadeId) {
		if (this.tarefaController.checkTarefasPendentes(atividadeId) == false) {
			this.atividadeControler.encerrarAtividade(atividadeId); 
		}
	}

	public void desativarAtividade(String atividadeId) {
		if (this.tarefaController.checkTarefasPendentes(atividadeId) == false) {
			this.atividadeControler.desativarAtividade(atividadeId);
		}
	}

	public void reabrirAtividade(String atividadeId) {
		this.atividadeControler.reabrirAtividade(atividadeId);
	}

	public String exibirAtividade(String atividadeId) {
		String atividade = this.atividadeControler.exibirAtividade(atividadeId,this.tarefaController.getTarefas(atividadeId));
		return atividade;
	}

	public void alterarDescricaoAtividade(String atividadeId, String descricao) {
		this.atividadeControler.alterarDescricaoAtividade(atividadeId, descricao);
	}

	public void alterarResponsavelAtividade(String atividadeId, String cpf) {
		this.atividadeControler.alterarResponsavelAtividade(atividadeId, cpf);
	}
	
	// Métodos para as classes relacionadas a Atividades terminam aqui. 
	
	// Métodos para as classes relacionadas a Tarefas começam aqui.
	
	public String cadastrarTarefa(String atividadeId, String nome, String[] habilidades) {
		if (this.atividadeControler.getStatusTarefa(atividadeId).equals("aberta")) {
			String nomeAtividade = this.atividadeControler.getNome(atividadeId);
			this.tarefaController.cadastrarTarefa(atividadeId, nome, nomeAtividade, habilidades);
		}else {
			throw new IllegalStateException("A atividade não está aberta!"); 
		}
		return "";
	}
	
	public void alterarNomeTarefa(String idTarefa, String novoNome) {
		this.tarefaController.alterarNomeTarefa(idTarefa, novoNome);
	}
	
	public void alterarHabilidadesTarefa(String idTarefa, String[] habilidades) {
		this.tarefaController.alterarHabilidadesTarefa(idTarefa, habilidades);
	}
	
	public void adicionarHorasTarefa(String idTarefa, int horas) {
		this.tarefaController.adicionarHorasTarefa(idTarefa, horas);
	}
	
	public void removerHorasTarefa(String idTarefa, int horas) {
		this.tarefaController.removerHorasTarefa(idTarefa, horas);
	}
	
	public void concluirTarefa(String idTarefa) {
		this.tarefaController.concluirTarefa(idTarefa);
	}
	
	public void removerTarefa(String idTarefa) {
		this.tarefaController.removerTarefa(idTarefa);
	}
	
	public String exibirTarefa(String idTarefa) { 
		return this.tarefaController.exibirTarefa(idTarefa, this.pessoaControler.getPessoas());
	}
	
	public void associarPessoaTarefa(String cpf, String idTarefa) {
		this.tarefaController.associarPessoaTarefa(cpf, idTarefa);
	}
	
	public void removerPessoaTarefa(String cpf, String idTarefa) {
		this.tarefaController.removerPessoaTarefa(cpf, idTarefa);
	}
	
	// Métodos para as classes relacionadas a Tarefas começam aqui.
}