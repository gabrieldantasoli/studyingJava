package lp2;

/*
 * A classe RegistroTempoOnline é responsável por armazenar a informação sobre quantidade de horas de internet que o aluno tem dedicado a uma disciplina remota. 
 * A classe armazena o tempo online , tempo necessário de dedicacação e o nome da disciplina que o estudante está cursando e , através desses dados , irá determinar se o estudante está se dedicando o suficiente .
 */
public class RegistroTempoOnline {
	private int tempoOnline = 0;
	private int tempo;
	private String disciplina;
	/*
	 * O método RegistroTempoOnline armazena o nome da disciplina e o tempo necessário de dedicação nos atributos privados disciplina e tempo , respectivamente .
	 * @param nomeDaDisciplna
	 * @parem cargaHorária
	 */
	public RegistroTempoOnline(String disciplina,int tempo) {
		this.disciplina = disciplina;
		this.tempo = tempo;
	}
	/*
	 * Caso só seja passado o nome da disciplina , o método RegistroTempoOnline irá armazenar o nome da disciplina e o tempo necessário de dedicação (VALOR PADRÃO DE 60 , MAS COMO É NECESSÁRIO O DOBRO , IRÁ ARMAZENAR 120) nos atributos privados disciplina e tempo , respectivamente .
	 * @param nomeDaDisciplina
	 */
	public RegistroTempoOnline(String disciplina) {
		this.disciplina = disciplina;
		this.tempo = 120;
	}
	/*
	 * O método adicionaTempoOnline adiciona um tempo (TEMPO ONLINE DO ESTUDANTE) no atributo global tempoOnline.
	 * @param tempoOnline
	 */
	public void adicionaTempoOnline(int tempo) {
		this.tempoOnline += tempo;
	}
	/*
	 * O método atingiuMetaTempoOnline irá retornar true se o estudante atingiu a meta (DOBRO DA CARGA HORÁRIA DA DISCIPLINA) e false < caso contrário .
	 */
	public boolean atingiuMetaTempoOnline() {
		if (this.tempoOnline >= this.tempo) {
			return true;
		}else {
			return false;
		}
	}
	/*
	 * O método toString irá retornar uma string contendo o nome da disciplina , o tempo online e o tempo necesário de dedicação à disciplina.
	 */
	public String toString() {
		return this.disciplina + " " + this.tempoOnline + "/" + this.tempo;
	}

}
