package game.cells;

import game.Player;
import game.map.Position;

public class PenaltyCell extends EmptyCell implements Cell {
    private int penaltyCoeff;

    public void PenaltyCell(int penaltyCoeff){
        this.penaltyCoeff = penaltyCoeff;
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
