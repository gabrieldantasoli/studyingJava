/*
 * Laboratório de Programação 2 - Lab 1
 * 
 * Gabriel Dantas de Oliveira - 121110669
*/

import java.util.Scanner;

public class dt{
	public static void main(String[] args){
		Scanner teclado = new Scanner(System.in);
		int number = teclado.nextInt(); 
		System.out.println("dobro: " + dobro(number) + ", triplo: " + triplo(number));;
	}
	public static int dobro(int a){
		return a * 2;
	}
	public static int triplo(int a){
		return a * 3;
	}
}
