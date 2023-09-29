import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
public class Main {
    public static void main(String[] args) {
        //TODO enable playing against the computer
        


        //Programmet frågar först hur många spelare som vill spela, hur många tärningar varje
        // spelare skall ha  och  hur  många  sidor  tärningarna  skall  ha.  Det  frågar
        // sedan  efter  namnen  på  spelarna.  Ni  kan anta att användaren matar in korrekta
        // värden, dvs ni behöver ej ha med felhantering.
        //Spelet kommer sedan att spelas i fem omgångar. Varje omgång består av att spelarna,
        // en efter en, gissar på ett värde och sedan rullar sina tärningar.
        // Om värdet spelaren gissade på är lika med det sammanlagda värdet på tärningarna,
        // så får spelaren en poäng. En omgång är slut då en sista spelaren har gissat och
        // rullat sina tärningar.
        ArrayList<Player> playerList = initialize();
        takeTurn(playerList);
        ArrayList<Player> winnerArray = getWinners(playerList);
        printWinners(winnerArray);
    }
    static Scanner sc = new Scanner(System.in);



    private static ArrayList<Player> initialize() {
        // En metod som initialiserar spelet genom att ta emot användarinput och skapa alla
        // instanser som behövs, samt en lista av spelare som sedan returneras.
        ArrayList<Player> playerList = new ArrayList<>();
        System.out.println("Let's play a game of dice!");
        System.out.println();
        System.out.print("Enter number of players: ");
        int numOfPlayers = sc.nextInt();
        System.out.println();
        System.out.print("Enter number of dice in the game: ");
        int numOfDice = sc.nextInt();
        System.out.println();
        System.out.print("Now enter number of sides for each die: ");
        int numOfSides = sc.nextInt();
        sc.nextLine();
        System.out.println();
        for (int i = 0; i < numOfPlayers; i++) {
            int playerNumber = i + 1;
            System.out.println("Name of player " + playerNumber + ":");
            String name = sc.nextLine();
            playerList.add(new Player(name));
        }
        for (Player player : playerList) {
            for (int i = 0; i < numOfDice; i++) {
                player.addDie(numOfSides);
            }
        }
        return playerList;
    }

    private static void takeTurn(ArrayList<Player> players) {
        // En metod som tar  emot  en  lista  av  spelare  och  spelar  färdigt
        // en  hel  omgång. Går igenom listan av spelare, rullar varje spelares tärningar,
        // frågar efter en gissning och ökar spelarens poäng om hen gissat rätt.
        //TODO delay between printing lines
        //long ROLL_DELAY = 3;

        for (int round = 1; round < 6; round++) { // 5 rounds

            System.out.println();
            System.out.println("ROUND " + round + ":");
            System.out.println("You are using " +
                    numString(players.get(0).dice.size()) + " " +
                    players.get(0).dice.get(0).getNumberOfSides() + "-sided dice.");
            for (Player player : players) {
                player.rollDice();
                int sum = player.getDieValue();
                //   player.score = 0;
                //int diceSum = 0;
                //for (Die die : player.dice) {
                //    die.roll();
                //    diceSum += die.getCurrentValue();


                System.out.print(player.name + ", how much do you think you will get? ");
                int guess = sc.nextInt();
                System.out.print("You rolled... ");
                //TimeUnit.SECONDS.sleep(ROLL_DELAY); // Waits 3 seconds...
                System.out.println(sum);
                if (guess == sum) {
                    player.increaseScore();
                    System.out.println("You guessed right!");
                    System.out.println("Your score increased by 1. Current score: " +
                            player.score);
                    System.out.println();
                } else {
                    System.out.println("I'm afraid you guessed wrong. Current score: " +
                            player.score);
                    System.out.println();
                }
                System.out.println();

            }
        }

    }
    private static ArrayList<Player> getWinners(ArrayList<Player> players) {
        // Tar emot en lista av spelare och returnerar en lista med vinnare.
        // Vinnarlistan kan innehålla flera vinnare med samma poäng.
        ArrayList<Player> ArrayOfWinners = new ArrayList<>();
        int highestScore = 0;
        for (Player player : players) {
            if (player.score > highestScore) highestScore = player.score;
        }
        for (Player player : players) {
            if (player.score == highestScore) ArrayOfWinners.add(player);
        }
        return ArrayOfWinners;
    }

    private static void printWinners(ArrayList<Player> ArrayOfWinners) {
        //Check if there are multiple winners
        if (ArrayOfWinners.size() > 1) {
            System.out.println("We have more than one winner! The winners are:");
            // prints
            // p1, p2 and p3!
            // if there are three winners.
            for (int i = 0; i<ArrayOfWinners.size(); i++){
                if (i == ArrayOfWinners.size() - 2) { // penultimate
                    System.out.print(ArrayOfWinners.get(i).name);
                }
                else if (i == ArrayOfWinners.size() - 1) { // last
                    System.out.println(" and " + ArrayOfWinners.get(i).name + "!");
                }
                else {
                    System.out.print(ArrayOfWinners.get(i).name + ", ");
                }
            }
        } else {
            System.out.println("And the winner is " + ArrayOfWinners.get(0).name + "!");
        }
        System.out.println();

    }
    // A method that takes an int between 0 and 10 as input and returns the
    // number as a string, for example input: 1, return "one"
    private static String numString(int num) {
        ArrayList<String> numStrings = new ArrayList<>();
        numStrings.add("zero");
        numStrings.add("one");
        numStrings.add("two");
        numStrings.add("three");
        numStrings.add("four");
        numStrings.add("five");
        numStrings.add("six");
        numStrings.add("seven");
        numStrings.add("eight");
        numStrings.add("nine");
        numStrings.add("ten");
        return numStrings.get(num);
    }


}