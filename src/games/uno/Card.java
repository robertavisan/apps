package games.uno;

public class Card {

    private int number;
    private char symbol;

    public Card(int number, char symbol) {
        this.number = number;
        this.symbol = symbol;
    }

    public int getNumber() {
        return number;
    }

    public char getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return "" + number + symbol;
    }
}
