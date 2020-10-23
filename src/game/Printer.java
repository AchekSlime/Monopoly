package game;

import game.cells.Cell;
import game.map.Map;
import game.map.Position;
import game.offices.Bank;
import game.utils.WriterReader;

import java.util.List;

public class Printer {
    public final static WriterReader console = new WriterReader(System.in, System.out);

    public static void printBankCoeff(double creditCoeff, double debtCoeff) {
        console.write("creditCoeff = ");
        console.writeln(creditCoeff);
        console.write("debtCoeff = ");
        console.writeln(debtCoeff);
    }

    public static void printPenaltyCoeff(double penaltyCoeff) {
        console.write("penaltyCoeff = ");
        console.writeln(penaltyCoeff);
    }

    public static void printMap(List<Cell> field, int width, int height) {
        int rightTopCorner = width - 1;
        int rightBotCorner = rightTopCorner + height - 1;
        int leftBotCorner = rightBotCorner + width - 1;
        int oneRound = leftBotCorner + height - 1;

        for (int i = 0; i < width; ++i) {
            console.write(field.get(i).toString());
            if (i < (width - 1)) {
                console.write("  ");
            }
        }

        console.writeln("");

        for (int i = 0; i < height - 2; ++i) {
            console.write(field.get(oneRound - 1 - i).toString());
            console.write((" ").repeat(width * 3 - 4));
            console.write(field.get(rightTopCorner + 1 + i).toString());
            console.writeln("");
        }

        for (int i = 0; i < width; ++i) {
            console.write(field.get(leftBotCorner - i).toString());
            if (i < (width - 1)) {
                console.write("  ");
            }
        }

        console.writeln("");
    }

    public static void printPlayerInfo(int indexOnMap, double balance, Map map, String prefx) {
        Cell currCell = map.getCellByIndex(indexOnMap);
        console.writeln(prefx + "Position : " + currCell.getPosition().toString());
        console.writeln(prefx + "Cell : " + currCell.getFullName());
        console.write("Balance = ");
        console.writeln(balance);
    }

}
