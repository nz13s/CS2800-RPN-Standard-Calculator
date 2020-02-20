package project;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * The Class GuiView.
 * Implements the GUI for calculating expressions in RPN and standard notation.
 *
 * @author Nick Bogachev
 */
public class GuiView implements ViewInterface, ActionListener {
  /**
   * The calculator.
   */
  public static CalcModel model = new CalcModel();

  /**
   * The infix boolean that is accessed by the view.
   */
  public static boolean infix;

  /**
   * The frame.
   */
  static JFrame frame;

  /**
   * The text field for calculations.
   */
  static JTextField textField;

  /**
   * The notation display.
   */
  static JTextField notation;

  /**
   * The author display.
   */
  static JTextField author;

  /**
   * The error display.
   */
  static JTextField errors;

  /**
   * The interactive buttons.
   */
  static JButton bClear;
  static JButton bEquals;
  static JButton bRPN;
  static JButton bStand;

  /**
   * The String objects for getting an expression and storing an answer.
   */
  static String expression;
  static String answer;

  /**
   * The draw method to create a frame.
   */
  public void draw() {
    /* Initialise all static fields. */
    final GuiView c = new GuiView();
    frame = new JFrame("Calculator");
    textField = new JTextField(16);
    notation = new JTextField(16);
    author = new JTextField(16);
    errors = new JTextField(21);
    textField.setEditable(true);
    notation.setEditable(true);
    errors.setEditable(true);
    author.setText("@author Nick Bogachev");
    notation.setText("Select notation below.");
    errors.setText("Error messages will be displayed here.");
    author.setEditable(false);

    bClear = new JButton("C");
    bEquals = new JButton("=");
    bRPN = new JButton("RPN");
    bStand = new JButton("Standard");

    final JPanel panel = new JPanel();

    /* Add action listeners to the variables. */
    textField.addActionListener(c);
    notation.addActionListener(c);
    errors.addActionListener(c);
    bClear.addActionListener(c);
    bEquals.addActionListener(c);
    bRPN.addActionListener(c);
    bStand.addActionListener(c);

    /* Set up the panel */
    panel.add(author);
    panel.add(notation);
    panel.add(textField);
    panel.add(bEquals);
    panel.add(bClear);
    panel.add(bRPN);
    panel.add(bStand);
    panel.add(errors);
    panel.setBackground(Color.ORANGE);

    /* Draw on the frame. */
    frame.add(panel);
    frame.setBounds(300, 300, 300, 300);
    frame.setVisible(true);
  }

  /**
   * Gets the expression.
   *
   * @return the expression
   */
  @Override
  public String getExpression() {
    expression = textField.getText();
    return expression;
  }

  /**
   * Sets the answer.
   */
  @Override
  public void setAnswer() {
    float out = 0;
    try {
      out = model.evaluate(expression, infix);
    } catch (EmptyStack | BadType | InvalidExpression exception) {
      errors.setText(exception.getMessage());
      exception.printStackTrace();
    }
    answer = String.valueOf(out);
    if (answer.equals("Infinity")) {
      textField.setText("");
      errors.setText("Error!");
      System.out.println("Error!");
    } else {
      System.out.println(answer);
      String[] output = String.valueOf(out).split("\\.");
      textField.setText(output[0]);
    }
  }

  /**
   * Method which responds to actions performed.
   *
   * @param e ActionEvent
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    /* RPN notation switch. */
    if (e.getActionCommand().equals("RPN")) {
      notation.setText("RPN notation is active.");
      infix = false;
    }
    /* Standard notation switch. */
    if (e.getActionCommand().equals("Standard")) {
      notation.setText("Standard notation is active.");
      infix = true;
    }
    /* Calculate expression when bEquals is pressed and display in textField. */
    if (e.getActionCommand().equals("=")) {
      errors.setText("");
      getExpression();
      setAnswer();
    }
    /* Clear textField if bClear is pressed. */
    if (e.getActionCommand().equals("C")) {
      textField.setText("");
    }
  }
}