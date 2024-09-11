import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Pile {
    ArrayList<Card> cards;

    public Pile() {
        cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public int calculatePoints() {
        int points = 0;
        for (Card card : cards) {
            points += card.value;
        }
        return points;
    }

    public boolean canAddCard(Card card) {
        for (Card c : cards) {
            if (c.color.equals(card.color)) {
                return false;
            }
        }
        return true;
    }

    public void clearPile() {
        cards.clear();
    }

    public String toString() {
        return cards.toString();
    }
}
