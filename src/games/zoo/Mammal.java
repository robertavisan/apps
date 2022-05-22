package games.zoo;

public class Mammal extends Animal {

    private boolean isBiped;
    private boolean isMammal;


    public Mammal(String name, String dietType, boolean isBiped, String gender, boolean isMammal, boolean isNocturnal) {
        super(name, dietType, gender, isNocturnal);
        this.isBiped = isBiped;
        this.isMammal = isMammal;

    }

    public boolean isBiped() {
        return isBiped;
    }

    public boolean isMammal() {
        return isMammal;
    }

    public String printIsBiped() {
        if(isBiped) {
            return "a biped";
        } else {
            return "not a biped";
        }
    }

    public String printIsMammal() {
        if(isMammal) {
            return "feeds its baby with milk";
        } else {
            return "is not a mammal";
        }
    }
}
