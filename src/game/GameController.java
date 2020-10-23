package game;

import game.utils.EmptyBalanceException;

public class GameController {

    public static void main(String[] args) {

        // Написано грубо только для тестирования.
        Game game = new Game();
    
        try{
            game.Play();
        }
        catch (EmptyBalanceException ex){
            Printer.console.writeln("Игра окончена");
        }
    }
}
