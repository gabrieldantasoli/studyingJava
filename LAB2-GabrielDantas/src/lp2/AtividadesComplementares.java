package lp2;

/*
 * O método AtividadesComplementares é responsável por cadastrar até estágios e até 16 projetos , adicionar horas de estágios , meses de projetos e horas de cursos . Além disso , a classe também é responsável por contar os créditos do aluno e retornar um array do tipo int com todos os estágios , projetos , as horas de curso e os créditos resferentes aos estágios , projetos e cursos .
 */
public class AtividadesComplementares {
	private int[] estagios = {0,0,0,0,0,0,0,0,0};
	private int[] projetos = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	private int horasEstagios;
	private int mesesProjetos;
	private double horasCursos; 
	private int totalEstagios;
	private int totalProjetos;
	/*
	 * O método AtividadesComplementares é responsável por inicializar os atributos privados nnecessários para o funcionamento da classe.
	 */
	public AtividadesComplementares() {
		this.horasEstagios = 0;
		this.mesesProjetos = 0;
		this.horasCursos = 0;
		this.totalEstagios = 0;
		this.totalProjetos = 0;
	}
	/*
	 * O método adicionarEstagio cadastra um novo estágio (SOMENTE SE JÁ FORAM CADASTRADOS MENOS QUE NOVE ESTÁGIOS) e incrementa as horas totais de estágio .
	 * @param numeroDeHoras
	 */
	public void adicionarEstagio(int horas) {
		if (this.totalEstagios < 9) {
			this.horasEstagios += horas;
			this.estagios[this.totalEstagios] = horas;
			this.totalEstagios += 1;
		}
	}
	/*
	 * O método adicionarProjeto cadastra um novo projeto (SOMENTE SE JÁ FORAM CADASTRADOS MENOS QUE 16 PROJETOS) e incrementa as horas totais de projetos . 
	 * @param mesesDeProjetos
	 */
    public void adicionarProjeto(int meses) {
		if (this.totalProjetos < 16) {
			this.mesesProjetos += meses;
			this.projetos[totalProjetos] = meses;
			this.totalProjetos += 1;
		}
	}
	/*
	 * O método adicionarCurso incrementa as horas totais de curso .
	 * @param numeroDeHoras
	 */
    public void adicionarCurso(double horas) {
		this.horasCursos += horas;
	}
	/*
	 * O método contaCreditos calcula e retorna o número total de créditos (COM BASE NAS HORAS DE CURSO E ESTÁGIO E NÚMERO DE MESES).
	 */ 
    public int contaCreditos() { 
		int totalCreditos = (this.horasEstagios / 300) * 5 + (this.mesesProjetos / 3) * 2 + (int)(this.horasCursos / 30);
		return totalCreditos;
	}
	/*
	 * O método pegaAtividades é responsável por criar e retornar um array do tipo String contendo todos os estágios (COM SUAS HORAS DE DURAÇÃO) , os projetos (COM SEUS MESES DE DURAÇÃO) , os cursos (COM SUAS HORAS DE DURAÇÃO) e o número de créditos obtidos a partir dos estágios , cursos e projetos.
	 */
    public String[] pegaAtividades() {
		int totalIndex = 4;
		int index = 0;
		for (int i = 0; i < 9; i++){
			if (this.estagios[i] != 0){
				totalIndex += 1;
			}else{
				break;
			}
		}
		for (int i = 0; i < 16; i++){
			if (this.projetos[i] != 0){
				totalIndex += 1;
			}else{
				break;
			}
		}
		String[] retornoAtividades = new String[totalIndex];
		for (; index < this.totalEstagios; index++) {
			retornoAtividades[index] = "Estagio " + this.estagios[index];
		} 
		for (int i = 0; i < this.totalProjetos; index++ , i++) {
			retornoAtividades[index] = "Projeto " + this.projetos[i];
		}
		retornoAtividades[index] = "Cursos " + this.horasCursos;
		index += 1;
		retornoAtividades[index] = "Creditos_Estagio " + (this.horasEstagios / 300) * 5;
		index += 1;
		retornoAtividades[index] = "Creditos_Projeto " + (this.mesesProjetos / 3) * 2;
		index += 1;
		retornoAtividades[index] = "Creditos_Cursos " + (int)(this.horasCursos / 30);

		return retornoAtividades;
	}

}
