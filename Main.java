import java.util.Scanner;

            public class Main {
                public static void main(String[] args) {
                    Scanner scanner = new Scanner(System.in);

                    // Crear una instancia del juego con el número de jugadores deseado
                    int numberOfPlayers = 2; // Puedes ajustar el número de jugadores según sea necesario
                    PushGame game = new PushGame(numberOfPlayers);

                    // Iniciar la lógica del juego
                    while (true) {
                        Player player = game.getCurrentPlayer();
                        System.out.println("Turno del Jugador " + (game.getPlayers().indexOf(player) + 1));

                        // Recibir una carta
                        Card newCard = game.getPile().drawCard();
                        if (newCard != null) {
                            System.out.println("Carta recibida: " + newCard);
                            player.addCardToHand(newCard);
                        } else {
                            System.out.println("El mazo está vacío. El juego ha terminado.");
                            break;
                        }

                        // Mostrar cartas en mano
                        System.out.println("Cartas en mano:");
                        for (int i = 0; i < player.getHand().size(); i++) {
                            System.out.println(i + ": " + player.getHand().get(i));
                        }

                        // Decidir si tomar otra carta
                        System.out.print("¿Deseas tomar otra carta? (sí/no): ");
                        String response = scanner.nextLine();
                        while (response.equalsIgnoreCase("sí")) {
                            newCard = game.getPile().drawCard();
                            if (newCard != null) {
                                System.out.println("Carta nueva: " + newCard);
                                player.addCardToHand(newCard);
                            } else {
                                System.out.println("El mazo está vacío. No puedes tomar más cartas.");
                                break;
                            }
                            System.out.print("¿Deseas tomar otra carta? (sí/no): ");
                            response = scanner.nextLine();
                        }

                        // Elegir carta y columna
                        System.out.print("Elige el índice de la carta para jugar: ");
                        int cardIndex = Integer.parseInt(scanner.nextLine());
                        Card chosenCard = player.getHand().get(cardIndex);

                        // Mostrar columnas disponibles
                        System.out.println("Elige la columna (0-2) donde colocar la carta: ");
                        int columnIndex = Integer.parseInt(scanner.nextLine());

                        try {
                            player.playCard(chosenCard, columnIndex);
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                            game.handleDiceCard(player); // Lanzar el dado en caso de incumplimiento
                        }

                        // Mostrar estado final de las columnas después de jugar
                        System.out.println("Estado de las columnas:");
                        for (int i = 0; i < player.getColumns().size(); i++) {
                            System.out.println("Columna " + i + ": " + player.getColumns().get(i));
                        }

                        // Fin del turno
                        game.nextTurn();
                    }

                    // Final del juego, calcular y mostrar puntuaciones
                    for (int i = 0; i < game.getPlayers().size(); i++) {
                        Player p = game.getPlayers().get(i);
                        System.out.println("Jugador " + (i + 1) + " ha obtenido " + p.calculatePoints() + " puntos.");
                    }
                }
            }
