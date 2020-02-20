package test;

import static junit.framework.TestCase.fail;

import static org.junit.Assert.assertEquals;
import static project.Type.SYMBOL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import project.BadType;
import project.Entry;
import project.Symbol;

/**
 * The Class EntryTest to test methods of the Entry class, and enums Type and Symbol.
 *
 * @author Nick Bogachev
 **/

public class EntryTest {

  /**
   * The symbol entry.
   */
  private static Entry symbolEntry;

  /**
   * The float entry.
   */
  private static Entry floatEntry;

  /**
   * The string entry.
   */
  private static Entry stringEntry;

  /**
   * Sets up the Entries to be used.
   */
  @Before
  public void setUp() {
    symbolEntry = new Entry(Symbol.PLUS);
    floatEntry = new Entry(10.0f);
    stringEntry = new Entry("test");
  }

  /**
   * Test get value.
   *
   * @throws BadType exception
   */
  @Test
  public void testGetValue() throws BadType {
    assertEquals(10.0f, floatEntry.getValue(), 0.0);
  }

  /**
   * Test get value with an exception expected to be thrown.
   */
  @Test
  public void testGetValueException() {
    try {
      symbolEntry.getValue();
      fail("Expected a BadType to be thrown");
    } catch (BadType e) {
      assertEquals("Float input required.", e.getMessage());
    }
  }

  /**
   * Test get symbol.
   *
   * @throws BadType e
   */
  @Test
  public void testGetSymbol() throws BadType {
    assertEquals(Symbol.PLUS, symbolEntry.getSymbol());
  }


  /**
   * Test get symbol with an exception expected to be thrown.
   */
  @Test
  public void testGetSymbolException() {
    try {
      floatEntry.getSymbol();
      fail("Expected a BadType to be thrown");
    } catch (BadType e) {
      assertEquals("Symbol input required.", e.getMessage());
    }
  }


  /**
   * Test get string.
   *
   * @throws BadType exception
   */
  @Test
  public void testGetString() throws BadType {
    assertEquals("test", stringEntry.getString());
  }

  /**
   * Test get string with an exception expected to be thrown.
   */
  @Test
  public void testGetStringException() {
    try {
      symbolEntry.getString();
      fail("Expected a BadType to be thrown");
    } catch (BadType e) {
      assertEquals("String input required.", e.getMessage());
    }
  }


  /**
   * Test get type.
   */
  @Test
  public void testGetType() {
    assertEquals(SYMBOL, symbolEntry.getType());
  }

  /**
   * Test toString.
   *
   */
  @Test
  public void testToString() {
    assertEquals("+", symbolEntry.toString());
    assertEquals("10.0", floatEntry.toString());
    assertEquals("test", stringEntry.toString());
  }

  /**
   * Clean up.
   */
  @After
  public void cleanUp() {

  }
}
