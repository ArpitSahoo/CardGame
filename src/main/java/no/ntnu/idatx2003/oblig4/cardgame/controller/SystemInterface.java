package no.ntnu.idatx2003.oblig4.cardgame.controller;
import no.ntnu.idatx2003.oblig4.cardgame.deck.DeckOfCards;
import no.ntnu.idatx2003.oblig4.cardgame.gui.View;

public class SystemInterface {
  private DeckOfCards deck;
  private View view;

  public SystemInterface(DeckOfCards deck, View view) {
    this.deck = deck;
    this.view = view;
  }

  public void getCardsToView() {
    deck.dealToHand();
    view.updateCardsInHand();
  }

  public void checkAllCards() {
    deck.isFlush();
    deck.isHearts();
    deck.isSpareQueen();
    deck.sumOfCards();
    view.updateAllChecks();
  }
}
