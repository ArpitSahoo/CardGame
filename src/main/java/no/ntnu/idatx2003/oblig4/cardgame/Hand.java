package no.ntnu.idatx2003.oblig4.cardgame;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Represents the dealers hand.
 *
 * @version 0.0.1
 */
public class Hand {
  private DeckOfCards deck;
  private List<PlayingCard> cardsInHand;

  public Hand() {
    deck = new DeckOfCards();
    cardsInHand = new ArrayList<>();
  }


  public boolean newRound() {
    boolean newGame = false;
    if (cardsInHand.isEmpty()) {
      newGame = true;
      addToHand();
    }
    removeCardsFromHand();
    return newGame;
  }

  public void removeCardsFromHand() {
    cardsInHand.clear();
  }

  public void addToHand() {
    cardsInHand.add(deck.getRandomCard());
  }



}
