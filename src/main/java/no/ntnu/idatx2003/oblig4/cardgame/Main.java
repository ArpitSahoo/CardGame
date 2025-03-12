package no.ntnu.idatx2003.oblig4.cardgame;

import no.ntnu.idatx2003.oblig4.cardgame.gui.View;
/**
 * The Main class starts the application by creating and displaying the GUI.
 * It invokes the View class, which represents the graphical user interface.
 *
 * @since 0.0.1
 * @author arpit
 * @version 0.1.0
 */
public class Main {

  /**
   * The main method to launch the application.
   *
   * @param args Command-line arguments (not used).
   */
  public static void main(String[] args) {
    try {
      View.main(args);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
