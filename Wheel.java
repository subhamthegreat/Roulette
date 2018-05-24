//**********************************




//  EDITED BY SUBHAM



//************************************
import java.util.Random;

//************************************************************************
//   Class Wheel represents a roulette wheel and its operations.  Its
//   data and methods are static because there is only one wheel.
//************************************************************************
class Wheel
{
    // public name constants -- accessible to others
    public final static int BLACK     =  0;			// even numbers
    public final static int RED       =  1;			// odd numbers
    public final static int GREEN     =  2;			// 00 OR 0
    public final static int NUMBER    =  3;			// number bet
    public final static int MIN_NUM   =  1;			// smallest number to bet
    public final static int MAX_NUM   = 14;			// largest number to bet
    public final static int MAX_BET   = 10;			// largest amount to bet
    public final static int MIN_BET   = 1;			// smallest number to bet
    public static int   HOUSENETWINS  = 0;

    // private name constants -- internal use only
    private final static int MAX_POSITIONS = 16;	// number of positions on wheel
    private final static int NUMBER_PAYOFF = 14;	// payoff for number bet
    private final static int COLOR_PAYOFF  = 2;		// payoff for color bet

    // private variables -- internal use only
    private static int ballPosition;				// 00, 0, 1 .. 14
    private static int color; // GREEN, RED, OR BLACK
    private static String colorString;


    //=====================================================================
    //  Presents welcome message
    //=====================================================================
    public static void welcomeMessage()
    {
        System.out.println("Welcome to a simple version of roulette game.");
        System.out.println("You can place a bet on black, red, or a number.");
        System.out.println("A color bet is paid " + COLOR_PAYOFF + " the bet amount.");
        System.out.println("A number bet is paid " + NUMBER_PAYOFF + " the bet amount.");
        System.out.println("You can bet on a number from " + MIN_NUM + " to " + MAX_NUM + ".");
        System.out.println("You can bet an amount between $" + MIN_BET + " and $" + MAX_BET + ".");
        System.out.println("Gamble responsibly.  Have fun and good luck!\n");
    }


    //=====================================================================
    //  Presents betting options
    //=====================================================================
    public static void betOptions()
    {
        System.out.println("Betting Options:");
        System.out.println("    1. Bet on black (even numbers)");
        System.out.println("    2. Bet on red (odd numbers)");
        System.out.println("    3. Bet on a number between " + MIN_NUM +
                " and " + MAX_NUM);
        System.out.println();
    }

    public static void Spin() {

        Random rand = new Random();
        int spinResult = rand.nextInt(15);
        if (spinResult != 0) {
            ballPosition = spinResult - 1;
            if (spinResult % 2 == 0) {
                color = BLACK;
                colorString = "BLACK";
            }
            else {
                color = RED;
                colorString = "RED";
            }
        }
        else {
            color = GREEN;
            colorString = "GREEN";
        }

        System.out.println("Number Result: " + ballPosition);
        System.out.println("Color Landed on: " + colorString);
    }

    public static int payOff(int bet, int betType, int number) {
        if (betType == NUMBER && number != 0 && ballPosition == number) {
            bet *= NUMBER_PAYOFF;
            HOUSENETWINS -= bet;
        }
        else if ((betType == BLACK || betType == RED) && color == betType) {
            bet *= COLOR_PAYOFF;
            HOUSENETWINS -= bet;
        }
        else {
            HOUSENETWINS += bet;
            bet = 0;
        }
        return bet;
    }
}


