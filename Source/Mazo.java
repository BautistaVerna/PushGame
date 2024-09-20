import java.util.ArrayList;
import java.util.Collections;

public class Mazo {
    private ArrayList<Carta> cartas;

    public Mazo() {
        cartas = new ArrayList<>();
        String[] colores = {"Verde", "Violeta", "Amarillo", "Rojo", "Azul"};

        // Añadir cartas de números
        for (String color : colores) {
            for (int valor = 1; valor <= 6; valor++) {
                cartas.add(new Carta(color, valor));
                cartas.add(new Carta(color, valor));
                cartas.add(new Carta(color, valor)); // Tres cartas de cada valor
            }
        }

        // Añadir cartas de dado
        for (int i = 0; i < 15; i++) {
            cartas.add(new Carta(true)); // 15 cartas de dado
        }

        // Mezclar el mazo
        Collections.shuffle(cartas);
    }

    public Carta robarCarta() {
        if (cartas.isEmpty()) {
            System.out.println("El mazo se ha agotado.");
            return null;
        }
        return cartas.remove(0); // Robar la primera carta del mazo
    }

    public boolean estaVacio() {
        return cartas.isEmpty();
    }
}

