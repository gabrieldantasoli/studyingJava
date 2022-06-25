package agenda;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthLookAndFeel;
import javax.swing.text.Position;

/**
 * Interface com menus texto para manipular uma agenda de contatos.
 * 
 * @author nazarenoandrade
 *
 */
public class MainAgenda {
	/*
	 * Gerencia o menu e carrega a agenda inicial.
	 */
	public static void main(String[] args) {
		Agenda agenda = new Agenda();

		System.out.println("Carregando agenda inicial");
		try {
			/*
			 * Essa é a maneira de lidar com possíveis erros por falta do arquivo. 
			 */
			carregaAgenda("agenda_inicial.csv", agenda);
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo não encontrado: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Erro lendo arquivo: " + e.getMessage());
		}

		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha, agenda, scanner);
		}

	}

	/**
	 * Exibe o menu e captura a escolha do/a usuário/a.
	 * 
	 * @param scanner Para captura da opção do usuário.
	 * @return O comando escolhido.
	 */
	private static String menu(Scanner scanner) {
		System.out.print(
				"\n---\nMENU\n" + 
						"(V)isualizar Por\n" +
						"(C)adastrar Contato\n" + 
						"(M)udar Telefone\n" +
						"(L)istar Contatos\n" + 
						"(E)xibir Contato\n" + 
						"(F)avoritos\n" + 
						"(A)dicionar Favorito\n" +
						"(Z)remover Favorito\n" +
						"(T)ags\n" +
						"(P)apagar Tag\n" +
						"(R)emover Contato\n" + 
						"(S)air\n" + 
						"\n" + 
						"Opção> ");
		return scanner.next().toUpperCase();
	}

	/**
	 * Interpreta a opção escolhida por quem está usando o sistema.
	 * 
	 * @param opcao   Opção digitada.
	 * @param agenda  A agenda que estamos manipulando.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 */
	private static void comando(String opcao, Agenda agenda, Scanner scanner) {
		switch (opcao) {
		case "V":
			visualisarPor(scanner,agenda);
			break;
		case "C":
			cadastraContato(agenda, scanner);
			break;
		case "M":
			editarTelefone(agenda,scanner);
			break;
		case "L":
			listaContatos(agenda);  
			break;
		case "E":
			exibeContato(agenda, scanner);
			break;
		case "F":
			agenda.listarFavoritos();
			break;
		case "A":
			adicionarFavorito(scanner,agenda);
			break;
		case "Z":
			removerFavorito(agenda,scanner);
			break;
		case "S":
			sai();
			break;
		case "T" : 
			adicionarTag(scanner ,agenda);     
			break;
		case "P":
			apagarTag(scanner,agenda);
			break;
		case "R":
			removerContato(scanner,agenda);
			break;
		default: 
			System.out.println("OPÇÃO INVÁLIDA!");
		}
	}

	/**
	 * Imprime lista de contatos da agenda.
	 * 
	 * @param agenda A agenda sendo manipulada.
	 */
	private static void listaContatos(Agenda agenda) {
		System.out.println("\nLista de contatos: ");
		agenda.listarContatos();
	}

	/**
	 * Imprime os detalhes de um dos contatos da agenda. 
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para capturar qual contato.
	 */
	private static boolean exibeContato(Agenda agenda, Scanner scanner) {
		System.out.print("Qual contato> ");
		int posicao = scanner.nextInt();
		if (!(posicao >= 1 && posicao <= 100)) {
			System.out.println("POSIÇÃO INVÁLIDA!");
			return false;
		}
		agenda.showContato(posicao);
		
		return true;
	}

	/**
	 * Cadastra um contato na agenda. 
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para pedir informações do contato.
	 */
	private static boolean cadastraContato(Agenda agenda, Scanner scanner) {
		System.out.print("\nPosição na agenda> ");
		int posicao = readNumber(scanner);
		if (!(posicao >= 1 && posicao <= 100)) {
			System.out.println("POSIÇÃO INVÁLIDA!");
			return false;
		}
		System.out.print("\nNome> ");
		String nome = scanner.nextLine();
		nome = nome.trim();
		if (nome.trim().equals("") || nome == null) {
			System.out.println("CONTATO INVALIDO!");
			return false;
		}
		System.out.print("\nSobrenome> ");
		String sobrenome = scanner.nextLine();  
		sobrenome = sobrenome.trim();
		if (sobrenome.equals("") || sobrenome == null) {
			System.out.println("CONTATO INVALIDO!");
			return false;
		}
		boolean isCadastred = agenda.checkIsCadastred(nome,sobrenome);
		if (!isCadastred) {
			System.out.print("\nTelefone> ");
			String telefone = scanner.nextLine().trim();
			if (telefone.equals("") || telefone == null) {
				System.out.println("CONTATO INVALIDO!");
				return false;
			}
			agenda.cadastraContato(posicao, nome, sobrenome, telefone,true);
			System.out.println("CADASTRO REALIZADO!");
		}else {
			System.out.println("CONTATO JA CADASTRADO!");
		}
		
		return true;
	}

	/**
	 * Sai da aplicação.
	 */
	private static void sai() {
		System.out.println("\nVlw flw o/");
		System.exit(0);
	}

	/**
	 * Lê uma agenda de um arquivo csv. 
	 * 
	 * @param arquivoContatos O caminho para o arquivo.
	 * @param agenda A agenda que deve ser populada com os dados. 
	 * @throws IOException Caso o arquivo não exista ou não possa ser lido.
	 */
	private static void carregaAgenda(String arquivoContatos, Agenda agenda) throws FileNotFoundException, IOException {
		LeitorDeAgenda leitor = new LeitorDeAgenda();
		
		int carregados =  leitor.carregaContatos(arquivoContatos, agenda);
		System.out.println("Carregamos " + carregados + " registros.");
	}

	/**
	 * Lê um número e retorna o numero
	 * 
	 * @param scanner Scanner para ler o número.
	 * @param return o número lido
	 */
	private static int readNumber(Scanner scanner) {
		int number = scanner.nextInt();
		scanner.nextLine();
		return number;
	}

	/**
	 * Lê um contato e uma posição para adicionar como favorito.
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para para ler o contao e posição.
	 * @return valor booleano true caso o contato seja adicionado como favorito e false caso contrário
	 */
	private static boolean adicionarFavorito(Scanner scanner,Agenda agenda) {
		System.out.print("Contato> ");
		int contato = scanner.nextInt();
		if (!(contato >= 1 && contato <= 100)) {
			System.out.println("CONTATO INEXISTENTE!");
			return false;
		}
		boolean isCadastred = agenda.getContato(contato-1);
		if (isCadastred) {
			System.out.print("Posicao> ");
			int posicao = scanner.nextInt();
			if (!(posicao >= 1 && posicao <= 10)) {
				System.out.println("POSIÇÃO INVÁLIDA!");
				return false;
			}
			agenda.favoritar(posicao-1, contato-1);
		}else {
			System.out.println("CONTATO NÃO CADASTRADO!");		
			return false;
		}
		return true;
	}
	  
	/**
	 * Lê uma série de contatos(SEPARADOS POR ESPAÇO) , uma TAG e uma posição para a tag . Adiciona uma tag à lista de tags de um objeto Contato.
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para capturar os contatos , tag e posição dessa tag.
	 */
    private static boolean adicionarTag(Scanner scanner,Agenda agenda) {
		scanner.nextLine();  
		System.out.print("Contato(s)> ");                     
		String cont = scanner.nextLine(); 
		if (cont.trim().equals("") || cont == null) {
			System.out.println("CONTATOS INVÁLIDOS!");                            
			return false;
		}
		String[] contatos = cont.split(" ");
		for (int index = 0; index < contatos.length; index++) {
			int num = Integer.parseInt(contatos[index]);
			if (!(num >= 1 && num <= 100)) {
				System.out.println("EXISTE(M) CONTATO(S) INVÁLIDO(S) NA LISTA!");
				return false;
			}
		}
		System.out.print("Tag> ");
		String tag = scanner.nextLine();
		if (tag.trim().equals("") || tag == null) {
			System.out.println("TAG INVÁLIDA!");
			return false; 
		}
		System.out.print("Posicao tag> ");
		int posicaoTag = scanner.nextInt();
		if (!(posicaoTag >= 1 && posicaoTag <= 5)) {
			System.out.println("POSIÇÃO INVÁLIDA!");
			return false;
		}
		agenda.adicionarTag(tag, posicaoTag, contatos);

		return true;
	}  
	
	/**
	 * Lê um contato e remove esse contato da agenda , caso ele exista.
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para capturar qual o contato.
	 * @return valor booleano true caso o contato seja removido e falso caso contrátio.
	 */
	private static boolean removerContato(Scanner scanner, Agenda agenda) {
		System.out.print("Contato(s)> ");
		scanner.nextLine();
		String cont = scanner.nextLine();
		String[] contato = cont.split(" ");
		for (int index = 0; index < contato.length; index++) {
			int num = Integer.parseInt(contato[index]);
			if (!(num >= 1 && num <= 100)) {
				System.out.println("EXISTE(M) POSIÇÃO(ÕES) INVÁLIDA(S)!");
				return false;
			}
		}
		agenda.removerContato(contato);
		return true;
	}

	/**
	 * Lê uma opção (NOME , SOBRENOME OU TAG) , lê uma palavra e faz uma busca na agenda por contato que satisfaçam as condições estabelecidas.
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para capturar qual opção e qual palavra.
	 */
	private static void visualisarPor(Scanner scanner, Agenda agenda) {
		System.out.print("--VISUALIZAR CONTATOS POR :\n" +
						 "(N)ome\n" +
						 "(S)obrenome\n" +
						 "(T)ag\n" +
						 "\nOpcao> ");
		String opcao = scanner.next().toUpperCase();
		if (opcao.equals("N") || opcao.equals("S") || opcao.equals("T")) {
			System.out.print("Digite a palavra : ");
			String palavra = scanner.next();
			System.out.println("");
			agenda.visualisarPor(opcao,palavra);
		}else {	
			System.out.println("OPÇÃO INVÁLIDA!");
		}
	}

	/**
	 * Lê um contato e um telefone. A partir disso , edita o telefone do contato , reescrevendo seu valor.
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para capturar qual contato e telefone.
	 * @return valor booleano true caso o contato seja editado e false caso contrário.
	 */
	private static boolean editarTelefone(Agenda agenda, Scanner scanner) {
		System.out.print("EDITAR TELEFONE DE QUAL CONTATO : ");
		int contato = scanner.nextInt();
		if (!(contato >= 1 && contato <= 100)) {
			System.out.println("POSIÇÃO INVÁLIDA!");
			return false;
		}
		scanner.nextLine();
		System.out.print("DIGITE O NOVO TELEFONE : ");
		String telefone = scanner.nextLine().trim();
		if (telefone.equals("") || telefone == null) {
			System.out.println("CONTATO INVALIDO!");
			return false;
		}
		agenda.editarTelefone(contato-1,telefone);
		return true;
	}

	/**
	 * Lê um contato e desfavorita esse contato , caso seja favorito.
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para capturar qual contato.
	 * @return valor booleano true , caso o contato seja desfavoritado e false , caso contrário.
	 */
	private static boolean removerFavorito(Agenda agenda, Scanner scanner) {
		System.out.print("DE QUAL CONTATO DESEJA DESFAVORITAR ? ");
		int contato = scanner.nextInt();
		if (!(contato >= 1 && contato <= 100)) {
			System.out.println("POSIÇÃO INVÁLIDA!");
			return false;
		}
		agenda.removerFavorito(contato-1);
		return true;
	}
 
	/**
	 * Lê um contato e uma tag . A partir disso , remove a tag , caso ela exista.
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para capturar qual contato e tag.
	 */
	private static boolean apagarTag(Scanner scanner,Agenda agenda) {
		System.out.print("REMOVER TAG DE QUAL CONTATO ? ");
		int contato = scanner.nextInt();
		scanner.nextLine();
		if (!(contato >= 1 && contato <= 100)) {
			System.out.println("POSIÇÃO INVÁLIDA!");
			return false;
		}
		System.out.print("DIGITE O NOME DA TAG : ");
		String tag = scanner.nextLine().trim();
		if (tag.equals("") || tag == null) {
			System.out.println("TAG INVALIDA!");
			return false;
		}
		agenda.removerTag(contato-1,tag);
		return true;
	}
}
