package no.ntnu.idatx2003.oblig4.cardgame;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the dealers hand.
 *
 * @version 0.1.0
 */
public class Hand {
  private DeckOfCards deck;
  private List<PlayingCard> cardsInHand;

  public Hand() {
    deck = new DeckOfCards();
    cardsInHand = new ArrayList<>();
  }


  public void newRound() {
    boolean newGame = false;
    if (cardsInHand.isEmpty()) {
      newGame = true;
      dealToHand(6); // 6 til the user interface has been developed.
    }
    removeCardsFromHand();
  }

  public void removeCardsFromHand() {
    cardsInHand.clear();
  }

  public void dealToHand(int n){
    if (n <= 0) {
      throw new IllegalArgumentException("Dealer can not deal 0 or less");
    }
    for (int i = 0; i < n; i++) {
      addToHand();
    }
  }

  public void addToHand() {
    cardsInHand.add(deck.getRandomCard());
  }

  public int getHandSize() {
    return cardsInHand.size();
  }



}
