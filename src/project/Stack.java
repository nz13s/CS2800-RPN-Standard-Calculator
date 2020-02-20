package project;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class Stack that implements a List as a Stack.
 *
 * @author Nick Bogachev
 */
public class Stack {

  /**
   * The size of the Stack.
   */
  public int size;

  /**
   * The entries List.
   */
  public List<Entry> entries = new ArrayList<>();

  /**
   * Checks if Stack is empty.
   *
   * @return true, if empty
   */
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * Push Entry into the stack.
   *
   * @param entry Entry
   */
  public void push(Entry entry) {
    entries.add(entry);
    size++;
  }

  /**
   * Return the top Entry of the stack but not pop it.
   *
   * @return top Entry
   * @throws EmptyStack exception
   */
  public Entry top() throws EmptyStack {
    if (isEmpty()) {
      throw new EmptyStack();
    }
    return entries.get(size - 1);
  }

  /**
   * Pop the most recent Entry of the stack and decrease its size.
   *
   * @return top Entry
   * @throws EmptyStack exception
   */
  public Entry pop() throws EmptyStack {
    if (isEmpty()) {
      throw new EmptyStack();
    }

    Entry temp = top();
    entries.remove(--size);
    return temp;
  }

  /**
   * Get the size of the Stack.
   *
   * @return int size
   */
  public int size() {
    return size;
  }
}


