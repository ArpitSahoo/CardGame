package no.ntnu.idatx2003.oblig4.cardgame;

import no.ntnu.idatx2003.oblig4.cardgame.dealer.Hand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandTest {
  Hand hand;

  @BeforeEach
  public void setUp() {
    hand = new Hand();
  }

  @Test
  void removeCardsFromHandPositiveTest() {
    hand.newRound();
    hand.removeCardsFromHand();
    assertEquals(0, hand.getHandSize());
  }

}
