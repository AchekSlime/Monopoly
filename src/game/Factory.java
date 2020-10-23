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
}
