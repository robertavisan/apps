package games.zoo;

public class Bird extends Animal{

    private boolean isFlying;

    public Bird(String name, String dietType, String gender, boolean isFlying, boolean isNocturnal) {
        super(name, dietType, gender, isNocturnal);
        this.isFlying = isFlying;
    }

    public boolean isFlying() {
        return isFlying;
    }

    public String printIsFlying() {
        if(isFlying()) {
            return "can fly";
        } else {
            return "can not fly";
        }
    }
}
