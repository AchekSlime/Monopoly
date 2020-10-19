package game.map;

import game.Factory;
import game.utils.MyRandom;
import game.cells.*;
import game.offices.Bank;
import game.offices.Shop;
import game.utils.WriterReader;

import java.util.ArrayList;
import java.util.List;

public class Map {
    private final MyRandom rnd = new MyRandom();

    private final int width;
    private final int height;
    private final int oneRound;
    private final List<Cell> field;

    private int rightTopCorner;
    private int rightBotCorner;
    private int leftTopCorner;
    private int leftBotCorner;

    private Bank bank;
    private double penaltyCoeff;

    private int penaltyCount = 2;
    private int taxiCount = 2;

    private final WriterReader writerReader;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;

        oneRound = width * 2 + (height - 2) * 2;
        field = new ArrayList<>(oneRound);

        this.writerReader = Factory.console;

        initBank();
        initPenaltyCoeff();

        initCorners();
        initField();
    }

    public void initBank() {
        double creditCoeff = rnd.nextDouble(0.002, 0.2);
        double debtCoeff = rnd.nextDouble(1.0, 3.0);

        bank = new Bank(creditCoeff, debtCoeff, writerReader);
    }

    private void initPenaltyCoeff() {
        penaltyCoeff = rnd.nextDouble(0.01, 0.1);
    }

    private void initCorners() {
        leftTopCorner = 0;
        rightTopCorner = width - 1;
        rightBotCorner = rightTopCorner + height - 1;
        leftBotCorner = rightBotCorner + width - 1;
    }

    public void initField() {
        setEmptyCells();
        setBankCells();

        initRow(leftTopCorner);
        initRow(rightBotCorner);

        initColumn(rightTopCorner);
        initColumn(leftBotCorner);

        initCellsPositions();
    }

    public void setEmptyCells() {
        for(int i = 0; i < oneRound; ++i){
            field.add(new EmptyCell());
        }
    }

    private void setBankCells() {
        field.set(rnd.nextInt(leftTopCorner + 1, rightTopCorner - 1), new BankCell(bank));
        field.set(rnd.nextInt(rightTopCorner + 1, rightBotCorner - 1), new BankCell(bank));
        field.set(rnd.nextInt(rightBotCorner + 1, leftBotCorner - 1), new BankCell(bank));
        field.set(rnd.nextInt(leftBotCorner + 1, oneRound - 1), new BankCell(bank));
    }

    private void initRow(int corner){
        setTaxiAndPenaltyCountsBack();
        for (int i = 1; i < width - 1; ++i) {
            fillCell(corner + i);
        }
    }

    private void initColumn(int corner){
        setTaxiAndPenaltyCountsBack();
        for (int i = 1; i < height - 1; ++i) {
            fillCell(corner + i);
        }
    }

    private void setTaxiAndPenaltyCountsBack(){
        penaltyCount = 2;
        taxiCount = 2;
    }

    private void fillCell(int index) {
        if (field.get(index).getClass() == EmptyCell.class) {
            if (rnd.nextInt(0, 1) == 1 && penaltyCount > 0) {
                field.set(index, new PenaltyCell(penaltyCoeff));
                penaltyCount--;
            } else if (rnd.nextInt(0, 1) == 1 && taxiCount > 0) {
                field.set(index, new TaxiCell());
                taxiCount--;
            } else {
                field.set(index, new ShopCell(createShop()));
            }
        }
    }

    private void initCellsPositions() {
        for (int i = 0; i < width; ++i) {
            field.get(leftTopCorner + i).setPosition(new Position(i, 0));
            field.get(rightBotCorner + i).setPosition(new Position(i, height - 1));
        }
        for (int i = 0; i < height - 1; ++i) {
            field.get(rightTopCorner + i).setPosition(new Position(width - 1, i));
            field.get(leftBotCorner + i).setPosition(new Position(0, height - i - 1));
        }
    }

    public Shop createShop() {
        double improvementCoeff = rnd.nextDouble(0.1, 2);
        double compensationCoeff = rnd.nextDouble(0.1, 1);
        int N = rnd.nextInt(50, 500);
        double K = rnd.nextDouble(0.5 * N, 0.9 * N);

        return new Shop(improvementCoeff, compensationCoeff, N, K, writerReader);
    }

    public int getNextIndex(int oldIndex, int steps) {
        return (oldIndex + steps) % oneRound;
    }

    public Cell getCellByIndex(int curIndex) {
        return field.get(curIndex);
    }

    public void printMap() {
        for (int i = 0; i < width; ++i) {
            writerReader.write(field.get(i).toString());
            if (i < (width - 1)) {
                writerReader.write("  ");
            }
        }

        writerReader.writeln("");

        for (int i = 0; i < height - 2; ++i) {
            writerReader.write(field.get(oneRound - 1 - i).toString());
            writerReader.write((" ").repeat(width * 3 - 4));
            writerReader.write(field.get(rightTopCorner + 1 + i).toString());
            writerReader.writeln("");
        }

        for (int i = 0; i < width; ++i) {
            writerReader.write(field.get(leftBotCorner - i).toString());
            if (i < (width - 1)) {
                writerReader.write("  ");
            }
        }

    }


}
