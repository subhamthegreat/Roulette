
import java.util.*;

//************************************************************************
//   Class Roulette contains the main driver for a roulette betting game.
//************************************************************************
class Roulette {
    // =====================================================================
    // Contains the main processing loop for the roulette game.
    // =====================================================================
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
//        Player player1 = new Player("Jane", 60); // $60 to start for Jane
//        Player player2 = new Player("Mark", 60); // getting another player into the game

//        boolean done = false, done1 = false;

        System.out.println("Authors: ");
        System.out.println("     Subham Thakulla Kshetri");
        System.out.println("     Matthew Pinada");
        System.out.println("     Jose Sanchez");
        Dis.display3();


        for (int i = 0; i < Game.playersInGame.size(); i++) {

            System.out.println( "Money available for " + Game.playersInGame.get(i).getName() + ": " + Game.playersInGame.get(i).getMoney());



        }

//        while (!done || !done1) {
//            if (done == false) {
//                System.out.println("Money available for " + player1.getName() + ": " + player1.getMoney());
//                player1.makeBet(scan);
//                System.out.println();
//            }
//            if (done1 == false) {
//                System.out.println("Money available for " + player2.getName() + ": " + player2.getMoney());
//                player2.makeBet(scan);
//                System.out.println();
//            }
//            Wheel.spin();
//            if (done == false) {
//                player1.payment();
//                done = !player1.playAgain(scan);
//            }
//            if (done1 == false) {
//                player2.payment();
//                done1 = !player2.playAgain(scan);
//            }

            System.out.println();


//        System.out.println(player1);
//        System.out.println(player2);
//        System.out.println();
//        System.out.println("------------Game over!  Thanks for playing.---------------");
//        scan.close();
        }


    }

