import java.util.Random;

public class Feline extends Critter {
    private int moveCount; // counter for getMove method before random direction
    private int eatCount; // counter for eating
    private Direction currDir; // current direction

    public Feline() {
        super("Fe");
        moveCount = 0;
        eatCount = 0;
        currDir = null;
    }
    
    

    @Override
    public Direction getMove() {
    moveCount++;

    if (moveCount % 5 == 0) {
        Direction[] directions = {Direction.NORTH, Direction.SOUTH, Direction.EAST, Direction.WEST};
        currDir = directions[new Random().nextInt(directions.length)];
    }
    
    return currDir;
}
    
    @Override
    public boolean eat() {
        eatCount++;
        return eatCount % 3 == 0;
    }


    @Override
    public Attack getAttack(String opponent) {
        return Attack.POUNCE;
}

}