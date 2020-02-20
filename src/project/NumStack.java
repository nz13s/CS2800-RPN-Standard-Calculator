package project;

/**
 * The Class NumStack. Uses calls to Stack's attributes to fit the edited methods
 *
 * @author Nick Bogachev
 */
public class NumStack {

  /**
   * The stack with only float entries.
   */
  private Stack numStack;

  public NumStack() {
    this.numStack = new Stack();
  }

  /**
   * Checks if Stack is empty.
   *
   * @return true, if empty
   */
  public boolean isEmpty() {
    return numStack.size == 0;
  }

  /**
   * Push an Entry into the stack.
   *
   * @param i float
   */
  public void push(float i) {
    Entry n = new Entry(i);
    numStack.push(n);
  }

  /**
   * Pop the most recent Entry of the stack and decrease its size.
   *
   * @return top Entry
   * @throws EmptyStack exception
   * @throws BadType    the bad type
   */
  public float pop() throws EmptyStack, BadType {
    if (isEmpty()) {
      throw new EmptyStack();
    }
    Entry temp = numStack.top();
    numStack.entries.remove(--numStack.size);
    if (temp.getType() != Type.NUMBER) {
      throw new BadType("Float input required.");
    }
    return temp.getValue();
  }

  /**
   * Get the size of the NumStack.
   *
   * @return int size
   */
  public int size() {
    return numStack.size;
  }
}

