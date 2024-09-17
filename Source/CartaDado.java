//public class CartaDado extends Carta {
//    public CartaDado(String color) {
//        super(color);
//    }
//
//    @Override
//    public String getDescripcion() {
//        return "Carta de dado de color " + getColor();
//    }
//}

//// Clase CartaDado que extiende de la clase base Carta
//public class CartaDado extends Carta {
//
//    // Constructor que inicializa el color de la carta dado
//    public CartaDado(String color) {
//        super(color); // Llama al constructor de la clase base
//    }
//
//    // Implementación del método getDescripcion que proporciona una descripción específica de la carta
//    @Override
//    public String getDescripcion() {
//        return String.format(" %s", getColor());
//    }
//}

package Source;
// Clase CartaDado que extiende de la clase base Carta
public class CartaDado extends Source.Carta {

    // Constructor que inicializa el color de la carta dado
    public CartaDado(String color) {
        super(color); // Llama al constructor de la clase base
    }

    // Implementación del método getDescripcion que proporciona una descripción específica de la carta
    @Override
    public String getDescripcion() {
        return String.format("%s", getColor());
    }

    // Sobrescritura del método toString para evitar la referencia en memoria
    @Override
    public String toString() {
        return getDescripcion(); // Llama al método que ya describe la carta
    }
}

//HECHO POR TOMI