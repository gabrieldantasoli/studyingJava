package bordados.src;

import java.util.Arrays;

public class Bordado {
    private String[][] pontos;
    private int totalPontos = 0;

    public Bordado(int linhas,int colunas) {
        this.pontos = new String[linhas][colunas];
        for (int a = 0; a < this.pontos.length; a++) {
            Arrays.fill(this.pontos[a]," ");
        }
    }

    public int[] getLinhasColunas(){
        int[] ret = {this.pontos.length,this.pontos[0].length};
        return ret;
    }

    public void atualizaNo(int linha,int coluna,String simbol) {
        this.pontos[linha][coluna] = simbol;
        this.totalPontos += 1;
    }

    public void imprimirBordado() {
        System.out.print("|");
        for (int a = 0; a < this.pontos[0].length; a++) {
        System.out.print("-");
        }
        System.out.printf("|%n");

        for (int a = 0; a < this.pontos.length; a++) {
            System.out.print("|");
            for (int b = 0; b < this.pontos[a].length; b++) {
                System.out.print(this.pontos[a][b]);
            }
            System.out.printf("|%n");
        }
        System.out.print("|");
        for (int a = 0; a < this.pontos[0].length; a++) {
        System.out.print("-");
        }
        System.out.printf("|%n");
    }

    public void listarBordado(int position) {
        System.out.printf("%d - %d x %d - %d pontos%n",position,this.pontos.length,this.pontos[0].length,this.totalPontos);
    }

    public boolean alterarBordado(int linha,int coluna) {
        if (linha < this.pontos.length || coluna < this.pontos[0].length) {
            for (int a = 0; a < this.pontos.length;a++) {
                for (int b = coluna; b < this.pontos[0].length; b++) {
                    if (!this.pontos[a][b].equals(" ")) {
                        return false;
                    }
                }
            }
            for (int a = linha; a < this.pontos.length; a++) {
                for (int b = 0; b < this.pontos[0].length; b++) {
                    if (!this.pontos[a][b].equals(" ")) {
                        return false;
                    }
                }
            }
        }
        String[][] pt = this.pontos;
        this.pontos = new String[linha][coluna];
        for (int a = 0; a < linha; a++) {
            for (int b = 0; b < coluna; b++) {
                try{
                    this.pontos[a][b] = pt[a][b];
                }catch(Exception e) {
                    this.pontos[a][b] = " ";                                    
                }
            }                                  
        }
        
        return true;
    }

    public String[] getBordado(int position) {
        return this.pontos[position];
    }
}
