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
 * A class that creates a graphical interface for the user.
 *
 * @since 0.0.1
 * @author arpit
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

  public Pane centerPaneCreate() {
    VBox centerPane = new VBox();
    centerPane.getChildren().addAll(buttonAndCards(), getCheckCardPane());
    return centerPane;
  }

  public HBox buttonAndCards() {
    HBox buttonAndCards = new HBox();
    buttonAndCards.getChildren().addAll(getCardPane(), getButtons());
    return buttonAndCards;
  }

  public FlowPane getCardPane() {
    FlowPane cardPane = new FlowPane();
    cardPane.setStyle("-fx-background-color: lightblue;");
    cardsInHand = new Text("");
    cardsInHand.setFont(new Font(40));
    cardsInHand.setTextAlignment(TextAlignment.CENTER);
    cardPane.getChildren().add(cardsInHand);
    return cardPane;
  }

  public void updateCardsInHand() {
    if (deck != null && cardsInHand != null) {
      cardsInHand.setText(deck.getCardsFromHand());
    }
  }

  private FlowPane getButtons() {
    FlowPane buttonPane = new FlowPane();

    Button add1button = new Button("Deal hand");
    add1button.setPrefWidth(200);
    add1button.setPrefHeight(30);
    add1button.setOnAction(event ->
      controller.getCardsToView()
    );

    Button add2button = new Button("Check hand");
    add2button.setPrefWidth(200);
    add2button.setPrefHeight(30);
    add2button.setOnAction(event ->
        controller.checkAllCards());

    buttonPane.getChildren().addAll(add1button, add2button);
    buttonPane.setAlignment(Pos.TOP_RIGHT);
    return buttonPane;
  }

  public GridPane getCheckCardPane() {
    GridPane checkCardPane = new GridPane();

    checkCardPane.add(getHeartsPane(), 0, 0);
    checkCardPane.add(getCheckSum(), 1, 0);
    checkCardPane.add(getSpareQueenPane(), 0, 1);
    checkCardPane.add(getFlushPane(), 1, 1);
    checkCardPane.setAlignment(Pos.BOTTOM_LEFT);
    checkCardPane.setHgap(20);
    checkCardPane.setVgap(20);
    return checkCardPane;
  }

  public GridPane getCheckSum() {
    GridPane checkSumPane = new GridPane();
    Text sum = new Text("Sum: ");
    totalSum = new Text("0");
    checkSumPane.add(sum, 1, 0);
    checkSumPane.add(totalSum, 2, 0);
    checkSumPane.setVgap(10);
    return checkSumPane;
  }

  public GridPane getHeartsPane() {
    GridPane heartsPane = new GridPane();
    Text hearts = new Text("Hearts: ");
    heartsFound = new Text("Something");

    heartsPane.add(hearts, 0, 0);
    heartsPane.add(heartsFound, 1, 0);
    heartsPane.setVgap(10);
    return heartsPane;
  }

  public GridPane getSpareQueenPane() {
    GridPane spareQueenPane = new GridPane();
    Text spareQueen = new Text("Spare Queen: ");
    wasFound = new Text("yes/no");

    spareQueenPane.add(spareQueen, 0, 0);
    spareQueenPane.add(wasFound, 1, 0);
    spareQueenPane.setVgap(10);
    return spareQueenPane;
  }

  public GridPane getFlushPane() {
    GridPane flushPane = new GridPane();
    Text flush = new Text("Flush: ");
    flushFound = new Text("yes/no");
    flushPane.add(flush, 0, 0);
    flushPane.add(flushFound, 1, 0);
    flushPane.setVgap(10);
    return flushPane;
  }

  public void updateAllChecks() {
    updateSum();
    updateCheckForHearts();
    updateCheckForSpareQueen();
    updateCheckForFlush();
  }

  private void updateSum() {
    if (deck != null && cardsInHand != null) {
      totalSum.setText(Integer.toString(deck.sumOfCards()));
    }
  }

  public void updateCheckForHearts() {
    if (deck != null && cardsInHand != null) {
      heartsFound.setText(deck.isHearts());
    }
  }

  public void updateCheckForSpareQueen() {
    if (deck != null && cardsInHand != null) {
      wasFound.setText(deck.isSpareQueen());
    }
  }

  public void updateCheckForFlush() {
    if (deck != null && cardsInHand != null) {
      flushFound.setText(deck.isFlush());
    }
  }

  public static void main(String[] args) {
    launch(args);
  }

}
