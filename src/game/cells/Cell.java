package game.cells;

import game.Player;
import game.map.Position;
import game.utils.EmptyBalanceException;

public interface Cell {
    void onCellEvent(Player player) throws EmptyBalanceException;

    Position getPosition();

    void setPosition(Position posion);

    String getMessage();

    String helloMessage();

    String getFullName();
}
