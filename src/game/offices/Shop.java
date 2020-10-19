package game.offices;

import game.Player;

public class Shop {
    private final int improvementCoeff;
    private final int compensationCoeff;

    private Player owner;
    private int compensation;
    private int value;

//    public Shop(int improvementCoeff, int compensationCoeff) {
//        this.improvementCoeff = improvementCoeff;
//        this.compensationCoeff = compensationCoeff;
//    }

    public void process(Player visitor) {
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

    public void tryBuyShop(Player visitor) {
        // работа со сканером.

        buyShop(visitor);
    }

    public void buyShop(Player buyer) {
        buyer.reduceBalance(value);
        owner = buyer;
    }

    public void processOwner() {
        tryUpgradeShop();
    }

    public void processCustomer(Player customer) {
        customer.reduceBalance(compensation);
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
        value += improvementCoeff * value;
    }

    public void increaseCompensation() {
        compensation += compensationCoeff * compensation;
    }

}
