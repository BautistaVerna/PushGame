import java.util.ArrayList;
import java.util.List;

public class Fila {
    private List<Carta> cartas;

    public Fila() {
        cartas = new ArrayList<>();
    }

    public boolean agregarCarta(Carta carta) {
        for (Carta c : cartas) {
            if (c.getColor().equals(carta.getColor()) ||
                    (c instanceof CartaNumero && ((CartaNumero) c).getNumero() == ((CartaNumero) carta).getNumero())) {
                return false; // No se puede agregar la carta
            }
        }
        cartas.add(carta);
        return true;
    }

    public List<Carta> getCartas() {
        return cartas;
    }
}
