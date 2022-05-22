package games.bakery;

import java.util.Scanner;

public class Shop {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Bakery bakery = new Bakery();

    public static void main(String[] args) {

        System.out.println("Insert kg of wheat you want to add to stock:");
        double wheatQuantity = scanner.nextDouble();
        scanner.nextLine();
        System.out.println(wheatQuantity + " kg of wheat added in stock");
        bakery.setWheat(wheatQuantity);
        System.out.println("Current wheat stock = " + bakery.getWheat() + " kg");
        System.out.println();

        chooseAction();
        while (true) {
            System.out.println();
            System.out.println("Choose action:");
            int command = scanner.nextInt();
            scanner.nextLine();
            switch (command) {

                case 1:
                    addExtraWheat();
                    break;

                case 2:
                    addFlour("white");
                    break;

                case 3:
                    addFlour("integral");
                    break;

                case 4:
                    addBread("white", "white");
                    break;

                case 5:
                    addBread("integral", "integral");
                    break;

                case 6:
                    printCurrentStock();
                    break;

                case 7:
                    buyBread();
                    break;

                case 8:
                    System.out.println("Thank you for your order");
                    return;
            }
        }
    }

    public static void addExtraWheat() {
        System.out.println("Insert number of extra kg of wheat you want to add to stock:");
        double wheatQuantity = scanner.nextDouble();
        scanner.nextLine();
        System.out.println(wheatQuantity + " extra kg of wheat added in stock");
        bakery.setWheat(wheatQuantity);
        System.out.println("Current wheat stock = " + bakery.getWheat() + " kg");
    }

    public static void addFlour(String flourType) {
        System.out.println("Current wheat = " + bakery.getWheat() + " kg");
        System.out.println("Insert kg of wheat to be converted to kg of " + flourType + " flour");
        double wheatQuantity = scanner.nextDouble();
        scanner.nextLine();
        if(bakery.getWheat() >= wheatQuantity) {
            double flourQuantity = convertWheatToFlour(wheatQuantity, flourType);
            bakery.setWheat(-wheatQuantity);
            bakery.setFlour(flourQuantity, flourType);

            System.out.println(wheatQuantity + " kg of wheat = " + flourQuantity + " kg of " + flourType + " flour");
            System.out.println("Current wheat stock = " + bakery.getWheat() + " kg");
            if (flourType.equals("white")) {
                System.out.println("Current " + flourType + " flour stock = " + bakery.getWhiteFlour() + " kg");
            } else if (flourType.equals("integral")) {
                System.out.println("Current " + flourType + " flour stock = " + bakery.getIntegralFlour() + " kg");
            }
        } else {
            System.out.println("Not enough wheat in stock");
        }
    }

    public static void addBread(String flourType, String breadType) {
        if(flourType.equals("white")) {
            System.out.println("Current white flour in stock = " + bakery.getWhiteFlour() + " kg");
        } else if(flourType.equals("integral")) {
            System.out.println("Current integral flour in stock = " + bakery.getIntegralFlour() + " kg");
        }
        System.out.println("Insert kg of " + flourType + " flour to be converted to " + flourType + " breads");
        double flourQuantity = scanner.nextDouble();
        scanner.nextLine();
        if(flourType.equals("white") && bakery.getWhiteFlour() >= flourQuantity) {
            int breadQuantity = convertFlourToBread(flourQuantity, breadType);
            bakery.setFlour(-flourQuantity, flourType);
            bakery.setBread(breadQuantity, breadType);
            System.out.println(flourQuantity + " kg of " + flourType + " flour = " + breadQuantity + " " + flourType + " breads");
        } else if(flourType.equals("white") && bakery.getWhiteFlour() < flourQuantity) {
            System.out.println("Not enough white flour in stock");
        } else if(flourType.equals("integral") && bakery.getIntegralFlour() >= flourQuantity) {
            int breadQuantity = convertFlourToBread(flourQuantity, breadType);
            bakery.setFlour(-flourQuantity, flourType);
            bakery.setBread(breadQuantity, breadType);
            System.out.println(flourQuantity + " kg of " + flourType + " flour = " + breadQuantity + " " + flourType + " breads");
        } else if(flourType.equals("integral") && bakery.getIntegralFlour() < flourQuantity){
            System.out.println("Not enough integral flour in stock");
        }
        if (flourType.equals("white") && breadType.equals("white")) {
            System.out.println("Current white flour = " + bakery.getWhiteFlour() + " kg");
            System.out.println("Current white bread = " + bakery.getWhiteBread() + " buc");
        } else if (flourType.equals("integral") && breadType.equals("integral")) {
            System.out.println("Current integral flour = " + bakery.getIntegralFlour() + " kg");
            System.out.println("Current integral bread = " + bakery.getIntegralBread() + " buc");
        }
    }

    public static double convertWheatToFlour(double quantity, String flourType) {
        if (flourType.equals("white")) {
            return quantity;
        } else {
            return quantity / 2;
        }
    }

    public static int convertFlourToBread(double quantity, String breadType) {
        int breads = 0;
        if (breadType.equals("white") && bakery.getWhiteFlour() >= quantity) {
            breads = (int) (quantity * 10);
        } else if(breadType.equals("integral") && bakery.getIntegralFlour() >= quantity) {
            breads = (int) (quantity * 5);
        }
        return breads;
    }

    public static void printCurrentStock() {
        System.out.println("Current wheat stock = " + bakery.getWheat() + " kg");
        System.out.println("Current white flour stock = " + bakery.getWhiteFlour() + " kg");
        System.out.println("Current integral flour stock = " + bakery.getIntegralFlour() + " kg");
        System.out.println("Current white bread stock = " + bakery.getWhiteBread() + " buc");
        System.out.println("Current integral bread stock = " + bakery.getIntegralBread() + " buc");
    }


    public static void buyBread() {
        double whiteBreadPrice = 0;
        double integralBreadPrice = 0;
        double totalBreadPrice = 0;
        boolean isTrue = true;
        while (isTrue) {
            System.out.println("Current white bread  = " + bakery.getWhiteBread() + " buc");
            System.out.println("Current integral bread = " + bakery.getIntegralBread() + " buc");
            System.out.println("Insert type of bread and buc you want to buy");
            String input = scanner.nextLine();
            String[] split = input.split(" ");
            String typeOfBread = split[0];
            int breadNumber = Integer.parseInt(split[1]);
            if (typeOfBread.equalsIgnoreCase("white") && bakery.getWhiteBread() >= breadNumber) {
                whiteBreadPrice = bakery.buyBread(breadNumber, typeOfBread);
                totalBreadPrice = totalBreadPrice + whiteBreadPrice;
            } else if (bakery.getWhiteBread() < breadNumber) {
                System.out.println("Not enough white bread in stock");
            } else if (typeOfBread.equalsIgnoreCase("integral") && bakery.getIntegralBread() >= breadNumber) {
                integralBreadPrice = bakery.buyBread(breadNumber, typeOfBread);
                totalBreadPrice = totalBreadPrice + integralBreadPrice;
            } else if (bakery.getIntegralBread() < breadNumber) {
                System.out.println("Not enough integral bread in stock");
            }
            System.out.println("Your order = " + totalBreadPrice + " RON");
            System.out.println("Do you want to buy more bread? (yes/no)");
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("no")) {
                isTrue = false;
                System.out.println("Your order = " + totalBreadPrice + " RON");
            }
        }
    }


    public static void chooseAction() {
        System.out.println("Available actions:");
        System.out.println("1. Add extra wheat in stock");
        System.out.println("2. Convert wheat to white flour");
        System.out.println("3. Convert wheat to integral flour");
        System.out.println("4. Convert white flour to white bread");
        System.out.println("5. Convert integral flour to bread");
        System.out.println("6. See current wheat, white flour, white bread, integral flour, integral bread available in stock");
        System.out.println("7. Buy bread");
        System.out.println("8. Close the program");
    }
}
