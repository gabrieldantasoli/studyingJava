package agenda;

public class Contato {
    private String nome;
    private String sobrenome;
    private String telefone;
    private boolean favorito;
    private String[] tags;

    /**
	 * 
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para capturar qual contato.
	 */
    public Contato(String nome, String sobrenome, String telefone) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.favorito = false;
        this.tags = new String[5];
    }

    /**
	 * 
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para capturar qual contato.
	 */
    public boolean comparaTags(String word) {
        for (int i = 0; i < 5; i++) {
            if (word.equals(this.tags[i])) {
                return true;
            }
        }
        return false;
    }

    /**
	 * Retorna uma array do tipo String contendo o nome e sobrenome do contato.
	 * 
	 * @param return String[] com nome e sobrenome do contato
	 */
    public String[] getInfo() {
        String[] info = {this.nome,this.sobrenome};
        return info;
    }

    /**
	 * Imprime uma representação textual do contato contendo informações como : Um coração (caso o contato seja favorito) , nome , sobrenome , telefone e tags (caso existam) do contato.
	 * 
	 */
    public void showContato() {
        System.out.println("");
        if (this.favorito) {
            System.out.print("\u2764 ");
        }
        System.out.printf("%s %s%n%s%n",this.nome,this.sobrenome,this.telefone);
        boolean temTag = false;
        for (int index = 0; index < 5; index++) {
            if (this.tags[index] != null) {
                temTag = true;
                System.out.printf("%s ",this.tags[index]);
            }
        }
        if (temTag) {
            System.out.println("");
        }
    }

    /**
	 * Muda o estado favorito do contato : true , caso false e vice-versa.
	 * 
	 */
    public void trocarFavorito() {
        this.favorito = this.favorito == true ? false : true;
    }

    /**
	 * Recebe uma tag e uma posição . A partir disso , coloca a tag na lista de tags do contato (na posição informada).
	 * 
	 * @param tag A tag.
	 * @param posição A posição.
	 */
    public void adicionarTag(String tag, int posicao) {
        this.tags[posicao-1] = tag;
    }

    /**
	 * Recebe um TELEFONE e reescreve o atributo telefone com o TELEFONE recebido.
	 * 
	 * @param TELEFONE O novo telefone do contato.
	 */
    public void editarTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
	 * Recebe uma tag , faz uma busca em todas as tags do contato e remove a tag informada(CASO EXISTA). 
	 * 
	 * @param tag A tag.
	 */
    public void removerTag(String tag) {
        boolean temTag = false;
        for (int index = 0; index < 5; index++) {
            if (this.tags[index] != null) {
                if (this.tags[index].equals(tag)) {
                    temTag = true;
                    this.tags[index] = null;
                    break;
                }
            }
        }
        if (temTag) {
            System.out.println("Tag Removida!");
        }else {
            System.out.println("Tag Não Encontrada!");
        }
    }
}
