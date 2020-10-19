package game;

import game.cells.Cell;
import game.map.Map;
import game.utils.WriterReader;
import java.util.List;


public class Factory {
    public final static WriterReader console = new WriterReader(System.in, System.out);

    private static final int MIN_WIDTH = 6;
    private static final int MAX_WIDTH = 30;
    private static final int MIN_HEIGHT = 6;
    private static final int MAX_HEIGHT = 30;

    public static Map initMap() {
        do {
            try {
                return new Map(getWidth(), getHeight());
            } catch (NumberFormatException ex) {
                console.writeln("Invalid number format, please try again");
            }
        } while (true);
    }

    private static int getWidth() throws NumberFormatException {
        int width = 0;
        console.writeln("Enter width (6 - 30)");
        width = Integer.parseInt(console.read());

        if (width < MIN_WIDTH || width > MAX_WIDTH)
            throw new NumberFormatException();

        return width;
    }

    private static int getHeight() throws NumberFormatException {
        int height = 0;
        console.writeln("Enter height (6 - 30)");
        height = Integer.parseInt(console.read());

        if (height < MIN_HEIGHT || height > MAX_HEIGHT)
            throw new NumberFormatException();

        return height;
    }



//    public void printMap(List<Cell> field, int width, int height){
//        int rightTopCorner = width - 1;
//        int rightBotCorner = rightTopCorner + height - 1;
//        int leftBotCorner = rightBotCorner + width - 1;
//        int oneRound = leftBotCorner + height - 1;
//
//        for (int i = 0; i < width; ++i) {
//            console.write(field.get(i).toString());
//            if (i < (width - 1)) {
//                console.write("  ");
//            }
//        }
//
//        console.writeln("");
//
//        for (int i = 0; i < height - 2; ++i) {
//            console.write(field.get(oneRound - 1 - i).toString());
//            console.write((" ").repeat(width * 3 - 4));
//            console.write(field.get(rightTopCorner + 1 + i).toString());
//            console.writeln("");
//        }
//
//        for (int i = 0; i < width; ++i) {
//            console.write(field.get(leftBotCorner - i).toString());
//            if (i < (width - 1)) {
//                console.write("  ");
//            }
//        }
//    }
}
