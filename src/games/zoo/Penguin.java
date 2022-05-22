package games.zoo;

public class Penguin extends Bird {

    String environment;

    public Penguin(String name, String dietType, String gender, String environment) {
        super(name, dietType, gender, false, false);
        this.environment = environment;
    }

    public String getEnvironment() {
        return environment;
    }

    @Override
    public String toString() {
        return "The penguin is a " + getDietType() + " animal, that " + hunt() + ", it " + printIsFlying() + ", it lives in the " + getEnvironment() + " area, and the one we have is a " + getGender() + ".";
    }
}
