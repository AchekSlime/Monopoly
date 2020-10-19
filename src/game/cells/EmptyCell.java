package game.cells;

import game.Player;
import game.map.Position;

public class EmptyCell implements Cell{
    protected Position onMapPosition;
    protected String symbol = "E";

    @Override
    public void onCellEvent(Player player) {

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
    public String toString() {
        return symbol;
    }
}
