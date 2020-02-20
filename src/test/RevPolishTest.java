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
import project.RevPolishCalc;

/**
 * The Class TestRevPolish for testing the reverse polish calculator.
 * @author Nick Bogachev
 */
public class RevPolishTest {

  /** The calculator. */
  private RevPolishCalc calc;
  
  /** The different values to be tested against. **/
  private String expression1;
  private String expression2;
  private String expression3;
  private float value;


  /**
   * Sets up the calculator and the values.
   */
  @Before
  public void setUp() {
    calc = new RevPolishCalc();
    expression1 = "5 6 7 + * 2 -";
    expression2 = "( 5 * ( 6 + 7 ) ) - 2";
    expression3 = "";
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
   * Test evaluation of the expression.
   *
   * @throws InvalidExpression the invalid expression
   * @throws EmptyStack exception
   * @throws BadType exception
   */
  @Test
  public void testEvaluate() throws InvalidExpression, EmptyStack, BadType {
    assertEquals(value, calc.evaluate(expression1), 0.0);
  }

  /**
   * Test that an exception is correctly thrown on an invalid expression.
   */
  @Test
  public void testEvaluateException() {
    try {
      assertNotEquals(11.0f, calc.evaluate(expression2), 0.0);
      assertNotEquals(11.0f, calc.evaluate(expression3), 0.0);
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
