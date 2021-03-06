package game.cells;

import game.utils.MyRandom;
import game.Player;

public class TaxiCell extends EmptyCell implements Cell {
    private final MyRandom rnd = new MyRandom();

    private static final int MIN_STEPS = 3;
    private static final int MAX_STEPS = 5;

    private int steps;

    public TaxiCell() {
        symbol = "T";
        fullName = "Taxi";
    }


    @Override
    public void onCellEvent(Player player) {
        generateSteps();
        player.changePosition(steps);
    }

    public void generateSteps() {
        steps = rnd.nextInt(MIN_STEPS, MAX_STEPS);
    }

    @Override
    public String getMessage() {
        return "You are shifted forward by " + steps + " cells";
    }

    @Override
    public String helloMessage() {
        return null;
    }

}
