package project;

import static java.lang.System.exit;

import java.util.Scanner;

/**
 * The Class AsciiView.
 * This is the console view for the calculator that starts up a menu,
 * accepts notations, expressions and returns an answer, and has
 * an option to activate GuiView class.
 * @author Nick Bogachev
 */
public class AsciiView implements ViewInterface {

  /** The scanner from console. */
  static Scanner sc;
  
  /** The expression. */
  static String expression;
  
  /** The answer. */
  static String answer;

  /** The user input. */
  static String input;


  /**
   * Menu method to print the instructions to console and then keep accepting input.
   */
  public void menu() {
    System.out.println("Welcome!");;
    System.out.println("P -- activate postfix (RPN) notation.");
    System.out.println("I -- activate infix (standard) notation.");
    System.out.println("= -- activate calculation mode.");
    System.out.println("G -- start up a visual interface for calculation.");
    System.out.println("E -- exit the program.");
    sc = new Scanner(System.in);
    System.out.print(">>");
    while (sc.hasNext()) {
      actionPerformed();
      System.out.print(">>");
    }
  }

  /**
   * Gets the expression.
   *
   * @return the expression
   */
  @Override
  public String getExpression() {
    expression = sc.nextLine();
    return expression;
  }

  /**
   * Sets the answer.
   */
  @Override
  public void setAnswer() {
    float out = 0;
    try {
      out = GuiView.model.evaluate(expression, GuiView.infix);
    } catch (EmptyStack | BadType | InvalidExpression exception) {
      System.out.println(exception.getMessage());
      exception.printStackTrace();
    }
    answer = String.valueOf(out);
    if (answer.equals("Infinity")) {
      System.out.println("Error!");
    } else {
      System.out.println(answer);
      String[] output = String.valueOf(out).split("\\.");
      System.out.println("Rounded answer = " + output[0]);
    }
  }

  /**
   * Method which responds to actions performed.
   */
  public void actionPerformed() {
    input = sc.nextLine();
    /* RPN notation switch. */
    if (input.equals("P")) {
      System.out.println("RPN notation is active.");
      GuiView.infix = false;
    }
    /* Standard notation switch. */
    if (input.equals("I")) {
      System.out.println("Standard notation is active.");
      GuiView.infix = true;
    }
    /* Calculate expression when bEquals is pressed and display in textField. */
    if (input.equals("=")) {
      System.out.println("Enter an expression: ");
      System.out.print(">>");
      getExpression();
      setAnswer();
    }
    if (input.equals("G")) {
      GuiView gui = new GuiView();
      gui.draw();
    }
    if (input.equals("E")) {
      System.out.println("Exiting...");
      exit(0);
    }
  }
}