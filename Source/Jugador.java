import java.util.ArrayList;
import java.util.HashMap;

public class Jugador {
    private String nombre;
    private ArrayList<Carta> fila1;
    private ArrayList<Carta> fila2;
    private ArrayList<Carta> fila3;
    private HashMap<String, ArrayList<Integer>> botin; // Botín agrupado por color
    private boolean tieneDado; // Indicador de si el jugador tiene una carta de dado

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.fila1 = new ArrayList<>();
        this.fila2 = new ArrayList<>();
        this.fila3 = new ArrayList<>();
        this.botin = new HashMap<>();
        this.tieneDado = false;

        // Inicializar los colores en el botín
        botin.put("Verde", new ArrayList<>());
        botin.put("Violeta", new ArrayList<>());
        botin.put("Amarillo", new ArrayList<>());
        botin.put("Rojo", new ArrayList<>());
        botin.put("Azul", new ArrayList<>());
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Carta> getFila(int num) {
        switch (num) {
            case 1: return fila1;
            case 2: return fila2;
            case 3: return fila3;
            default: return null;
        }
    }

    public boolean agregarCartaAFila(Carta carta, int numFila) {
        ArrayList<Carta> fila = getFila(numFila);
        if (fila != null) {
            // Validar que no haya repetición de color o de número en la fila
            for (Carta c : fila) {
                if (c.getColor().equals(carta.getColor()) || c.getValor() == carta.getValor()) {
                    return false; // No se puede agregar porque hay repetición de color o número
                }
            }
            fila.add(carta);
            if (carta.esDado()) {
                tieneDado = true; // Si es una carta de dado, activar el indicador
            }
            return true;
        }
        return false; // No se puede colocar la carta en la fila
    }

    public void asegurarCartas() {
        // Agregar las cartas de las filas al botín por colores
        agregarFilaABotin(fila1);
        agregarFilaABotin(fila2);
        agregarFilaABotin(fila3);

        // Limpiar las filas
        fila1.clear();
        fila2.clear();
        fila3.clear();
    }

    private void agregarFilaABotin(ArrayList<Carta> fila) {
        if (!fila.isEmpty()) {
            for (Carta carta : fila) {
                if (!carta.esDado()) {
                    botin.get(carta.getColor()).add(carta.getValor());
                }
            }
        }
    }

    public void lanzarDado() {
        if (tieneDado) {
            String[] colores = {"Verde", "Violeta", "Amarillo", "Rojo", "Azul", "Negro"};
            int resultado = (int) (Math.random() * 6); // Lanzar el dado
            String colorSeleccionado = colores[resultado];
            System.out.println("El color que tocó en el dado es: " + colorSeleccionado);

            if (!colorSeleccionado.equals("Negro")) {
                botin.get(colorSeleccionado).clear(); // Limpiar cartas de ese color
                System.out.println("Tu botín después de lanzar el dado:");
                mostrarBotin();
            } else {
                System.out.println("Dado negro: no pierdes cartas.");
            }
            tieneDado = false; // Resetear dado
        }
    }

    public void mostrarBotin() {
        for (String color : botin.keySet()) {
            System.out.println(color + ": " + botin.get(color).toString());
        }
    }

    public int calcularPuntos() {
        int puntos = 0;
        for (String color : botin.keySet()) {
            for (int valor : botin.get(color)) {
                puntos += valor;
            }
        }
        return puntos;
    }
}

