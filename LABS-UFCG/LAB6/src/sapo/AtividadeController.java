package sapo;

public class AtividadeController {
	private AtividadeRepository attRep;
	
	public AtividadeController() {
		this.attRep = new AtividadeRepository();
	}
	
	public String cadastrarAtividade(String nome, String descricao, String cpf) {
		Atividade atividade = new Atividade(nome, descricao, cpf, this.attRep.numeroAttCadastradas());
		attRep.cadastrarAtividade(atividade.getCodigo(), atividade);
		return atividade.getCodigo();
	}
	
	public void encerrarAtividade(String atividadeId) {
		checkAtributo(atividadeId);
		Atividade atividade = attRep.getAtividade(atividadeId);
		atividade.encerrarAtividade();
	}
	
	public void desativarAtividade(String atividadeId) {
		checkAtributo(atividadeId);
		Atividade atividade = attRep.getAtividade(atividadeId);
		atividade.desativarAtividade();
	}
	
	public void reabrirAtividade(String atividadeId) {
		checkAtributo(atividadeId);
		Atividade atividade = attRep.getAtividade(atividadeId);
		atividade.reabrirAtividade();
	}
	
	public String exibirAtividade(String atividadeId) {
		checkAtributo(atividadeId);
		Atividade atividade = attRep.getAtividade(atividadeId);
		return atividade.toString();
	}
	
	public void alterarDescricaoAtividade(String atividadeId, String descricao) {
		checkAtributo(atividadeId);
		checkAtributo(descricao);
		Atividade atividade = attRep.getAtividade(atividadeId);
		atividade.alterarDescricaoAtividade(descricao);
	}
	
	public void alterarResponsavelAtividade(String atividadeId, String cpf) {
		checkAtributo(atividadeId);
		Atividade atividade = attRep.getAtividade(atividadeId);
		atividade.alterarResponsavelAtividade(cpf);
	}
	
	private boolean checkAtributo(String atributo) {
		if (atributo.trim().equals("")) {
			throw new IllegalArgumentException("O/A " + atributo.toUpperCase() + " não pode ser vazio(a)!");
		}
		
		return true;
	}
}
