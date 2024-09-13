import java.util.Random;

public class Dice {
    private Random random;

    public Dice() {
        random = new Random();
    }

    public String roll() {
        int result = random.nextInt(6);
        switch (result) {
            case 0: return "VIOLET";
            case 1: return "YELLOW";
            case 2: return "RED";
            case 3: return "GREEN";
            case 4: return "BLUE";
            default: return "BLACK";
        }
    }
}
