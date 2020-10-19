package game.offices;

import game.Player;
import game.Printer;
import game.utils.WriterReader;

public class Bank {
    private double playerDebt = 0;
    private final double creditCoeff;
    private final double debtCoeff;
    private WriterReader writerReader;

    public Bank(double creditCoeff, double debtCoeff, WriterReader writerReader) {
        this.creditCoeff = creditCoeff;
        this.debtCoeff = debtCoeff;
        this.writerReader = writerReader;
    }

    public void process(Player visitor) {
        if (isDebtor(visitor)) {
            visitor.reduceBalance(playerDebt);
            playerDebt = 0;
        } else {
            tryGetCredit(visitor);
        }
    }

    public boolean isDebtor(Player player) {
        return playerDebt != 0;
    }

    public void tryGetCredit(Player visitor) {
        // работа со сканером

        getCredit(visitor);
    }

    public void getCredit(Player creditor) {
        double currentCredit = calculateCredit(creditor);
        creditor.increaseBalance(currentCredit);
        changePlayerDebt(currentCredit);
    }

    private double calculateCredit(Player player) {
        return creditCoeff * player.getSpentMoney();
    }

    private void changePlayerDebt(double credit) {
        playerDebt = credit * debtCoeff;
    }

    public void printCoeffs(){
        Printer.printBankCoeff(creditCoeff, debtCoeff);
    }
}
