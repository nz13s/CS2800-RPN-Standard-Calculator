package test;

import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import project.BadType;
import project.EmptyStack;
import project.Entry;
import project.Stack;
import project.Symbol;

/**
 * The Class StackTest to test the methods of the Stack class.
 *
 * @author Nick Bogachev
 */
public class StackTest {

  /**
   * The size of the stack.
   */
  private int size;

  /**
   * The Entries to be used.
   */
  private Entry float1;
  private Entry symbol;

  /**
   * The stack.
   */
  private Stack stack;

  /**
   * Sets up the Entries and the Stack to be used.
   */
  @Before
  public void setUp() {
    size = 0;
    float1 = new Entry(2.0f);
    symbol = new Entry(Symbol.PLUS);
    stack = new Stack();
  }

  /**
   * Test if the Stack is empty.
   */
  @Test
  public void testEmpty() {
    assertTrue(stack.isEmpty());
  }

  /**
   * Test pushing Entries to the stack.
   */
  @Test
  public void testPush() {
    stack.push(float1);
    stack.push(symbol);
    assertFalse(stack.isEmpty()); //NTS: size should have increased, so this should return true;
  }

  /**
   * Test returning top Entry with an exception expected to be thrown.
   */
  @Test
  public void testTopException() {
    try {
      stack.top();
      fail("Expected an EmptyStack to be thrown");
    } catch (EmptyStack e) {
      assertEquals("Stack is empty", e.getMessage());
    }
  }

  /**
   * Test returning top Entry.
   *
   * @throws BadType    exception
   * @throws EmptyStack exception
   */
  @Test
  public void testTop() throws BadType, EmptyStack {
    stack.push(float1);
    stack.push(symbol);
    assertEquals(stack.top().getSymbol(), symbol.getSymbol());
  }

  /**
   * Test getting the size of the stack.
   */
  @Test
  public void testSize() {
    stack.push(float1);
    stack.push(symbol);
    assertFalse(stack.isEmpty());
    assertSame(stack.size(), 2);
  }


  /**
   * Test popping the top Entry with an exception expected to be thrown.
   */
  @Test
  public void testPopException() {
    try {
      stack.pop();
      fail("Expected an EmptyStack to be thrown");
    } catch (EmptyStack e) {
      assertEquals("Stack is empty", e.getMessage());
    }
  }

  /**
   * Test popping the top Entry.
   *
   * @throws BadType    exception
   * @throws EmptyStack exception
   */
  @Test
  public void testPop() throws BadType, EmptyStack {
    stack.push(float1);
    stack.push(symbol);
    assertEquals(2, stack.size());
    assertEquals(stack.pop().getSymbol(), symbol.getSymbol());
    assertEquals(1, stack.size());
  }


  /**
   * Clean up.
   */
  @After
  public void cleanUp() {

  }
}
