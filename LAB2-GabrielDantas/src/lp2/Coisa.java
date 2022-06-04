package lp2;

/*
 * A classe Coisa é a classe principal do projeto e , através dela , instanciamos objetos e seus métodos . A classe contém métodos usados que , a partir deles , são "chamados" outros métodos pertencentes à outras classe como RegistroTempoOnline , Descanso , Disciplina e AtividadesComplementares.
 *  
 * A classe contém os seguintes métodos : main , descanso , registroOnline , atividadesComplementares e Disciplinas
 * 
 * @author Gabriel Dantas de Oliveira
 * @version 1.0
 */

public class Coisa {    
    /*
     * O método main é o método principal da classe Coisa . Por ele , "chamamos" os demais métodos da classe . 
     */
   public static void main(String[] args) {
       descanso();
       System.out.println("-----");
       registroOnline();
       System.out.println("-----");
       disciplina();
       System.out.println("-----");
       atividadesComplementares();
   }
   /*
    * O método descanso é responsável por instanciar a classe Descanso e , fazendo o uso dos métodos de tal classe , armazena as horas de descanso do estudante e as semanas referentes à esse descanso , com o fim de retornar se o estudante está cansado ou não .
    */
   public static void descanso() {
       Descanso descanso = new Descanso();
       System.out.println(descanso.getStatusGeral());
       descanso.defineHorasDescanso(30);
       descanso.defineNumeroSemanas(1);
       System.out.println(descanso.getStatusGeral());
       descanso.defineHorasDescanso(26);
       descanso.defineNumeroSemanas(2);
       System.out.println(descanso.getStatusGeral());
       descanso.defineHorasDescanso(26);
       descanso.defineNumeroSemanas(1);
       System.out.println(descanso.getStatusGeral());
   }
   /*
    * O método registroOnline é responsável por instanciar a classe RegistroTempoOnline e , a partir dela , usando seus métodos , podemos armazenar o nome da disciplina e adicionar determinado tempo online de dedicação à tal disciplina , para determinar se o estudante está se dedicando o suficiente (duas vezes a carga horária da disciplina).
    */
   private static void registroOnline() {
       RegistroTempoOnline tempoLP2 = new RegistroTempoOnline("LP2", 30);
       tempoLP2.adicionaTempoOnline(10);
       System.out.println(tempoLP2.atingiuMetaTempoOnline());
       tempoLP2.adicionaTempoOnline(10);
       tempoLP2.adicionaTempoOnline(10);
       System.out.println(tempoLP2.atingiuMetaTempoOnline());
       tempoLP2.adicionaTempoOnline(2);
       System.out.println(tempoLP2.atingiuMetaTempoOnline());
       System.out.println(tempoLP2.toString());
       RegistroTempoOnline tempoP2 = new RegistroTempoOnline("P2"); 
       System.out.println(tempoP2.toString());
   }
   /*
    * O método disciplina instancia a classe Disciplina e , "chamando" seus métodos , armazena o nome da disciplina , adiciona horas de estuso (ACUMULATIVAS) , armazena 4 notas (QUE PODEM SER SOBREESCRITAS) e a partir da média aritmética dessas quatro notas , retorna true se tal média for maior ou igual à sete e false , caso contrário.
    *300 horas de estágio = 5 créditos
    *3 meses de projeto = 2 créditos
    *30 horas de curso = 1 crédito
    */
   private static void disciplina() {
       Disciplina prog2 = new Disciplina("PROGRAMACAO 2");
       prog2.cadastraHoras(4);
       prog2.cadastraNota(1, 5.0);
       prog2.cadastraNota(2, 6.0);
       prog2.cadastraNota(3, 7.0);
       System.out.println(prog2.aprovado());
       prog2.cadastraNota(4, 10.0);
       System.out.println(prog2.aprovado());
       System.out.println(prog2.toString());
   }
   /*
    * O método atividadesComplementares instancia a classe AtividadesComplementares e , chamando os métodos de tal classe, pode cadastrar a duração de até 9 estágios , 16 projetos e infinitos cursos. É possível , também , adicionar horas (de estágios e cursos) e meses (de projetos) - TODAS ESSES TEMPOS SÃO ACUMULATIVOS e são necessários para calcular o total de créditos do estudante .
    */
   private static void atividadesComplementares() {
       AtividadesComplementares minhasAtividades = new AtividadesComplementares();
       int horasEstagio = 350;
       int mesesProjeto = 6;
       double horasCurso = 40.5;
       minhasAtividades.adicionarEstagio(horasEstagio);
       minhasAtividades.adicionarProjeto(mesesProjeto);
       minhasAtividades.adicionarCurso(horasCurso);
       String[] atividades = minhasAtividades.pegaAtividades();
       for (int i = 0; i < atividades.length; i++) {
           System.out.println(minhasAtividades.pegaAtividades()[i]);
       }
       System.out.println(minhasAtividades.contaCreditos());
 
       double horasOutroCurso = 49.5;
       int mesesOutroProjeto = 7;
 
       minhasAtividades.adicionarProjeto(mesesOutroProjeto);
       minhasAtividades.adicionarCurso(horasOutroCurso);
      
       atividades = minhasAtividades.pegaAtividades();
       for (int i = 0; i < atividades.length; i++) {
           System.out.println(minhasAtividades.pegaAtividades()[i]);
       }
       System.out.println(minhasAtividades.contaCreditos());
 
   }
}
