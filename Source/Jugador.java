import java.util.ArrayList;
import java.util.List;

public class Jugador {
    private String nombre;
    private List<Carta> botin;
    private List<Fila> filas;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.botin = new ArrayList<>();
        this.filas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void addCartaBotin(Carta carta) {
        botin.add(carta);
    }

    public List<Carta> getBotin() {
        return botin;
    }

    public void addFila(Fila fila) {
        filas.add(fila);
    }

    public List<Fila> getFilas() {
        return filas;
    }

    public void asegurarCartas(String color) {
        // Crear mazo de cartas aseguradas
        List<Carta> aseguradas = new ArrayList<>();
        botin.removeIf(carta -> {
            if (carta.getColor().equals(color)) {
                aseguradas.add(carta);
                return true;
            }
            return false;
        });
        // Aquí podrías mantener las cartas aseguradas en una lista separada si es necesario
    }

    public void perderCartas(String color) {
        botin.removeIf(carta -> carta.getColor().equals(color));
    }
}
