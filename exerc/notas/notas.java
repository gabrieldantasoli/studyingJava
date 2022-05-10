import java.util.Scanner;

public class notas{
    public static void main(String[] args){
        Scanner inputs = new Scanner(System.in);
        int bigger = 0 , smalest = 1000 , greater = 0 , less = 0 , sum = 0 , iterations = 0;
        
        while (true){
            String student = inputs.nextLine();
            if (student.equals("-")){
                break;
            }
            int value = Integer.parseInt(student.split(" ")[1]);
            if (value > bigger){
                bigger = value;
            }
	    if (value < smalest){
                smalest = value;
            }
            sum += value;
            iterations += 1;
            if (value >= 700){
                greater += 1;
            }else{
                less += 1;
            }
        }
        
        inputs.close();
        
        float media = sum / iterations;
        System.out.println("maior: " + bigger);
        System.out.println("menor: " +smalest);
        System.out.printf("media: %.0f%n",media);
        System.out.println("acima: " + greater);
        System.out.println("abaixo: " + less);
    }
}
