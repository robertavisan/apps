package games.zoo;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ZooPark {

    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        List<String> animals = zoo.getAnimals();
        Collections.shuffle(animals);
        System.out.println(animals);
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("Insert animal you want to visit");
            String animal = scanner.nextLine();
            Cage cage = zoo.visitCageByAnimal(animal);
            if(cage == null) {
                System.out.println("We are sorry but the animal you want to visit is not available");
                continue;
            }
            System.out.println("The " + animal + " is in cage " + cage.getNumber());

            String answer = null;
            boolean isNotValid = true;
            while (isNotValid) {
                System.out.println("Do you want to know information about the " + animal + "? (yes/no)");
                answer = scanner.nextLine();
                if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("no")) {
                    isNotValid = false;
                } else {
                    System.out.println("The answer is not valid. Please answer with yes or no.");
                }
            }
            if (answer.equalsIgnoreCase("yes")) {
                cage.getInformation(animal);
                isNotValid = true;
                while(isNotValid) {
                    System.out.println("Do you want to visit another animal? (yes/no)");
                    answer = scanner.nextLine();
                    if(answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("no")) {
                        isNotValid = false;
                    } else {
                        System.out.println("The answer is not valid. Please answer with yes or no.");
                    }
                }
                if(answer.equalsIgnoreCase("no")) {
                    zoo.printNumberOfCageVisits();
                    break;
                }
            } else if(answer.equalsIgnoreCase("no")) {
                isNotValid = true;
                while (isNotValid) {
                    System.out.println("Do you want to visit another animal? (yes/no)");
                    answer = scanner.nextLine();
                    if(answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("no")) {
                        isNotValid = false;
                    } else {
                        System.out.println("The answer is not valid. Please answer with yes or no.");
                    }
                }
                if(answer.equalsIgnoreCase("no")) {
                    zoo.printNumberOfCageVisits();
                    break;
                }
            } else {
                System.out.println("The answer is not valid. Please answer with yes or no.");
            }
        }
    }

}
