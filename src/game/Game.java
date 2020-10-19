package game;

import com.sun.tools.javac.Main;
import game.cells.Cell;
import game.map.Map;
import game.utils.MyRandom;
import game.utils.WriterReader;

public class Game {

    private final MyRandom rnd  = new MyRandom();
    private static final WriterReader console = new WriterReader(System.in, System.out);

    private Map map;
    private final Player player;
    private final Player bot;

    public static void main(String[] args){
        Map map = new Map(20, 10, console);
        map.printMap();
    }

    public Game(){
        player = new Player();
        bot = new Player();
        map = new Map(0, 0, console);
    }

    public void nextStep(Player currentPLayer){
        int steps = generateStep();
        currentPLayer.changePosition(steps);

        Cell nextCell = map.getCellByIndex(currentPLayer.getIndexOnMap());
        nextCell.onCellEvent(currentPLayer);
    }

    private int generateStep() {
        int a = rnd.nextInt(1, 6);
        int b = rnd.nextInt(1, 6);
        return a + b;
    }
}
