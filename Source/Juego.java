import java.util.ArrayList;
import java.util.Scanner;

public class Juego {
    private ArrayList<Jugador> jugadores;
    private Mazo mazo;
    private Scanner scanner;

    public Juego() {
        jugadores = new ArrayList<>();
        mazo = new Mazo();
        scanner = new Scanner(System.in);
    }

    public void iniciarJuego() {
        System.out.print("Ingrese cantidad de jugadores (2-6): ");
        int cantidadJugadores = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        for (int i = 1; i <= cantidadJugadores; i++) {
            System.out.print("Nombre Jugador " + i + ": ");
            String nombre = scanner.nextLine();
            jugadores.add(new Jugador(nombre));
        }

        System.out.println("Comienza el juego");
        while (!mazo.estaVacio()) { // Verificar si el mazo está vacío
            for (Jugador jugador : jugadores) {
                jugarTurno(jugador);
            }
        }

        finalizarJuego();
    }

    private void jugarTurno(Jugador jugador) {
        System.out.println("Turno de " + jugador.getNombre());
        System.out.println("Opciones:\n1 - Robar carta\n2 - Asegurar cartas y pasar turno");

        int eleccion = scanner.nextInt();
        if (eleccion == 1) {
            Carta cartaRobada = mazo.robarCarta();
            if (cartaRobada != null) {
                System.out.println("Carta robada: " + cartaRobada);
                colocarCartaEnFila(jugador, cartaRobada);
            }
        } else if (eleccion == 2) {
            jugador.asegurarCartas();
            jugador.mostrarBotin();
            jugador.lanzarDado();
        }
    }

    private void colocarCartaEnFila(Jugador jugador, Carta carta) {
        System.out.println("Fila 1: " + jugador.getFila(1));
        System.out.println("Fila 2: " + jugador.getFila(2));
        System.out.println("Fila 3: " + jugador.getFila(3));
        System.out.print("En qué fila colocas la " + carta + " [1-3]? ");

        int numFila = scanner.nextInt();
        if (!jugador.agregarCartaAFila(carta, numFila)) {
            System.out.println("No se puede colocar la carta en ninguna fila. Tirar dado y pasar de turno.");
            jugador.lanzarDado();
        }
    }

    private void finalizarJuego() {
        System.out.println("Fin del juego");

        Jugador ganador = null;
        int mayorPuntaje = 0;

        for (Jugador jugador : jugadores) {
            int puntos = jugador.calcularPuntos();
            System.out.println("El botín de " + jugador.getNombre() + " tiene: " + puntos + " puntos.");
            if (puntos > mayorPuntaje) {
                mayorPuntaje = puntos;
                ganador = jugador;
            }
        }

        if (ganador != null) {
            System.out.println("¡Ganó " + ganador.getNombre() + " con " + mayorPuntaje + " puntos!");
        }
    }

    public static void main(String[] args) {
        Juego juego = new Juego();
        juego.iniciarJuego();
    }
}