package game.cells;

import game.Player;

public class EmptyCell implements Cell{

    @Override
    public void onCellEvent(Player player) {

    }

    @Override
    public String getMessage() {
        return "Just relax there";
    }
}
