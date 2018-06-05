import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    public String name;
    public static int minBet, maxBet;
    public static int transactionNumber;
    public static int houseMoney;


    public static ArrayList<Player> playersInGame = new ArrayList<Player>();

    public static ArrayList<Transaction> transactionLines = new ArrayList<Transaction>();

    public Game( String name, int minBet, int maxBet) {

        this.name =  "100A" + name;
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

    public static boolean hasSpace() {

        if(playersInGame.size() < 5) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public void addPlayer(Player p) {
        playersInGame.add(p);
    }

    public static void printPlayers() {
        for (int i = 0; i < playersInGame.size(); i++) {
            System.out.println("Player " + playersInGame.get(i).name + " \t Money: $" + playersInGame.get(i).money);
        }

    }

    public boolean playAgain(Scanner scan) {
        String answer;
        System.out.print("Play again [y/n]? ");
        answer=scan.next();
        return answer.equalsIgnoreCase("y");
    }

}
