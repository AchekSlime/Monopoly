package game.cells;

import game.MyRandom;
import game.Player;

public class TaxiCell implements Cell {
    private final MyRandom rnd = new MyRandom();

    private static final int MIN_STEPS = 3;
    private static final int MAX_STEPS = 5;

    private int steps;

    @Override
    public void onCellEvent(Player player) {
        generateSteps();
        player.changePosition(steps);
    }

    public void generateSteps(){
        steps = rnd.nextInt(MIN_STEPS, MAX_STEPS);
    }

    @Override
    public String getMessage() {
        return String.format("You are shifted forward by %d cells", steps);
    }


}
