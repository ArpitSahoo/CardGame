package no.ntnu.idatx2003.oblig4.cardgame;

import static org.junit.jupiter.api.Assertions.*;
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

}