import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;

import java.util.Queue;

import java.util.Scanner;

public class Implementation {

	public static Queue<Player> waitingPlayers = new LinkedList<Player>(); // Queue of Players not currently in game.
																			// Add initial queue elements from text
			public static int opt2=0;																// inputs

	public Implementation() {

	}

	public static void implement(Scanner scan) {

		boolean k = false;
		try {

		while (k == false) { // beginning of main menu

			Dis.display1();

			Mainpp.opt1 = scan.nextInt();

			switch (Mainpp.opt1) {

			case 1:

				int gameIndex = -1;

				Dis.displayGames();

				boolean a = false;

				while (a == false) { // checking for inputted game validity

					System.out.println("Select a Game:");

					String choice = scan.next();

					int tracker = 0;

					for (int i = 0; i < Mainpp.gameList.size(); i++) { // look for inputed game choice in the arrayList
																		// of Games

						if (choice.equals(Mainpp.gameList.get(i).name)) { // inputted game is a valid game in arraylist
																			// of games in program

							a = true;

							gameIndex = i;

							boolean z = false;

							tracker++;

							while (z == false) { // setting up game menu functionality

								Dis.display2();

								opt2 = scan.nextInt();

								if (opt2 == 1) { // "Add Player to the Game"

									try {

										Mainpp.gameList.get(gameIndex).addPlayerFromQueue();

										System.out.println("Adding Player to Game");

									}

									catch (IndexOutOfBoundsException e) {

										System.out.println(
												"Variable gameIndex was not altered after initialization: " + e);

									}

								}

								else if (opt2 == 2) { // "Play one round" CREATE PLAYER MENU

									Dis.playerOption();

									int opt3 = scan.nextInt();

									if (opt3 == 1)

									{
																				
											Dis.display3();

											Wheel.betOptions();
//											int betOption =scan.nextInt();
											for (int x = 0; x < Mainpp.gameList.size() - 1; x++) {

                                                System.out.println("Game #" + (x + 1));

                                                //Mainpp.gameList.get(x).makeBet(scan);
                                                if(Mainpp.gameList.get(gameIndex).playersInGame.size()==0) {
                                                	System.out.println("Error! No Players Added to the game");
                                                }
                                                for (int play = 0; play < Mainpp.gameList.get(gameIndex).playersInGame.size(); play++) {
                                                	System.out.println("Play");

                                                    Mainpp.gameList.get(gameIndex).playersInGame.get(play).makeBet(scan);
                                                    
                                                }

                                                System.out.println("Finished ");

                                                System.out.println("Spinning Wheel");

                                                Wheel.spin();

                                            }


									}
									else if (opt3==2) {//Multiple Bets
										Dis.display3();

										Wheel.betOptions();
//										int betOption =scan.nextInt()
                                            //Mainpp.gameList.get(x).makeBet(scan);

                                            for (int play = 0; play < Mainpp.gameList.get(gameIndex).playersInGame.size(); play++) {
                                            	System.out.println("Play");
                                            	while(Dis.playAgain(scan)) {
                                                Mainpp.gameList.get(gameIndex).playersInGame.get(play).makeBet(scan);
                                                
                                            	}
                                            }

                                            System.out.println("Finished ");

                                            System.out.println("Spinning Wheel");

                                            Wheel.spin();

										
									}
									else if (opt3==3) {//Add more money to Existing Players
										System.out.println("How much money to add?");
										int addmoney=scan.nextInt();
										
										
									}
									else if(opt3==4) {// Skip the bet
										
										
									}
									else if(opt3==5) {// return to game menu
										
									}

								}

								else if (opt2 == 3) { // "Game Status"

									Mainpp.gameList.get(gameIndex).printPlayers();

									System.out.println("House Money: $" + Mainpp.gameList.get(gameIndex).houseMoney);

									for (int j = Mainpp.gameList.get(gameIndex).transactionLines.size()- 1; j > Mainpp.gameList.get(gameIndex).transactionLines.size() - 4; j--) {

										System.out.println(	Mainpp.gameList.get(gameIndex).transactionLines.get(i).toString());

									}

								}

								else if (opt2 == 4) { // "Return to the main menu

									z = true;

								}

							}

						}

						else if (tracker == 0) { // execute if we cant find the

							System.out.println("Game Choice not found, please select from the given list.");
							break;

						}

					}

				}

				break;

			// invoke game selection

			case 2:

				System.out.println("Adding Player to the Queue.");

				addPlayerToQueue();

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
		
		catch(InputMismatchException e) {
			System.out.println("Invalid Input. Please,Restart the game to Try Again-->");
		}
		

	}

	public static void addPlayerToQueue() {

		Scanner scan = new Scanner(System.in);

		System.out.println(
				"What kind of player would you like to add? (Input Number: Normal == 0, VIP == 1, SuperVIP == 2 )");

		int type = scan.nextInt();

		System.out.println("How much money does this player start with?");

		int initialMoney = scan.nextInt();

		if (type > 0) {

			System.out.println("Enter a 4 digit ID number for you player:");

			String idNumber = scan.nextLine();

			System.out.println("Please Enter a First and Last Name:");

			String fullName = scan.nextLine();

			if (type == 1) {

				Player p1 = new VIPPlayer(fullName, initialMoney, idNumber);

				System.out.println("VIP Player Created and added to Queue");

			}

			if (type == 2) {

				Player p2 = new SuperVIPPlayer(fullName, initialMoney, idNumber);

				System.out.println("Super VIP Player Created and added to Queue");

			}

		}

		else {

			Player p3 = new NormalPlayer(initialMoney);

			System.out.println("Normal Player Created and added to Queue");

		}

	}

}
