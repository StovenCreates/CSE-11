import java.awt.Color;

public class Elephant extends Critter {
    protected static int goalX = 0;
    protected static int goalY = 0;

    public Elephant() {
        super("El");
        goalX = 0;
        goalY = 0;
    }

    @Override
    public Color getColor() {
        return Color.GRAY;
    }

    @Override
    public Direction getMove() {
        if (info.getX() == goalX && info.getY() == goalY) {
            goalX = random.nextInt(60);
            goalY = random.nextInt(50);
        }

        if (Math.abs(info.getX() - goalX) > Math.abs(info.getY() - goalY)) {
            return info.getX() > goalX ? Direction.WEST : Direction.EAST;
        }
        else {
            return info.getY() > goalY ? Direction.NORTH : Direction.SOUTH;
        }
    }

    @Override
    public boolean eat() {
        return true;
    }

    @Override
    public void mate() {
        level += 2;
    }

    @Override
    public void reset() {
        goalX = 0;
        goalY = 0;
    }
}
