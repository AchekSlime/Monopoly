package game.cells;

import game.Bank;
import game.Player;

public class BankCell implements Cell{
    private final Bank gameBank;

    public BankCell(Bank gameBank){
        this.gameBank = gameBank;
    }

    @Override
    public void onCellEvent(Player player) {
        if(!player.isBot()){
            gameBank.process(player);
        }
    }

    @Override
    public String getMessage() {
        return null;
    }
}
