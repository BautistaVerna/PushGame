//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class Juego {
//    private Mazo mazo;
//    private List<Jugador> jugadores;
//    private boolean cambioSentido;
//
//    public Juego(List<Jugador> jugadores) {
//        this.jugadores = jugadores;
//        this.mazo = new Mazo();
//        this.cambioSentido = false;
//    }
//
//    public void iniciar() {
//        Scanner scanner = new Scanner(System.in);
//        int turno = 0;
//        while (!mazo.estaVacio()) {
//            Jugador jugador = jugadores.get(turno % jugadores.size());
//            System.out.println("Turno de " + jugador.getNombre());
//
//            jugarTurno(jugador, scanner);
//
//            // Pasar al siguiente turno
//            turno++;
//        }
//        calcularPuntos();
//        scanner.close();
//    }
//
//    private void jugarTurno(Jugador jugador, Scanner scanner) {
//        List<Fila> filasActivas = new ArrayList<>();
//        for (int i = 0; i < 3; i++) {
//            filasActivas.add(new Fila());
//        }
//
//        while (true) {
//            Source.Carta carta = mazo.robarCarta();
//            if (carta == null) {
//                System.out.println("El mazo está vacío.");
//                break;
//            }
//
//
//            System.out.println("Carta robada: " + carta.getDescripcion());
//
//            // Mostrar las filas actuales al jugador
//            mostrarFilas(filasActivas);
//
//            // Mostrar opciones al jugador
//            System.out.println("Opciones:");
//            System.out.println("1. Colocar carta en una fila");
//            System.out.println("2. Asegurar cartas");
//            System.out.println("3. Pasar turno");
//
//
//            int opcion = scanner.nextInt();
//            scanner.nextLine(); // Limpiar buffer
//
//            switch (opcion) {
//                case 1:
//                    colocarCartaEnFila(jugador, carta, filasActivas, scanner);
//                    break;
//                case 2:
//                    asegurarCartas(jugador, scanner);
//                    break;
//                case 3:
//                    // Terminar el turno
//                    terminarTurno(jugador, filasActivas);
//                    return; // Terminar el turno actual
//                default:
//                    System.out.println("Opción no válida.");
//            }
//        }
//        // Si el jugador se arriesgó demasiado
//        manejarArriesgarse(jugador);
//    }
//
//    private void colocarCartaEnFila(Jugador jugador, Source.Carta carta, List<Fila> filasActivas, Scanner scanner) {
//        System.out.println("Selecciona la fila (1-3) para colocar la carta: ");
//        int filaIndex = scanner.nextInt() - 1;
//        scanner.nextLine(); // Limpiar buffer
//
//        if (filaIndex >= 0 && filaIndex < filasActivas.size()) {
//            Fila fila = filasActivas.get(filaIndex);
//            if (fila.agregarCarta(carta)) {
//                System.out.println("Carta colocada en la fila " + (filaIndex + 1));
//            } else {
//                System.out.println("No se puede colocar la carta en esta fila.");
//                // Manejar si el jugador se arriesga demasiado
//                manejarArriesgarse(jugador);
//            }
//        } else {
//            System.out.println("Índice de fila inválido.");
//        }
//    }
//
//    private void asegurarCartas(Jugador jugador, Scanner scanner) {
//        System.out.println("Ingrese el color de las cartas a asegurar: ");
//        String color = scanner.nextLine();
//        jugador.asegurarCartas(color);
//        System.out.println("Cartas del color " + color + " aseguradas.");
//    }
//
//    private void terminarTurno(Jugador jugador, List<Fila> filasActivas) {
//        // Añadir filas activas al botín del jugador
//        for (Fila fila : filasActivas) {
//            jugador.addFila(fila);
//        }
//    }
//
//    private void manejarArriesgarse(Jugador jugador) {
//        // Implementar la lógica si el jugador se arriesga demasiado
//        // Perder cartas y repartir filas
//        System.out.println(jugador.getNombre() + " se ha arriesgado demasiado.");
//        // Lógica para perder cartas y repartir filas
//    }
//
//    private void calcularPuntos() {
//        // Calcular y mostrar los puntos finales
//        for (Jugador jugador : jugadores) {
//            int puntos = 0;
//            // Contar puntos de cartas en botín y aseguradas
//            System.out.println(jugador.getNombre() + " tiene " + puntos + " puntos.");
//        }
//        // Determinar el ganador
//    }
//
//    private void mostrarFilas(List<Fila> filasActivas) {
//        for (int i = 0; i < filasActivas.size(); i++) {
//            Fila fila = filasActivas.get(i);
//            System.out.println("Fila " + (i + 1) + ": " + fila.getCartas());
//        }
//    }
//}


import javax.swing.text.html.HTMLDocument;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class Juego {
    private Mazo mazo;
    private List<Jugador> jugadores;
    private boolean cambioSentido;
    private List<Fila> filasActivas; // Filas activas como parte del juego

    public Juego(List<Jugador> jugadores) {
        this.jugadores = jugadores;
        this.mazo = new Mazo();
        this.cambioSentido = false;
        this.filasActivas = inicializarFilas(); // Inicializar filas una vez
    }

    // Inicia el juego
    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        int turno = 0;
        while (!mazo.estaVacio()) {
            Jugador jugador = jugadores.get(turno % jugadores.size());
            System.out.println("\nTurno de " + jugador.getNombre());
            jugarTurno(jugador, scanner);
            turno = siguienteTurno(turno);
        }
        calcularPuntos();
        scanner.close();
    }

//    // Juega el turno de un jugador
//    private void jugarTurno(Jugador jugador, Scanner scanner) {
//        while (true) {
//            Source.Carta carta = mazo.robarCarta();
//            if (carta == null) {
//                System.out.println("El mazo está vacío.");
//                break;
//            }
//
//            System.out.println("Carta robada: " + carta.getDescripcion());
//            mostrarFilas();
//
//            // Mostrar opciones al jugador y procesar su elección
//            switch (mostrarOpciones(scanner)) {
//                case 1:
//                    colocarCartaEnFila(jugador, carta, scanner);
//                    break;
//                case 2:
//                    asegurarCartas(jugador, scanner);
//                    break;
//                case 3:
//                    terminarTurno(jugador);
//                    return; // Terminar el turno actual
//                default:
//                    System.out.println("Opción no válida.");
//            }
//        }
//        manejarArriesgarse(jugador);
//    }

    // Juega el turno de un jugador
    private void jugarTurno(Jugador jugador, Scanner scanner) {
        while (true) {
            System.out.println("¿Qué quieres hacer?");
            System.out.println("1. Pedir carta");
            System.out.println("2. Asegurar cartas y pasar turno");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            if (opcion == 2) {
                // Si el jugador decide asegurar cartas
                asegurarCartas(jugador, scanner);
                System.out.println("Has asegurado tus cartas. El turno ha terminado.");
                terminarTurno(jugador);
                return; // Termina el turno sin robar carta
            } else if (opcion == 1) {
                // Si el jugador decide pedir carta
                Source.Carta carta = mazo.robarCarta();
                if (carta == null) {
                    System.out.println("El mazo está vacío.");
                    break;
                }

                System.out.println("Carta robada: " + carta.getDescripcion());
                mostrarFilas();

                // Mostrar opciones para colocar la carta o pasar el turno
                switch (mostrarOpciones(scanner)) {
                    case 1:
                        colocarCartaEnFila(jugador, carta, scanner);
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } else {
                System.out.println("Opción no válida. Por favor, elige 1 o 2.");
            }
        }

        manejarArriesgarse(jugador); // Si el jugador arriesga demasiado
    }

    //    ..
    // Mostrar las opciones al jugador y devolver su elección
    private int mostrarOpciones(Scanner scanner) {
        System.out.println("Opciones:");
        System.out.println("1. Colocar carta en una fila");
//        System.out.println("2. Asegurar cartas");
//        System.out.println("3. Pasar turno");
        return scanner.nextInt();
    }

    // Colocar la carta robada en una fila seleccionada por el jugador
    private void colocarCartaEnFila(Jugador jugador, Source.Carta carta, Scanner scanner) {
        boolean cartaColocada = false;

        while (!cartaColocada) {
            System.out.println("Selecciona la fila (1-3) para colocar la carta: ");
            int filaIndex = scanner.nextInt() - 1;

            if (filaIndexValido(filaIndex)) {
                Fila fila = filasActivas.get(filaIndex);
                if (fila.agregarCarta(carta)) {
                    System.out.println("Carta colocada en la fila " + (filaIndex + 1));
                    cartaColocada = true; // Salir del bucle
                } else {
                    System.out.println("No se puede colocar la carta en esta fila.");
                    manejarArriesgarse(jugador);
                    break; // Salir del bucle si no se puede colocar la carta
                }
            } else {
                System.out.println("Índice de fila inválido.");
            }
        }
    }

    // Validar si el índice de fila seleccionado es válido
    private boolean filaIndexValido(int filaIndex) {
        return filaIndex >= 0 && filaIndex < filasActivas.size();
    }

    // Asegurar cartas de un color específico
    private void asegurarCartas(Jugador jugador, Scanner scanner) {
        System.out.println("Ingrese el color de las cartas a asegurar: ");
        String color = scanner.next();
        jugador.asegurarCartas(color);
        System.out.println("Cartas del color " + color + " aseguradas.");
    }


    // Terminar el turno del jugador y añadir filas activas a su botín
    private void terminarTurno(Jugador jugador) {
        for (Fila fila : filasActivas) {
            jugador.addFila(fila);
        }
        filasActivas = inicializarFilas(); // Reiniciar filas para el siguiente turno
    }

    // Manejar cuando un jugador se arriesga demasiado
    private void manejarArriesgarse(Jugador jugador) {
        System.out.println(jugador.getNombre() + " se ha arriesgado demasiado.");
        // Lógica adicional para manejar cuando el jugador se arriesga demasiado
    }

    // Calcular y mostrar los puntos finales de cada jugador
    private void calcularPuntos() {
        for (Jugador jugador : jugadores) {
            int puntos = jugador.calcularPuntos(); // Asumiendo que el jugador tiene un método para calcular puntos
            System.out.println(jugador.getNombre() + " tiene " + puntos + " puntos.");
        }
        determinarGanador();
    }

    // Determinar el ganador del juego
    private void determinarGanador() {
        Jugador ganador = jugadores.stream()
                .max((j1, j2) -> Integer.compare(j1.calcularPuntos(), j2.calcularPuntos()))
                .orElse(null);
        if (ganador != null) {
            System.out.println("El ganador es " + ganador.getNombre() + " con " + ganador.calcularPuntos() + " puntos.");
        }
    }

    // Mostrar las filas activas y sus cartas
    private void mostrarFilas() {
        for (int i = 0; i < filasActivas.size(); i++) {
            System.out.println("Fila " + (i + 1) + ": " + filasActivas.get(i).getCartas());
        }
    }

    // Inicializa las filas activas al inicio del juego o después de cada turno
    private List<Fila> inicializarFilas() {
        List<Fila> filas = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            filas.add(new Fila());
        }
        return filas;
    }

    // Determina el siguiente turno considerando si hay cambio de sentido
    private int siguienteTurno(int turnoActual) {
        return cambioSentido ? turnoActual - 1 : turnoActual + 1;
    }
}
