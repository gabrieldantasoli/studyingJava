import java.util.Scanner;

public class greater{
    public static void main(String[] args){
        Scanner inputs = new Scanner(System.in);
        String numbers = inputs.nextLine();
        
        float sum = 0;
        int len = numbers.split(" ").length;
        
        for (String number:numbers.split(" ")){
            sum += Integer.parseInt(number);
        }
        
        sum /= len;
        
        for (String number:numbers.split(" ")){
            if (Integer.parseInt(number) > sum){
                System.out.print(number + " ");
            }
        }
        inputs.close();
    }
}
