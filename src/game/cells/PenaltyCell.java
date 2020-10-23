package game.cells;

import game.Player;
import game.utils.EmptyBalanceException;

public class PenaltyCell extends EmptyCell implements Cell {
    private double penaltyCoeff;

    public PenaltyCell(double penaltyCoeff) {
        this.penaltyCoeff = penaltyCoeff;
        symbol = "%";
        fullName = "penalty";
    }

    @Override
    public void onCellEvent(Player player) throws EmptyBalanceException {
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
