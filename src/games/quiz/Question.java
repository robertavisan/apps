package games.quiz;

import java.util.List;

public class Question {

    private String question;
    private List<String> answers;
    private String rightAnswer;

    public Question(String question, List<String> answers, String rightAnswer) {
        this.question = question;
        this.answers = answers;
        this.rightAnswer = rightAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public void printAnswers() {
        char letter = 'a';
        for(int i = 0; i < answers.size(); i++) {
            System.out.println((char)(letter + i) + ". " + answers.get(i));
        }
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

}
