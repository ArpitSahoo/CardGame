package no.ntnu.idatx2003.oblig4.cardgame.dealer;
import no.ntnu.idatx2003.oblig4.cardgame.cards.PlayingCard;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents the dealers hand.
 *
 * @version 0.2.2
 */
public class Hand {
  private List<PlayingCard> cardsInHand;

  public Hand() {
    cardsInHand = new ArrayList<>();
  }

  /**
   * Adds cards to the hand.
   *
   * @param card in the hand.
   */
  public void addCardsToHand(PlayingCard card) {
    cardsInHand.add(card);
  }

  /**
   * Clears all the cards in the hand.
   *
   */
  public void removeCardsFromHand() {
    cardsInHand.clear();
  }

  /**
   * Gets the amount of cards in the hand.
   *
   * @return cardsInHand.size();
   */
  public int getHandSize() {
    return cardsInHand.size();
  }

  /**
   * Calculates the total sum of the cards.
   *
   * @return an integer of the total sum.
   */
  public int checkSum() {
    return cardsInHand
        .stream()
        .mapToInt(PlayingCard::getFace)
        .sum();
  }


  /**
   *
   * @return
   */
  public String checkAllHearts() {
    String hearts = cardsInHand.stream()
        .filter(card -> card.getSuit() == 'H')
        // map makes the two fields to one
        .map(card -> card.getSuit() + String.valueOf(card.getFace()))
        // Collect: collects all the streams to one with a space.
        .collect(Collectors.joining(" "));
    return hearts.isEmpty() ? "No Hearts" : hearts;
  }

  public boolean checkSpareQueen() {
    return cardsInHand.stream()
        .anyMatch(card -> card.getSuit() == 'S' && card.getFace() == 12);
  }

  public boolean checkFlush() {
    return cardsInHand.stream()
        .allMatch(card -> cardsInHand.getFirst().getSuit() == card.getSuit());
  }

  public String getAllCards() {
    return cardsInHand.stream()
        .map(card -> card.getSuit() + String.valueOf(card.getFace()))
        .collect(Collectors.joining(" "));
  }
}
