package project;

/**
 * The Class CalcModel. The class creates a unified calculator model which can evaluate
 * any expression given the notation in boolean form (infix = true or infix = false).
 *
 * @author Nick Bogachev
 */
public class CalcModel {

  /**
   * The RPN calculator in RPN (postfix) notation.
   */
  private Calculator revPolish = new RevPolishCalc();

  /**
   * The Standard calculator in infix notation.
   */
  private Calculator standard = new StandardCalc();

  /**
   * Evaluate an expression.
   *
   * @param what  String
   * @param infix boolean
   * @return answer float
   * @throws EmptyStack        exception
   * @throws BadType           exception
   * @throws InvalidExpression exception
   */
  public float evaluate(String what, boolean infix) throws EmptyStack, BadType, InvalidExpression {
    if (infix) {
      return standard.evaluate(what);
    } else if (!infix) {
      return revPolish.evaluate(what);
    } else {
      throw new InvalidExpression();
    }
  }
}
