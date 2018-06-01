public class Dis {
    public static void display1() {
        System.out.println(" Main Menu \n");
        System.out.println("1. Select a game");
        System.out.println("2. Add a new Player to the list");
        System.out.println("3. Quit");
    }

    public static void display2() {
        System.out.println("Game Menu \n");
        System.out.println("1. Add a Player to the game");
        System.out.println("2. Play one Round");
        System.out.println("3. Game Status");
        System.out.println("4. Return to the main Menu");
    }
    public static void display3() {
        System.out.println("-------------------------------------------");
        System.out.println("Welcome to a simple version of roulette game.");
        System.out.println("You can place a bet on black, red, or a number.");
        System.out.println("A color bet is paid " + Wheel.COLOR_PAYOFF + " the bet amount.");
        System.out.println("A number bet is paid " + Wheel.NUMBER_PAYOFF + " the bet amount.");
        System.out.println("You can bet on a number from " + Wheel.MIN_NUM + " to " +Wheel.MAX_NUM + ".");
        System.out.println("You can bet an amount between $" + Game.minBet + " and $" + Game.maxBet + ".");// need to get these
        System.out.println("Gamble responsibly.  Have fun and good luck!\n");
        System.out.println("-------------------------------------------------");
    }

    public static void displayGames() {

        System.out.println("Select From Available Games: ");
        for(int i = 0; i < Mainpp.gameList.size(); i++) {

            if( Mainpp.gameList.get(i).hasSpace() ) {

                System.out.println( Mainpp.gameList.get(i).name );
            }
        }

    }
}