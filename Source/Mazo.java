//import Source.Carta;
//import Source.CartaCambioSentido;
//import Source.CartaDado;
//
//import java.util.Collections;
//import java.util.LinkedList;
//import java.util.List;
//
//public class Mazo {
//    private List<Carta> cartas;
//
//    public Mazo() {
//        cartas = new LinkedList<>();
//        inicializarMazo();
//        Collections.shuffle(cartas);
//    }
//
//    private void inicializarMazo() {
//        // Agregar cartas de número
//        for (int numero = 1; numero <= 6; numero++) {
//            for (int i = 0; i < 3; i++) {
//                for (String color : new String[]{"Rojo", "Azul", "Verde", "Amarillo", "Naranja"}) {
//                    cartas.add(new CartaNumero(numero, color));
//                }
//            }
//        }
//
//        // Agregar cartas de dado
//        for (int i = 0; i < 18; i++) {
//            cartas.add(new CartaDado("ColorDado"));
//        }
//
//        // Agregar cartas de cambio de sentido
//        for (int i = 0; i < 12; i++) {
//            cartas.add(new CartaCambioSentido());
//        }
//    }
//
//    public Carta robarCarta() {
//        if (cartas.isEmpty()) return null;
//        return cartas.remove(0);
//    }
//
//
//    public boolean estaVacio() {
//        return cartas.isEmpty();
//    }
//}


import Source.Carta;
import Source.CartaCambioSentido;
import Source.CartaDado;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Mazo {
    private static final int NUM_CARTAS_NUMERO = 3;  // Constante para cartas numéricas
    private static final int NUM_CARTAS_CAMBIO_SENTIDO = 12;  // Cantidad de cartas de cambio de sentido
    private static final int NUM_CARTAS_DADO = 18;  // Cantidad de cartas de dado
    private static final int MIN_NUMERO_CARTA = 1;  // Número mínimo de cartas numéricas
    private static final int MAX_NUMERO_CARTA = 6;  // Número máximo de cartas numéricas
    private static final String[] COLORES = {"Rojo", "Azul", "Verde", "Amarillo", "Naranja"};

    private List<Carta> cartas;

    public Mazo() {
        cartas = new LinkedList<>();  // Usamos LinkedList para mejor rendimiento en operaciones de eliminación de elementos
        inicializarMazo();  // Inicializa todas las cartas
        Collections.shuffle(cartas);  // Mezcla las cartas aleatoriamente
    }

    // Método para inicializar el mazo completo
    private void inicializarMazo() {
        agregarCartasNumero();
        agregarCartasDado();
        agregarCartasCambioSentido();
    }

    // Agregar cartas numéricas al mazo
    private void agregarCartasNumero() {
        for (int numero = MIN_NUMERO_CARTA; numero <= MAX_NUMERO_CARTA; numero++) {
            for (int i = 0; i < NUM_CARTAS_NUMERO; i++) {
                for (String color : COLORES) {
                    cartas.add(new CartaNumero(numero, color));
                }
            }
        }
    }

    // Agregar cartas de dado al mazo
    private void agregarCartasDado() {
        for (int i = 0; i < NUM_CARTAS_DADO; i++) {
            cartas.add(new CartaDado("ColorDado"));  // Asumimos que la carta de dado tiene un color genérico
        }
    }

    // Agregar cartas de cambio de sentido al mazo
    private void agregarCartasCambioSentido() {
        for (int i = 0; i < NUM_CARTAS_CAMBIO_SENTIDO; i++) {
            cartas.add(new CartaCambioSentido());
        }
    }

    // Robar una carta del mazo (retorna null si el mazo está vacío)
    public Carta robarCarta() {
        if (estaVacio()) {
            System.out.println("El mazo está vacío. No se pueden robar más cartas.");
            return null;
        }
        return cartas.remove(0);  // Roba la primera carta (comportamiento de FIFO)
    }

    // Verifica si el mazo está vacío
    public boolean estaVacio() {
        return cartas.isEmpty();
    }
}
