package games.zoo;

public class Fish extends Animal {

    private String water;

    public Fish(String name, String dietType, String gender, String water, boolean isNocturnal) {
        super(name, dietType, gender, isNocturnal);
        this.water = water;
    }

    public String getWater() {
        return water;
    }
}
