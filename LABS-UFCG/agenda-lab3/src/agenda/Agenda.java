package agenda;

/**
 * Uma agenda que mantém uma lista de contatos com posições. Podem existir 100 contatos. 
 * 
 * @author nazareno
 *
 */
public class Agenda {
	
	private static final int TAMANHO_AGENDA = 100;
	
	private String[] nomesContatos;
	private Contato[] contatos;

	/**
	 * Cria uma agenda.
	 */
	public Agenda() {
		this.nomesContatos = new String[TAMANHO_AGENDA];
		this.contatos = new Contato[100];
	}
	
	/**
	 * Acessa a lista de contatos mantida.
	 * @return O array de contatos.
	 */
	public String[] getContatos() {
		return this.nomesContatos.clone();
	}

	/**
	 * Acessa os dados de um contato específico.
	 * @param posicao Posição do contato na agenda.
	 * @return Dados do contato. Null se não há contato na posição.
	 */
	public String getContato(int posicao) {
		return nomesContatos[posicao];
	}

	/**
	 * Cadastra um contato em uma posição. Um cadastro em uma posição que já existe sobrescreve o anterior. 
	 * @param posicao Posição do contato.
	 * @param nome Nome do contato.
	 * @param sobrenome Sobrenome do contato.
	 * @param telefone Telefone do contato.
	 */
	public void cadastraContato(int posicao, String nome, String sobrenome, String telefone) {
		boolean cadastra = true;
		for (int i = 0; i < 100; i++){
			if (this.contatos[i] != null) {
				if (contatos[i].getNome() == nome && contatos[i].getSobrenome() == sobrenome) {
					System.out.println("CONTATO JA CADASTRADO!");
					cadastra = false;
				}
			}
		}
		if (cadastra) {
			this.nomesContatos[posicao] = nome;
			Contato contato = new Contato(nome, sobrenome, telefone);
			this.contatos[posicao] = contato;
			System.out.print("CADASTRO REALIZADO!");
		}
	}

}
