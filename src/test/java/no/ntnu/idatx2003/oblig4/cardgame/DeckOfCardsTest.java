package no.ntnu.idatx2003.oblig4.cardgame;

import static org.junit.jupiter.api.Assertions.*;

import no.ntnu.idatx2003.oblig4.cardgame.cards.PlayingCard;
import no.ntnu.idatx2003.oblig4.cardgame.dealer.Hand;
import no.ntnu.idatx2003.oblig4.cardgame.deck.DeckOfCards;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


class DeckOfCardsTest {
  DeckOfCards deck = new DeckOfCards();
  Hand hand;
  List<PlayingCard> expected;
  PlayingCard playingCard1;
  PlayingCard playingCard2;
  PlayingCard playingCard3;
  PlayingCard playingCard4;
  PlayingCard playingCard5;
  PlayingCard playingCard6;

  @BeforeEach
  void setUp() {
    hand = new Hand();
    deck = new DeckOfCards();
    expected = new ArrayList<>();
    expected.addAll(deck.getCards());

    playingCard1 = new PlayingCard('H', 1);
    playingCard2 = new PlayingCard('H', 2);
    playingCard3 = new PlayingCard('H', 3);
    playingCard4 = new PlayingCard('H', 4);
    playingCard5 = new PlayingCard('H', 5);
    playingCard6 = new PlayingCard('S', 6);
  }

  @Test
  void addToDeckPositiveTest(){
    // Assert
    assertEquals(52, deck.getCards().size());
  }

  @Test
  void addToDeckNegativeTest(){
    assertNotEquals(-1, deck.getCards().size());
    assertNotEquals(55, deck.getCards().getFirst().getSuit());
  }

  @Test
  void RandomIndexNumberPositiveTest(){
    boolean correctIndex = false;
    int index = deck.randomIndexNumber();
    if(index <=deck.getCards().size()){
      correctIndex = true;
    }
    assertTrue(correctIndex);
  }

  @Test
  void RandomIndexNumberNegativeTest(){
    boolean wrongIndex = false;
    int index = deck.randomIndexNumber();
    if(index < 0 || index >= deck.getCards().size()){
      wrongIndex = true;
    }
    assertFalse(wrongIndex);
  }

  @Test
  void getRandomCardPositiveTest() {
    deck.getRandomCard();
    assertEquals(expected.size() - 1, deck.getCards().size(), "The deck size should be reduced by one");
  }

  @Test
  void GetRandomCardNegativeTest() {
    PlayingCard randomCard = deck.getRandomCard();
    assertNotNull(randomCard, "The random card should not be null");
    assertFalse(deck.getCards().contains(randomCard), "The deck should no longer contain the drawn card");
  }

  @Test
  void RemoveCardFromDeckPositiveTest() {
    int initialSize = deck.getCards().size();
    deck.removeCardFromDeck(0);
    assertEquals(initialSize - 1, deck.getCards().size(), "The deck size should be reduced by one");
  }

  @Test
  void RemoveCardFromDeckNegativeTest() {
    deck.removeCardFromDeck(0);
    assertNotEquals(0, deck.getCards().size());
  }

  @Test
  void positiveTestForDealToHand() {
    deck.dealToHand();
    assertEquals(52 - 5, deck.getCards().size(), "The deck size should be reduced by 5" );
  }

  @Test
  void negativeTestForDealToHand() {
    deck.dealToHand();
    assertNotEquals(0, deck.getCards().size());
    assertNotEquals(52, deck.getCards().size());
    assertNotEquals(52-4, deck.getCards().size());
  }

  @Test
  void isFlushPositiveTest() {
    hand.addCardsToHand(playingCard1);
    hand.addCardsToHand(playingCard2);
    hand.addCardsToHand(playingCard3);
    hand.addCardsToHand(playingCard4);
    hand.addCardsToHand(playingCard5);

    assertEquals("FLUSH BABY", deck.isFlush());
  }
}