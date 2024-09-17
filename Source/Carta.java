package Source;

public abstract class Carta {
    private String color;

    public Carta(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public abstract String getDescripcion();

    public int getValor(int i) {
        return 0;
    }

    public int getValor() {
        return 0;
    }
}