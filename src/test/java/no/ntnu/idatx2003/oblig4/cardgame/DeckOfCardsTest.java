package no.ntnu.idatx2003.oblig4.cardgame;

import static org.junit.jupiter.api.Assertions.*;

import no.ntnu.idatx2003.oblig4.cardgame.cards.PlayingCard;
import no.ntnu.idatx2003.oblig4.cardgame.deck.DeckOfCards;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


class DeckOfCardsTest {
  DeckOfCards deck = new DeckOfCards();
  PlayingCard playingCard;
  final char[] suits = { 'S', 'H', 'D', 'C' };
  List<PlayingCard>cards;
    List<PlayingCard> expected;
  @BeforeEach
  void setUp() {
    cards = new ArrayList<>();
    deck = new DeckOfCards();
    expected = new ArrayList<>();
    expected.addAll(deck.getCards());
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
    int initialSize = deck.getCards().size();
    deck.removeCardFromDeck(0);
    assertNotEquals(initialSize, deck.getCards().size(), "The deck size should be reduced by one");
  }

}