import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    public String type, name;
    public static int minBet, maxBet;
    public static int transactionNumber;
    public static int houseMoney;


    public static ArrayList<Player> playersInGame = new ArrayList<Player>();

    public static ArrayList<Transaction> transactionLines = new ArrayList<Transaction>();

    public Game(String type, String name, int minBet, int maxBet) {

        this.type = type;
        this.name = name;
        this.minBet = minBet;
        this.maxBet = maxBet;

        transactionNumber = 0;

    }

    public static void addPlayerFromQueue() {
        //take player out of queue and put into playersInGame

        if(Mainpp.waitingPlayers.peek() == null) {
            System.out.println("No waiting players to pull from Queue");
        }
        else {
            playersInGame.add(Mainpp.waitingPlayers.poll()); // adding to arrayList playersInGame from Queue waitingPlayers

        }




    }



    public boolean playAgain(Scanner scan) {
        String answer;
        System.out.print("Play again [y/n]? ");
        answer=scan.next();
        return answer.equalsIgnoreCase("y");
    }




}
