public class VIPPlayer extends Player{

    public int initialMoney;
    public String playerName;
    public String idNumber;
    public int totalBetAmount;

    public VIPPlayer(String playerName, int initialMoney, String idNumber) {

        super(1, Integer.parseInt(idNumber),initialMoney, playerName); // parent constructor

        this.playerName = playerName;
        this.idNumber = idNumber;
        this.initialMoney = initialMoney;
    }

    public int vipCashBack() {

        double cashBackDouble = .05 * totalBetAmount; // calculate cashback double
        return (int) Math.round(cashBackDouble); // convert to int and return

    }



}
