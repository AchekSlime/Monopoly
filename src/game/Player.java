package game;

import game.map.Map;

public class Player {
    private int balance;
    private int spentMoney;
    private boolean isBot;

    private Map map;
    private int curIndexOnMap;

    public void changePosition(int steps) {
        curIndexOnMap = map.getNextIndex(curIndexOnMap, steps);
    }

    public int getBalance() {
        return balance;
    }

    public int getIndexOnMap() {
        return curIndexOnMap;
    }

    public void reduceBalance(int amount) {

    }

    public void increaseBalance(int amount) {

    }

    public int getSpentMoney() {
        return spentMoney;
    }

    public boolean isBot() {
        return isBot;
    }
}
