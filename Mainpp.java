import java.util.ArrayList;

import java.util.LinkedList;

import java.util.Queue;

import java.util.Scanner;

public class Mainpp {

	public static ArrayList<Game> gameList = new ArrayList<Game>();

	public static int opt1;

	public static void main(String[] args) {

		gameList.add(new Game("1", 50, 5000));

		gameList.add(new Game("2", 50, 10000));

		Player p1 = new NormalPlayer(5000);
		
		Player p2= new Player(8600);

		Implementation.waitingPlayers.offer(p1); // experimenting not important
		Implementation.waitingPlayers.offer(p2);

		Scanner scan = new Scanner(System.in);

		Implementation.implement(scan);

	}

}
