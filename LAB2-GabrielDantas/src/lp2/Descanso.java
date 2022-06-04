package lp2;

/*
 * A classe Descanso é responsável por acompanhar a rotina de descanso do aluno. O aluno deve descansar 26 horas por semana, ou mais, para se considerar descansado . 
 * Isto, sem incluir as horas de sono, mas somente de atividades de lazer em geral.
 * A classe de descanso contém 3 métodos:
 * O método : defineHorasDescanso;
 * O método : defineNumeroSemanas;
 * O método : getStatusGeral;
 */
public class Descanso {
	private int descanso = 0;
	private int semana = 0;
	private String stats = "cansado";
	
	/*
	 * O método defineHorasDescanso reescreve o atributo privado descanso com o valor HorasDeDescanso informado , sendo usado como as horas de descanso do estudante . 
	 * @param HorasDeDescanso 
	 */
	public void defineHorasDescanso(int valor) {
		this.descanso = valor;
	}
	/*
	 * O método defineNumeroSemanas reescreve o atributo privado semana com o valor numeroSemana informado , sendo usado como a semana de descanso do estudante . 
	 * @param numeroSemana
	 */
	public void defineNumeroSemanas(int valor) {
		this.semana = valor;
	}
	/*
	 * o método getStatusGeral checa se o valor dos atributos privados descanso e semana foram modificados e , caso negativo , reatribui o valor do stats (ATRAVÉS DA DIVISÃO ENTRE NUMERO DE HORAS DE DESCANSO E NÚMERO DE SEMANAS) do estudante (CANSADO OU DESCANSADO) e retorna esse stats. Caso positivo , irá retornar o valor inicial do stats do estudante (CANSADO).
	 */
	public String getStatusGeral() {
		if (this.descanso == 0 && this.semana == 0) {
			return this.stats;
		}else {
			if (this.descanso/this.semana >= 26) {
				this.stats = "descansado";
			}else {
				this.stats = "cansado";
			}
			return this.stats;
		}
		
	}
}
