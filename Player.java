import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Player {
    String name;
    Pile pile;
    int totalPoints;

    public Player(String name) {
        this.name = name;
        this.pile = new Pile();
        this.totalPoints = 0;
    }

    public void addCardToPile(Card card) {
        pile.addCard(card);
    }

    public void endTurn() {
        totalPoints += pile.calculatePoints();
        pile.clearPile();
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public String toString() {
        return name + " - Puntos: " + totalPoints;
    }
}
