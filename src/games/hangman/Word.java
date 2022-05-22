package games.hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Word {

    private static final String DEFAULT_WORD = "ADVENTURE";
    private static final String WORD_LIST_PATH = "src/games/hangman/word_list.txt";

    private final String word;
    private final List<Letter> letterList;

    public Word() {
        this.word = initializeWord();
        this.letterList = new ArrayList<>();

        char firstChar = word.charAt(0);
        Letter firstLetter = new Letter(firstChar,false);
        letterList.add(firstLetter);

        for(int i = 1; i < word.length() - 1; i++) {
            Letter middleLetter = new Letter(word.charAt(i),true);
            letterList.add(middleLetter);
        }

        char lastChar = word.charAt(word.length() - 1);
        Letter lastLetter = new Letter(lastChar,false);
        letterList.add(lastLetter);
    }

    public String getWord() {
        return word;
    }

    public void printCharacter() {
        Letter firstLetter = letterList.get(0);
        Letter lastLetter = letterList.get(letterList.size() - 1);
       for(int i = 0; i < letterList.size(); i++) {
           if(letterList.get(i).getCharacter() == firstLetter.getCharacter() || letterList.get(i).getCharacter() == lastLetter.getCharacter()) {
               letterList.get(i).setHidden(false);
           }
           if (letterList.get(i).isHidden()) {
               System.out.print("_");
           } else {
               System.out.print(letterList.get(i));
           }
       }
    }

    public void guessLetter(char letter) {
        for(int i = 0; i < letterList.size(); i++) {
            if(letterList.get(i).getCharacter() == letter) {
                letterList.get(i).setHidden(false);
            }
        }
    }

    public boolean hasGameEnded() {
        for(int i = 0; i < letterList.size(); i++) {
            if(letterList.get(i).isHidden()) {
                return false;
            }
        }
        return true;
    }

    public boolean isLetterValid(char letter) {
       for(int i = 0; i < letterList.size(); i++) {
           if(letterList.get(i).getCharacter() == letter) {
               return true;
           }
       }
       return false;
    }

    public String initializeWord() {
        List<String> wordList = new ArrayList<>();
        try {
            File file = new File(WORD_LIST_PATH);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                wordList.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Could not get words from file: " + e.getMessage());
            System.out.println("Using default word!");
            return DEFAULT_WORD;
        }
        Random random = new Random();
        return wordList.get(random.nextInt(wordList.size())).toUpperCase();
    }
}
