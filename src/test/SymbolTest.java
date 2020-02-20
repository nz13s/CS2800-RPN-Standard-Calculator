package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import project.Symbol;

/**
 * The Class SymbolTest to test methods of the Symbol enum class.
 */
public class SymbolTest {
  private Symbol symbolPlus;
  private Symbol symbolRB;

  /**
   * Sets up the symbols to be used.
   */
  @Before
  public void setUp() {
    symbolPlus = Symbol.PLUS;
    symbolRB = Symbol.RIGHT_BRACKET;
  }

  /**
   * Test getting the symbol.
   */
  @Test
  public void testGetSymbol() {
    assertEquals("+", symbolPlus.getSymbol());
    assertEquals(")", symbolRB.getSymbol());
  }
  
  /**
   * Test checking priority.
   */
  @Test
  public void testPriority() {
    assertSame(6, Symbol.checkPriority(")"));
    assertSame(3, Symbol.checkPriority("*"));
    assertSame(1, Symbol.checkPriority("+"));
  }

  /**
   * Clean up.
   */
  @After
  public void cleanUp() {

  }
}
