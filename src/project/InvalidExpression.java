package project;

/**
 * The Class InvalidExpression for a custom exception.
 *
 * @author Nick Bogachev
 **/


public class InvalidExpression extends Exception {
  /**
   * Instantiates a new InvExp exception.
   * No param as message is always the same.
   */
  public InvalidExpression() {
    super("Invalid expression.");
  }
}
