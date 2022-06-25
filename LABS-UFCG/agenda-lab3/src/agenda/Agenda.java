package agenda;

import java.time.format.SignStyle;

/**
 * Uma agenda que mantém uma lista de contatos com posições. Podem existir 100 contatos. 
 * 
 * @author nazareno
 *
 */
public class Agenda {
	
	private static final int TAMANHO_AGENDA = 100;
	
	private Contato[] contatos;
	private int[] favoritos;

	/**
	 * Cria uma agenda.
	 */
	public Agenda() {
		this.contatos = new Contato[100];
		this.favoritos = new int[10];          
		for (int index = 0; index < 10; index++) {
			this.favoritos[index] = -1;
		}            
	}

	/**
	 * Acessa a lista de contatos mantida.
	 * @return O array de contatos.
	 */
	public boolean getContato(int posicao) {
		return this.contatos[posicao] != null ? true : false;
	}                     

	/**
	 * Acessa os dados de um contato específico.
	 * @param posicao Posição do contato na agenda.
	 * @return Dados do contato. Null se não há contato na posição.
	 */
	public void showContato(int posicao) {
		if (this.contatos[posicao-1] != null) {
			this.contatos[posicao - 1].showContato();
		}else {
			System.out.println("CONTATO INEXISTENTE!");
		}
		
	}

	/**
	 * Lista todos os contatos da agenda.
	 * 
	 */
	public void listarContatos() {
		System.out.println("");
		for (int index = 0; index < 100; index++) {
			if (this.contatos[index] != null) {
				String[] info = this.contatos[index].getInfo();
				System.out.printf("%d - %s %s%n",index+1,info[0],info[1]);
			}
		}
	}

	/**
	 * Recebe uma posição e um contato. A partir disso, verifica se o contato não é favorito , favorita o contato(CASO NÃO SEJA FAVORITO) e o adiciona na lista de favoritos.
	 * 
	 * @param posicao A posicao do contato (para ser adicionado na lista de favoritos).
	 * @param contato O contato a ser favoritado.
	 */
	public void favoritar(int posicao,int contato) {
		boolean isFavorito = false;
		for (int index = 0; index < 10; index++) {
			if (this.favoritos[index] == contato) {
				System.out.println("O CONTATO JÁ É FAVORITO!");
				isFavorito = true;
			}
		}
		if (!isFavorito) {
			if (this.favoritos[posicao]  == -1) {
				this.favoritos[posicao] = contato;
				this.contatos[contato].trocarFavorito();
			}else {
				this.contatos[favoritos[posicao]].trocarFavorito();
				this.contatos[contato].trocarFavorito();
				this.favoritos[posicao] = contato;
			}
			System.out.printf("CONTATO FAVORITADO NA POSIÇÃO %d!%n",posicao+1);
		}
		
	}

	/**
	 * Cadastra um contato em uma posição. Um cadastro em uma posição que já existe sobrescreve o anterior. 
	 * @param posicao Posição do contato.
	 * @param nome Nome do contato.
	 * @param sobrenome Sobrenome do contato.
	 * @param telefone Telefone do contato.
	 */
	public void cadastraContato(int posicao, String nome, String sobrenome, String telefone, boolean checked) {
		boolean isCadastred = false;
		if (!checked) {
			isCadastred = checkIsCadastred(nome, sobrenome);	
		}
		if (!isCadastred) {
			this.contatos[posicao - 1] = new Contato(nome, sobrenome, telefone);
		}
		
	}

	/**
	 * Recebe o nome e sobrenome do contato e verifica se o contato já é cadastrado.
	 * 
	 * @param nome O nome do contato.
	 * @param sobrenome O sobrenome do contato.
	 * @param return valor booleano true (CASO O CONTATO SEJA CADASTRADO) e false (CASO CONTRÁRIO).
	 */
	public boolean checkIsCadastred(String nome, String sobrenome) {
		boolean cadastred = false;
		for (int index = 0; index < 100; index++) {
			if (this.contatos[index] != null) {
				String[] info = contatos[index].getInfo();
				if (nome.equals(info[0]) && sobrenome.equals(info[1])) {
					cadastred = true;
				}
			}
		}
		return cadastred;
	}

	/**
	 * Lista todos os contatos marcados como FAVORITOS , retornando uma representação textual deles.
	 * 
	 */
	public void listarFavoritos() {
		boolean temFavoritos = false;
		for (int index = 0; index < 10; index++) {
			if (this.favoritos[index] != -1) {
				temFavoritos = true;
				break;
			}
		} 
		System.out.println("");
		if (temFavoritos) { 
			for (int index = 0; index < 10; index++) {
				if (this.favoritos[index] != -1) {
					String[] info = this.contatos[favoritos[index]].getInfo();
					System.out.printf("%d - %s %s%n",index + 1,info[0],info[1]);
				}
			}
		}else {
			System.out.println("NÃO EXISTE NENHUM CONTATO SALVO COMO FAVORITO!");
		}  
	}

	/**
	 * Recebe uma tag , uma posição e uma lista de contatos . A partir disso , adiciona na lista de tags (POSIÇÃO INFORMADA) a tag informada - em todos os contatos recebidos.
	 * 
	 * @param tag A tag a ser adicionada.
	 * @param posicao A posição em que a tag será adicionada.
	 * @param contatos Array contendo todos os contatos.
	 */
	public void adicionarTag(String tag, int posicao, String[] contatos) {
		for (int index = 0; index < contatos.length; index++) {
			if (this.contatos[Integer.parseInt(contatos[index])-1] != null) {
				this.contatos[Integer.parseInt(contatos[index])-1].adicionarTag(tag, posicao);
			}
		}
	}

	/**
	 * Recebe um Array de contatos e remove todos eles da agenda.
	 * 
	 * @param contato Um Array com todos os contatos a serem removidos.
	 */
	public void removerContato(String[] contato) {
		for (int index = 0; index < contato.length; index++) {
			int num = Integer.parseInt(contato[index]) - 1;
			if (this.contatos[num] != null) {
				for (int i = 0; i < 10; i++) {
					if (this.favoritos[i] == num) {
						this.favoritos[i] = -1;
					}
				}
				this.contatos[num] = null;
			}
		}
	}

	/**
	 * Recebe uma opção (NOME,SOBRENOME ou TAG) e faz uma busca em todos contatos em que o nome , sobrenome ou tag seja igual à palavra e mostra uma representação textual do contato.
	 * 
	 * @param opcao Procurar por (NOME,SOBRENOME ou TAG)
	 * @param word A palavra a ser procurada.
	 */
	public void visualisarPor(String opcao, String word) {
		for (int index = 0; index < 100; index++) {
			if (this.contatos[index] != null) {
				String[] info = this.contatos[index].getInfo();
				if (opcao.equals("N")) {
					if (word.equals(info[0])) {
						System.out.printf("%d - %s %s%n",index+1,info[0],info[1]);
					}
				}else if (opcao.equals("S")) {
					if (word.equals(info[1])) {
						System.out.printf("%d - %s %s%n",index+1,info[0],info[1]);
					}
				}else if (opcao.equals("T")) {	
					boolean isEqual = this.contatos[index].comparaTags(word);
					if (isEqual) {
						System.out.printf("%d - %s %s%n",index+1,info[0],info[1]);
					}
				}
			} 
		}
	}

	/**
	 * Recebe um contato e um novo telefone e modifica o antigo telefone do contato recebido com o novo contato.
	 * 
	 * @param contato O contato para trocar o telefone.
	 * @param telefone O novo telefone.
	 */
	public void editarTelefone(int contato,String telefone) {
		this.contatos[contato].editarTelefone(telefone);
	}

	/**
	 * Recebe um contato , verifica se o contato é favorito e , caso positivo , desfavorita o contato.
	 * 
	 * @param contato O contato.
	 */
	public void removerFavorito(int contato) {
		boolean eraFavorito = false;
		for (int i = 0; i < 10; i++) {
			if (this.favoritos[i] == contato) {
				eraFavorito = true;
				this.contatos[contato].trocarFavorito();
				this.favoritos[i] = -1;
				break;
			}
		}
		if (eraFavorito) {
			System.out.println("Favorito removido!");
		}else {
			System.out.println("O contato não era favorito!");
		}
	}

	/**
	 * Recebe um contato , uma tag e remove a tag do contato.
	 * 
	 * @param contato O contato.
	 * @param tag A tag.
	 */
	public void removerTag(int contato,String tag) {
		this.contatos[contato].removerTag(tag);
	}
}
