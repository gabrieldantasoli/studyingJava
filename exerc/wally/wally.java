import java.util.Scanner;

public class wally{
    public static void main(String[] args){
        Scanner inputs = new Scanner(System.in);
        String Array;
        while (true){
            String name = "?";
            Array = inputs.nextLine();
            if (Array.equals("wally")){
                break;
            }
            for (int i = 0; i < Array.split(" ").length; i++){
                if (Array.split(" ")[i].length() == 5){
                    name = Array.split(" ")[i];              
                }
            }
            System.out.println(name);
        }
        inputs.close();
    }
}