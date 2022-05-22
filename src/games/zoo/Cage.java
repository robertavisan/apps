package games.zoo;

import java.util.List;

public class Cage {

    private int number;
    private List<Animal> animalList;
    private int countVisits;

    public Cage(int number, List<Animal> animalList) {
        this.number = number;
        this.animalList = animalList;
    }

    public int getNumber() {
        return number;
    }

    public List<Animal> getAnimalList() {
        return animalList;
    }

    public int getCountVisits() {
        return countVisits;
    }


    public boolean hasAnimal(String animalName) {
        for(Animal animal: animalList) {
            if(animal.getName().equalsIgnoreCase(animalName)) {
                return true;
            }
        }
        return false;
    }

    public void increaseCountVisits() {
        countVisits = countVisits + 1;
    }

    public void getInformation(String animalName) {
        Animal animal = null;
        for(int i = 0; i < animalList.size(); i++) {
            if(animalList.get(i).getName().equalsIgnoreCase(animalName)) {
               animal = animalList.get(i);
            }
        }
        if(animal instanceof Lion) {
            System.out.println((Lion) animal);
        } else if(animal instanceof Shark) {
            System.out.println((Shark) animal);
        } else if(animal instanceof Tuna) {
            System.out.println((Tuna) animal);
        } else if(animal instanceof Eagle) {
            System.out.println((Eagle) animal);
        } else if(animal instanceof Parrot) {
            System.out.println((Parrot) animal);
        } else if(animal instanceof Pig) {
            System.out.println((Pig) animal);
        } else if(animal instanceof Penguin) {
            System.out.println((Penguin) animal);
        } else if(animal instanceof Ostrich) {
            System.out.println((Ostrich) animal);
        }
    }

    @Override
    public String toString() {
        return "Cage number = " + number +
                ", animalList = " + animalList +
                ", countVisits = " + countVisits;
    }
}
