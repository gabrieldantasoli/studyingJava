package objects;
public class team {
    public static void main(String[] args) {

        int num = 1;
        Player p1 = new Player(num++);
        Player p2 = new Player(num++);
        Player p3 = new Player(num++);

        /*
        p1.number = 100;
        p2.number = 50;

        p1.life = 50;
        p2.life = 20;
        p3.life = 35;

        System.out.println(p1.number);
        System.out.println(p2.number);
        System.out.println(p3.number);

        System.out.println(p1.life);
        System.out.println(p2.life);
        System.out.println(p3.life);
        */

        System.out.println(p1.getLifes());
        p1.setLifes(50);
        System.out.println(p1.getLifes());

        
        p1.info();
        p2.info();
        p3.info();
    }
}