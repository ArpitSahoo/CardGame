package no.ntnu.idatx2003.oblig4.cardgame.controller;

import no.ntnu.idatx2003.oblig4.cardgame.deck.DeckOfCards;
import no.ntnu.idatx2003.oblig4.cardgame.gui.View;

/**
 * The {@code SystemInterface} class serves as a mediator
 * between the deck of cards and the user interface.
 *
 * <p>It provides methods to update the view with card
 * information and perform various checks on the deck.
 * </p>
 *
 * @since 0.0.1
 * @author arpit
 * @version 0.2.1
 */
public class SystemInterface {
  private DeckOfCards deck;
  private View view;

  /**
   * Constructs a {@code SystemInterface} with the specified deck of cards and view.
   *
   * @param deck the deck of cards used for dealing and checking card conditions
   * @param view the user interface component responsible for displaying card information
   */
  public SystemInterface(DeckOfCards deck, View view) {
    this.deck = deck;
    this.view = view;
  }

  /**
   * Deals cards to the player's hand and updates the view accordingly.
   */
  public void getCardsToView() {
    deck.dealToHand();
    view.updateCardsInHand();
  }

  /**
   * Performs various checks on the deck.
   *
   * <p>spare queen identification, and summing the card values.
   * The results are then updated in the view.
   * </p>
   *
   */
  public void checkAllCards() {
    deck.isFlush();
    deck.isHearts();
    deck.isSpareQueen();
    deck.sumOfCards();
    view.updateAllChecks();
  }

  //TODO create new tests.
}
