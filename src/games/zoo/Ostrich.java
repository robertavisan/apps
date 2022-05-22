package games.zoo;

public class Ostrich extends Mammal {

    boolean canFly;

    public Ostrich(String name, String dietType, String gender, boolean canFly) {
        super(name, dietType, true, gender, false, false);
        this.canFly = canFly;
    }

    public String printCanFly() {
        if(canFly) {
            return "can fly";
        } else {
            return "can not fly";
        }
    }


    @Override
    public String toString() {
        return "The ostrich is an " + getDietType() + " animal, that " + hunt() + ", it is " + printIsBiped() + ", but " + printIsMammal() + ", it " + printCanFly() + " and the one we have is a " + getGender() + ".";
    }


}
