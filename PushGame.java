import java.util.List;
import java.util.ArrayList;

public class PushGame {
    private Pile pile;
    private List<Player> players;
    private Player currentPlayer;
    private int currentPlayerIndex;

    public PushGame(int numberOfPlayers) {
        pile = new Pile();
        players = new ArrayList<>();
        for (int i = 0; i < numberOfPlayers; i++) {
            players.add(new Player());
        }
        currentPlayerIndex = 0;
        currentPlayer = players.get(currentPlayerIndex);
    }

    public void nextTurn() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        currentPlayer = players.get(currentPlayerIndex);
    }

    public void handleDiceCard(Player player) {
        Dice dice = new Dice();
        String result = dice.roll();
        if (!result.equals("BLACK")) {
            player.addToAccumulatedPool(new Card(0, result, false)); // Agregar una carta de dado ficticia
        }
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Pile getPile() {
        return pile;
    }
}
