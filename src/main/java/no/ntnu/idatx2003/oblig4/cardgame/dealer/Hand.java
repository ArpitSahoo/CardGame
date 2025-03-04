package no.ntnu.idatx2003.oblig4.cardgame.dealer;
import no.ntnu.idatx2003.oblig4.cardgame.deck.DeckOfCards;
import no.ntnu.idatx2003.oblig4.cardgame.cards.PlayingCard;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the dealers hand.
 *
 * @version 0.1.1
 */
public class Hand {
  private final DeckOfCards deck;
  private final List<PlayingCard> cardsInHand;
  private int amountOfCards;

  public Hand() {
    deck = new DeckOfCards();
    cardsInHand = new ArrayList<>();
  }

  /**
   * Mutates the amount of rounds.
   *
   * @param amountOfCards that will be dealt.
   */
  public void setAmountOfCards(int amountOfCards) {
    if (amountOfCards < 1) {
      throw new IllegalArgumentException("Rounds must be greater than 0");
    }
    this.amountOfCards = amountOfCards;
  }

  /**
   * Accesses how many cards in the game.
   *
   * @return amountOfCards that will be played.
   */
  public int getAmountOfCards() {
    return amountOfCards;
  }

  public void newRound() {
    if (cardsInHand.isEmpty()) {
      dealToHand(getAmountOfCards()); // 6 til the user interface has been developed.
    }
    removeCardsFromHand();
  }

  public void removeCardsFromHand() {
    cardsInHand.clear();
  }

  public void dealToHand(int rounds){
    for (int i = 0; i < rounds; i++) {
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
