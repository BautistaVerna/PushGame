// public class CartaNumero extends Carta {
// private int numero;
//
// public CartaNumero(int numero, String color) {
// super(color);
// this.numero = numero;
// }
//
// public int getNumero() {
// return numero;
// }
//
// @Override
// public String getDescripcion() {
// return "Número " + numero + " de color " + getColor();
// }
// }


//*
// * Representa una carta con un número y un color.
//public class CartaNumero extends Carta {
//    private final int numero;
//
//    *
//     * Crea una carta con un número y un color especificados.
//     *
//     * @param numero el número de la carta
//     * @param color  el color de la carta
//    public CartaNumero(int numero, String color) {
//        super(color);
//        this.numero = numero;
//    }
//
//    *
//     * Obtiene el número de la carta.
//     *
//     * @return el número de la carta
//    public int getNumero() {
//        return numero;
//    }
//
//    *
//     * Obtiene una descripción completa de la carta.
//     *
//     * @return una cadena que describe la carta
//    @Override
//    public String getDescripcion() {
//        return String.format("Número %d de color %s", numero, getColor());
//    }
//} */


import Source.Carta;

/**
 * Representa una carta con un número y un color.
 */
public class CartaNumero extends Carta {
    private final int numero;

    /**
     * Crea una carta con un número y un color especificados.
     *
     * @param numero el número de la carta
     * @param color  el color de la carta
     */
    public CartaNumero(int numero, String color) {
        super(color);
        this.numero = numero;
    }

    /**
     * Obtiene el número de la carta.
     *
     * @return el número de la carta
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Obtiene una descripción completa de la carta.
     *
     * @return una cadena que describe la carta
     */
    @Override
    public String getDescripcion() {
        return String.format(" %d %s", numero, getColor());
    }

    /**
     * Retorna una representación en cadena del objeto.
     *
     * @return una cadena que representa el objeto
     */
    @Override
    public String toString() {
        return getDescripcion();
    }
}

//HECH0 POR TOMI