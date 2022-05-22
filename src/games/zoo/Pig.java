package games.zoo;

public class Pig extends Mammal {

    private String size;

    public Pig(String name, String dietType, String gender, String size) {
        super(name, dietType, false, gender, true, false);
        this.size = size;
    }

    public String getSize() {
        return size;
    }


    @Override
    public String toString() {
        return "The pig is an " + getDietType() + " animal, that " + hunt() + ", it " + printIsMammal() + ", it`s " + printIsBiped() + ", its size is " + getSize() + " and the one we have is a " + getGender() + ".";
    }
}
