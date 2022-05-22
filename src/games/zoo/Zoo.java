package games.zoo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Zoo {

    private List<Cage> cageList;


    public Zoo() {
        List<Animal> cage1Animals = new ArrayList<>();
        Lion lion = new Lion("lion", "carnivore", "female", "predator");
        cage1Animals.add(lion);

        List<Animal> cage2Animals = new ArrayList<>();
        Shark shark = new Shark("shark", "carnivore", "male", "salty", false);
        Tuna tuna = new Tuna("tuna", "carnivore", "male", "sweet", "medium");
        cage2Animals.add(shark);
        cage2Animals.add(tuna);

        List<Animal> cage3Animals = new ArrayList<>();
        Eagle eagle = new Eagle("eagle", "carnivore", "female", "mountain");
        Parrot parrot = new Parrot("parrot", "herbivore", "female", true);
        cage3Animals.add(eagle);
        cage3Animals.add(parrot);

        List<Animal> cage4Animals = new ArrayList<>();
        Pig pig = new Pig("pig", "omnivore", "male", "large");
        Ostrich ostrich = new Ostrich("ostrich", "herbivore", "female", false);
        cage4Animals.add(pig);
        cage4Animals.add(ostrich);

        List<Animal> cage5Animals = new ArrayList<>();
        Penguin penguin = new Penguin("penguin", "carnivore", "female", "ocean and coastal");
        cage5Animals.add(penguin);

        cageList = Arrays.asList(
                new Cage(1, cage1Animals),
                new Cage(2, cage2Animals),
                new Cage(3, cage3Animals),
                new Cage(4, cage4Animals),
                new Cage(5, cage5Animals));
    }

    public List<String> getAnimals() {
        List<String> animalList = new ArrayList<>();
        for(int i = 0; i < cageList.size(); i++) {
            List<Animal> allAnimals = cageList.get(i).getAnimalList();
            for(int j = 0; j < allAnimals.size(); j++) {
                animalList.add(allAnimals.get(j).getName());
            }
        }
        return animalList;
    }


    public Cage visitCageByAnimal(String animalName) {
        for(Cage cage:cageList) {
            if(cage.hasAnimal(animalName)) {
                cage.increaseCountVisits();
                return cage;
            }
        }
        return null;
    }

    public void printNumberOfCageVisits() {
        for(int i = 0; i < cageList.size(); i++) {
            System.out.println("Cage number " + cageList.get(i).getNumber() + " was visited " + cageList.get(i).getCountVisits() + " times");
        }
    }

}
