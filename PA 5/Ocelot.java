import java.awt.Color;

public class Ocelot extends Leopard {
    private int confidence;

    public Ocelot() {
        this.displayName = "Oce";
        this.confidence = 0;
    }

    @Override
    public Color getColor() {
        return Color.LIGHT_GRAY;
    }

    @Override
    protected Attack generateAttack(String opponent) {
        if (confidence > 5 || opponent.equals("Turtle")) {
            return Attack.POUNCE;
        }
        else if (opponent.equals("Lion") || opponent.equals("Feline") || opponent.equals("Leopard")) {
            return Attack.SCRATCH;
        }
        else {
            return Attack.POUNCE;
        }
    }

    public void increaseConfidence(int value) {
        this.confidence += value;
    }

    public void resetConfidence() {
        this.confidence = 0;
    }
}
