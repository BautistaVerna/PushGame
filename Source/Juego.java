import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Juego {
    private Mazo mazo;
    private List<Jugador> jugadores;
    private boolean cambioSentido;

    public Juego(List<Jugador> jugadores) {
        this.jugadores = jugadores;
        this.mazo = new Mazo();
        this.cambioSentido = false;
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        int turno = 0;
        while (!mazo.estaVacio()) {
            Jugador jugador = jugadores.get(turno % jugadores.size());
            System.out.println("Turno de " + jugador.getNombre());

            jugarTurno(jugador, scanner);

            // Pasar al siguiente turno
            turno++;
        }
        calcularPuntos();
        scanner.close();
    }

    private void jugarTurno(Jugador jugador, Scanner scanner) {
        List<Fila> filasActivas = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            filasActivas.add(new Fila());
        }

        while (true) {
            Carta carta = mazo.robarCarta();
            if (carta == null) {
                System.out.println("El mazo está vacío.");
                break;
            }

            System.out.println("Carta robada: " + carta.getDescripcion());

            // Mostrar las filas actuales al jugador
            mostrarFilas(filasActivas);

            // Mostrar opciones al jugador
            System.out.println("Opciones:");
            System.out.println("1. Colocar carta en una fila");
            System.out.println("2. Asegurar cartas");
            System.out.println("3. Pasar turno");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    colocarCartaEnFila(jugador, carta, filasActivas, scanner);
                    break;
                case 2:
                    asegurarCartas(jugador, scanner);
                    break;
                case 3:
                    // Terminar el turno
                    terminarTurno(jugador, filasActivas);
                    return; // Terminar el turno actual
                default:
                    System.out.println("Opción no válida.");
            }
        }
        // Si el jugador se arriesgó demasiado
        manejarArriesgarse(jugador);
    }

    private void colocarCartaEnFila(Jugador jugador, Carta carta, List<Fila> filasActivas, Scanner scanner) {
        System.out.println("Selecciona la fila (1-3) para colocar la carta: ");
        int filaIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Limpiar buffer

        if (filaIndex >= 0 && filaIndex < filasActivas.size()) {
            Fila fila = filasActivas.get(filaIndex);
            if (fila.agregarCarta(carta)) {
                System.out.println("Carta colocada en la fila " + (filaIndex + 1));
            } else {
                System.out.println("No se puede colocar la carta en esta fila.");
                // Manejar si el jugador se arriesga demasiado
                manejarArriesgarse(jugador);
            }
        } else {
            System.out.println("Índice de fila inválido.");
        }
    }

    private void asegurarCartas(Jugador jugador, Scanner scanner) {
        System.out.println("Ingrese el color de las cartas a asegurar: ");
        String color = scanner.nextLine();
        jugador.asegurarCartas(color);
        System.out.println("Cartas del color " + color + " aseguradas.");
    }

    private void terminarTurno(Jugador jugador, List<Fila> filasActivas) {
        // Añadir filas activas al botín del jugador
        for (Fila fila : filasActivas) {
            jugador.addFila(fila);
        }
    }

    private void manejarArriesgarse(Jugador jugador) {
        // Implementar la lógica si el jugador se arriesga demasiado
        // Perder cartas y repartir filas
        System.out.println(jugador.getNombre() + " se ha arriesgado demasiado.");
        // Lógica para perder cartas y repartir filas
    }

    private void calcularPuntos() {
        // Calcular y mostrar los puntos finales
        for (Jugador jugador : jugadores) {
            int puntos = 0;
            // Contar puntos de cartas en botín y aseguradas
            System.out.println(jugador.getNombre() + " tiene " + puntos + " puntos.");
        }
        // Determinar el ganador
    }

    private void mostrarFilas(List<Fila> filasActivas) {
        for (int i = 0; i < filasActivas.size(); i++) {
            Fila fila = filasActivas.get(i);
            System.out.println("Fila " + (i + 1) + ": " + fila.getCartas());
        }
    }
}
