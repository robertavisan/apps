package games.zoo;

public class Lion extends Mammal {

    private String species;

    public Lion(String name, String dietType, String gender, String species) {
        super(name, dietType, false, gender, true, true);
        this.species = species;
    }

    public String getSpecies() {
        return species;
    }



    @Override
    public String toString() {
        return "The lion is a " + getDietType() + " animal, that " + hunt() + ", it " + printIsMammal() + ", it is " + printIsBiped() + ", its species is a " + getSpecies() + " and the one we have is a " + getGender() + ".";
    }
}
