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
        boolean turnoTerminado = false;

        System.out.println("Turno de " + jugador.getNombre());

        // Reiniciar filas al inicio del turno
        jugador.reiniciarFilas();

        while (!turnoTerminado && !mazo.estaVacio()) {
            System.out.println("Opciones:\n1 - Robar carta\n2 - Asegurar cartas y pasar turno");

            int eleccion = scanner.nextInt();

            if (eleccion == 1) {
                Carta cartaRobada = mazo.robarCarta();
                if (cartaRobada != null) {
                    System.out.println("Carta robada: " + cartaRobada);
                    if (!colocarCartaEnFila(jugador, cartaRobada)) {
                        System.out.println("No puedes colocar la carta. Lanzarás el dado y perderás tu turno.");
                        jugador.lanzarDado(); // Lanzar dado si corresponde
                        String colorSalido = jugador.getColorLanzado(); // Obtener el color salido
                        System.out.println("El color que salió en el dado es: " + colorSalido);
                        jugador.mostrarBotin(); // Mostrar nuevo botín
                        turnoTerminado = true; // Terminar turno
                    }
                } else {
                    turnoTerminado = true;
                }
            } else if (eleccion == 2) {
                jugador.asegurarCartas();
                jugador.mostrarBotin();
                jugador.lanzarDado(); // Lanzar dado si corresponde
                turnoTerminado = true;
            }
        }
    }



    private boolean colocarCartaEnFila(Jugador jugador, Carta carta) {
        System.out.println("Fila 1: " + jugador.getFila(1));
        System.out.println("Fila 2: " + jugador.getFila(2));
        System.out.println("Fila 3: " + jugador.getFila(3));
        System.out.print("En qué fila colocas la " + carta + " [1-3]? ");

        int numFila = scanner.nextInt();
        if (!jugador.agregarCartaAFila(carta, numFila)) {
            return false; // No se puede colocar la carta en ninguna fila
        }

        return true; // Se pudo colocar la carta
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
            System.out.println("El ganador es " + ganador.getNombre() + " con " + mayorPuntaje + " puntos.");
        } else {
            System.out.println("Hubo un empate.");
        }
    }
}
