package sapo;

public class Atividade {
	private String nome;
	private String descricao;
	private String cpfResponsavel;
	private String codigoAtt;
	private String status;
	
	public Atividade(String nome, String descricao, String cpf, int attIndex) {
		checkAtributo(nome);
		checkAtributo(descricao);
		checkAtributo(cpf);
		this.nome = nome;
		this.descricao = descricao;
		this.cpfResponsavel = cpf;
		this.codigoAtt = gerarCodigo(this.nome) + "-" + attIndex;
		this.status = "aberta";
	}
	
	public void encerrarAtividade() {
		if (this.status == "aberta") {
			this.status = "encerrada";
		}else {
			throw new IllegalArgumentException("A tarefa já estava aberta !");
		}
	}

	public void desativarAtividade() {
		if (this.status == "aberta") {
			this.status = "desativada";
		}else {
			throw new IllegalArgumentException("A tarefa já estava aberta !");
		}
	}

	public void reabrirAtividade() {
		if (this.status == "aberta") {
			throw new IllegalArgumentException("A tarefa já estava aberta !");
		}else {
			this.status = "aberta";
		}
	}

	@Override
	public String toString() {
		String sobreAtt = "";
		sobreAtt += this.codigoAtt + this.nome + "/n";
		if (this.cpfResponsavel != null) {
			sobreAtt += "Responsável: " + "nome do responsavel" + " - " + this.cpfResponsavel + "/n";
		}
		
		sobreAtt += "===/n" + this.descricao + "/n===/n";
		
		//adicionar tarefas em toString
		/*
		 * Tarefas: 6/20
		 * - Fazer apresentação sobre atributos e métodos - STD-0-20
		   - Preparar material de estudo - STD-0-15
		   - Revisar questões da prova - STD-0-10
		 */
		
		return sobreAtt;
	}

	public void alterarDescricaoAtividade(String descricao) {
		this.descricao = descricao;
	}

	public void alterarResponsavelAtividade(String cpf) {
		this.cpfResponsavel = cpf;
	}
	
	public String getCodigo() {
		return this.codigoAtt;
	}

	private String gerarCodigo(String nome) {
		nome = nome.toUpperCase();
		String codigo = "";
		
		int letras = 0;
		for (int index = 0; index < nome.length(); index++) {
			String letra = nome.substring(index, index + 1);
			if ("AEIOU".contains(letra)) {
				letras += 1;
				codigo += letra;
				if (letras == 3) break;
			}
		}
		while (letras < 3) {
			codigo += "X";
			letras += 1;
		}
		
		return codigo;
	}
	
	private boolean checkAtributo(String atributo) {
		if (atributo.trim().equals("")) {
			throw new IllegalArgumentException("O/A " + atributo.toUpperCase() + " não pode ser vazio(a)!");
		}
		
		return true;
	}
}
