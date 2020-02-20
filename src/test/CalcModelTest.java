package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import project.BadType;
import project.CalcModel;
import project.EmptyStack;
import project.InvalidExpression;

/**
 * The Class CalcModelTest.
 */
public class CalcModelTest {

  /**
   * The RPN calculator.
   */
  private CalcModel calculator;

  /**
   * The expressions to be tested against.
   */
  private String expression1;
  private String expression2;
  private String expression3;


  /**
   * Set up the values.
   */
  @Before
  public void setUp() {
    calculator = new CalcModel();
    expression1 = "( 5 * ( 6 + 7 ) ) - 2";
    expression2 = "5 6 7 + * 2 -";
    expression3 = "";
  }

  /**
   * Test evaluation for both notations.
   *
   * @throws InvalidExpression exception
   * @throws BadType           exception
   * @throws EmptyStack        exception
   */
  @Test
  public void testEvaluate() throws InvalidExpression, BadType, EmptyStack {
    assertEquals(63.0f, calculator.evaluate(expression1, true), 0.0);
    assertEquals(63.0f, calculator.evaluate(expression2, false), 0.0);
  }

  /**
   * Test Invalid Expression exception.
   */
  @Test
  public void testEvaluateException() {
    try {
      assertEquals(63.0f, calculator.evaluate(expression2, true), 0.0);
      assertEquals(63.0f, calculator.evaluate(expression1, false), 0.0);
      assertEquals(63.0f, calculator.evaluate(expression3, true), 0.0);
      assertEquals(63.0f, calculator.evaluate(expression3, false), 0.0);
      fail("Invalid Expression is not thrown.");
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
