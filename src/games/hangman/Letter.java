package games.hangman;

public class Letter {

    private char character;
    private boolean isHidden;

    public Letter(char character, boolean isHidden) {
        this.character = character;
        this.isHidden = isHidden;
    }

    public char getCharacter() {
        return character;
    }

    public boolean isHidden() {
        return isHidden;
    }

    public void setHidden(boolean hidden) {
        isHidden = hidden;
    }


    @Override
    public String toString() {
        return character + "";
    }
}
