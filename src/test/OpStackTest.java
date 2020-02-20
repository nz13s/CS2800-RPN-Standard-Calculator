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
import project.OpStack;
import project.Symbol;


/**
 * The Class OpStackTest to test the methods of NumStack class.
 */
public class OpStackTest {

  /**
   * The Stack.
   */
  private OpStack opStack;

  /**
   * The value to be entered.
   */
  private Symbol value;

  /**
   * Sets up the stack and value.
   */
  @Before
  public void setUp() {
    opStack = new OpStack();
    value = Symbol.PLUS;
  }

  /**
   * Test if the Stack is empty.
   */
  @Test
  public void testOpIsEmpty() {
    assertTrue(opStack.isEmpty());
  }

  /**
   * Test pushing the value to the OpStack.
   */
  @Test
  public void testOpPush() {
    opStack.push(value);
    assertFalse(opStack.isEmpty());
  }

  /**
   * Test popping the top Entry with an exception expected to be thrown.
   */
  @Test
  public void testOpPopException() {
    try {
      opStack.pop();
      fail("Expected an EmptyStack to be thrown");
    } catch (EmptyStack e) {
      assertEquals("Stack is empty", e.getMessage());
    } catch (BadType e) {
      assertEquals("Symbol input required", e.getMessage());
    }
  }

  /**
   * Test popping the top Entry.
   *
   * @throws BadType    exception
   * @throws EmptyStack exception
   */
  @Test
  public void testOpPop() throws BadType, EmptyStack {
    opStack.push(value);
    assertSame(1, opStack.size());
    assertSame(value, opStack.pop());
    assertSame(0, opStack.size());
  }

  /**
   * Test getting the size of the stack.
   */
  @Test
  public void testNumSize() {
    opStack.push(value);
    assertFalse(opStack.isEmpty());
    assertSame(opStack.size(), 1);
  }

  /**
   * Clean up.
   */
  @After
  public void cleanUp() {

  }

}
