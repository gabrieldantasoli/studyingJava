package lp2;

public class Descanso {
	private int descanso = 0;
	private int semana = 0;
	private String stats = "cansado";
	
	public void defineHorasDescanso(int valor) {
		this.descanso = valor;
	}
	
	public void defineNumeroSemanas(int valor) {
		this.semana = valor;
	}
	
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
