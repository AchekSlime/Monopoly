package game.cells;

import game.Player;
import game.map.Position;

public interface Cell {
    public void onCellEvent(Player player);

    public Position getPosition();

    public String getMessage();

    public String helloMessage();
}
