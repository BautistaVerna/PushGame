import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Crear jugadores
        Scanner scanner = new Scanner(System.in);
        List<Jugador> jugadores = new ArrayList<>();

        System.out.println("Ingrese el número de jugadores (2-6): ");
        int numJugadores = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        for (int i = 0; i < numJugadores; i++) {
            System.out.println("Ingrese el nombre del jugador " + (i + 1) + ": ");
            String nombre = scanner.nextLine();
            jugadores.add(new Jugador(nombre));
        }

        // Crear el juego
        Juego juego = new Juego(jugadores);

        // Iniciar el juego
        juego.iniciar();

        // Cerrar scanner
        scanner.close();
    }
}