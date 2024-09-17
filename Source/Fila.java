//import java.util.ArrayList;
//import java.util.List;
//
//public class Fila {
//    private List<Source.Carta> cartas;
//
//    public Fila() {
//        cartas = new ArrayList<>();
//    }
//
//    public boolean agregarCarta(Source.Carta carta) {
//        for (Source.Carta c : cartas) {
//            if (c.getColor().equals(carta.getColor()) ||
//                    (c instanceof CartaNumero && ((CartaNumero) c).getNumero() == ((CartaNumero) carta).getNumero())) {
//                return false; // No se puede agregar la carta
//            }
//        }
//        cartas.add(carta);
//        return true;
//    }
//
//    public List<Source.Carta> getCartas() {
//        return cartas;
//    }
//}


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Fila {
    private List<Source.Carta> cartas;

    public Fila() {
        this.cartas = new ArrayList<>();
    }

    // Método para agregar una carta a la fila con validación
    public boolean agregarCarta(Source.Carta carta) {
        if (esCartaValidaParaAgregar(carta)) {
            cartas.add(carta);
            return true;
        } else {
            return false; // No se puede agregar la carta si no cumple las condiciones
        }
    }

    // Método para obtener las cartas de la fila de forma inmutable
    public List<Source.Carta> getCartas() {
        return Collections.unmodifiableList(cartas); // Evita modificaciones externas
    }

    // Verifica si la carta puede ser agregada (validación de color y número)
    private boolean esCartaValidaParaAgregar(Source.Carta nuevaCarta) {
        for (Source.Carta cartaExistente : cartas) {
            // Verificar si hay una carta del mismo color o el mismo número
            if (cartaExistente.getColor().equals(nuevaCarta.getColor()) ||
                    (nuevaCarta instanceof CartaNumero && cartaExistente instanceof CartaNumero &&
                            ((CartaNumero) nuevaCarta).getNumero() == ((CartaNumero) cartaExistente).getNumero())) {
                return false; // No es válida, ya existe una carta con el mismo color o número
            }
        }
        return true; // La carta es válida para agregar
    }
}
