// Class Player for CSCI 145 Project 2 Spring 18
// Modified by:Subham Thakulla Kshetri

import java.util.*;

//************************************************************************
//   Class Player represents one roulette player.
//************************************************************************
class Player {
    private static final int RELOAD_AMOUNT = 50;
    private int bet, money, betType, number, record, initalMoney, Housemoney;
    private int count = 0;
    private String name;

    // =====================================================================
    // The Player constructor sets up name and initial available money.
    // =====================================================================
    public Player(String playerName, int initialMoney) {
        name = playerName;
        money = initialMoney;
        this.initalMoney = initialMoney;
        record = money;
    } // constructor Player

    // =====================================================================
    // Returns this player's name.
    // =====================================================================
    public String getName() {
        return name;
    } // method getName

    // =====================================================================
    // Returns this player's current available money.
    // =====================================================================
    public int getMoney() {
        if (money == 0) {
            money = RELOAD_AMOUNT;
            count++;
        }
        return money;
    } // method getMoney

    // =====================================================================
    // Prompts the user and reads betting information.
    // =====================================================================
    public void makeBet(Scanner scan) {

        boolean a = true;

        System.out.print("How much to bet: ");
        bet = scan.nextInt();
        while (a) {

            if (bet > money) {
                System.out.print("Invalid Input! Please enter bet within your total amount: ");
                bet = scan.nextInt();
                a = true;
            } else if (bet >= Wheel.MIN_BET && bet <= Wheel.MAX_BET) {
                a = false;
            } else {
                System.out.print("Invalid Input! Please enter valid Bet($1-$10): ");
                bet = scan.nextInt();
                a = true;
            }
        }
        money-=bet;
        Housemoney += bet;
        Wheel.betOptions();
        System.out.print("Enter the number to command for bet:");
        betType = scan.nextInt();
        while (betType != 1 && betType != 2 && betType != 3) {
            System.out.print("Invalid Input! Please input (1,2 or 3):");
            betType = scan.nextInt();
        }
        if (betType == Wheel.NUMBER) {
            System.out.print("Enter the number to bet on:");
            number = scan.nextInt();
            while (number < 1 || number > 14) {
                System.out.print("Invalid Input. Please enter number between 1 to 14:");
                number = scan.nextInt();
            }
        }

    } // method makeBet

    // =====================================================================
    // Determines if the player wants to play again.
    // =====================================================================
    public boolean playAgain(Scanner scan) {
        String answer;
        System.out.print("Play again [y/n]? ");
        answer=scan.next();
        return answer.equalsIgnoreCase("y");
    }

    public void payment() {
        money = money + Wheel.payOff(bet, betType, number);
        System.out.println(name + " won: " + Wheel.payOff(bet, betType, number));
        if (Wheel.payOff(bet, betType, number) == 0) {
            System.out.println("New Balance: " + (money));

        } else {
            money += bet;
            System.out.println("New Balance: " + (money));
        }
        Housemoney -= Wheel.payOff(bet, betType, number);
    }

    // =====================================================================
    // Return relevant information about the player.
    // =====================================================================
    public String toString() {
        String result;
        if (count <= 0) {
            int result1 = money - record;
            System.out.println();
            if (result1 > 0) {
                System.out.println("---------Congratulations!---------" + name + ", You won..");
                result = "Total money won by " + name + " is $" + (result1 - count * initalMoney);
            } else if (result1 == 0) {
                result = name + " did not win nor did lose..";
            } else {
                result1 *= -1;
                System.out.println("---------Better Luck next time!!--------- " + name);
                result = "Total money lost by " + name + " is $" + (result1 + count * initalMoney);
            }
        } else {
            int result1 = money - RELOAD_AMOUNT;
            if (result1 > 0) {
                System.out.println("----------Congratulations!--------");
                System.out.println(name + ", You won..");
                result = "Total money won by " + name + " is $" + (result1 - count * initalMoney);
            } else if (result1 == 0) {
                result = name + " did not win nor did lose..";
            } else {
                result1 *= -1;
                System.out.println("---------Better Luck next time!!------- " + name);
                result = "Total money lost by " + name + " is $" + (result1 + count * initalMoney);
            }
        }
        System.out.println(" Housemoney because of " + name + ":$" + Housemoney);
        System.out.println();
        return result;
    } // method toString
}
