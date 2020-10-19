package game;

import game.map.Map;

public class Player {
    private double balance;
    private double spentMoney;
    private boolean isBot;

    private Map map;
    private int curIndexOnMap;

    public void changePosition(int steps) {
        curIndexOnMap = map.getNextIndex(curIndexOnMap, steps);
    }

    public double getBalance() {
        return balance;
    }

    public int getIndexOnMap() {
        return curIndexOnMap;
    }

    public void reduceBalance(double amount) {

    }

    public void increaseBalance(double amount) {

    }

    public double getSpentMoney() {
        return spentMoney;
    }

    public boolean isBot() {
        return isBot;
    }
}
