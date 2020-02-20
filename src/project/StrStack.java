package project;

/**
 * The Class StrStack. Uses calls to Stack's attributes to fit the edited methods
 *
 * @author Nick Bogachev
 */
public class StrStack {

  /**
   * The stack with only String entries.
   */
  private Stack strStack;

  public StrStack() {
    this.strStack = new Stack();
  }

  /**
   * Checks if Stack is empty.
   *
   * @return true, if empty
   */
  public boolean isEmpty() {
    return strStack.size == 0;
  }

  /**
   * Push an Entry into the stack.
   *
   * @param i String
   */
  public void push(String i) {
    Entry n = new Entry(i);
    strStack.push(n);
  }

  /**
   * Pop the most recent Entry of the stack and decrease its size.
   *
   * @return top Entry
   * @throws EmptyStack exception
   * @throws BadType    the bad type
   */
  public String pop() throws EmptyStack, BadType {
    if (isEmpty()) {
      throw new EmptyStack();
    }
    Entry temp = strStack.top();
    strStack.entries.remove(--strStack.size);
    if (temp.getType() != Type.STRING) {
      throw new BadType("String input required.");
    }
    return temp.getString();
  }

  /**
   * Get the size of the StrStack.
   *
   * @return int size
   */
  public int size() {
    return strStack.size;
  }
}

