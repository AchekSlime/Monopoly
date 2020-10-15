package game.cells;

import game.Player;
import game.Shop;

public class ShopCell implements Cell{
    private final Shop cellShop;

    public ShopCell(Shop shop){
        cellShop = shop;
    }

    @Override
    public void onCellEvent(Player player) {
        cellShop.process(player);

    }

    @Override
    public String getMessage() {
        return null;
    }
}
