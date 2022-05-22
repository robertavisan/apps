package games.quiz;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Quiz {


   private List<Question> questionList;

    public Quiz() {
        questionList = new ArrayList<>();

        Question question1 = new Question("A person with well developed abdominal muscles is said to have a what?",
                Arrays.asList("one-pack", "six-pack", "12-pack", "family-pack"), "b");
        Question question2 = new Question("Which two words traditionally appear onscreen at the termination of a film?",
                Arrays.asList("the end", "the conclusion", "the finish", "the pizza rolls are done"), "a");
        Question question3 = new Question("A magnet would most likely attract which of the following?",
                Arrays.asList("metal", "plastic", "wood", "the wrong man"), "a");
        Question question4 = new Question("Which of these names is not in the title of a Shakespeare play?",
                Arrays.asList("Hamlet", "Romeo", "Macbeth", "Darren"), "d");
        Question question5 = new Question("Where did scotch whisky originate?",
                Arrays.asList("Ireland", "Wales", "The United States", "Scotland"), "d");
        Question question6 = new Question("What name is traditionally given to the party held for a woman who is expecting a baby?",
                Arrays.asList("baby drizzle", "baby shower", "baby downpour", "baby deluge"), "b");
        Question question7 = new Question("In the United States what is traditionally the proper way to address a judge?",
                Arrays.asList("your holiness", "your honor", "your eminence", "you da man!"), "b");
        Question question8 = new Question("If someone asked to see your ID, what might you show them?",
                Arrays.asList("your tongue", "your teeth", "your passport", "the door"), "c");
        Question question9 = new Question("A well-known lyric int the holiday song Silver Bells promises that soon it will be what?",
                Arrays.asList("july 4th weekend", "halloween night", "christmas day", "national burrito month"), "c");
        Question question10 = new Question("Something in an obvious location is said to be right under your what?",
                Arrays.asList("mattress", "nose", "azaleas", "boxer shorts"), "b");

        questionList.add(question1);
        questionList.add(question2);
        questionList.add(question3);
        questionList.add(question4);
        questionList.add(question5);
        questionList.add(question6);
        questionList.add(question7);
        questionList.add(question8);
        questionList.add(question9);
        questionList.add(question10);
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void printQuestion(String question) {
        for(int i = 0; i < questionList.size(); i++) {
            if(questionList.get(i).getQuestion().equalsIgnoreCase(question)) {
                System.out.println(i + 1 + ". " + questionList.get(i).getQuestion());
            }
        }
    }

    public boolean isAnswerRight(Question question, String answer) {
        return question.getRightAnswer().equalsIgnoreCase(answer);
    }

    public void playGame() {
        System.out.println("Answer the following questions and find out your final score.");
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        for (Question question : getQuestionList()) {
            printQuestion(question.getQuestion());
            question.printAnswers();
            System.out.println("Choose answer:");
            String answer = scanner.nextLine();
            if (isAnswerRight(question, answer)) {
                score = score + 1;
                System.out.println("Your score is " + score);
            } else {
                System.out.println("The correct answer was " + question.getRightAnswer());
            }

            System.out.println();
        }

        System.out.println("Congratulations, your final score is " + score + " points");
    }

}
