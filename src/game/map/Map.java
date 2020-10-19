package game.map;

import game.MyRandom;
import game.Player;
import game.cells.*;
import game.offices.Bank;

import java.util.ArrayList;
import java.util.List;

public class Map {
    private final MyRandom rnd = new MyRandom();

    private int rightTopCorner;
    private int rightBotCorner;
    private int leftTopCorner;
    private int leftBotCorner;

    private List<Cell> field;
    private final int width;
    private final int height;
    private final int oneRound;

    private Bank bank;
    private Bank shop;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        oneRound = width * 2 + (height - 2) * 2;

        fillCorners();

        field = new ArrayList<>(oneRound);

    }

    private void fillCorners() {
        leftTopCorner = 0;
        rightTopCorner = width - 1;
        rightBotCorner = rightTopCorner + height - 1;
        leftBotCorner = rightBotCorner + width - 1;
    }

    public int getNextIndex(int oldIndex, int steps) {
        return (oldIndex + steps) % oneRound;
    }

    public Cell getCellByIndex(int curIndex) {
        return field.get(curIndex);
    }

    public void fillField() {
        setEmptyCells();
        setBankCells();

        int penaltyCount = 2;
        int taxiCount = 2;

        for (int i = 1; i < width - 1; ++i) {
            fillCell(leftTopCorner + i, penaltyCount, taxiCount);
            fillCell(rightBotCorner + i, penaltyCount, taxiCount);
        }
        for (int i = 1; i < height - 1; ++i) {
            fillCell(rightTopCorner + i, penaltyCount, taxiCount);
            fillCell(leftBotCorner + i, penaltyCount, taxiCount);
        }
    }

    public void setEmptyCells() {
        field.set(leftTopCorner, new EmptyCell());
        field.set(rightTopCorner, new EmptyCell());
        field.set(rightBotCorner, new EmptyCell());
        field.set((leftBotCorner, new EmptyCell());
    }

    private void setBankCells() {
        field.set(rnd.nextInt(leftTopCorner + 1, rightTopCorner - 1), new BankCell(bank));
        field.set(rnd.nextInt(rightTopCorner + 1, rightBotCorner - 1), new BankCell(bank));
        field.set(rnd.nextInt(rightBotCorner + 1, leftBotCorner - 1), new BankCell(bank));
        field.set(rnd.nextInt(leftBotCorner + 1, leftTopCorner - 1), new BankCell(bank));
    }

    private void fillCell(int index, int penaltyCount, int taxiCount) {
        if (field.get(index) == null) {
            if (rnd.nextInt(0, 2) == 1 && penaltyCount > 0) {
                field.set(index, new PenaltyCell());
            } else if (rnd.nextInt(0, 2) == 1 && taxiCount > 0) {
                field.set(index, new TaxiCell());
            }
            else{
                field.set(index, new ShopCell());
            }
        }
    }
}
