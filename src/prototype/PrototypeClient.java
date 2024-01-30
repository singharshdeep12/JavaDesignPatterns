package prototype;

public class PrototypeClient {

    public static void main(String[] args) throws CloneNotSupportedException {

        SwordsMan swordsman = new SwordsMan();
        swordsman.attack();
        System.out.println(swordsman);

        SwordsMan swordsMan2 = (SwordsMan) swordsman.clone();
        System.out.println("Cloned object below \n" + swordsMan2);

        General general = new General();
        general.boostMorale();
        System.out.println("-".repeat(50));
        System.out.println(general);

        try{
            General general2 = (General) general.clone();
        }catch(CloneNotSupportedException e){
            System.out.println("While Cloning, Clone not supported exception thrown");
        }

    }

}



abstract class GameUnitPrototype implements Cloneable{

    private int x,y,z;
    GameUnitPrototype(){
        x=0;
        y=0;
        z=0;
    }

    GameUnitPrototype(int x1,int y1,int z1){
        x=x1;
        y=y1;
        z=z1;
    }

    public void initialize(){
        x=0;
        y=0;
        z=0;
    }

    @Override
    public GameUnitPrototype clone() throws CloneNotSupportedException {
        GameUnitPrototype game = (GameUnitPrototype) super.clone();
        game.initialize();
        return game;
    }

    @Override
    public String toString() {
        return "GameUnitPrototype{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                "} && ";
    }
}


class SwordsMan extends GameUnitPrototype{
    private String state = "idle";

    public void attack(){
        state = "attacking";
    }

    public void initialize(){
        super.initialize();
        state = "idle";
    }


    @Override
    public String toString() {
        return super.toString() +
        "SwordsMan{" +
                "state='" + state + '\'' +
                '}';
    }
}

//Doesnt support cloning
class General extends GameUnitPrototype{

    private String state = "idle";

    public void boostMorale(){
        state = "Boost Morale";
    }

    public void initialize(){
        throw new UnsupportedOperationException("Not allowed as not cloneable");
    }

    @Override
    public GameUnitPrototype clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Generals are unique");
    }

    @Override
    public String toString() {
        return super.toString() +
                "General{" +
                "state='" + state + '\'' +
                '}';
    }
}