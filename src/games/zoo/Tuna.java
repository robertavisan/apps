package games.zoo;

public class Tuna extends Fish {

    private String size;


    public Tuna(String name, String dietType, String gender, String water, String size) {
        super(name, dietType, gender, water, false);
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "The tuna is a " + getDietType() + " animal, that " + hunt() + ", it swims in " + getWater() + " water, its size is " + getSize() + " and the one we have is a " + getGender() + ".";
    }
}
