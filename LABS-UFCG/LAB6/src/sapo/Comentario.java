package sapo;
import java.util.Calendar;

public class Comentario {
	private String descricao;
	private String cpfAutor;
	private String data;
	
	
	public Comentario(String descricao, String cpfAutor) {
		checkAtributo(descricao);
		checkAtributo(cpfAutor);
		this.cpfAutor = cpfAutor;
		this.descricao = descricao;
		Calendar c = Calendar.getInstance();
		this.data += c.get(Calendar.DAY_OF_MONTH) + "/" + c.get(Calendar.MONTH) + "/" + c.get(Calendar.YEAR) + "-" + c.get(Calendar.HOUR) + ":" + c.get(Calendar.MINUTE);
	}
	
	public String[] getInfo() {
		String[] info = {this.descricao,this.cpfAutor,this.data};
		return info;
	}
	
	private boolean checkAtributo(String atributo) {
		if (atributo.trim().equals("")) {
			throw new IllegalArgumentException("O/A " + atributo.toUpperCase() + " não pode ser vazio!");
		}
		
		return true;
	}
}
