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

  public Hand() {
    deck = new DeckOfCards();
    cardsInHand = new ArrayList<>();
  }

  public void addCardsToHand(PlayingCard card) {
    cardsInHand.add(card);
  }

  public void newRound() {
    if (cardsInHand.isEmpty()) {

    }
    removeCardsFromHand();
  }

  public void removeCardsFromHand() {
    cardsInHand.clear();
  }

  public int getHandSize() {
    return cardsInHand.size();
  }

}
