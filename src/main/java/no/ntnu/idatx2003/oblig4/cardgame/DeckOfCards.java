package no.ntnu.idatx2003.oblig4.cardgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Represents a Deck, which is a collection of {@link PlayingCard} objects.
 *
 * @version 0.2.0
 */
public class DeckOfCards {
  private List<PlayingCard> cards;
  private PlayingCard newPlayingCard;
  private final char[] suits = { 'S', 'H', 'D', 'C' };
  private final Random randomCard;

  /**
   * Creates a deck of cards.
   *
   */
  public DeckOfCards() {
    cards = new ArrayList<>();
    addToDeck();
    randomCard = new Random();
  }

  /**
   * A method that creates and adds cards to the deck.
   *
   */
  public void addToDeck() {
    for (char suit: suits) {
      for (int cardsNumber = 1; cardsNumber < 14; cardsNumber++) {
        newPlayingCard = new PlayingCard(suit, cardsNumber);
        cards.add(newPlayingCard);
      }
    }
  }

  /**
   * A method that retrieves cards from the deck.
   *<p>This method is used for the test class.</p>
   * @return cards.
   */
  public List<PlayingCard> getCards() {
    return cards; //only for test methods.
  }

  /**
   * Access the number of cards in the deck.
   * @return returns the number of cards in the deck.
   */
  public int getSize(){
    return cards.size();
  }

  /**
   * Generates a random number from the number of cards
   * in the deck.
   * @return random number.
   */
  public int randomIndexNumber() {
    return randomCard.nextInt(getSize());
  }

  /**
   * Accesses a random card from the deck.
   * @return a random card from the deck.
   */
  public PlayingCard getRandomCard() {
    int index = randomIndexNumber(); // Get a random index
    PlayingCard randomCard = cards.get(index); // Retrieve the card at that index
    removeCardFromDeck(index);
    return randomCard; // Return the random card
  }

  /**
   * Removes the card from the deck.
   * @param index of the card that will be removed from the deck.
   */
  public void removeCardFromDeck(int index) {
    cards.remove(index);
  }

}
