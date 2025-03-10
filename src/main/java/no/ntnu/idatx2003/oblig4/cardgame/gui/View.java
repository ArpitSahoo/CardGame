package no.ntnu.idatx2003.oblig4.cardgame.gui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import no.ntnu.idatx2003.oblig4.cardgame.controller.SystemInterface;
import no.ntnu.idatx2003.oblig4.cardgame.deck.DeckOfCards;

/**
 * The {@code View} class creates a graphical user interface for interacting with a deck of cards.
 * It provides a layout for displaying the dealt cards and checking various card conditions.
 *
 * @since 0.0.1
 * @author Arpit
 * @version 0.2.0
 */
public class View extends Application {
  private SystemInterface controller;
  private DeckOfCards deck;
  private Text cardsInHand;
  private Text heartsFound;
  private Text wasFound;
  private Text flushFound;
  private Text totalSum;

  /**
   * Starts the JavaFX application and initializes the user interface.
   *
   * @param stage the primary stage for this application
   * @throws Exception if an error occurs during initialization
   */
  @Override
  public void start(Stage stage) throws Exception {
    deck = new DeckOfCards();
    controller = new SystemInterface(deck, this);
    BorderPane borderPane = new BorderPane();
    borderPane.setCenter(centerPaneCreate());
    Scene scene = new Scene(borderPane);
    stage.setScene(scene);
    stage.setTitle("Poker");
    stage.show();
  }

  /**
   * Creates the center pane containing buttons and card details.
   *
   * @return a {@code Pane} containing the interface layout
   */
  public Pane centerPaneCreate() {
    VBox centerPane = new VBox();
    centerPane.getChildren().addAll(buttonAndCards(), getCheckCardPane());
    return centerPane;
  }

  /**
   * Creates a horizontal box containing buttons and the card display area.
   *
   * @return an {@code HBox} containing buttons and card display
   */
  public HBox buttonAndCards() {
    HBox buttonAndCards = new HBox();
    buttonAndCards.getChildren().addAll(getCardPane(), getButtons());
    return buttonAndCards;
  }

  /**
   * Creates a pane for displaying the cards in hand.
   *
   * @return a {@code FlowPane} containing the displayed cards
   */
  public FlowPane getCardPane() {
    FlowPane cardPane = new FlowPane();
    cardPane.setStyle("-fx-background-color: lightblue;");
    cardsInHand = new Text("");
    cardsInHand.setFont(new Font(40));
    cardsInHand.setTextAlignment(TextAlignment.CENTER);
    cardPane.getChildren().add(cardsInHand);
    return cardPane;
  }

  /**
   * Updates the displayed cards in hand.
   */
  public void updateCardsInHand() {
    if (deck != null && cardsInHand != null) {
      cardsInHand.setText(deck.getCardsFromHand());
    }
  }

  /**
   * Creates a button panel for dealing and checking cards.
   *
   * @return a {@code FlowPane} containing control buttons
   */
  private FlowPane getButtons() {
    FlowPane buttonPane = new FlowPane();

    Button dealButton = new Button("Deal hand");
    dealButton.setPrefWidth(200);
    dealButton.setPrefHeight(30);
    dealButton.setOnAction(event -> controller.getCardsToView());

    Button checkButton = new Button("Check hand");
    checkButton.setPrefWidth(200);
    checkButton.setPrefHeight(30);
    checkButton.setOnAction(event -> controller.checkAllCards());

    buttonPane.getChildren().addAll(dealButton, checkButton);
    buttonPane.setAlignment(Pos.TOP_RIGHT);
    return buttonPane;
  }

  /**
   * Creates a pane displaying various card checks.
   *
   * @return a {@code GridPane} containing check results
   */
  public GridPane getCheckCardPane() {
    GridPane checkCardPane = new GridPane();
    checkCardPane.add(getHeartsPane(), 0, 0);
    checkCardPane.add(getCheckSum(), 1, 0);
    checkCardPane.add(getSpareQueenPane(), 0, 1);
    checkCardPane.add(getFlushPane(), 1, 1);
    checkCardPane.setAlignment(Pos.CENTER);
    checkCardPane.setPrefWidth(400);
    checkCardPane.setHgap(20);
    checkCardPane.setVgap(20);
    return checkCardPane;
  }

  /**
   * Creates a panel displaying the total sum of cards.
   *
   * @return a {@code GridPane} containing the sum display
   */
  public GridPane getCheckSum() {
    GridPane checkSumPane = new GridPane();
    Text sum = new Text("Sum: ");
    totalSum = new Text("0");
    checkSumPane.add(sum, 1, 0);
    checkSumPane.add(totalSum, 2, 0);
    checkSumPane.setVgap(10);
    return checkSumPane;
  }

  /**
   * Creates a panel displaying the presence of hearts in the hand.
   *
   * @return a {@code GridPane} containing heart check results
   */
  public GridPane getHeartsPane() {
    GridPane heartsPane = new GridPane();
    Text hearts = new Text("Hearts: ");
    heartsFound = new Text("Something");
    heartsPane.add(hearts, 0, 0);
    heartsPane.add(heartsFound, 1, 0);
    heartsPane.setVgap(10);
    return heartsPane;
  }

  /**
   * Creates a panel displaying the presence of a spare queen.
   *
   * @return a {@code GridPane} containing spare queen check results
   */
  public GridPane getSpareQueenPane() {
    GridPane spareQueenPane = new GridPane();
    Text spareQueen = new Text("Spare Queen: ");
    wasFound = new Text("yes/no");
    spareQueenPane.add(spareQueen, 0, 0);
    spareQueenPane.add(wasFound, 1, 0);
    spareQueenPane.setVgap(10);
    spareQueenPane.setPrefWidth(500);
    return spareQueenPane;
  }

  /**
   * Creates a panel displaying whether a flush is present.
   *
   * @return a {@code GridPane} containing flush check results
   */
  public GridPane getFlushPane() {
    GridPane flushPane = new GridPane();
    Text flush = new Text("Flush: ");
    flushFound = new Text("yes/no");
    flushPane.add(flush, 0, 0);
    flushPane.add(flushFound, 1, 0);
    flushPane.setVgap(10);
    return flushPane;
  }

  /**
   * Updates all card check displays.
   */
  public void updateAllChecks() {
    updateSum();
    updateCheckForHearts();
    updateCheckForSpareQueen();
    updateCheckForFlush();
  }

  /**
   * Updates the sum of cards displayed.
   */
  private void updateSum() {
    if (deck != null && totalSum != null) {
      totalSum.setText(Integer.toString(deck.sumOfCards()));
    }
  }

  /**
   * Updates the display indicating if hearts are present.
   */
  public void updateCheckForHearts() {
    if (deck != null && heartsFound != null) {
      heartsFound.setText(deck.isHearts());
    }
  }

  /**
   * Updates the display indicating if a spare queen is present.
   */
  public void updateCheckForSpareQueen() {
    if (deck != null && wasFound != null) {
      wasFound.setText(deck.isSpareQueen());
    }
  }

  /**
   * Updates the display indicating if a flush is present.
   */
  public void updateCheckForFlush() {
    if (deck != null && flushFound != null) {
      flushFound.setText(deck.isFlush());
    }
  }

  /**
   * The main entry point of the application.
   *
   * @param args command-line arguments
   */
  public static void main(String[] args) {
    launch(args);
  }
}
