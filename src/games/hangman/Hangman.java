package games.hangman;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Hangman {

    public static void main(String[] args) {
        Word word = new Word();
        word.printCharacter();

        Set<Character> wrongLetters = new HashSet<>();
        int lives = 5;
        System.out.println();
        System.out.println("Lives = " + lives);
        Scanner scanner = new Scanner(System.in);
        while (!word.hasGameEnded()) {
            System.out.println();
            System.out.println("Please insert a letter in UPPERCASE");
            String letter = scanner.nextLine();
            word.guessLetter(letter.charAt(0));
            word.printCharacter();

            if(!word.isLetterValid(letter.charAt(0))) {
                wrongLetters.add(letter.charAt(0));
                lives = lives - 1;
            }
            System.out.println();
            System.out.println("Wrong letters = " + wrongLetters);
            System.out.println("Remaining lives = " + lives);
            if(lives == 0) {
                word.hasGameEnded();
                System.out.println("The word was " + word.getWord());
                return;
            }
        }
    }
}
