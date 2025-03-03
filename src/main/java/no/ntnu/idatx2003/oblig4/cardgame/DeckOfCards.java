package no.ntnu.idatx2003.oblig4.cardgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Represents a Deck, which is a collection of {@link PlayingCard} objects.
 *
 * @version 0.1.0
 */
public class DeckOfCards {
  private List<PlayingCard> cards;
  private PlayingCard newPlayingCard;
  private final char[] suits = { 'S', 'H', 'D', 'C' };
  private Random randomCard;

  public DeckOfCards() {
    cards = new ArrayList<>();
    addToDeck();
    randomCard = new Random();
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

  public List<PlayingCard> dealHand(int n) {
    List<PlayingCard> hand = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      int index = randomCard.nextInt(cards.size());
      hand.add(cards.get(index));
    }
    return hand;
  }
}
