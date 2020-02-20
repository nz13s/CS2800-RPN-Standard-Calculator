package project;

/**
 * The Class EmptyStack for a custom exception.
 *
 * @author Nick Bogachev
 */
public class EmptyStack extends Exception {

  /**
   * Instantiates a new Empty Stack.
   * No param as message is always the same.
   */
  public EmptyStack() {
    super("Stack is empty");
  }
}