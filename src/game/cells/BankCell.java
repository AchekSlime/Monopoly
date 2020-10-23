package game.cells;

import game.map.Position;
import game.offices.Bank;
import game.Player;
import game.utils.EmptyBalanceException;

public class BankCell extends EmptyCell implements Cell {
    private final Bank gameBank;

    public BankCell(Bank gameBank) {
        this.gameBank = gameBank;
        symbol = "$";
        fullName = "Bank";
    }

    @Override
    public void onCellEvent(Player player) throws EmptyBalanceException {
        if (!player.isBot()) {
            gameBank.process(player);
        }
    }

    @Override
    public String getMessage() {
        return null;
    }

    @Override
    public String helloMessage() {
        return null;
    }
}
