package game;

import java.util.Random;

public class MyRandom extends Random {
    public int nextInt(int leftBound, int rightBound){
        return leftBound + super.nextInt(rightBound - leftBound + 1);
    }
}
