package games.bakery;

public class Bread {

    private String breadType;
    private double price;

    public Bread(String breadType, double price) {
        this.breadType = breadType;
        this.price = price;
    }

    public String getBreadType() {
        return breadType;
    }

    public double getPrice() {
        return price;
    }


    public void setBreadType(String breadType) {
        this.breadType = breadType;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
