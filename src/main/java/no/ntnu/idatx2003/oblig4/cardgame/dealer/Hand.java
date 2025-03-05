package no.ntnu.idatx2003.oblig4.cardgame.dealer;
import no.ntnu.idatx2003.oblig4.cardgame.cards.PlayingCard;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the dealers hand.
 *
 * @version 0.1.1
 */
public class Hand {
  private final List<PlayingCard> cardsInHand;

  public Hand() {
    cardsInHand = new ArrayList<>();
  }

  public void addCardsToHand(PlayingCard card) {
    cardsInHand.add(card);
  }

  public void newRound() {
    removeCardsFromHand();
  }

  public void removeCardsFromHand() {
    cardsInHand.clear();
  }

  public int getHandSize() {
    return cardsInHand.size();
  }

  public int checkSum() {
    return cardsInHand.stream().mapToInt(PlayingCard::getFace).sum();
  }

  public String checkAllHearts() {
    return cardsInHand.stream()
        .filter(card -> card.getSuit() == 'H')
        .toList()
        .toString();
  }

  public String checkSpareQueen() {
    return cardsInHand.stream()
        .filter(card -> card.getSuit() == 'S')
        .filter(card -> card.getFace() == 12)
        .toList()
        .toString();
  }



}
