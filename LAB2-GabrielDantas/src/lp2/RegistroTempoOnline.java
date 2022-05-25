package lp2;

public class RegistroTempoOnline {
	private int tempoOnline = 0;
	private int tempo;
	private String disciplina;
	
	public RegistroTempoOnline(String disciplina,int tempo) {
		this.disciplina = disciplina;
		this.tempo = tempo;
	}
	public RegistroTempoOnline(String disciplina) {
		this.disciplina = disciplina;
		this.tempo = 60;
	}
	public void adicionaTempoOnline(int tempo) {
		this.tempoOnline += tempo;
	}
	public boolean atingiuMetaTempoOnline() {
		if (this.tempoOnline >= this.tempo) {
			return true;
		}else {
			return false;
		}
		
	}
	public String toString() {
		return this.disciplina + " " + this.tempoOnline + "/" + this.tempo;
	}

}
