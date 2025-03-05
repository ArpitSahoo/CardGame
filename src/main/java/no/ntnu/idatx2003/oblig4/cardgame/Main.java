package no.ntnu.idatx2003.oblig4.cardgame;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
  @Override
  public void start(Stage primaryStage) throws Exception {
    BorderPane borderPane = new BorderPane();
    borderPane.setCenter(createCenterPane());
    borderPane.setTop(createMenuBar());

    Scene scene = new Scene(borderPane);

    primaryStage.setScene(scene);
    primaryStage.setTitle("JavaFxDemo");
    primaryStage.show();
  }

  private MenuBar createMenuBar() {
    MenuItem openMenuItem = new MenuItem("Open");
    MenuItem saveMenuItem = new MenuItem("Save");
    MenuItem closeMenuItem = new MenuItem("Close");

    Menu fileMenu = new Menu("File");
    fileMenu.getItems().addAll(openMenuItem, saveMenuItem, new SeparatorMenuItem(), closeMenuItem);

    Menu editMenu = new Menu("Edit");

    MenuBar menuBar = new MenuBar();
    menuBar.getMenus().addAll(fileMenu, editMenu);
    return menuBar;
  }

  private Pane createCenterPane() {
    Button button1 = new Button("Button 1");
    Button button2 = new Button("Button 2");
    Button button3 = new Button("Button 3");
    Button button4 = new Button("Button 4");

    FlowPane centerPane = new FlowPane();
    centerPane.getChildren().addAll(button1, button2, button3, button4);

    return centerPane;
  }

  public static void main(String[] args) {
    launch(args);
  }

}
