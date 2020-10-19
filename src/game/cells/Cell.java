package game.cells;

import game.Player;
import game.map.Position;

public interface Cell {
    void onCellEvent(Player player);

    Position getPosition();

    void setPosition(Position posion);

    String getMessage();

    String helloMessage();
}
