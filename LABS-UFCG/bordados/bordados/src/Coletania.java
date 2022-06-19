package bordados.src;

import java.util.Arrays;

public class Coletania {
    private Bordado[][] coletaniasDeBordados;
    private int[] totalBordadosPorColetania;
    private int[] pontosPorColetania;

    public Coletania() {
        this.coletaniasDeBordados = new Bordado[10][100];
        this.totalBordadosPorColetania = new int[10];
        this.pontosPorColetania = new int[10];
        Arrays.fill(totalBordadosPorColetania, 0);
        Arrays.fill(pontosPorColetania, 0);
    }

    public void cadastrarBordado(int coletanea,Bordado[] bordados,int total) {
        for (int a = 0; a < total; a++) {
            this.coletaniasDeBordados[coletanea-1][totalBordadosPorColetania[coletanea-1]] = bordados[a];
            this.totalBordadosPorColetania[coletanea-1] += 1;
        }
    }

    public void mostrarColetania(int numero) {
        Bordado[] coletania = coletaniasDeBordados[numero-1];
        for (int i = 0; i < totalBordadosPorColetania[numero-1]; i++) {
            System.out.printf("Bordado %d%n",i+1);
            coletania[i].imprimirBordado();
        }
        
    }    
}
