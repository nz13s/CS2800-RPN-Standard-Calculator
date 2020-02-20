package project;

/**
 * The Class Entry.
 * Entry objects are used as members of the List that is implemented as a Stack.
 *
 * @author Nick Bogachev
 */
public class Entry {
  private float number;
  private Symbol other;
  private String str;
  private Type type;

  /**
   * Instantiates a new entry with a float param and assigns the number Type to it.
   *
   * @param number float
   */
  public Entry(float number) {
    this.number = number;
    this.type = Type.NUMBER;
  }

  /**
   * Instantiates a new entry with a Symbol param and assigns a Symbol Type to it.
   *
   * @param which Symbol
   */
  public Entry(Symbol which) {
    this.other = which;
    this.type = Type.SYMBOL;
  }

  /**
   * Instantiates a new entry with a String param and assigns a String type to it.
   *
   * @param str String
   */
  public Entry(String str) {
    this.str = str;
    this.type = Type.STRING;
  }

  /**
   * Gets the value of the Entry.
   *
   * @return float number
   * @throws BadType exception
   */
  public float getValue() throws BadType {
    if (type != Type.NUMBER) {
      throw new BadType("Float input required.");
    }
    return number;
  }

  /**
   * Gets the symbol of the Entry.
   *
   * @return Symbol other
   * @throws BadType exception
   */
  public Symbol getSymbol() throws BadType {
    if (type != Type.SYMBOL) {
      throw new BadType("Symbol input required.");
    }
    return other;
  }

  /**
   * Gets the string of the Entry.
   *
   * @return String str
   * @throws BadType exception
   */
  public String getString() throws BadType {
    if (type != Type.STRING) {
      throw new BadType("String input required.");
    }
    return str;
  }

  /**
   * Gets the type of the Entry.
   *
   * @return Type type
   */
  public Type getType() {
    return type;
  }

  /**
   * Transfers the Entry to string depending on its type.
   *
   * @return the string
   */
  @Override
  public String toString() {
    String s = null;

    if (this.getType().equals(Type.NUMBER)) {
      s = String.valueOf(this.number);
    }

    if (this.getType().equals(Type.SYMBOL)) {
      s = this.other.getSymbol();
    }

    if (this.getType().equals(Type.STRING)) {
      s = str;
    }

    return s;
  }
}
