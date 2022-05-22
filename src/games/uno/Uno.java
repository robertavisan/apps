package games.uno;

import java.util.Scanner;

public class Uno {

    public static void main(String[] args) {
        
        Game game = new Game();
        game.printDeckSize();
        System.out.println("Played = " + game.getFirstCard());

        Scanner scanner = new Scanner(System.in);
        boolean isPlayerTurn = true;
        while (!game.hasGameEnded()) {
            /*
                1. Decide if we draw (skip)
                1a. If we skip, go to next player.
                1b. If we don't skip, go to step 2.
                2. Play card.
                3. Go to step 1.
             */
            System.out.println();
            if (isPlayerTurn) {
                System.out.println("Player turn");
            } else {
                System.out.println("Computer turn");
            }
            printHand(isPlayerTurn, game);
            System.out.println("Last card played = " + game.getFirstCard());

            System.out.println("Insert card number, followed by space, and symbol in UPPERCASE that you want to play:");
            String input = scanner.nextLine();
            if (!input.equalsIgnoreCase("skip")) {
                String[] split = input.split(" ");
                int cardNumber = Integer.parseInt(split[0]);
                char symbol = split[1].charAt(0);

                Card newCard = new Card(cardNumber, symbol);
                game.playCard(isPlayerTurn, newCard);
            } else {
                game.drawCard(isPlayerTurn);
                game.printDeckSize();
            }
            isPlayerTurn = !isPlayerTurn;
            game.reshuffle();
        }
        game.printFinalMessage();
    }

    public static void printHand(boolean isPlayerTurn, Game game) {
        if (isPlayerTurn) {
            System.out.print("Player");
        } else {
            System.out.print("Computer");
        }
        System.out.println(" hand = " + game.getHand(isPlayerTurn));
    }
}

