package game.utils;

public class EmptyBalanceException extends Exception{

    public EmptyBalanceException(){
        super();
    }

    public EmptyBalanceException(String message){
        super(message);
    }
}
