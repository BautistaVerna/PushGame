import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class Player {
    private List<Card> hand;
    private List<List<Card>> columns;
    private Map<String, List<Card>> accumulatedPool;

    public Player() {
        hand = new ArrayList<>();
        columns = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            columns.add(new ArrayList<>());
        }
        accumulatedPool = new HashMap<>();
        for (String color : new String[]{"VIOLET", "YELLOW", "RED", "GREEN", "BLUE"}) {
            accumulatedPool.put(color, new ArrayList<>());
        }
    }

    public void addCardToHand(Card card) {
        hand.add(card);
    }

    public void playCard(Card card, int columnIndex) {
        if (columnIndex < 0 || columnIndex >= columns.size()) {
            throw new IllegalArgumentException("Índice de columna no válido");
        }
        List<Card> column = columns.get(columnIndex);
        for (Card c : column) {
            if (c.getColor().equals(card.getColor()) || c.getNumber() == card.getNumber()) {
                throw new IllegalArgumentException("Ubicación de carta inválida: Color o número ya existe en esta columna.");
            }
        }
        column.add(card);
        hand.remove(card);
    }

    public void addToAccumulatedPool(Card card) {
        List<Card> pool = accumulatedPool.get(card.getColor());
        if (pool != null) {
            pool.add(card);
        }
    }

    public int calculatePoints() {
        int points = 0;
        for (List<Card> column : columns) {
            for (Card card : column) {
                points += card.getNumber();
            }
        }
        for (List<Card> pool : accumulatedPool.values()) {
            for (Card card : pool) {
                points += card.getNumber();
            }
        }
        return points;
    }

    public List<Card> getHand() {
        return hand;
    }

    public List<List<Card>> getColumns() {
        return columns;
    }

    public Map<String, List<Card>> getAccumulatedPool() {
        return accumulatedPool;
    }
}
