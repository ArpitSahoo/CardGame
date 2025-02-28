package no.ntnu.idatx2003.oblig4.cardgame;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Deck, which is a collection of {@link PlayingCard} objects.
 *
 */
public class DeckOfCards {
  private List<PlayingCard> cards;
  private PlayingCard newPlayingCard;
  private final char[] suits = { 'S', 'H', 'D', 'C' };

  public DeckOfCards() {
    cards = new ArrayList<>();
    addToDeck();
  }

  public void addToDeck() {
    for (char suit: suits) {
      for (int cardsNumber = 1; cardsNumber < 14; cardsNumber++) {
        newPlayingCard = new PlayingCard(suit, cardsNumber);
        cards.add(newPlayingCard);
      }
    }
  }

  public List<PlayingCard> getCards() {
    return cards;
  }

}
