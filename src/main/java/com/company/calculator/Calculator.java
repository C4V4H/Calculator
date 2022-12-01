package com.company.calculator;

/**
 * Class Calculator, it manages the algorithm for find the result
 * 
 * @author Cavallero Lorenzo
 * @version b.0.2
 */
public class Calculator {

  /**
   * empty constructor
   */
  public Calculator() {}

  /**
   * Given a string of numbers, resolution of the expression.
   * @param expression
   * @return
   */
  /**
   * It takes a string, that contains the expression to resolve
   * it first do the exponentials, secondly it do the multiplications and divisions
   * and lastly it do the additions and subtractions.
   *
   * @param expression The expression to be resolved.
   * @return The result of the calculation.
   */
  public static String resolve(String expression) {
    //"^"position, "*" position, "/" position, "+" position, "-" position;
    int powPos, mPos, dPos, aPos, sPos;
    String calc;
    while (expression.contains("_")) {
      powPos = expression.lastIndexOf("_^_");
      mPos = expression.indexOf("_*_");
      dPos = expression.indexOf("_/_");
      aPos = expression.indexOf("_+_");
      sPos = expression.indexOf("_-_");

      //if there are exponentials, it do them first, and then do the others.
      if (powPos != -1) {
        calc = getOperation(expression, ++powPos);

        //it do the operation and replace the calc in the expression with the result.
        try {
          expression = expression.replace(calc, "" + resolveFromStr(calc, "^"));
        } catch (NullPointerException e) {
          return null;
        }
      }
      //if there are multiplications or divisions, it do them first, and then do the others.
      else if (mPos != -1 || dPos != -1) {
        //it find the calc in the expression
        if (mPos == -1) {
          dPos++;
          calc = getOperation(expression, dPos);
          mPos = dPos + 1;
        } else if (dPos == -1) {
          mPos++;
          calc = getOperation(expression, mPos);
          dPos = mPos + 1;
        } else {
          mPos++;
          dPos++;
          calc = getOperation(expression, Math.min(mPos, dPos));
        }

        //it do the operation and replace the calc in the expression with the result.
        try {
          expression =
            expression.replace(
              calc,
              "" + resolveFromStr(calc, mPos < dPos ? "*" : "/")
            );
        } catch (NullPointerException e) {
          return null;
        }
      } else if (aPos != -1 || sPos != -1) {
        //it find the calc in the expression
        if (aPos == -1) {
          sPos++;
          calc = getOperation(expression, sPos);
          aPos = sPos + 1;
        } else if (sPos == -1) {
          aPos++;
          calc = getOperation(expression, aPos);
          sPos = aPos + 1;
        } else {
          aPos++;
          sPos++;
          calc = getOperation(expression, Math.min(aPos, sPos));
        }

        //it do the operation and replace the calc in the expression with the result.
        try {
          expression =
            expression.replace(
              calc,
              "" + resolveFromStr(calc, aPos < sPos ? "+" : "-")
            );
        } catch (NullPointerException e) {
          return null;
        }
      }
    }

    //when it don't find any "_" that means the expression is resolved, so it return it
    return expression;
  }

  /**
   * From the given expression an positions it return the single operation.
   *
   * @param expression the expression to be evaluated
   * @param pos the position of the operator in the expression
   * @return The operation that is being performed on the two numbers.
   */
  private static String getOperation(String expression, int pos) {
    int start = 0, end = expression.length();
    for (int i = pos - 2; i > 0; i--) {
      if (expression.charAt(i) == '_') {
        start = i + 1;
        break;
      }
    }

    for (int i = pos + 2; i < expression.length(); i++) {
      if (expression.charAt(i) == '_') {
        end = i;
        break;
      }
    }

    return expression.substring(start, end);
  }

  /**
   * It takes a string, splits it into two parts, and then performs the operation on the two parts
   *
   * @param calc the string to be evaluated
   * @param operator the operator to be used in the calculation
   * @return The result of the calculation.
   */
  private static Double resolveFromStr(String calc, String operator) {
    calc = calc.replaceAll("_", "");
    String[] tmp;
    switch (operator) {
      case "*":
        tmp = calc.split("\\*");
        return Double.parseDouble(tmp[0]) * Double.parseDouble(tmp[1]);
      case "/":
        tmp = calc.split("/");
        return divide(Double.parseDouble(tmp[0]), Double.parseDouble(tmp[1]));
      case "+":
        tmp = calc.split("\\+");
        return Double.parseDouble(tmp[0]) + Double.parseDouble(tmp[1]);
      case "-":
        tmp = calc.split("-");
        return Double.parseDouble(tmp[0]) - Double.parseDouble(tmp[1]);
      case "^":
        tmp = calc.split("\\^");
        return Math.pow(Double.parseDouble(tmp[0]), Double.parseDouble(tmp[1]));
      default:
        return null;
    }
  }

  /**
   * If the division is successful, return the result, otherwise return null
   *
   * @param x The dividend
   * @param y The number to divide by.
   * @return A Double object.
   */
  private static Double divide(double x, double y) {
    try {
      return x / y;
    } catch (Exception e) {
      return null;
    }
  }
}
