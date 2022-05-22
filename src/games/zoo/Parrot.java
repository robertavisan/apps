package games.zoo;

public class Parrot extends Bird {

    private boolean isDomestic;

    public Parrot(String name, String dietType, String gender, boolean isDomestic) {
        super(name, dietType, gender, true, false);
        this.isDomestic = isDomestic;
    }

    public String printIsDomestic() {
        if(isDomestic) {
            return "domestic";
        } else {
            return "not domestic";
        }
    }

    @Override
    public String toString() {
        return "The parrot is an " + getDietType() + " and a " + printIsDomestic() + " animal, that " + hunt() + ", it " + printIsFlying() + " and the one we have is a " + getGender() + ".";
    }
}
