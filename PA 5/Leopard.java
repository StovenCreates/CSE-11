import java.awt.Color;
import java.util.Random;

public class Leopard extends Feline {
    protected static int confidence = 0;

    public Leopard() {
        this.displayName = "Lpd";
    }

    @Override
    public Color getColor() {
        return Color.RED;
    }

    @Override
    public Direction getMove() {
        Direction[] directions = {Direction.NORTH, Direction.SOUTH, Direction.EAST, Direction.WEST};
        return directions[new Random().nextInt(directions.length)];
    }

    @Override
    public boolean eat() {
        return new Random().nextInt(100) < (confidence * 10);
    }

    @Override
    public void win() {
        if (confidence < 10) {
            confidence++;
        }
    }

    @Override
    public void lose() {
        if (confidence > 0) {
            confidence--;
        }
    }

    @Override
    public Attack getAttack(String opponent) {
        if (opponent.equals("Tu") || confidence > 5) {
            return Attack.POUNCE;
        }
        else {
            return generateAttack(opponent);
        }
    }

    protected Attack generateAttack(String opponent) {
        Attack[] attacks = {Attack.ROAR, Attack.POUNCE, Attack.SCRATCH};
        return attacks[new Random().nextInt(attacks.length)];
    }

    @Override
    public void reset() {
        confidence = 0;
    }
}
