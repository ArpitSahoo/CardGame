package no.ntnu.idatx2003.oblig4.cardgame;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


class DeckOfCardsTest {
  DeckOfCards deck = new DeckOfCards();
  PlayingCard playingCard;
  final char[] suits = { 'S', 'H', 'D', 'C' };
  List<PlayingCard>cards;

  @BeforeEach
  void setUp() {
    cards = new ArrayList<>();
    deck = new DeckOfCards();
  }

  @Test
  void addToDeckPositiveTest(){
    // Assert
    assertEquals(52, deck.getCards().size());
  }


}