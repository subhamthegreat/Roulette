public class Implementation {
}
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Implementation {
	public static int opt1, opt2;

	public static ArrayList<Game> gameList = new ArrayList<Game>();

	public Implementation() {

	}

	public static void implement(Scanner scan) {
		boolean k = false;

		while (k == false) {

			Dis.display1();

			opt1 = scan.nextInt();
			switch (opt1) {

			case 1:

				int gameIndex = -1;

				Dis.displayGames();

				boolean a = false;

				while (a == false) {

					System.out.println("Select a Game:");

					String choice =scan.next();
							
					boolean z = false;

					while (z == false) { // setting up game menu functionality

						Dis.display2();

						opt2 = scan.nextInt();

						if (opt2 == 1) { // "Add Player to the Game"

							try {

								gameList.get(gameIndex).addPlayerFromQueue();

								System.out.println("Adding Player to Game");

							}

							catch (IndexOutOfBoundsException e) {

								System.out.println("Variable gameIndex was not altered after initialization: " + e);

							}

						}

						else if (opt2 == 2) { // "Play one round"

							Dis.display3(); // initial into to details of game and bet options

							Player temp = new Player(50);

							temp.makeBet(scan);

							Wheel.spin();

							temp.payment();

						}

						else if (opt2 == 3) { // "Game Status"

							gameList.get(gameIndex).printPlayers();

							System.out.println("House Money: $" + gameList.get(gameIndex).houseMoney);

							for (int j = gameList.get(gameIndex).transactionLines.size()
									- 1; j > gameList.get(gameIndex).transactionLines.size() - 4; j--) {

								System.out.println(gameList.get(gameIndex).transactionLines.get(i).toString());

							}

						}

						else if (opt2 == 4) { // "Return to the main menu

							z = true;

						}

						else if (i == gameList.size() - 1 && opt2 == 0)

						{ // execute if we cant find the

							System.out.println("Game Choice not found, please select from the given list.");

						}
					}

				}
					

					for (int i = 0; i < gameList.size(); i++) { // look for inputed game choice in the arrayList of
																// Games

						if (choice.equals(gameList.get(i).name)) {

							a = true;

							gameIndex = i;

						}
					}
				}

				// invoke game selection

			case 2:

				System.out.println("Adding Player to the Queue.");

				Mainpp.addPlayerToQueue();

				// invoke add a new player to the list with the queue

				break;

			case 3:

				k = true;

				// terminate the program while displaying the complete information for each game
				// to a new txt file

				break;

			default:

				System.out.println("Invalid Input! Please Try again");

				break;

			}

		}

	}


