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
import project.StrStack;


/**
 * The Class StrStackTest to test the methods of NumStack class.
 */
public class StrStackTest {

  /**
   * The Stack.
   */
  private StrStack strStack;

  /**
   * The value to be entered.
   */
  private String value;

  /**
   * Sets up the stack and value.
   */
  @Before
  public void setUp() {
    strStack = new StrStack();
    value = "test";
  }

  /**
   * Test if the Stack is empty.
   */
  @Test
  public void testStrIsEmpty() {
    assertTrue(strStack.isEmpty());
  }

  /**
   * Test pushing the value to the NumStack.
   */
  @Test
  public void testStrPush() {
    strStack.push(value);
    assertFalse(strStack.isEmpty());
  }

  /**
   * Test popping the top Entry with an exception expected to be thrown.
   */
  @Test
  public void testStrPopException() {
    try {
      strStack.pop();
      fail("Expected an EmptyStack to be thrown");
    } catch (EmptyStack e) {
      assertEquals("Stack is empty", e.getMessage());
    } catch (BadType e) {
      assertEquals("String input required", e.getMessage());
    }
  }

  /**
   * Test popping the top Entry.
   *
   * @throws BadType    exception
   * @throws EmptyStack exception
   */
  @Test
  public void testStrPop() throws BadType, EmptyStack {
    strStack.push(value);
    assertSame(1, strStack.size());
    assertSame(value, strStack.pop());
    assertSame(0, strStack.size());
  }

  /**
   * Test getting the size of the stack.
   */
  @Test
  public void testNumSize() {
    strStack.push(value);
    assertFalse(strStack.isEmpty());
    assertSame(strStack.size(), 1);
  }

  /**
   * Clean up.
   */
  @After
  public void cleanUp() {

  }

}
