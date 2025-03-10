package no.ntnu.idatx2003.oblig4.cardgame;

import no.ntnu.idatx2003.oblig4.cardgame.cards.PlayingCard;
import no.ntnu.idatx2003.oblig4.cardgame.dealer.DealersHand;
import no.ntnu.idatx2003.oblig4.cardgame.deck.DeckOfCards;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DealersHandTest {
  DealersHand dealersHand;
  DeckOfCards deck;
  PlayingCard playingCard;
  PlayingCard playingCard2;
  PlayingCard playingCard3;
  PlayingCard playingCard4;
  PlayingCard playingCard5;
  PlayingCard playingCard6;

  @BeforeEach
  public void setUp() {
    dealersHand = new DealersHand();
    deck = new DeckOfCards();
    playingCard = new PlayingCard('H', 1);
    playingCard2 = new PlayingCard('H', 2);
    playingCard3 = new PlayingCard('H', 3);
    playingCard4 = new PlayingCard('H', 4);
    playingCard5 = new PlayingCard('H', 5);
    playingCard6 = new PlayingCard('S', 12);
  }

  @Test
  void removeCardsFromHandPositiveTest() {
    dealersHand.removeCardsFromHand();
    assertEquals(0, dealersHand.getHandSize());
  }

  @Test
  void positiveTestForAddCardsToHand() {
    dealersHand.addCardsToHand(playingCard);
    assertEquals(1, dealersHand.getHandSize());
  }

  @Test
  void negativeTestForAddCardsToHand() {
    assertNotEquals(1, dealersHand.getHandSize());
  }

  @Test
  void positiveTestForCheckSum() {
    dealersHand.addCardsToHand(playingCard);
    dealersHand.addCardsToHand(playingCard2);
    dealersHand.addCardsToHand(playingCard3);
    dealersHand.addCardsToHand(playingCard4);
    dealersHand.addCardsToHand(playingCard5);

    assertEquals(15,  dealersHand.checkSum());
  }

  @Test
  void negativeTestForCheckSum() {
    dealersHand.addCardsToHand(playingCard);
    dealersHand.addCardsToHand(playingCard2);
    assertNotEquals(15,  dealersHand.checkSum());
  }

  @Test
  void positiveTestForCheckHeart() {
    dealersHand.addCardsToHand(playingCard);
    dealersHand.addCardsToHand(playingCard2);
    assertEquals("H1 H2", dealersHand.checkAllHearts());
  }

  @Test
  void negativeTestForCheckHeart() {
    assertEquals("No Hearts", dealersHand.checkAllHearts());
  }

  @Test
  void positiveTestForCheckSpareQueen() {
    dealersHand.addCardsToHand(playingCard6);
    assertTrue(dealersHand.checkSpareQueen());
  }

  @Test
  void negativeTestForCheckSpareQueen() {
    assertFalse(dealersHand.checkSpareQueen());
  }

  @Test
  void positiveTestForFlush() {
    dealersHand.addCardsToHand(playingCard);
    dealersHand.addCardsToHand(playingCard2);
    dealersHand.addCardsToHand(playingCard3);
    dealersHand.addCardsToHand(playingCard4);
    dealersHand.addCardsToHand(playingCard5);

    assertTrue(dealersHand.checkFlush());
  }

  @Test
  void negativeTestForFlush() {
    dealersHand.addCardsToHand(playingCard);
    dealersHand.addCardsToHand(playingCard2);
    dealersHand.addCardsToHand(playingCard3);
    dealersHand.addCardsToHand(playingCard4);
    dealersHand.addCardsToHand(playingCard6);

    assertFalse(dealersHand.checkFlush());
  }

  @Test
  void positiveTestGetAllCards() {
    dealersHand.addCardsToHand(playingCard);
    dealersHand.addCardsToHand(playingCard2);
    dealersHand.addCardsToHand(playingCard3);
    dealersHand.addCardsToHand(playingCard4);
    dealersHand.addCardsToHand(playingCard5);
    assertEquals("H1 H2 H3 H4 H5", dealersHand.getAllCards());
  }

}
