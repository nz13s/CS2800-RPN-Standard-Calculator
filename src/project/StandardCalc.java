package project;

/**
 * The Class StandardCalc.
 * The class' evaluation method takes in an expression in standard notation,
 * unwraps it into separate symbols (numbers and operators) and sorts them into an
 * output queue to form a String in RPN.
 *
 * @author Nick Bogachev
 */
public class StandardCalc implements Calculator {

  /**
   * The RPN calculator.
   */
  private RevPolishCalc rpCalc;

  /**
   * The operator stack.
   */
  private OpStack opStack;

  /**
   * The output queue.
   */
  private StrStack outputQ;

  /**
   * Checks if a String is an integer.
   *
   * @param s String
   * @return true, if is integer
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
   * Reverse an array
   * (will be used to reverse the StringBuilder expression).
   * @param a String[]
   * @param n int
   */
  public String reverse(String[] a, int n) {
    String[] b = new String[n];
    StringBuilder temp = new StringBuilder();
    int j = n;
    for (int i = 0; i < n; i++) {
      b[j - 1] = a[i];
      j = j - 1;
    }
    for (String s : b) {
      temp.append(s).append(" ");
    }
    String out = temp.toString();
    return out;
  }


  /**
   * Evaluate an expression in standard notation and then turn in into RPN.
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

    //The actual calculator to be used in the end
    rpCalc = new RevPolishCalc();

    //The stack to store operators
    opStack = new OpStack();

    //The stack to store both numbers and operators to create an RPN string
    outputQ = new StrStack();

    String[] expArr = expression.split(" ");
    StringBuilder expReformed = new StringBuilder(); //Future RPN string

    //If an expression is given in RPN, throw an exception
    if (isInteger(expArr[0]) && isInteger(expArr[1])) {
      throw new InvalidExpression();
    }

    for (String token : expArr) {
      //Check if the token is not a number and not a bracket:
      if (!isInteger(token)
          && !token.equals(Symbol.RIGHT_BRACKET.getSymbol())
          && !token.equals(Symbol.LEFT_BRACKET.getSymbol())) {
        //If the stack is not empty and the token has higher priority,
        //pop the operator from opStack to outputQ.
        while (!opStack.isEmpty()
            && opStack.top().priority < Symbol.checkPriority(token)) {
          outputQ.push(opStack.pop().getSymbol() + " ");
        }
        //Push the token to operator stack.
        if (token.equals(Symbol.TIMES.getSymbol())) {
          opStack.push(Symbol.TIMES);
        }
        if (token.equals(Symbol.DIVIDE.getSymbol())) {
          opStack.push(Symbol.DIVIDE);
        }
        if (token.equals(Symbol.PLUS.getSymbol())) {
          opStack.push(Symbol.PLUS);
        }
        if (token.equals(Symbol.MINUS.getSymbol())) {
          opStack.push(Symbol.MINUS);
        }
      } else if (token.equals(Symbol.LEFT_BRACKET.getSymbol())) {
        //When the token is a left bracket, push it to the stack as well.
        opStack.push(Symbol.LEFT_BRACKET);
      } else if (token.equals(Symbol.RIGHT_BRACKET.getSymbol())) {
        //When the token is a right bracket, pop the opStack to outputQ.
        while (!opStack.top().equals(Symbol.LEFT_BRACKET)) {
          outputQ.push(opStack.pop().getSymbol() + " ");
        }
        opStack.pop(); //Pop the left bracket and discard it
      } else { //the token is a number, so just push to outputQ.
        outputQ.push(token + " ");
      }
    }
    //Pop remaining operators to outputQ.
    while (!opStack.isEmpty()) {
      outputQ.push(opStack.pop().getSymbol() + " ");
    }
    //Create a string from outputQ.
    while (!outputQ.isEmpty()) {
      expReformed.append(outputQ.pop());
    }
    expReformed.deleteCharAt(expReformed.length() - 1);
    String expRefStr = expReformed.toString();
    String[] output = expRefStr.split(" ");
    String rpnExp = reverse(output, output.length);

    return rpCalc.evaluate(rpnExp);
  }
}
