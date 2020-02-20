package project;

/**
 * The Enum Symbol class. These are assigned to Entry object if one is a Symbol.
 *
 * @author Nick Bogachev
 */
public enum Symbol {
  LEFT_BRACKET("(", 5),
  RIGHT_BRACKET(")", 6),
  TIMES("*", 3),
  DIVIDE("/", 4),
  PLUS("+", 1),
  MINUS("-", 2),
  INVALID("", 0);

  /**
   * The String field to assign the corresponding symbol to its enum.
   */
  public String symb;

  /**
   * Priority is used in standard calculator to implement Shunting algorithm.
   */
  public int priority;

  /**
   * Instantiates a new symbol.
   *
   * @param symb     String
   * @param priority int
   */
  Symbol(String symb, int priority) {
    this.symb = symb;
    this.priority = priority;
  }

  /**
   * Gets the symbol.
   *
   * @return String symb
   */
  public String getSymbol() {
    return this.symb;
  }


  /**
   * Check priority of a Symbol.
   *
   * @param item String
   * @return priority int
   */
  public static int checkPriority(String item) {
    if (item.equals(Symbol.LEFT_BRACKET.getSymbol())) {
      return LEFT_BRACKET.priority;
    }
    if (item.equals(Symbol.RIGHT_BRACKET.getSymbol())) {
      return RIGHT_BRACKET.priority;
    }
    if (item.equals(Symbol.TIMES.getSymbol())) {
      return TIMES.priority;
    }
    if (item.equals(Symbol.DIVIDE.getSymbol())) {
      return DIVIDE.priority;
    }
    if (item.equals(Symbol.PLUS.getSymbol())) {
      return PLUS.priority;
    }
    if (item.equals(Symbol.MINUS.getSymbol())) {
      return MINUS.priority;
    } else {
      return 0;
    }
  }
}