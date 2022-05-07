import java.util.Scanner;

public class loops{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int a , b , c , what;
        System.out.print("Enter the Counting Starts : ");
        a = input.nextInt();
        System.out.print("Enter the Counting Ends : ");
        b = input.nextInt();
        System.out.print("Enter the Counting Steps : ");
        c = input.nextInt();
        System.out.printf("What loop do you want to use ? %n1 = for%n2 = while%n3 = do while%nLOOP : ");
        what = input.nextInt();      
        
        if (what == 1){
            loopFor(a,b,c);
        }else if (what == 2){
            loopWhile(a,b,c);
        }else{
            loopDoWhile(a,b,c);
        }
        input.close();
    }
    public static void loopFor(int a,int b,int c){
        System.out.println("Counting from " + a + " to " + b + " with steps =" + c + ".");
        if (b > a && c > 0){
            for (int index = a; index <= b;index += c){
                System.out.println(index);
            }
        }else if (a > b && c < 0){
            for (int index = a; index >= b;index += c){
                System.out.println(index);
            }
        }else if (a == b){
            System.out.println("The initial and final numbers are the same. Please , try again !");
        }else{
            System.out.println("Data isn't correct. Try again!");
        }
    }
    public static void loopWhile(int a , int b, int c){
        System.out.println("Counting from " + a + " to " + b + " with steps =" + c + ".");
        if (b > a && c > 0){
            while (a <= b){
                System.out.println(a);
                a += c;
            }
        }else if (a > b && c < 0){
            while (a >= b){
                System.out.println(a);
                a += c;
            }
        }else if (a == b){
            System.out.println("The initial and final numbers are the same. Please , try again !");
        }else{
            System.out.println("Data isn't correct. Try again!");
        }
    }
    public static void loopDoWhile(int a, int b, int c){
        System.out.println("Counting from " + a + " to " + b + " with steps =" + c + ".");
        System.out.println("Counting from " + a + " to " + b + " with steps =" + c + ".");
        if (b > a && c > 0){
            do {
                System.out.println(a);
                a += c;
            } while (b >= a);
        }else if (a > b && c < 0){
            do {
                System.out.println(a);
                a += c;
            } while (a >= b);
        }else if (a == b){
            System.out.println("The initial and final numbers are the same. Please , try again !");
        }else{
            System.out.println("Data isn't correct. Try again!");
        }
    }
}
