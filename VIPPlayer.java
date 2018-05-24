public class VIPPlayer extends Player{

    int initialMoney;
    String playerName;
    String idNumber;
    int totalBetAmount;

    public VIPPlayer(String playerName, int initialMoney, String idNumber) {

        super(playerName, initialMoney); // parent constructor

        this.playerName = playerName;
        this.idNumber = idNumber;
        this.initialMoney = initialMoney;
    }

    public int vipCashBack() {

        double cashBackDouble = .05 * totalBetAmount; // calculate cashback double
        return (int) Math.round(cashBackDouble); // convert to int and return

    }



}
