import java.awt.Color;
import java.util.Random;

public class CustomCritter extends Critter {
    private int moveCount;
    private boolean hungry;

    public CustomCritter() {
        super("Zeb");
        moveCount = 0;
        hungry = false;
    }

    @Override
    public Color getColor() {
        return Color.BLACK;
    }

    @Override
    public Direction getMove() {
        moveCount++;
        Random rand = new Random();

        if (moveCount < 10) {
            Direction[] directions = {Direction.NORTH, Direction.SOUTH, Direction.EAST, Direction.WEST};
            return directions[rand.nextInt(directions.length)];
        } else {
            moveCount = 0;
            return Direction.CENTER;
        }
    }

    @Override
    public boolean eat() {
        hungry = !hungry;
        return hungry;
    }

    @Override
    public Attack getAttack(String opponent) {
        if (opponent.equals("Raccoon")) {
            return Attack.ROAR;
        } else {
            Random rand = new Random();
            Attack[] attacks = {Attack.POUNCE, Attack.SCRATCH, Attack.ROAR};
            return attacks[rand.nextInt(attacks.length)];
        }
    }
}
