//public class CartaCambioSentido extends Carta {
//    public CartaCambioSentido() {
//        super("");
//    }
//
//    @Override
//    public String getDescripcion() {
//        return "Carta de cambio de sentido";
//    }
//}

package Source;
// Clase CartaCambioSentido que extiende de la clase base Carta
public class CartaCambioSentido extends Source.Carta {

    // Constructor que inicializa la carta de cambio de sentido sin color específico
    public CartaCambioSentido() {
        super(null); // Usa null o un valor más representativo en lugar de una cadena vacía
    }

    // Implementación del método getDescripcion que proporciona una descripción específica de la carta
    @Override
    public String getDescripcion() {
        return "Carta de cambio de sentido";
    }

    // Sobrescritura del método toString para evitar la referencia en memoria
    @Override
    public String toString() {
        return getDescripcion();
    }
}


//HECHO POR TOMI