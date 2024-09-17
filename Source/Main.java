//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        // Crear jugadores
//        Scanner scanner = new Scanner(System.in);
//        List<Jugador> jugadores = new ArrayList<>();
//
//        System.out.println("Ingrese el número de jugadores (2-6): ");
//        int numJugadores = scanner.nextInt();
//        scanner.nextLine(); // Limpiar buffer
//
//        for (int i = 0; i < numJugadores; i++) {
//            System.out.println("Ingrese el nombre del jugador " + (i + 1) + ": ");
//            String nombre = scanner.nextLine();
//            jugadores.add(new Jugador(nombre));
//        }
//
//        // Crear el juego
//        Juego juego = new Juego(jugadores);
//
//        // Iniciar el juego
//        juego.iniciar();
//
//        // Cerrar scanner
//        scanner.close();
//    }
//}


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear jugadores con validación
        List<Jugador> jugadores = crearJugadores(scanner);

        // Crear y empezar el juego
        Juego juego = new Juego(jugadores);
        juego.iniciar();

        // Cerrar el scanner al final
        scanner.close();
    }

    // Método para crear jugadores con validaciones
    private static List<Jugador> crearJugadores(Scanner scanner) {
        List<Jugador> jugadores = new ArrayList<>();
        int numJugadores = 0;

        // Validar el número de jugadores (debe estar entre 2 y 6)
        while (numJugadores < 2 || numJugadores > 6) {
            System.out.println("Ingrese el número de jugadores (2-6): ");
            try {
                numJugadores = scanner.nextInt();
                if (numJugadores < 2 || numJugadores > 6) {
                    System.out.println("Número de jugadores no válido. Debe ser entre 2 y 6.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.next(); // Limpiar la entrada inválida
            }
        }
        scanner.nextLine(); // Limpiar el buffer de entrada

        // Pedir el nombre de cada jugador
        for (int i = 0; i < numJugadores; i++) {
            System.out.print("Ingrese el nombre del jugador " + (i + 1) + ": ");
            String nombre = scanner.nextLine().trim();

            // Validar que el nombre no esté vacío
            while (nombre.isEmpty()) {
                System.out.println("El nombre no puede estar vacío. Ingrese un nombre válido:");
                nombre = scanner.nextLine().trim();
            }

            jugadores.add(new Jugador(nombre));
        }

        System.out.println("¡Jugadores listos! Comienza el juego.");
        return jugadores;
    }
}
