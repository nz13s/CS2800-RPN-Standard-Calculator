package project;

/**
 * The Class BadType for a custom exception.
 *
 * @author Nick Bogachev
 **/


public class BadType extends Exception {
  /**
   * Instantiates a new BadType exception.
   *
   * @param message String
   *                Error message is displayed, specific to different Getters in the Entry class.
   */
  public BadType(String message) {
    super(message);
  }
}
