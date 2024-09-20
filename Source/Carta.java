public class Carta {
    private String color;
    private int valor; // Solo aplicable para las cartas numeradas
    private boolean esDado; // Indicador de si es una carta de dado

    // Constructor para cartas numeradas
    public Carta(String color, int valor) {
        this.color = color;
        this.valor = valor;
        this.esDado = false;
    }

    // Constructor para cartas de dado
    public Carta(boolean esDado) {
        this.color = "Dado";
        this.valor = 0; // Las cartas de dado no tienen valor numérico
        this.esDado = esDado;
    }

    // Método para saber si la carta es de dado
    public boolean esDado() {
        return esDado;
    }

    // Getter para el color de la carta
    public String getColor() {
        return color;
    }

    // Getter para el valor de la carta
    public int getValor() {
        return valor;
    }

    // Representación en String de la carta
    @Override
    public String toString() {
        if (esDado) {
            return "Carta de Dado";
        } else {
            return color + " " + valor;
        }
    }
}
