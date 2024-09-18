public class Carta {
    private String color;
    private int valor; // Solo aplicable para las cartas numeradas
    private boolean esDado; // Indicador de si es una carta de dado

    public Carta(String color, int valor) {
        this.color = color;
        this.valor = valor;
        this.esDado = false; // Por defecto no es un dado
    }

    public Carta(boolean esDado) {
        this.esDado = esDado;
    }

    public String getColor() {
        return color;
    }

    public int getValor() {
        return valor;
    }

    public boolean esDado() {
        return esDado;
    }

    @Override
    public String toString() {
        if (esDado) {
            return "Carta de Dado";
        }
        return color + " " + valor;
    }
}
//Fran