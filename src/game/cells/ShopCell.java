package game.cells;

import game.Player;
import game.map.Position;
import game.offices.Shop;

public class ShopCell extends EmptyCell implements Cell{
    private final Shop localShop;

    public ShopCell(Shop shop){
        localShop = shop;
        symbol = "S";
    }

    @Override
    public void onCellEvent(Player player) {
        localShop.process(player);
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
