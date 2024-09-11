import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Card {
    String color;
    int value;

    public Card(String color, int value) {
        this.color = color;
        this.value = value;
    }

    public String toString() {
        return color + " " + value;
    }
}
