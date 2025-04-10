import java.awt.Color;
import java.util.Random;

public class Turtle extends Critter {
    public Turtle() {
        super("Tu");
    }

    @Override
    public Color getColor() {
        return Color.GREEN;
    }

    @Override
    public Direction getMove() {
        return Direction.WEST;
    }

    @Override
    public boolean eat() {
        return new Random().nextBoolean();
    }

    @Override
    public Attack getAttack(String opponent) {
        if (new Random().nextBoolean()) {
            return Attack.ROAR;
        }
        else {
            return Attack.FORFEIT;
        }
    }
}
