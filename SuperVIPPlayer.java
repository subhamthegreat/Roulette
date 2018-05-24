public class SuperVIPPlayer  extends VIPPlayer{

    int betCount = 0;

    public SuperVIPPlayer(String playerName, int initialMoney, String idNumber) {

        super(playerName, initialMoney, idNumber);

    }

    public int superVipCashBack() {

        int cashBack = this.vipCashBack();

        if(betCount >= 5 && betCount <= 10) {
            cashBack += 10;
        }
        else if( betCount>= 11 && betCount <= 20) {
            cashBack += 25;
        }
        else if(betCount > 20) {
            cashBack += 50;
        }
        return cashBack;

    }

    public void addBet() {
        betCount++;
    }

}
