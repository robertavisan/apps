package games.bakery;

public class Bakery {


    private double wheat;
    private double whiteFlour;
    private double integralFlour;
    private int whiteBread;
    private int integralBread;
    private double whiteBreadPrice;
    private double integralBreadPrice;

    public Bakery() {
        this.wheat = 0;
        this.whiteFlour = 0;
        this.integralFlour = 0;
        this.whiteBread = 0;
        this.integralBread = 0;
        this.whiteBreadPrice = 2.57;
        this.integralBreadPrice = 3.84;
    }

    public double getWheat() {
        return wheat;
    }

    public double getWhiteFlour() {
        return whiteFlour;
    }

    public double getIntegralFlour() {
        return integralFlour;
    }

    public int getWhiteBread() {
        return whiteBread;
    }

    public int getIntegralBread() {
        return integralBread;
    }

    public void setWheat(double wheat) {
        this.wheat = this.wheat + wheat;
    }

    public void setFlour(double flourQuantity, String flourType) {
        if (flourType.equals("white")) {
            this.whiteFlour = this.whiteFlour + flourQuantity;
        } else if (flourType.equals("integral")) {
            this.integralFlour = this.integralFlour + flourQuantity;
        }
    }

    public void setBread(int breadQuantity, String breadType) {
        if (breadType.equals("white")) {
            this.whiteBread = this.whiteBread + breadQuantity;
        } else if (breadType.equals("integral")) {
            this.integralBread = this.integralBread + breadQuantity;
        }
    }


    public double buyBread(int quantity, String breadType) {
        double total = 0;
        if(breadType.equals("white") && this.whiteBread >= quantity) {
            this.whiteBread = this.whiteBread - quantity;
            total = total + whiteBreadPrice * quantity;
            System.out.println("The price of a white bread is " + whiteBreadPrice + " RON.");
            System.out.println("You bought " + quantity + " white breads, at the total cost of " + total + " RON.");
            System.out.println("Remaining white breads  = " + this.whiteBread + " buc");
        } else if (breadType.equals("integral") && this.integralBread >= quantity) {
            this.integralBread = this.integralBread - quantity;
            total = total + integralBreadPrice * quantity;
            System.out.println("The price of an integral bread is " + integralBreadPrice + " RON.");
            System.out.println("You bought " + quantity + " integral breads, at the total cost of " + total + " RON.");
            System.out.println("Remaining integral breads = " + this.integralBread + " buc");
        }
        return total;
    }

}
