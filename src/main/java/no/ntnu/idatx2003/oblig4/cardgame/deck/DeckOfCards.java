package no.ntnu.idatx2003.oblig4.cardgame.deck;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import no.ntnu.idatx2003.oblig4.cardgame.cards.PlayingCard;
import no.ntnu.idatx2003.oblig4.cardgame.dealer.Hand;

/**
 * Represents a Deck, which is a collection of {@link PlayingCard} objects.
 *
 * @version 0.3.0
 */
public class DeckOfCards {
  private List<PlayingCard> cards;
  private final char[] suits = { 'S', 'H', 'D', 'C' };
  private final Random randomCard;
  private final Hand hand;

  /**
   * Creates a deck of cards.
   *
   */
  public DeckOfCards() {
    hand = new Hand();
    cards = new ArrayList<>();
    addToDeck();
    randomCard = new Random();
  }

  /**
   * A method that creates and adds cards to the deck.
   *
   */
  public void addToDeck() {
    for (char suit : suits) {
      for (int cardsNumber = 1; cardsNumber < 14; cardsNumber++) {
        PlayingCard newPlayingCard = new PlayingCard(suit, cardsNumber);
        cards.add(newPlayingCard);
      }
    }
  }

  /**
   * A method that retrieves cards from the deck.
   *
   *<p>This method is used for the test class.</p>
   *
   * @return cards.
   */
  public List<PlayingCard> getCards() {
    return cards; //only for test methods.
  }

  /**
   * Access the number of cards in the deck.
   *
   * @return returns the number of cards in the deck.
   */
  public int getSize() {
    return cards.size();
  }

  /**
   * Generates a random number from the number of cards
   * in the deck.
   *
   * @return random number.
   */
  public int randomIndexNumber() {
    return randomCard.nextInt(getSize());
  }

  /**
   * Accesses a random card from the deck.
   *
   * @return a random card from the deck.
   */
  public PlayingCard getRandomCard() {
    int index = randomIndexNumber(); // Get a random index
    PlayingCard randomCardToGet = cards.get(index); // Retrieve the card at that index
    removeCardFromDeck(index);
    return randomCardToGet; // Return the random card
  }

  /**
   * Removes the card from the deck.
   *
   * @param index of the card that will be removed from the deck.
   */
  public void removeCardFromDeck(int index) {
    cards.remove(index);
  }

  /**
   * Clears all cards from the deck.
   */
  public void clearTheDeck() {
    cards.clear();
  }

  /**
   * Creates a new deck of cards if there is
   * an inefficients amount of cards.
   */
  public void newDeck() {
    if (getSize() < 6) {
      clearTheDeck();
      addToDeck();
    }
  }

  /**
   * A method that deals the cards to the player.
   */
  public void dealToHand() {
    newDeck();
    hand.removeCardsFromHand();
    int cardsToDeal = 5;
    for (int i = 0; i < cardsToDeal; i++) {
      PlayingCard playingCardToBeDealt = getRandomCard();
      hand.addCardsToHand(playingCardToBeDealt);
    }
  }

  /**
   * Checks if the hand contains a flush (all cards of the same suit).
   *
   * @return a string if it's a flush or not.
   */
  public String isFlush() {
    if (hand.checkFlush()) {
      return "FLUSH BABY";
    }
    return "No flush";
  }

  /**
   * Checks if the hand contains a spare queen.
   *
   * @return Returns a spring if there is a spare queen.
   */
  public String isSpareQueen() {
    if (hand.checkSpareQueen()) {
      return "FOUND";
    }
    return "None..";
  }

  /** Check if the hand contains a hearts.
   *
   * @return A string of all the hearts.
   */
  public String isHearts() {
    return hand.checkAllHearts();
  }

  /**
   * Calculates the sum of all the cards on the hand.
   *
   * @return hand.checkSum();
   */
  public int sumOfCards() {
    return hand.checkSum();
  }

  /**
   * Retrieves all the cards from the hand.
   *
   * @return all the cards from the hand.
   */
  public String getCardsFromHand() {
    return hand.getAllCards();
  }

  //TODO create new tests.
}
