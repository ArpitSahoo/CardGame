package no.ntnu.idatx2003.oblig4.cardgame;

import static org.junit.jupiter.api.Assertions.*;

import no.ntnu.idatx2003.oblig4.cardgame.cards.PlayingCard;
import org.junit.jupiter.api.Test;

class PlayingCardTest {
  PlayingCard playingCardPositive;
  PlayingCard playingCardNegative1;
  PlayingCard playingCardNegative2;

  @Test
  void positiveTestForSuits() {
    playingCardPositive = new PlayingCard('H', 3);
    assertEquals('H', playingCardPositive.getSuit());
    assertEquals(3, playingCardPositive.getFace());
  }

  @Test
  void negativeTestForSuits() {
    assertThrows(IllegalArgumentException.class, () -> playingCardNegative1 = new PlayingCard('Z', 3));
  }

  @Test
  void negativeTestForFaces() {
    assertThrows(IllegalArgumentException.class, () -> playingCardNegative2 = new PlayingCard('H', 55));
  }

  @Test
  void testEqualsPositiveTest() {
    PlayingCard card1 = new PlayingCard('S', 12); // Queen of Spades
    PlayingCard card2 = new PlayingCard('S', 12); // Queen of Spades

    boolean isTrue = card1.equals(card2);
    boolean isTrue2 = card2.equals(card1);
    assertTrue(isTrue);
    assertTrue(isTrue2);
  }

  @Test
  void testEqualsNegativeTest() {
    PlayingCard card1 = new PlayingCard('S', 12);
    PlayingCard card2 = new PlayingCard('S', 12);
    PlayingCard card3 = new PlayingCard('H', 10);

    boolean isFalse = card1.equals(card3);
    boolean isFalse2 = card2.equals(card3);
    assertFalse(isFalse);
    assertFalse(isFalse2);
  }

  @Test
  void testHashCodePositiveTest() {
    PlayingCard card1 = new PlayingCard('S', 12);
    PlayingCard card2 = new PlayingCard('S', 12);

    // Test hash codes with same values
    assertEquals(card1.hashCode(), card2.hashCode());
  }

  @Test
  void testHashCodeNegativeTest() {
    PlayingCard card1 = new PlayingCard('S', 12);
    PlayingCard card2 = new PlayingCard('H', 10);
    assertNotEquals(card1.hashCode(), card2.hashCode());
  }


  @Test
  void testGetAsString() {
    PlayingCard card1 = new PlayingCard('S', 12); // Queen of Spades
    PlayingCard card2 = new PlayingCard('H', 10); // Ten of Hearts

    // Test string representation
    assertEquals("S12", card1.getAsString());
    assertEquals("H10", card2.getAsString());
  }

}