package lp2;

public class Disciplina {
	private double nota1;
	private double nota2; 
	private double nota3; 
	private double nota4; 
	private double media;
	private int horas = 0;
	private String disciplina;
	
	public Disciplina(String nomeDisciplina) {
		this.disciplina = nomeDisciplina;
	}
	public void cadastraHoras(int horas) {
		this.horas += horas;
	}
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
	public boolean aprovado( ) {
		double media = (this.nota1 + this.nota2 + this.nota3 + this.nota4)/4;
		this.media = media;
		if (media >= 7) {
			return true;
		}else {
			return false;
		}
	}
	public String toString( ) {
		return this.disciplina + " " + this.horas + " " + this.media + " " + "[" + this.nota1 + ", " + this.nota2 + ", " + this.nota3 + ", " + this.nota4 + "]";
	}
}
