package no.ntnu.idatx2003.oblig4.cardgame.controller;

import no.ntnu.idatx2003.oblig4.cardgame.dealer.Hand;
import no.ntnu.idatx2003.oblig4.cardgame.deck.DeckOfCards;
import no.ntnu.idatx2003.oblig4.cardgame.gui.View;

public class SystemInterface {
  private DeckOfCards deck;
  private View view;
  private Hand hand;

  public SystemInterface(DeckOfCards deck, View view) {
    deck = new DeckOfCards();
    view = new View();
  }

  public void getCardsToView() {
    deck.dealToHand();

  }

}
