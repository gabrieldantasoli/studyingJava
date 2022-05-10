/*
 * Laboratório de Programação 2 - Lab 1
 * 
 * Gabriel Dantas de Oliveira - MATRICULA
*/

import java.util.Scanner;

public class media{
	public static void main(String[] args){
		Scanner keyboard = new Scanner(System.in);
		float number1 = keyboard.nextFloat();
		float number2 = keyboard.nextFloat();

		float media = (number1 + number2) / 2;

		if (media >= 7){
			System.out.println("pass: True!");
		}else{
			System.out.println("pass: False!");
		}
	}
}	
