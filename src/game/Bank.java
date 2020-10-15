package game;

public class Bank {
    private int playerDebt;
    private int creditCoeff;
    private int debtCoeff;

    public void process(Player visitor){
        if(isDebtor(visitor)){
            visitor.reduceBalance(playerDebt);
        }
        else {
            tryGetCredit(visitor);
        }
    }

    public boolean isDebtor(Player player) {
        return false;
    }

    public void tryGetCredit(Player visitor){
        // работа со сканером

        getCredit(visitor);
    }

    public void getCredit(Player creditor){
        int currentCredit = calculateCredit(creditor);
        creditor.increaseBalance(currentCredit);
        changePlayerDebt(currentCredit);
    }

    private int calculateCredit(Player player){
        return creditCoeff * player.getSpentMoney();
    }

    private void changePlayerDebt(int credit){
        playerDebt = credit * 4;
    }


}
