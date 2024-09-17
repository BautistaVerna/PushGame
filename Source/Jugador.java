//import java.util.ArrayList;
//import java.util.List;
//
//public class Jugador {
//    private String nombre;
//    private List<Source.Carta> botin;
//    private List<Fila> filas;
//
//    public Jugador(String nombre) {
//        this.nombre = nombre;
//        this.botin = new ArrayList<>();
//        this.filas = new ArrayList<>();
//    }
//
//    public String getNombre() {
//        return nombre;
//    }
//
//    public void addCartaBotin(Source.Carta carta) {
//        botin.add(carta);
//    }
//
//    public List<Source.Carta> getBotin() {
//        return botin;
//    }
//
//    public void addFila(Fila fila) {
//        filas.add(fila);
//    }
//
//    public List<Fila> getFilas() {
//        return filas;
//    }
//
//    public void asegurarCartas(String color) {
//        // Crear mazo de cartas aseguradas
//        List<Source.Carta> aseguradas = new ArrayList<>();
//        botin.removeIf(carta -> {
//            if (carta.getColor().equals(color)) {
//                aseguradas.add(carta);
//                return true;
//            }
//            return false;
//        });
//        // Aquí podrías mantener las cartas aseguradas en una lista separada si es necesario
//    }
//
//    public void perderCartas(String color) {
//        botin.removeIf(carta -> carta.getColor().equals(color));
//    }
//
//    public int calcularPuntos() {
//        return 0;
//    }
//}


import java.util.ArrayList;
import java.util.List;

public class Jugador {
    private String nombre;
    private List<Source.Carta> botin;
    private List<Source.Carta> cartasAseguradas; // Lista separada para las cartas aseguradas
    private List<Fila> filas;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.botin = new ArrayList<>();
        this.cartasAseguradas = new ArrayList<>();
        this.filas = new ArrayList<>();
    }

    // Obtener el nombre del jugador
    public String getNombre() {
        return nombre;
    }

    // Añadir una carta al botín
    public void addCartaBotin(Source.Carta carta) {
        botin.add(carta);
    }

    // Obtener el botín del jugador
    public List<Source.Carta> getBotin() {
        return botin;
    }

    // Añadir una fila al jugador
    public void addFila(Fila fila) {
        filas.add(fila);
        // Opcionalmente, podrías mover las cartas de la fila al botín si es necesario
    }

    // Obtener las filas del jugador
    public List<Fila> getFilas() {
        return filas;
    }

    // Asegurar cartas de un color específico, moviéndolas del botín a las cartas aseguradas
    public void asegurarCartas(String color) {
        List<Source.Carta> cartasParaAsegurar = new ArrayList<>();
        for (Source.Carta carta : botin) {
            if (carta.getColor().equals(color)) {
                cartasParaAsegurar.add(carta);
            }
        }

        // Mover cartas del botín a las aseguradas
        botin.removeAll(cartasParaAsegurar);
        cartasAseguradas.addAll(cartasParaAsegurar);

        System.out.println(cartasParaAsegurar.size() + " cartas del color " + color + " aseguradas.");
    }

    // Eliminar cartas de un color específico del botín (cuando el jugador pierde)
    public void perderCartas(String color) {
        botin.removeIf(carta -> carta.getColor().equals(color));
        System.out.println("Cartas del color " + color + " perdidas.");
    }

    // Calcular puntos en base a las cartas en el botín y las aseguradas
    public int calcularPuntos() {
        int puntos = 0;
        // Asumiendo que cada carta tiene un valor asociado
        for (Source.Carta carta : botin) {
            puntos = carta.getValor(); // Considerando que Carta tiene un método getValor()
        }
        for (Source.Carta carta : cartasAseguradas) {
            puntos = carta.getValor(); // Las cartas aseguradas también suman puntos
        }
        return puntos;
    }

    // Obtener las cartas aseguradas
    public List<Source.Carta> getCartasAseguradas() {
        return cartasAseguradas;
    }
}
