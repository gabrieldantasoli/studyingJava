import java.security.SecureRandom;
import java.util.Scanner;

public class matriz{
    public static void main(String[] args){
        //int[] integers = new int[10];
        Scanner input = new Scanner(System.in);
        final int rows = input.nextInt();
        final int columns = input.nextInt();
        int[][] matriz = new int[rows][columns];
        input.close();
        
        for (int a = 0; a < rows; a++){
            for (int b = 0; b < columns; b++){
                matriz[a][b] = new SecureRandom().nextInt(100);
            }
        }
        
        /*
        for (int a = 0; a < rows; a ++){
            for (int b = 0; b < columns; b++){
                System.out.printf(" %2d|",matriz[a][b]);
            }
            System.out.printf("%n");
        }
        */
        
        for (int[] a:matriz){
            for (int num:a){
                System.out.printf(" %2d|",num);          
            }
            System.out.println("");
        }
        
    }
}