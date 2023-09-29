import java.util.Random;

public class Die {
    private int currentValue;
    private int numberOfSides;

    protected static Random random = new Random();

    public Die(int numberOfSides) {
        this.numberOfSides = numberOfSides;
    }

    public int getNumberOfSides() {
        return numberOfSides;
    }

    public int getCurrentValue() {
        return currentValue;
    }

    public void roll() {
        this.currentValue = random.nextInt(numberOfSides) + 1;
        //System.out.println("TEST: die rolled " + currentValue);
    }


    //Tärningen skall också ha en privat klassvariabel (dvs static): en slumpgenerator.
    //●Slumpgeneratorn  skall  vara  av  typen Random och  kommer  att  användas  i  vår
    //roll()-metod.
    //○Det räcker med en kopia av Random-klassen som kan delas av alla instanser -
    //det är därför den här variabeln är static.
    //
    //För att kunna använda klassen kommer vi att behöva en metod:
    //●public void roll();
    //○Den  här metoden  skall använda sig av slumpgeneratorn för  att  förändra tärningens
    // nuvarande värde.
    //○Tips:  ni  bör använda  standardklassen  Random  för  detta.  Random  har  en
    // metod public  int  nextInt(int  maxValue) som returnerar ett slumpmässigt
    // heltal mellan 0 och (maxValue-1).
}
