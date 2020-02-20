package project;

/**
 * The Interface Calculator.
 * This will be used in CalcModel class to create a unified interface for a calculator.
 */
public interface Calculator {

  /**
   * Evaluate an expression.
   *
   * @param what  String
   * @return answer float
   * @throws EmptyStack        exception
   * @throws BadType           exception
   * @throws InvalidExpression exception
   */
  float evaluate(String what) throws InvalidExpression, EmptyStack, BadType;
}
