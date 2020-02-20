package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import project.BadType;
import project.EmptyStack;
import project.InvalidExpression;
import project.StandardCalc;

/**
 * The Class StandardCalcTest to test the standard calculator.
 */
public class StandardCalcTest {

  /** The calculator. */
  private StandardCalc calc;
  
  /** The expressions to be tested. */
  private String expression1;
  private String expression2;
  
  /** The value to be tested against. */
  private float value;

  /**
   * Sets the up.
   */
  @Before
  public void setUp() {
    calc = new StandardCalc();
    expression1 = "( 5 * ( 6 + 7 ) ) - 2";
    expression2 = "5 6 7 + * 2 -";
    value = 63.0f;
  }

  /**
   * Testing if isInteger works correctly.
   */
  @Test
  public void testIsInt() {
    assertTrue(calc.isInteger("5"));
    assertFalse(calc.isInteger(")"));
  }

  /**
   * Test evaluation of an expression.
   *
   * @throws InvalidExpression exception
   * @throws EmptyStack exception
   * @throws BadType exception
   */
  @Test
  public void testEvaluate() throws InvalidExpression, EmptyStack, BadType {
    assertEquals(63.0f, calc.evaluate(expression1), 0.0);
  }
  
  /**
   * Test that an exception is correctly thrown on an invalid expression.
   */
  @Test
  public void testEvaluateException() {
    try {
      assertNotEquals(11.0f, calc.evaluate(expression2), 0.0);
      assertNotEquals(11.0f, calc.evaluate(""), 0.0);
      fail("Expected an Invalid Exception to be thrown");
    } catch (InvalidExpression e) {
      assertSame("Invalid expression.", e.getMessage());
    } catch (BadType | EmptyStack e) {
      e.printStackTrace();
    }
  }

  /**
   * Clean up.
   */
  @After
  public void cleanUp() {

  }

}
