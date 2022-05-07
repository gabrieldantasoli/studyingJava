public class Main{
    public static void main(String args[]){
        int a = 10 , b = 20;
        System.out.println(sumdobro(a,b));
        System.out.println(dobro(a)+sumdobro(a,b)+dobro(b));
    }
    public static int dobro(int a){
        return a * 2;
    }
    public static double sumdobro(int a , int b){
        return dobro(a) + dobro(b);
    }
}