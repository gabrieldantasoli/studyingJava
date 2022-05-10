package object;

public class Player{
    private boolean endGame = false;
    private float life = 100;
    private float power;
    private float armor;
    private float defense;
    private float armorBonus;
    private String kindof;
    
    public Player(int type){
        switch (type){
            case 1:
                kindof = "Soldier";
                break;
            case 2:
                kindof = "Defenser";
                break;
            case 3:
                kindof = "Armor Breaker";
                break;
            case 4:
                kindof = "Blacksmith";
                break;
        }
        System.out.println("Unit created : " + kindof + "!");
        setInfo(kindof);
    }
    
    public void setInfo(String Unit){
        switch (Unit){
            case "Soldier":
                this.power = 10;
                this.defense = 0;
                this.armor = 50;
                this.armorBonus = 0;
                break;
            case "Defenser":
                this.power = 0;
                this.defense = 15;
                this.armor = 20;
                this.armorBonus = 0;
                break;
            case "Armor Breaker":
                this.power = 40;
                this.defense = 0;
                this.armor = 10;
                this.armorBonus = 0;
                break;
            case "Blacksmith":
                this.power = 2;
                this.defense = 0;
                this.armor = 0;
                this.armorBonus = 2;
                break;
        }
    }
    
    public void showInfo(){
        System.out.println("-=-=-=" + this.kindof + "-=-=-=");
        System.out.println("POWER : " + this.power);
        System.out.println("DEFENSE : " + this.defense);
        System.out.println("ARMOR :" + this.armor);
        System.out.println("ARMOR BONUS : " + this.armorBonus);
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=");
        
    }
}