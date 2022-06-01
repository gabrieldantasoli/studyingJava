package lp2;

public class AtividadesComplementares{
	private int horasEstagios = 0;
	private int mesesProjetos = 0;
	private double horasCursos = 0;
	private int index;
	private String[] atividades;
	//9 estafios e 16 projetos
	
	public AtividadesComplementares() {
		this.index = 0;
		this.horasEstagios = 0;
		this.mesesProjetos = 0;
		this.horasCursos = 0;
		this.atividades = new String[1000];
	}
	public void adicionarEstagio(int horas) {
		this.horasEstagios += horas;
		String estagio =  "Estagio " + horas;
		
	}
	public void adicionarProjeto(int meses) {
		this.mesesProjetos += meses;
		String projeto = "Projeto " + meses;
	}
	public void adicionarCurso(double horas) {
		this.horasCursos += horas;
		String curso = "Cursos " + horas;
		
	}
	public int contaCreditos() {
		int contaCreditos = 0;
		int creditosEstagios = (this.horasEstagios / 300) * 5;
		int creditosProjetos = (this.mesesProjetos / 3) * 2;
		int creditosCursos = (int) (this.horasCursos / 30) ;
		contaCreditos = creditosEstagios + creditosProjetos + creditosCursos;
		return contaCreditos;
	}
	public String[] pegaAtividades() {
		//estagios e horas . 
		// projetos e meses total horas
		//total estagios  . projetos . cursos
		return this.atividades;
		
	}

}
