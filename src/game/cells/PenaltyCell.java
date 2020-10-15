package game.cells;

import game.Player;

public class PenaltyCell implements Cell {
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
}
