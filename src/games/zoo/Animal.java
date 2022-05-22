package games.zoo;

public class Animal implements HuntingBehaviour {

    private String name;
    private String dietType;
    private String gender;
    private boolean isNocturnal;

    public Animal(String name, String dietType, String gender, boolean isNocturnal) {
        this.name = name;
        this.dietType = dietType;
        this.gender = gender;
        this.isNocturnal = isNocturnal;
    }

    public String getName() {
        return name;
    }

    public String getDietType() {
        return dietType;
    }

    public String getGender() {
        return gender;
    }

    public boolean isNocturnal() {
        return isNocturnal;
    }

    @Override
    public String hunt() {
        if(isNocturnal) {
            return "hunts at night";
        } else {
            return "hunts during the day";
        }
    }
}
