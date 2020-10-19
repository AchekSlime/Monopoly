package game.cells;

import game.Player;
import game.map.Position;

public class PenaltyCell extends EmptyCell implements Cell {
    private double penaltyCoeff;

    public PenaltyCell(double penaltyCoeff) {
        this.penaltyCoeff = penaltyCoeff;
        symbol = "%";
    }

    @Override
    public void onCellEvent(Player player) {
        player.reduceBalance(penaltyCoeff * player.getBalance());
    }

    @Override
    public String getMessage() {
        return "";
    }

    @Override
    public String helloMessage() {
        return null;
    }
}
