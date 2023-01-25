package comp;

public class Produto implements Comparable<Produto>{
    int price;
    double width;
    double height;

    public Produto(int price) {
        this.price = price;
        this.width = 22;
        this.height = 100;
    }

    public void show() {
        System.out.println(this.price + "  " + this.width);
    }

    public int getPrice() {
        return this.price;
    }

    @Override
    public int compareTo(Produto o ){
        if (this.price > o.price) {
            return 1;
        }else if (this.price == o.price) {
            return 0;
        }
        return -1;
    }
}