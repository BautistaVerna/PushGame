public class Card {
    private int number;
    private String color;
    private boolean isDiceCard;

    public Card(int number, String color, boolean isDiceCard) {
        this.number = number;
        this.color = color;
        this.isDiceCard = isDiceCard;
    }

    public int getNumber() {
        return number;
    }

    public String getColor() {
        return color;
    }

    public boolean isDiceCard() {
        return isDiceCard;
    }

    @Override
    public String toString() {
        return (isDiceCard ? "DADO" : number + " " + color);
    }
}
