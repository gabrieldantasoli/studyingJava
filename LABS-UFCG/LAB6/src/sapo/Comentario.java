package sapo;

public class Comentario {
	// data do sistema
	private String descricao;
	private String cpfAutor;
	
	
	public Comentario(String descricao, String cpfAutor) {
		this.cpfAutor = cpfAutor;
		this.descricao = descricao;
	}
	
	public String[] getInfo() {
		String[] info = {this.descricao,this.cpfAutor};
		return info;
	}
	
	
}
