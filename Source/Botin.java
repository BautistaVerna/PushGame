import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Botin {
    private List<Source.Carta> cartas;

    public Botin() {
        this.cartas = new ArrayList<>();
    }

    // Agregar cartas al botín
    public void agregarCartas(List<Source.Carta> nuevasCartas) {
        cartas.addAll(nuevasCartas);
    }

    // Obtener todas las cartas del botín
    public List<Source.Carta> getCartas() {
        return cartas;
    }

    // Método para contar las cartas por color
    public Map<String, Integer> contarCartasPorColor() {
        Map<String, Integer> conteoPorColor = new HashMap<>();

        for (Source.Carta carta : cartas) {
            String color = carta.getColor();
            conteoPorColor.put(color, conteoPorColor.getOrDefault(color, 0) + 1);
        }

        return conteoPorColor;
    }
}



