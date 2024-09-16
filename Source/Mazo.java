import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Mazo {
    private List<Carta> cartas;

    public Mazo() {
        cartas = new LinkedList<>();
        inicializarMazo();
        Collections.shuffle(cartas);
    }

    private void inicializarMazo() {
        // Agregar cartas de número
        for (int numero = 1; numero <= 6; numero++) {
            for (int i = 0; i < 3; i++) {
                for (String color : new String[]{"Rojo", "Azul", "Verde", "Amarillo", "Naranja"}) {
                    cartas.add(new CartaNumero(numero, color));
                }
            }
        }

        // Agregar cartas de dado
        for (int i = 0; i < 18; i++) {
            cartas.add(new CartaDado("ColorDado"));
        }

        // Agregar cartas de cambio de sentido
        for (int i = 0; i < 12; i++) {
            cartas.add(new CartaCambioSentido());
        }
    }

    public Carta robarCarta() {
        if (cartas.isEmpty()) return null;
        return cartas.remove(0);
    }


    public boolean estaVacio() {
        return cartas.isEmpty();
    }
}
