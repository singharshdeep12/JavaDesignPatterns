package factory.abstractfactory;

public class AbstractFactoryClient {

    public static void main(String[] args) {
            getGameUnit(new IndustrialAgeGameFactory());
            getGameUnit(new MedievalAgeGameFactory());
    }

    static void getGameUnit(GameUnitFactory factory){

        String factoryClass = factory.getClass()
                .getSimpleName();

        String land = factory.createLandUnit()
                .getClass().getSimpleName();

        String naval = factory.createNavalUnit()
                .getClass().getSimpleName();

        System.out.println("Created " + land + " "
                + naval + " from " + factoryClass);

    }


}


abstract class GameUnitFactory{
    abstract LandUnit createLandUnit();
    abstract NavalUnit createNavalUnit();
}

class IndustrialAgeGameFactory extends GameUnitFactory{
    @Override
    LandUnit createLandUnit() {
        return new RifleMan();
    }
    @Override
    NavalUnit createNavalUnit() {
        return new Submarine();
    }
}

class MedievalAgeGameFactory extends GameUnitFactory{
    @Override
    LandUnit createLandUnit() {
        return new SwordsMan();
    }
    @Override
    NavalUnit createNavalUnit() {
        return new Boat();
    }
}

abstract class LandUnit{    }

class RifleMan extends LandUnit{    }

class SwordsMan extends LandUnit{    }

abstract class NavalUnit{    }

class Submarine extends NavalUnit{    }

class Boat extends NavalUnit{    }


