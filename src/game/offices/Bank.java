package game.offices;

import game.Player;

public class Bank {
    private int playerDebt;
    private final int creditCoeff;
    private final int debtCoeff;

    public Bank(int creditCoeff, int debtCoeff) {
        this.creditCoeff = creditCoeff;
        this.debtCoeff = debtCoeff;
    }

    public void process(Player visitor) {
        if (isDebtor(visitor)) {
            visitor.reduceBalance(playerDebt);
        } else {
            tryGetCredit(visitor);
        }
    }

    public boolean isDebtor(Player player) {
        if(playerDebt == 0){
            return false;
        }
        else
            return true;
    }

    public void tryGetCredit(Player visitor) {
        // работа со сканером

        getCredit(visitor);
    }

    public void getCredit(Player creditor) {
        int currentCredit = calculateCredit(creditor);
        creditor.increaseBalance(currentCredit);
        changePlayerDebt(currentCredit);
    }

    private int calculateCredit(Player player) {
        return creditCoeff * player.getSpentMoney();
    }

    private void changePlayerDebt(int credit) {
        playerDebt = credit * debtCoeff;
    }


}
