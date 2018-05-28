import java.util.Random;

class Wheel {
    public final static int BLACK = 0; // even numbers
    public final static int RED = 1; // odd numbers
    public final static int GREEN = 2; // 00 OR 0
    public final static int NUMBER = 3; // number bet
    public final static int MIN_NUM = 1; // smallest number to bet
    public final static int MAX_NUM = 36; // largest number to bet
    // needs to get minimum and maximum bet for each game


    public static int transactionNum = 0;
    public static int roundNumber = 0;

    // private name constants -- internal use only
    public final static int MAX_POSITIONS = 35; // number of positions on wheel
    public final static int NUMBER_PAYOFF = 14; // payoff for number bet
    public final static int COLOR_PAYOFF = 2; // payoff for color bet
    private static int ballPosition; // 00, 0, 1 .. 14
    private static int color; // GREEN, RED, OR BLACK
    // I have removed MIN_BET and MAX_BET.
    public static int bt;


    public static int payoutAmount;



    public static void betOptions() {
        System.out.println("Betting Options:");
        System.out.println("    1. Bet on black (even numbers)");
        System.out.println("    2. Bet on red (odd numbers)");
        System.out.println("    3. Bet on a number between " + MIN_NUM + " and " + MAX_POSITIONS);
        System.out.println();
    }

    public static void spin() {
        Random ran = new Random();
        roundNumber++;
        ballPosition = ran.nextInt(MAX_NUM + 3) - 1;
        if (ballPosition == -1 || ballPosition == 0) {
            color = GREEN;
            if (ballPosition == -1) {
                String qw = "00";
                System.out.println();
                System.out.println("Color is Green" + " and the number is " + qw);
            } else {
                System.out.println();
                System.out.println("Color: Green" + " ------ Number: " + ballPosition);
                System.out.println();
            }
        } else if (ballPosition > 0 && ballPosition % 2 == 0) {
            color = BLACK;
            System.out.println();
            System.out.println("Color: Black" + " ------ number: " + ballPosition);
            System.out.println();
        } else {
            color = RED;
            System.out.println();
            System.out.println("Color:red" + " ------ number: " + ballPosition);
            System.out.println();
        }
        Wheel.bet_result();
    }
    public static String bet_result() {
        return "( "+color+" "+ballPosition+" )";
    }

    public static int payoff(int bet, int betType, int numberbet) {
        //for a given game number
        transactionNum++;
        if (betType == 1)
        {
            bt=1;
            if (color == 0)
            {
                payoutAmount = (bet * COLOR_PAYOFF);
                return payoutAmount;
            }
        }
        else if (betType == 2)
        {
            bt=2;
            if (color == 1)
            {
                payoutAmount = (bet * COLOR_PAYOFF);
                return payoutAmount;
            }
        }
        else if (betType == 3)
        {
            bt=3;
            if (numberbet == (Wheel.ballPosition)) {

                payoutAmount = (bet * NUMBER_PAYOFF);
                return payoutAmount;
            }
        }
        return 0;
    }


    public static String BetType(){
        if(bt==1) {
            return "R";}
        else if (bt==2) {
            return "B";

        }
        else
            return "N";
    }
}

