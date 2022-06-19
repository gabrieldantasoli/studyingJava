package bordados.src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bordados bordados = new Bordados();
        System.out.println("Bem-vindo ao BEP!");
        Scanner inputs = new Scanner(System.in);
        String escolha = "";
        
        while (true) {
            System.out.printf("\nVoce pode cadastrar %d bordados. O que deseja fazer?%n",bordados.getCadastrosRestantes());
            escolha = menu(inputs);
            comando(escolha,inputs,bordados);
        }
    }

    private static String menu(Scanner scanner) {
        System.out.print("A - Cadastrar bordado\n" +
                         "B - Atualizar bordado\n" +
                         "C - Imprimir bordado\n" +
                         "D - Listar bordados\n" +
                         "E - Alterar tamanho do bordado\n" +
                         "F - Cadastrar coletanea\n" +
                         "G - Imprimir coletanea\n" +
                         "Acao? ");
        return scanner.next().toUpperCase();
    }

    private static void comando(String escolha,Scanner scanner,Bordados bordados) {
        switch (escolha) {
            case "A":
                boolean cadastrado = cadastrarBordado(scanner,bordados);
                if (!cadastrado) {
                    System.out.println("ERRO!");
                }
                break;
            case "B":
                boolean dadosok = atualizarBordado(scanner,bordados);
                if (!dadosok) {
                    System.out.println("ERRO!");
                }
                break;
            case "C":
                imprimirBordado(scanner,bordados);
                break;
            case "D":
                bordados.listarBordados();
                break;
            case "E":
                boolean ok = alteraTamanhoBordado(scanner,bordados);
                if (!ok) {
                    System.out.println("ERRO!");
                }
                break;
            case "F":
                boolean rigth = cadastraEmColetania(scanner,bordados);
                if (!rigth) {
                    System.out.println("ERRO!");
                }
                break;
            case "G":
                boolean impresso = imprimirColetania(scanner,bordados);
                if (!impresso) {
                    System.out.println("ERRO!");
                }
                break;
            default:
                System.out.println("ERRO!");
        }
    }

    private static boolean cadastrarBordado(Scanner scanner,Bordados bordados) {
        System.out.println("Numero do bordado? [0-9] ");
        int posicao = scanner.nextInt();
        if (!(posicao >= 0 && posicao <= 9)) {
            return false;
        }
        System.out.println("Numero de linhas? [2-100] ");
        int linhas = scanner.nextInt();
        if (!(linhas >=2 && linhas <= 100)) {
            return false;
        }
        System.out.println("Numero de colunas [2-100] ");
        int colunas = scanner.nextInt();
        if (!(colunas >= 2 && colunas <= 100)) {
            return false;
        }
        bordados.cadastrarBordados(posicao, linhas, colunas);
        return true;
    }

    public static boolean atualizarBordado(Scanner scanner,Bordados bordados) {
        System.out.println("Numero do bordado? [0-9] ");
        int numeroBordado = scanner.nextInt();
        if (!(numeroBordado >= 0 && numeroBordado <= 9)) {
            return false;
        }
        System.out.print("No a ser colocado no bordado? [/ \\ | - x, vazio para remover] ");
        String simbolo = scanner.next();
        if (!(simbolo.equals("/") || simbolo.equals("\\") || simbolo.equals("|") || simbolo.equals("-") || simbolo.equals("x"))){
            return false;
        }
        int[] linhasColunas = bordados.getInfo(numeroBordado);
        System.out.printf("Linha a ser inserida? [1-%d] ",linhasColunas[0]);
        int linha = scanner.nextInt();
        if (!(linha >= 1 && linha <= linhasColunas[0])) {
            return false;
        }
        System.out.printf("Coluna a ser inserida? [1-%d] ",linhasColunas[1]);
        int coluna = scanner.nextInt();
        if (!(coluna >= 1 && coluna <= linhasColunas[1])) {
            return false;
        }
        bordados.atualizarBordado(numeroBordado, linha - 1, coluna - 1, simbolo);
        return true;
    }

    public static void imprimirBordado(Scanner scanner,Bordados bordados) {
        System.out.println("Bordado a ser impresso? ");
        int position = scanner.nextInt();
        if (position >= 0 && position <= 9) {
            bordados.imprimirBordado(position);
        }else {
            System.out.println("ERRO!");
        }
    }

    public static boolean alteraTamanhoBordado(Scanner scanner,Bordados bordados) {
        System.out.println("Numero do bordado? [0-9] ");
        int posicao = scanner.nextInt();
        if (!(posicao >= 0 && posicao <= 9)) {
            return false;
        }
        System.out.println("Numero de linhas? [2-100] ");
        int linhas = scanner.nextInt();
        if (!(linhas >=2 && linhas <= 100)) {
            return false;
        }
        System.out.println("Numero de colunas [2-100] ");
        int colunas = scanner.nextInt();
        if (!(colunas >= 2 && colunas <= 100)) {
            return false;
        }
        boolean ok = bordados.alteraTamanhoBordado(posicao,linhas,colunas);
        if (!ok) {
            return false;
        }
        return true;
    }

    public static boolean cadastraEmColetania(Scanner scanner,Bordados bordados) {
        System.out.print("Numero da coletanea? [1-10] ");
        int numero = scanner.nextInt();
        if (!(numero >= 1 && numero <= 10)) {
            return false;
        }
        System.out.print("Total de bordados a serem inseridos? ");
        int total = scanner.nextInt();
        int[] index = new int[total];
        for (int a = 0; a < total; a++) {
            System.out.printf("%d Bordado a ser inserido? ",a+1);
            int num = scanner.nextInt();
            index[a] = num;
        }
        bordados.cadastrarBordadosEmColetania(numero,total,index);
        return true;
    }

    public static boolean imprimirColetania(Scanner scanner,Bordados bordados) {
        System.out.print("Numero da coletanea? ");
        int numero = scanner.nextInt();
        if (!(numero >= 1 && numero <= 10)) {
            return false;
        }
        bordados.mostrarColetania(numero);
        return true;
    }
}
