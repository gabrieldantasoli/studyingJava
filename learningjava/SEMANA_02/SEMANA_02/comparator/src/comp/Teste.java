package comp;

import java.util.Comparator;

import java.util.ArrayList;

public class Teste {
    public static void main(String[] args) {
        Produto p1 = new Produto(20);
        Produto p2 = new Produto(12);
        Produto p3 = new Produto(20);

        ArrayList<Produto> produtos = new ArrayList<Produto>();
        produtos.add(p3);
        produtos.add(p2);
        produtos.add(p1);

        Comparator<Produto> c = new Comparator<Produto>() {
            @Override
            public int compare(Produto o1 , Produto o2) {
                return o1.getPrice() - o2.getPrice();
            }
        };

        produtos.sort(c);

        for (Produto p : produtos){
            System.out.println(p.getPrice());
        }
    }
}
