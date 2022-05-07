import java.util.Scanner;

public class arrays{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int[] numbers = new int[size];
        
        for (int index = 0; index < size; index++){
            numbers[index] = sqrt(index,2);
            System.out.println(numbers[index]);
        }
        input.close();
    }
    public static int sqrt(int a , int b){
        for (int index = 1; index < b;index += 1){
            a *= a;
        }
        return a;
    }
}