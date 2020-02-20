package project;

/**
 * The Class RevPolishCalc for RPN calculator.
 *
 * @author Nick Bogachev
 */
public class RevPolishCalc implements Calculator {

  /**
   * The stack that only accepts numbers.
   */
  private NumStack stack = new NumStack();

  /**
   * Checks if a String is an integer.
   *
   * @param s String
   * @return true, if String is an integer
   */
  public boolean isInteger(String s) {
    try {
      Integer.parseInt(s);
    } catch (NumberFormatException e) {
      return false;
    }
    return true;
  }

  /**
   * Evaluate an expression given in RPN.
   *
   * @param expression String
   * @return answer float
   * @throws EmptyStack exception
   * @throws BadType    exception
   */
  @Override
  public float evaluate(String expression) throws InvalidExpression, EmptyStack, BadType {
    if (expression.equals(Symbol.INVALID.getSymbol())) {
      throw new InvalidExpression(); // If an expression is empty it will throw an exception
    }
    String[] expArr = expression.split(" ");
    try {
      for (int i = 0; i < expArr.length; i++) {

        //First, check if the first two elements of the array are both numbers,
        // otherwise an operation cannot occur in this notation:
        if ((isInteger(expArr[0]) && !isInteger(expArr[1]))
            || (!isInteger(expArr[0]) && !isInteger(expArr[1])
            || (!isInteger(expArr[0]) && isInteger(expArr[1])))) {
          throw new InvalidExpression();
        }

        // Check if the current item is a number, if true -> push to the stack.
        if (isInteger(expArr[i])) {
          stack.push(Float.parseFloat(expArr[i]));
        }

        // Conditions to check which operator symbol is i
        // currently pointing at and do the corresponding operation.
        if (expArr[i].equals(Symbol.DIVIDE.getSymbol())) {
          float x = stack.pop();
          float y = stack.pop();

          /*
          For some reason calculator divided numbers the wrong way around.
          e.g. 2 / 6 = 3.0 and 6 / 2 = 0.333...
          Better to swap them.
           */
          float swap = x;
          x = y;
          y = swap;
          float temp = x / y;

          stack.push(temp);
        }
        if (expArr[i].equals(Symbol.MINUS.getSymbol())) {
          float x = stack.pop();
          float y = stack.pop();
          if (x > y) {
            float temp = x - y;
            stack.push(temp);
          } else {
            float temp = y - x;
            stack.push(temp);
          }
        }
        if (expArr[i].equals(Symbol.PLUS.getSymbol())) {
          float x = stack.pop();
          float y = stack.pop();
          float temp = x + y;
          stack.push(temp);
        }
        if (expArr[i].equals(Symbol.TIMES.getSymbol())) {
          float x = stack.pop();
          float y = stack.pop();
          float temp = x * y;
          stack.push(temp);
        }

      }
    } catch (EmptyStack | BadType e) {
      e.printStackTrace();
    }
    System.out.println(expression);
    return stack.pop();
  }
}
