package lp2;

/*
 * A classe Disciplina é responsável por armazenar o nome da disciplina , a quantidade de horas de estudo e as $ notas do estudante (AS NOTAS PODEM SER SOBREESCRITAS) . A classe calcula a média do estuante e retorna true se o estudante for APROVADO e false , csao REPROVADO .
 */
public class Disciplina {
	private double nota1;
	private double nota2; 
	private double nota3; 
	private double nota4; 
	private double media;
	private int horas = 0;
	private String disciplina;
	/*
	 * O método Disciplina armazena o nome da disciplina . 
	 * @param nomeDaDisciplina
	 */
	public Disciplina(String nomeDisciplina) {
		this.disciplina = nomeDisciplina;
	}
	/*
	 * O método cadastraHoras adiciona horas de estudo do estudante .
	 * @param horasDeDedicação
	 */
	public void cadastraHoras(int horas) {
		this.horas += horas;
	}
	/*
	 * O método cadastra nota é responsável por cadastrar as notas do estudande.
	 * Para isso , são necessário dois parametros : O número da prova e o valor da nota da prova.
	 * Número da prova:
	 * 1 - PROVA 1
	 * 2 - PROVA 2
	 * 3 - PROVA 3
	 * 4 - PROVA 4
	 * Nota da prova : Um valor de 0 até 10.
	 * 
	 * @param numeroDaProva
	 * @param notaDaProva
	 */
	public void cadastraNota(int nota, double valorNota) {
		switch (nota) {
			case 1:
				this.nota1 = valorNota;
				break;
			case 2:
				this.nota2 = valorNota;
				break;
			case 3:
				this.nota3 = valorNota;
				break;
			case 4:
				this.nota4 = valorNota;
				break;
		}
	}
	/*
	 * O método aprovado calcula a média das 4 notas passadas e se a média for maior ou igual a 7 : retorna true. Caso contrário , retorna false.
	 */
	public boolean aprovado() {
		double media = (this.nota1 + this.nota2 + this.nota3 + this.nota4)/4;
		this.media = media;
		if (media >= 7) {
			return true;
		}else {
			return false;
		}
	}
	/*
	 * O método toString retorna uma string com o nome da disciplina , O total de horas de estudo , A média e as 4 notas do estudante.
	 */
	public String toString( ) {
		return this.disciplina + " " + this.horas + " " + this.media + " " + "[" + this.nota1 + ", " + this.nota2 + ", " + this.nota3 + ", " + this.nota4 + "]";
	}
}
