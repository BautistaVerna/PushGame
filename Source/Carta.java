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
}