public class CartaDado extends Carta {
    public CartaDado(String color) {
        super(color);
    }

    @Override
    public String getDescripcion() {
        return "Carta de dado de color " + getColor();
    }
}
