import java.util.Arrays;
public class Marrays{
    public static void main(String[] args){
        int[] integers = {10,3,4,2,5,1,6,8,7,9};
        int[] integers2 = new int[10];
        int pos ;

        //Arrays.sort(integers);
        //Arrays.fill(integers,10);
        
        //System.out.println(integers.length);
        
        //System.arraycopy(integers,0,integers2,0,10);
        
        //System.out.println("Os arrays " + (Arrays.equals(integers,integers2) ? "" : "NÃO") + " são iguais!");
        
        System.out.println("The element is " + (Arrays.binarySearch(integers,8) >= 0 ? "" : "NOT ") + "In array!");
        //System.out.println(pos);
    }
}