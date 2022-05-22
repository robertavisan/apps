package games.zoo;

public class Shark extends Fish {

    private boolean isAggressive;

    public Shark(String name, String dietType, String gender, String water, boolean isAggressive) {
        super(name, dietType, gender, water, true);
        this.isAggressive = isAggressive;
    }

    public boolean isAggressive() {
        return isAggressive;
    }

    public String printIsAggressive() {
        if (isAggressive) {
            return "an aggressive";
        } else {
            return "not an aggressive";
        }
    }

    @Override
    public String toString() {
        return "The shark is a " + getDietType() + " animal, that " + hunt() + ", it swims in " + getWater() + " water" + ", it is " + printIsAggressive() + " animal, and the one we have is a " + getGender() + ".";
    }
}
