package project;

/**
 * The Class OpStack. Uses calls to Stack's attributes to fit the edited methods
 *
 * @author Nick Bogachev
 */
public class OpStack {

  /**
   * The stack with only Symbol entries.
   */
  private Stack opStack;

  public OpStack() {
    this.opStack = new Stack();
  }

  /**
   * Checks if Stack is empty.
   *
   * @return true, if empty
   */
  public boolean isEmpty() {
    return opStack.size == 0;
  }

  /**
   * Push an Entry into the stack.
   *
   * @param i Symbol
   */
  public void push(Symbol i) {
    Entry n = new Entry(i);
    opStack.push(n);
  }

  /**
   * Pop the most recent Entry of the stack and decrease its size.
   *
   * @return top Entry
   * @throws EmptyStack exception
   * @throws BadType    the bad type
   */
  public Symbol pop() throws EmptyStack, BadType {
    if (isEmpty()) {
      throw new EmptyStack();
    }
    Entry temp = opStack.top();
    opStack.entries.remove(--opStack.size);
    if (temp.getType() != Type.SYMBOL) {
      throw new BadType("Symbol input required.");
    }
    return temp.getSymbol();
  }

  /**
   * Return the top Entry of the stack but not pop it.
   *
   * @return top Entry
   * @throws EmptyStack exception
   */
  public Symbol top() throws EmptyStack, BadType {
    if (isEmpty()) {
      throw new EmptyStack();
    }
    return opStack.entries.get(opStack.size - 1).getSymbol();
  }

  /**
   * Get the size of the OpStack.
   *
   * @return int size
   */
  public int size() {
    return opStack.size;
  }
}

