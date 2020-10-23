package game;

import game.map.Map;
import game.utils.EmptyBalanceException;

public class Player {
    private double balance;
    private double spentMoney;
    private boolean isBot;

    private Map map;
    private int curIndexOnMap;

    public Player(int startBalanca, boolean isBot){
        balance = startBalanca;
        this.isBot = isBot;
    }

    public void changePosition(int steps) {
        curIndexOnMap = map.getNextIndex(curIndexOnMap, steps);
    }

    public double getBalance() {
        return balance;
    }

    public int getIndexOnMap() {
        return curIndexOnMap;
    }

    public void reduceBalance(double amount) throws EmptyBalanceException {
        balance -= amount;
        if(balance < 0)
            throw new EmptyBalanceException();
    }

    public void increaseBalance(double amount) {
        balance += amount;
    }

    public double getSpentMoney() {
        return spentMoney;
    }

    public boolean isBot() {
        return isBot;
    }

    public void printInfo(String prefx){
        Printer.printPlayerInfo(curIndexOnMap, balance, map, prefx);
    }
}
