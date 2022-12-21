package com.company.calculator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;

/**
 * Class CalculatorController, the controller for the GUI
 * 
 * @author Cavallero Lorenzo (With the help of Ermanno Oliveri)
 * @version b.0.2
 */
public class CalculatorController {
  // declaration of all the attributes of the controller
  @FXML
  public VBox VBox;

  @FXML
  private MyLabel field;

  @FXML
  private Label expressionLabel;

  private final StringBuilder expression = new StringBuilder();

  private boolean result = false;

  private double n1 = 0;
  private char operator;
  private int opCounter;
  private boolean canPut = false;
  private int enterCounter = 0;

  /**
   * "If the user presses a key, the program will do something depending on the key pressed."
   * The first thing the program does is set the field to not editable. This is because the user
   * should not be able to type in the field. The program will do that for them
   *
   * @param event The event that occurred.
   */
  @FXML
  void keyPressed(KeyEvent event) {
    VBox.requestFocus();
    switch (event.getCode()) {
      case DIGIT0, NUMPAD0 -> zero();
      case DIGIT1, NUMPAD1 -> one();
      case DIGIT2, NUMPAD2 -> two();
      case DIGIT3, NUMPAD3 -> three();
      case DIGIT4, NUMPAD4 -> four();
      case DIGIT5, NUMPAD5 -> five();
      case DIGIT6, NUMPAD6 -> six();
      case DIGIT7, NUMPAD7 -> seven();
      case DIGIT8, NUMPAD8 -> eight();
      case DIGIT9, NUMPAD9 -> nine();
      case ADD, PLUS -> add();
      case SUBTRACT -> subtract();
      case MINUS -> negative();
      case MULTIPLY -> multiply();
      case DIVIDE -> divide();
      case DELETE -> canc();
      case DECIMAL, COMMA, PERIOD -> comma();
      case S -> sqrt();
      case P -> pow();
      case BACK_SPACE -> delete();
      case ENTER -> {
        enterCounter++;
        if (enterCounter % 2 == 0) equals();
      }
    }
  }

  /**
   * It appends a zero to the text field
   */
  public void zero() {
    field.appendText("0");
    canPut = true;
    VBox.requestFocus();
  }

  /**
   * It appends a one to the text field
   */
  public void one() {
    field.appendText("1");
    canPut = true;
    VBox.requestFocus();
  }

  /**
   * It appends a two to the text field
   */
  public void two() {
    field.appendText("2");
    canPut = true;
    VBox.requestFocus();
  }

  /**
   * It appends a three to the text field
   */
  public void three() {
    field.appendText("3");
    canPut = true;
    VBox.requestFocus();
  }

  /**
   * It appends a four to the text field
   */
  public void four() {
    field.appendText("4");
    canPut = true;
    VBox.requestFocus();
  }

  /**
   * It appends a five to the text field
   */
  public void five() {
    field.appendText("5");
    canPut = true;
    VBox.requestFocus();
  }

  /**
   * It appends a six to the text field
   */
  public void six() {
    field.appendText("6");
    canPut = true;
    VBox.requestFocus();
  }

  /**
   * It appends a seven to the text field
   */
  public void seven() {
    field.appendText("7");
    canPut = true;
    VBox.requestFocus();
  }

  /**
   * It appends eight to the text field
   */
  public void eight() {
    field.appendText("8");
    canPut = true;
    VBox.requestFocus();
  }

  /**
   * It appends a nine to the text field
   */
  public void nine() {
    field.appendText("9");
    canPut = true;
    VBox.requestFocus();
  }

  /**
   * It modifies the expression by adding _+_
   * It clear the field
   * It displays the expression in the top label
   * if another operator were put, it will be substituted with _+_
   */
  public void add() {
    VBox.requestFocus();
    operator = '+';
    if (!canPut) {
      if (expressionLabel.getText().length() == 0) return;

      expression.delete(expression.length() - 3, expression.length());
    } else opCounter++;

    if (!result) {
      expression.append(field.getText());
    }
    expression.append("_+_");
    result = false;

    expressionLabel.setText(expression.toString().replaceAll("_", " "));
    try {
      n1 = Double.parseDouble(field.getText());
    } catch (NumberFormatException ignored) {}
    clear();
  }

  /**
   * It modifies the expression by adding _-_
   * It clear the field
   * It displays the expression in the top label
   * if another operator were put, it will be substituted with _-_
   */
  public void subtract() {
    VBox.requestFocus();
    operator = '-';
    if (!canPut) {
      if (expressionLabel.getText().length() == 0) return;

      expression.delete(expression.length() - 3, expression.length());
    } else opCounter++;

    if (!result) {
      expression.append(field.getText());
    }
    expression.append("_-_");
    result = false;

    expressionLabel.setText(expression.toString().replaceAll("_", " "));
    try {
      n1 = Double.parseDouble(field.getText());
    } catch (NumberFormatException ignored) {}
    clear();
  }

  /**
   * It modifies the expression by adding _*_
   * It clear the field
   * It displays the expression in the top label
   * if another operator were put, it will be substituted with _*_
   */
  public void multiply() {
    VBox.requestFocus();
    operator = '*';
    if (!canPut) {
      if (expressionLabel.getText().length() == 0) return;

      expression.delete(expression.length() - 3, expression.length());
    } else opCounter++;

    if (!result) {
      expression.append(field.getText());
    }
    expression.append("_*_");
    result = false;

    expressionLabel.setText(expression.toString().replaceAll("_", " "));
    try {
      n1 = Double.parseDouble(field.getText());
    } catch (NumberFormatException ignored) {}
    clear();
  }

  /**
   * It modifies the expression by adding _/_
   * It clear the field
   * It displays the expression in the top label
   * if another operator were put, it will be substituted with _/_
   */
  public void divide() {
    VBox.requestFocus();
    operator = '/';
    if (!canPut) {
      if (expressionLabel.getText().length() == 0) return;

      expression.delete(expression.length() - 3, expression.length());
    } else opCounter++;

    if (!result) {
      expression.append(field.getText());
    }
    expression.append("_/_");
    result = false;

    expressionLabel.setText(expression.toString().replaceAll("_", " "));

    try {
      n1 = Double.parseDouble(field.getText());
    } catch (NumberFormatException ignored) {}
    clear();
  }

  /**
   * not complete method yet
   */
  public void frazionario() {
    VBox.requestFocus();
  }

  /**
   * not complete method yet
   */
  public void percentBtn() {
    VBox.requestFocus();

  }

  /**
   * It modifies the expression by adding _^_
   * It clear the field
   * It displays the expression in the top label
   * if another operator were put, it will be substituted with _^_
   */
  public void pow() {
    VBox.requestFocus();
    operator = '^';
    if (!canPut) {
      if (expressionLabel.getText().length() == 0) return;

      expression.delete(expression.length() - 3, expression.length());
    } else opCounter++;

    if (!result) {
      expression.append(field.getText());
    }
    expression.append("_^_");
    result = false;

    expressionLabel.setText(expression.toString().replaceAll("_", " "));

    try {
      n1 = Double.parseDouble(field.getText());
    } catch (NumberFormatException ignored) {}
    clear();
  }

  /**
   * not complete method yet
   */
  public void sqrt() {
    VBox.requestFocus();
    // double ris = Math.sqrt(Double.parseDouble(findResult()));
  }

  /**
   * It appends a comma in the field only if it isn't empty
   */
  public void comma() {
    VBox.requestFocus();
    if (field.getLength() != 0) {
      field.appendText(".");
      canPut = false;
    }
  }

  /**
   * It changes the sign of the number in the field
   */
  public void negative() {
    VBox.requestFocus();
    if (!result) {
      if (!field.getText().contains("-")) field.setText(
        "-" + field.getText()
      ); else field.setText(field.getText().replace("-", ""));
    }
  }

  /**
   * it clears the field
   */
  public void ce() {
    VBox.requestFocus();
    clear();
  }

  /**
   * delete the last character puts in the field
   */
  public void delete() {
    VBox.requestFocus();
    if (!result) {
      if (field.getLength() != 0) {
        field.setText(field.getText(0, field.getLength() - 1));
        if (field.getLength() == 0) canPut = false;
      }
    }
  }

  /**
   * it clears all (the field, the expression label and the expression)
   */
  public void canc() {
    VBox.requestFocus();
    opCounter = 0;
    result = false;
    expression.delete(0, expression.length());
    expressionLabel.setText("");
    clear();
  }

  /**
   * It displays in the field the result of the expression.
   */
  public void equals() {
    VBox.requestFocus();
    String ris;
    if (!result) {
      try {
        if (!canPut) {
          if (expressionLabel.getText().length() == 0) return;

          expression.delete(expression.length() - 3, expression.length());
        }
        expression.append(field.getText());
        ris = findResult();
        field.setText(ris);
        result = true;
        expressionLabel.setText(
          expression.toString().replaceAll("_", " ") + " ="
        );
        expression.delete(0, expression.length()).append(ris);
      } catch (Exception e) {
        System.out.println("An error occurred :(");
        canc();
      }
    }
  }

  /**
   * clear the field.
   */
  private void clear() {
    field.setText("");
    canPut = false;
    VBox.requestFocus();
  }

  /**
   * It finds the result of the expression.
   * if the expression have only two numbers it do the short version, simply it return the result
   * otherwise it return the result found with the Calculator class algorithm.
   * @return result of the expression
   */
  private String findResult() {
    if (opCounter == 1) {
      double n2 = Double.parseDouble(field.getText());

      opCounter = 0;
      return switch (operator) {
        case '+' -> Double.toString(n1 + n2);
        case '-' -> Double.toString(n1 - n2);
        case '*' -> Double.toString(n1 * n2);
        case '/' -> Double.toString(n1 / n2);
        case '^' -> Double.toString(Math.pow(n1, n2));
        default -> null;
      };
    }
    opCounter = 0;
    return Calculator.resolve(expression.toString());
  }
}
