package games.zoo;

public class Eagle extends Bird {

    private String environment;


    public Eagle(String name, String dietType, String gender, String environment) {
        super(name, dietType, gender, true, false);
        this.environment = environment;
    }


    @Override
    public String toString() {
        return "The eagle is a " + getDietType() + " animal, that " + hunt() + ", he " + printIsFlying() + ", he lives in the " + environment + " area, and the one we have is a " + getGender() + ".";
    }
}
