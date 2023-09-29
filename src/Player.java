import java.util.ArrayList;

public class Player {
    protected String name;
    protected int score;
    protected ArrayList<Die> dice;

    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.dice = new ArrayList<>();
    }
    //För att kunna göra ett simpelt tärningsspel skall vi nu också skapa en klass Player
    // för att representera en spelare. En spelare skall ha tre instansvariabler:
    // ett namn, en poäng och en lista av tärningar.
    //● Namnet skall vara av typen String. Ska ha en getter-metod.
    //● Poängen skall vara av typen int och skall representera hur många poäng spelaren
    // har lyckats samla ihop. Ska ha en getter-metod.
    //● Listan med tärningar är vad spelaren kommer att använda för att spela tärningsspelet.
    // Skall vara av typen ArrayList<Die>.
    //En spelare skall också ha ett antal metoder:
    //● public void rollDice();
    //○Skall rulla alla tärningar i spelarens tärnings-lista.
    public void rollDice() {
        for (Die die : dice) {
            die.roll();
        }
    }
    public int getDieValue() {
        int sum = 0;
        for (Die die : dice) {
            sum += die.getCurrentValue();
        }
        return sum;
    }
    public void increaseScore() {
        this.score ++;
    }
    public void addDie(int sides) {
        Die die = new Die(sides);
        this.dice.add(die);
    }
    //●public int getDieValue();
    //○ Skall summera och returnera värdet på spelarens alla tärningar i form av ett heltal.
    //●public void increaseScore();
    //○ Skall öka spelarens poäng med ett.
    //●public void addDie(int sides);
    //○Skapar en ny tärning med sidor sides och lägger till den till spelaren.
}
