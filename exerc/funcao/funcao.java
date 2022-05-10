import java.util.Scanner;

public class funcao{
	public static void main(String[] args){
		Scanner keyboard = new Scanner(System.in);
		int n1 , n2 , n3 , n4;
		n1 = keyboard.nextInt();
		n2 = keyboard.nextInt();
		n3 = keyboard.nextInt();
		n4 = keyboard.nextInt();

		if (n1 < n2 && n2 < n3 && n3 < n4){
			System.out.println("POSSIVELMENTE ESTRITAMENTE CRESCENTE");
		}else if (n1 > n2 && n2 > n3 && n3 > n4){
			System.out.println("POSSIVELMENTE ESTRITAMENTE DECRESCENTE");
		}else{
			System.out.println("FUNCAO NAO ESTRITAMENTE CRES/DECR");
		}
	}
}
