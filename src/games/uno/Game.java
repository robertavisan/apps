package games.uno;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {

    private List<Card> deck;
    private List<Card> played;
    private List<Card> playerHand;
    private List<Card> computerHand;

    public Game() {

        deck = new ArrayList<>();
        for (int i = 2; i < 15; i++) {
            deck.add(new Card(i, 'A'));
            deck.add(new Card(i, 'B'));
            deck.add(new Card(i, 'C'));
            deck.add(new Card(i, 'D'));
        }
        Collections.shuffle(deck);

        played = new ArrayList<>();
        played.add(deck.get(0));
        deck.remove(0);


        playerHand = draw5Cards();
        computerHand = draw5Cards();
    }

    private List<Card> draw5Cards() {
        List<Card> hand = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            hand.add(deck.get(0));
            deck.remove(0);
        }
        return hand;
    }

    public void drawCard(boolean forPlayer) {
        if (forPlayer) {
            playerHand.add(deck.get(0));
        } else {
            computerHand.add(deck.get(0));
        }
        deck.remove(0);
    }

    public void playCard(boolean isPlayerTurn, Card card) {
        if (isCardValid(card.getNumber(), card.getSymbol())) {
            played.add(card);
            removeCard(isPlayerTurn, card);
        }
    }

   public boolean isCardValid(int cardNumber, char symbol) {
        if(getFirstCard().getNumber() == cardNumber || getFirstCard().getSymbol() == symbol) {
            return true;
        }
        return false;
   }

   public Card getFirstCard() {
        return played.get(played.size() - 1);
   }

   public boolean hasGameEnded() {
        if(playerHand.size() == 0 || computerHand.size() == 0) {
            return true;
        }
        return false;
   }

   public void printFinalMessage() {
        if(playerHand.size() == 0) {
            System.out.println("Player won!");
        } else if(computerHand.size() == 0) {
            System.out.println("Computer won!");
        }
   }

    public void removeCard(boolean isPlayerTurn, Card playedCard) {
        if (isPlayerTurn) {
            for (int i = 0; i < playerHand.size(); i++) {
                if (playerHand.get(i).getNumber() == playedCard.getNumber() && playerHand.get(i).getSymbol() == playedCard.getSymbol()) {
                    playerHand.remove(i);
                    return;
                }
            }
        } else {
            for(int i = 0; i < computerHand.size(); i++) {
                if(computerHand.get(i).getNumber() == playedCard.getNumber() && computerHand.get(i).getSymbol() == playedCard.getSymbol()) {
                    computerHand.remove(i);
                    return;
                }
            }
        }
    }

    public List<Card> getHand(boolean isPlayerTurn) {
        if (isPlayerTurn) {
            return playerHand;
        } else {
            return computerHand;
        }
    }

    public void reshuffle() {
        if (deck.isEmpty()) {
            deck.addAll(played);
            deck.remove(deck.size() - 1);
            Collections.shuffle(deck);

            Card firstCard = getFirstCard();
            played = new ArrayList<>();
            played.add(firstCard);
        }
    }

    public void printDeckSize() {
        System.out.println("Deck size = " + deck.size());
    }


    @Override
    public String toString() {
        return "played =" + played + "\n" +
                "playerHand = " + playerHand + "\n" +
                "computerHand = " + computerHand;
    }
}
