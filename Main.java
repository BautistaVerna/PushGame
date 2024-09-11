import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el número de jugadores: ");
        int numberOfPlayers = scanner.nextInt();
        scanner.nextLine();  // Consumir la nueva línea

        PushGame game = new PushGame(numberOfPlayers);
        game.play();

        scanner.close();
    }
}