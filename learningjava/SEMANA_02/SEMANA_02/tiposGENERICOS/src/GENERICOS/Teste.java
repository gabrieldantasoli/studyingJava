package GENERICOS;

public class Teste {

    
    public static void main(String[] args) {
        MLIMPL<Integer> mli = new MLIMPL<Integer>();
        MLIMPL<String> mls = new MLIMPL<String>();

        mli.add(1);
        mli.add(3);
        mli.remove(1);

        mls.add("gabriel");
        mls.add("lindo");
        mls.remove("lindo");
        System.out.println("ok");
    }
}
