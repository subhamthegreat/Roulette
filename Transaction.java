public class Transaction {

    public int betAmount, payout;
    public String betType, name; // bet type(red, black, number, etc) and name of player


    public Transaction( String name, int betAmount, int payout) {

        this.name = name;
        betType = Wheel.BetType();
        this.betAmount = betAmount;
        this.payout = payout;

    }

    public String toString() {

        String output = "";

        output += Wheel.transactionNum + "\t" + name + "\t" + betAmount + "\t" + betType + payout;
        return output;

    }

}
