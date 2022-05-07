import java.util.Scanner;

public class input{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        float n1 , n2 , n3 ,n4 , n5 , soma;
        final int MIN = 60;
        
        System.out.print("Enter your name : ");
        String name = input.nextLine();
        
        System.out.print("Enter your first result : ");
        n1 = input.nextFloat();
        System.out.print("Enter your second result : ");
        n2 = input.nextFloat(); 
        System.out.print("Enter your third result : ");
        n3 = input.nextFloat();
        System.out.print("Enter your fourth result : ");
        n4 = input.nextFloat();
        System.out.print("Enter yout fifth result : ");
        n5 = input.nextFloat();
        
        soma = (n1 + n2 + n3 + n4 + n5) / 5;
        if (soma >= MIN){
            System.out.println("Student " + name + " APROVED!");
        }else{
            System.out.println("Student " + name + " REPROVED!");
        }
        input.close();
    }
}