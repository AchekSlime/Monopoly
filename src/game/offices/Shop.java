package game.offices;

import game.Player;
import game.utils.EmptyBalanceException;
import game.utils.WriterReader;

public class Shop {
    private final double improvementCoeff;
    private final double compensationCoeff;
    private WriterReader writerReader;

    private Player owner;
    private double K;
    private int N;

    public Shop(double improvementCoeff, double compensationCoeff, int N, double K, WriterReader writerReader) {
        this.improvementCoeff = improvementCoeff;
        this.compensationCoeff = compensationCoeff;
        this.writerReader = writerReader;
    }


    public void process(Player visitor) throws EmptyBalanceException {
        if (owner == null) {
            tryBuyShop(visitor);
        } else {
            if (owner == visitor) {
                processOwner();
            } else {
                processCustomer(visitor);
            }
        }
    }

    public void tryBuyShop(Player visitor) throws EmptyBalanceException{
        // работа со сканером.

        buyShop(visitor);
    }

    public void buyShop(Player buyer) throws EmptyBalanceException {
        buyer.reduceBalance(N);
        owner = buyer;
    }

    public void processOwner() {
        tryUpgradeShop();
    }

    public void processCustomer(Player customer) throws EmptyBalanceException {
        customer.reduceBalance(K);
    }

    public void tryUpgradeShop() {
        // работа со сканером.

        upgradeShop();
    }

    public void upgradeShop() {
        increaseValue();
        increaseCompensation();
    }

    public void increaseValue() {
        N += improvementCoeff * N;
    }

    public void increaseCompensation() {
        K += compensationCoeff * K;
    }

}
