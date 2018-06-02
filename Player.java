import java.util.*;

class Player {

    public int bet, money, betType, number, record, initalMoney, Housemoney, IDno, playerType;
    public int count = 0;
    public String name = "0";

    public Player(int number, int ID, int initialMon, String playerName) {
        name = playerName;
        money = initialMon;
        initalMoney = initialMon;
        record = money;
        IDno = ID;
        playerType = number;
    }

    public Player(int initialMoney) {

        this.initalMoney = initialMoney;
        money = initialMoney;
        playerType = 0;

    }

    public String getName() {
        return name;
    }

    public int getBet() {
        return bet;
    }

    public int getMoney() {
        if (money == 0) {
            System.out.println("Sorry you don't have any money!");
            // Need to remove this player from the queue
        }
        return money;
    }

    public int playerType() {
        return playerType;
    }

    public void makeBet(Scanner scan) {

        boolean a = true;

        System.out.print("How much to bet: ");
        bet = scan.nextInt();
        while (a) {

            if (bet > money) {
                System.out.print("Invalid Input! Please enter bet within your total amount: ");
                bet = scan.nextInt();
                a = true;
            } else if (bet < Game.minBet && bet > Game.maxBet)// Need to instantiate MIN and Max
            //  i.e. wheel no longer contains those
            {	System.out.println("Invalid Bet amount!!");
                System.out.println("Please enter amount between"+Game.minBet+" to "+ Game.maxBet);
                a = true;
            } else {

                a = false;
            }
        }
        money -= bet;
        Game.houseMoney += bet;
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
            while (number <= Wheel.MIN_NUM || number >= Wheel.MAX_NUM) {
                System.out.print("Invalid Input. Please enter number between 1 to 35:");
                number = scan.nextInt();
            }
            this.payment();
        }



    }

/*	public boolean playAgain(Scanner scan) {
		String answer;
		System.out.print("Play again [y/n]? ");
		answer = scan.next();
		return answer.equalsIgnoreCase("y");
	}*/ 													//Moving to the game class

    public void payment() {
        money = money + Wheel.payoff(bet, betType, number);
        System.out.println(name + " won: " + Wheel.payoff(bet, betType, number));

        if (Wheel.payoff(bet, betType, number) != 0) {

            money += bet;

        }
        Game.houseMoney -= Wheel.payoff(bet, betType, number);
    }


    public void addTransaction() {
        Game.transactionLines.add(new Transaction( getName(), getBet(), Wheel.payoutAmount ));

    }

    public void addsubMoney(int net) {
        money += net;
    }

    public String toString() {
        String result = "";
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
        }
        System.out.println(" Housemoney because of " + name + ":$" + Game.houseMoney);
        System.out.println();
        return result;
    } // method toString
}
