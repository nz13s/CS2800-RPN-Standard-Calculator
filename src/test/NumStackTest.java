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
import project.NumStack;



/**
 * The Class NumStackTest to test the methods of NumStack class.
 */
public class NumStackTest {

  /**
   * The Stack.
   */
  private NumStack numStack;

  /**
   * The value to be entered.
   */
  private float value;

  /**
   * Sets up the stack and value.
   */
  @Before
  public void setUp() {
    numStack = new NumStack();
    value = 10.0f;
  }

  /**
   * Test if the Stack is empty.
   */
  @Test
  public void testNumIsEmpty() {
    assertTrue(numStack.isEmpty());
  }

  /**
   * Test pushing the value to the NumStack.
   */
  @Test
  public void testNumPush() {
    numStack.push(value);
    assertFalse(numStack.isEmpty());
  }

  /**
   * Test popping the top Entry with an exception expected to be thrown.
   */
  @Test
  public void testNumPopException() {
    try {
      numStack.pop();
      fail("Expected an EmptyStack to be thrown");
    } catch (EmptyStack e) {
      assertEquals("Stack is empty", e.getMessage());
    } catch (BadType e) {
      assertEquals("Float input required", e.getMessage());
    }
  }

  /**
   * Test popping the top Entry.
   *
   * @throws BadType    exception
   * @throws EmptyStack exception
   */
  @Test
  public void testNumPop() throws BadType, EmptyStack {
    numStack.push(value);
    assertSame(1, numStack.size());
    assertTrue(value == numStack.pop());
    assertSame(0, numStack.size());
  }

  /**
   * Test getting the size of the stack.
   */
  @Test
  public void testNumSize() {
    numStack.push(value);
    assertFalse(numStack.isEmpty());
    assertSame(numStack.size(), 1);
  }

  /**
   * Clean up.
   */
  @After
  public void cleanUp() {

  }

}
