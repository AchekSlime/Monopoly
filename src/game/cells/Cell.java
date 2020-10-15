package game.cells;

import game.Player;

public interface Cell {
    public void onCellEvent(Player player);
    public String getMessage();

}
