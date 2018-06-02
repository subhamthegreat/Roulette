
import java.util.ArrayList;
import java.util.Scanner;


public class Mainpp {


    public static ArrayList<Game> gameList = new ArrayList<Game>();

    public static int opt1,opt2 = 0;


    public static void main(String[] args) {

        gameList.add(new Game("1",50, 5000));
        gameList.add(new Game("2", 500, 10000));



        Player p1 = new Player( 500);
        Implementation.waitingPlayers.offer(p1); //experimenting not important


        Scanner scan= new Scanner(System.in);

        Implementation.implement(scan);

    }






}
