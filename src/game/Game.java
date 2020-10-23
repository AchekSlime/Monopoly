package game;

import game.cells.Cell;
import game.map.Map;
import game.utils.EmptyBalanceException;
import game.utils.MyRandom;
import game.utils.WriterReader;

public class Game {

    private final MyRandom rnd = new MyRandom();
    private static final WriterReader console = new WriterReader(System.in, System.out);

    private final Map map;
    private final Player player;
    private final Player bot;

    public Game() {
        map = Factory.initMap();

        console.writeln("Enter startBalance");
        int startBalance = Integer.parseInt(Factory.console.read());

        player = new Player(startBalance, false);
        bot = new Player(startBalance, true);

        map.printMap();
        map.printCoeffs();
    }


    // Не дописал функцию.
    public void Play() throws EmptyBalanceException{
        boolean playerStep = rnd.nextBoolean();
        Player currPlayer;

        do {
            currPlayer = playerStep ? player : bot;
            nextStep(currPlayer);
        } while (true);
    }


    public void nextStep(Player currentPLayer) throws EmptyBalanceException {
        currentPLayer.printInfo("old");

        int steps = generateStep();
        currentPLayer.changePosition(steps);


        Cell nextCell = map.getCellByIndex(currentPLayer.getIndexOnMap());
        nextCell.onCellEvent(currentPLayer);

        map.printMap();
        currentPLayer.printInfo("new");
    }

    private int generateStep() {
        int a = rnd.nextInt(1, 6);
        int b = rnd.nextInt(1, 6);
        return a + b;
    }
}
