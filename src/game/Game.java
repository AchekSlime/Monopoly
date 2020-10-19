package game;

import game.cells.Cell;
import game.map.Map;

public class Game {

    private final MyRandom rnd  = new MyRandom();

    private Map map;
    private final Player player;
    private final Player bot;

    public Game(){
        player = new Player();
        bot = new Player();
        map = new Map(0, 0);
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
