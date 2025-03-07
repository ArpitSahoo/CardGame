package no.ntnu.idatx2003.oblig4.cardgame.gui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import no.ntnu.idatx2003.oblig4.cardgame.controller.SystemInterface;
import no.ntnu.idatx2003.oblig4.cardgame.deck.DeckOfCards;


/**
 * A class that creates a graphical interface for the user.
 *
 * @since 0.0.1
 * @author arpit
 * @version 0.0.1
 */
public class View extends Application {
  private SystemInterface controller;
  DeckOfCards deck;



  @Override
  public void start(Stage stage) throws Exception {
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
    FlowPane buttonPane = getButtons();
    HBox cardPane = getCardPane();
    GridPane checkCardPane = getCheckCardPane();

    centerPane.getChildren().addAll(cardPane, buttonPane, checkCardPane);
    return centerPane;
  }

  private static HBox getCardPane() {
    HBox cardPane = new HBox();
    Text card = new Text(" ");

    cardPane.setSpacing(10);
    cardPane.getChildren().addAll(card);
    return cardPane;
  }

  private static FlowPane getButtons() {
    FlowPane buttonPane = new FlowPane();

    Button add1button = new Button("Deal hand");
    Button add2button = new Button("Check hand");

    buttonPane.getChildren().addAll(add1button, add2button);
    buttonPane.setAlignment(Pos.BASELINE_RIGHT);
    return buttonPane;
  }

  public static GridPane getCheckCardPane() {
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

  public static GridPane getCheckSum() {
    GridPane checkSumPane = new GridPane();
    Text sum = new Text("Sum: ");
    Text totalSum = new Text("0");
    checkSumPane.add(sum, 1, 0);
    checkSumPane.add(totalSum, 1, 1);
    checkSumPane.setVgap(10);
    return checkSumPane;
  }

  public static GridPane getHeartsPane() {
    GridPane heartsPane = new GridPane();
    Text hearts = new Text("Hearts: ");
    Text heartsFound = new Text("Something");

    heartsPane.add(hearts, 0, 0);
    heartsPane.add(heartsFound, 1, 0);
    heartsPane.setVgap(10);
    return heartsPane;
  }

  public static GridPane getSpareQueenPane() {
    GridPane spareQueenPane = new GridPane();
    Text spareQueen = new Text("Spare Queen ");
    Text wasFound = new Text("yes/no");

    spareQueenPane.add(spareQueen, 0, 0);
    spareQueenPane.add(wasFound, 1, 0);
    spareQueenPane.setVgap(10);
    return spareQueenPane;
  }

  public static GridPane getFlushPane() {
    GridPane flushPane = new GridPane();
    Text flush = new Text("Flush: ");
    Text flushFound = new Text("yes/no");
    flushPane.add(flush, 0, 0);
    flushPane.add(flushFound, 1, 0);
    flushPane.setVgap(10);
    return flushPane;
  }


  public static void main(String[] args) {
    launch(args);
  }

}
