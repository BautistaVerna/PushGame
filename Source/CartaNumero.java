public class CartaNumero extends Carta {
    private int numero;

    public CartaNumero(int numero, String color) {
        super(color);
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public String getDescripcion() {
        return "Número " + numero + " de color " + getColor();
    }
}