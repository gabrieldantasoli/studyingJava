public class conditions{
    public static void main(String[] args){
        String res;
        int N = 55 , M = 50;
        
        res = (N >= M ? "Aproved" : "Reproved");
        
        System.out.println(res);
        
        
        // == > < >= <= != ! (true/false)
        int x = 1;
        if (x == 1){
            System.out.println("I am unstopable Today !");
        }else if (x == 2){
            System.out.println("I am stopable Today !");
        }else{
            System.out.println("I dont know how i am Today !");
        }
        
        int pos = 2;
        
        switch (pos){
            case 1:
                System.out.println("Fisrt!");
                break;
            case 2:
                System.out.println("Second!");
                break;
            case 3:
                System.out.println("Third!");
                break;
            case 4: case 5: case 6:
                System.out.println("Consolation!");
                break;
            default:
                System.out.println("Sorry!");
        }
    }
}