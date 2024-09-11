import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class PushGame {
    ArrayList<Player> players;
    Random random;
    String[] colors = {"Rojo", "Azul", "Verde", "Amarillo"};

    public PushGame(int numberOfPlayers) {
        players = new ArrayList<>();
        random = new Random();
        for (int i = 1; i <= numberOfPlayers; i++) {
            players.add(new Player("Jugador " + i));
        }
    }

    public Card drawCard() {
        String color = colors[random.nextInt(colors.length)];
        int value = random.nextInt(10) + 1;
        return new Card(color, value);
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        boolean gameEnd = false;

        while (!gameEnd) {
            for (Player player : players) {
                System.out.println(player.name + "'s turno:");
                boolean turnEnd = false;

                while (!turnEnd) {
                    Card card = drawCard();
                    System.out.println("Carta extraída: " + card);

                    if (player.pile.canAddCard(card)) {
                        player.addCardToPile(card);
                        System.out.println("Pila actual: " + player.pile);

                        System.out.print("¿Quieres seguir sacando cartas? (s/n): ");
                        String choice = scanner.nextLine();

                        if (choice.equalsIgnoreCase("n")) {
                            player.endTurn();
                            turnEnd = true;
                        }
                    } else {
                        System.out.println("No se puede agregar la carta. Pierdes todas las cartas de esta ronda.");
                        player.pile.clearPile();
                        turnEnd = true;
                    }
                }

                System.out.println(player);
            }

            System.out.print("¿El juego ha terminado? (s/n): ");
            String gameChoice = scanner.nextLine();
            if (gameChoice.equalsIgnoreCase("s")) {
                gameEnd = true;
            }
        }

        Player winner = players.get(0);
        for (Player player : players) {
            if (player.getTotalPoints() > winner.getTotalPoints()) {
                winner = player;
            }
        }

        System.out.println("¡El ganador es " + winner.name + " con " + winner.getTotalPoints() + " puntos!");
        scanner.close();
    }
}
