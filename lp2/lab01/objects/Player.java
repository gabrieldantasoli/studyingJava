package objects;
public class Player {

    //atributes
    private final int maxLifes = 100;
    public int number = 0;
    private int lifes = 100;
    static boolean endgame= false;


    public Player(int number){
        this.number = number;
        System.out.printf("Player %d created! Life = %d%n",this.number,this.lifes);
    }

    public int getLifes(){
        return this.lifes;
    }

    public void setLifes(int life){
        if (this.maxLifes < life && life >= 0){
            this.lifes = life;
        }else if (life > this.maxLifes){
            this.lifes = maxLifes;
        }else if (life < 0){
            this.lifes = 0;
        }
    }

    public void info(){
        System.out.printf("Lifes : %d%n",this.lifes);
        System.out.printf("End game : %s%n",this.endgame ? "Yes" : "Not");
    }



}