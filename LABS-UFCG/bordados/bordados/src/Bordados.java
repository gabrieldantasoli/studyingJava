package bordados.src;

public class Bordados {
    private int podeCadastrar = 10;
    private Coletania coletania;
    private Bordado[] bordados;

    public Bordados() {
        this.bordados = new Bordado[10];
        this.coletania = new Coletania();
    }

    public void cadastrarBordados(int position     ,int linhas,int colunas) {
        bordados[position] = new Bordado(linhas,colunas);
        this.podeCadastrar -= 1;
    }

    public void atualizarBordado(int position,int linha,int coluna,String simbol) {
        this.bordados[position].atualizaNo(linha, coluna, simbol);
    }

    public void imprimirBordado(int position) {
        this.bordados[position].imprimirBordado();                                    
    }                                          

    public void listarBordados() {
        for (int a = 0; a < this.bordados.length; a++) {
            if (this.bordados[a] != null) {
                this.bordados[a].listarBordado(a);
            }
        }                                                    
    }                                                                                                

    public int getCadastrosRestantes() {
        return this.podeCadastrar;
    }

    public int[] getInfo(int position){
        int[] ret = this.bordados[position].getLinhasColunas();
        return ret;
    }

    public boolean alteraTamanhoBordado(int position,int linha,int coluna) {
        boolean ok = bordados[position].alterarBordado(linha,coluna);
        if (!ok){
            return false;
        }
        return true;
    }                                                            
 
    public void cadastrarBordadosEmColetania (int coletanea,int total,int[] index) {
        Bordado[] array = new Bordado[total];
        for (int a = 0; a < total; a++) {
            array[a] = this.bordados[index[a]];
        }
        this.coletania.cadastrarBordado(coletanea, array,total);
    }

    public void mostrarColetania(int numero) {
        this.coletania.mostrarColetania(numero);
    }
}
