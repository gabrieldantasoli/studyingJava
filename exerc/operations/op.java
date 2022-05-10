/*
 * Laboratório de Programação 2 - Lab 1
 * 
 * Gabriel Dantas de Oliveira - 121110669
*/

import java.util.Scanner;

public class op{
 public static void main(String[] args){
		Scanner inputs = new Scanner(System.in);
		String operation = inputs.nextLine();

  if (operation.equals("+") || operation.equals("-") || operation.equals("*") || operation.equals("/")){
			float n1 , n2;
	  		n1 = inputs.nextFloat();
			n2 = inputs.nextFloat();
			if (n2 == 0){
				System.out.println("ERRO");
			}else{
				makeOperation(n1,n2,operation);
			}
		}else{
			System.out.println("ENTRADA INVALIDA");
		}
  		inputs.close();
	}
	public static void makeOperation(float n1 , float n2 , String operation){
		float result = 0;
		if (operation.equals("+")){
			result = n1 + n2;
		}else if (operation.equals("-")){
			result = n1 - n2;
		}else if (operation.equals("*")){
			result = n1 * n2;
		}else if (operation.equals("/")){
			result = n1 / n2;
		}
		System.out.printf("RESULTADO: %.1f%n",result);
	}
}
