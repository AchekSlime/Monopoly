package game.cells;

import game.Player;
import game.map.Position;
import game.utils.EmptyBalanceException;

public class EmptyCell implements Cell{
    protected Position onMapPosition;
    protected String symbol = "E";
    protected String fullName = "Empty";

    @Override
    public void onCellEvent(Player player) throws EmptyBalanceException {

    }

    @Override
    public Position getPosition() {
        return onMapPosition;
    }

    @Override
    public void setPosition(Position position) {
        onMapPosition = position;
    }

    @Override
    public String getMessage() {
        return "Just relax there";
    }

    @Override
    public String helloMessage() {
        return "Hello, world!";
    }

    @Override
    public String getFullName() {
        return fullName + "Cell";
    }

    @Override
    public String toString() {
        return symbol;
    }
}
