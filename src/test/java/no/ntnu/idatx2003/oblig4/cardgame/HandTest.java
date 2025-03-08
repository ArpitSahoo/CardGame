package no.ntnu.idatx2003.oblig4.cardgame;

import no.ntnu.idatx2003.oblig4.cardgame.cards.PlayingCard;
import no.ntnu.idatx2003.oblig4.cardgame.dealer.Hand;
import no.ntnu.idatx2003.oblig4.cardgame.deck.DeckOfCards;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandTest {
  Hand hand;
  DeckOfCards deck;
  PlayingCard playingCard;
  PlayingCard playingCard2;
  PlayingCard playingCard3;
  PlayingCard playingCard4;
  PlayingCard playingCard5;
  PlayingCard playingCard6;

  @BeforeEach
  public void setUp() {
    hand = new Hand();
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
    hand.removeCardsFromHand();
    assertEquals(0, hand.getHandSize());
  }

  @Test
  void positiveTestForAddCardsToHand() {
    hand.addCardsToHand(playingCard);
    assertEquals(1, hand.getHandSize());
  }

  @Test
  void negativeTestForAddCardsToHand() {
    assertNotEquals(1, hand.getHandSize());
  }

  @Test
  void positiveTestForCheckSum() {
    hand.addCardsToHand(playingCard);
    hand.addCardsToHand(playingCard2);
    hand.addCardsToHand(playingCard3);
    hand.addCardsToHand(playingCard4);
    hand.addCardsToHand(playingCard5);

    assertEquals(15,  hand.checkSum());
  }

  @Test
  void negativeTestForCheckSum() {
    hand.addCardsToHand(playingCard);
    hand.addCardsToHand(playingCard2);
    assertNotEquals(15,  hand.checkSum());
  }

  @Test
  void positiveTestForCheckHeart() {
    hand.addCardsToHand(playingCard);
    hand.addCardsToHand(playingCard2);
    assertEquals("H1 H2", hand.checkAllHearts());
  }

  @Test
  void negativeTestForCheckHeart() {
    assertEquals("No Hearts", hand.checkAllHearts());
  }

  @Test
  void positiveTestForCheckSpareQueen() {
    hand.addCardsToHand(playingCard6);
    assertTrue(hand.checkSpareQueen());
  }

  @Test
  void negativeTestForCheckSpareQueen() {
    assertFalse(hand.checkSpareQueen());
  }

  @Test
  void positiveTestForFlush() {
    hand.addCardsToHand(playingCard);
    hand.addCardsToHand(playingCard2);
    hand.addCardsToHand(playingCard3);
    hand.addCardsToHand(playingCard4);
    hand.addCardsToHand(playingCard5);

    assertTrue(hand.checkFlush());
  }

  @Test
  void negativeTestForFlush() {
    hand.addCardsToHand(playingCard);
    hand.addCardsToHand(playingCard2);
    hand.addCardsToHand(playingCard3);
    hand.addCardsToHand(playingCard4);
    hand.addCardsToHand(playingCard6);

    assertFalse(hand.checkFlush());
  }

  @Test
  void positiveTestGetAllCards() {
    hand.addCardsToHand(playingCard);
    hand.addCardsToHand(playingCard2);
    hand.addCardsToHand(playingCard3);
    hand.addCardsToHand(playingCard4);
    hand.addCardsToHand(playingCard5);
    assertEquals("H1 H2 H3 H4 H5", hand.getAllCards());
  }

}
