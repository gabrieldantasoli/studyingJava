import java.util.Scanner;

public class yest{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int result = 0;
        final int SIZE = 5;
        int pontPq = 100 / SIZE;
        char[] answer = {'a','a','c','d','b'};
        char[] studentAnswers = new char[SIZE];
        
        for (int index = 0; index < SIZE; index += 1){
            studentAnswers[index] = input.next().charAt(0);
        }
        
        
        for (int index = 0; index < SIZE; index += 1){
            System.out.println(answer[index] + " " + studentAnswers[index]);
            if (answer[index] == studentAnswers[index]){
                result += pontPq;
            }
        }
        
        System.out.print("Result = " + result + " .");
        input.close();
        
    }
}