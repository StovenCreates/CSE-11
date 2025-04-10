import java.awt.Color;

public class Lion extends Feline {
    private int moveCount;
    private int fightWins;
    private boolean isHungry;
    private boolean isSleeping;

    public Lion() {
        this.displayName = "Lion";
        moveCount = 0;
        fightWins = 0;
        isHungry = false;
        isSleeping = false;
    }

    @Override
    public Color getColor() {
        return Color.YELLOW;
    }

    @Override
    public Direction getMove() {
        moveCount++;
        if (moveCount <= 5) {
            return Direction.EAST;
        }
        else if (moveCount <= 10) {
            return Direction.SOUTH;
        }
        else if (moveCount <= 15) {
            return Direction.WEST;
        }
        else if (moveCount <= 20) {
            return Direction.NORTH;
        }
        else {
            moveCount = 0;
            return Direction.EAST;
        }
    }

    @Override
    public boolean eat() {
        if (isHungry) {
            isHungry = false;
            return true;
        }
        return false;
    }

    @Override
    public void sleep() {
        fightWins = 0;
        isSleeping = true;
        isHungry = false;
    }

    @Override
    public void wakeup() {
        isSleeping = false;
        isHungry = true;
    }

    @Override
    public void win() {
        fightWins++;
        if (!isSleeping) {
            isHungry = true;
        }
    }
}
