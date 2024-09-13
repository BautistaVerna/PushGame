import java.util.Collections;
import java.util.Stack;
import java.util.ArrayList;
import java.util.List;

public class Pile {
    private Stack<Card> cards;

    public Pile() {
        cards = new Stack<>();
        initializePile();
    }

    private void initializePile() {
        String[] colors = {"VIOLET", "YELLOW", "RED", "GREEN", "BLUE"};
        for (String color : colors) {
            for (int number = 1; number <= 6; number++) {
                for (int i = 0; i < 3; i++) {
                    cards.add(new Card(number, color, false));
                }
            }
        }
        for (int i = 0; i < 8; i++) {
            cards.add(new Card(0, "DADO", true));
        }
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        return cards.isEmpty() ? null : cards.pop();
    }
}
