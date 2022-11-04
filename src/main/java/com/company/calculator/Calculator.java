package com.company.calculator;

public class Calculator {
    public Calculator(){}

    public static String resolve(String expression) {
        //"*" position, "/" position, "+" position, "-" position;
        int mPos, dPos, aPos, sPos;
        do {
            mPos = expression.indexOf("*");
            dPos = expression.indexOf('/');
            aPos = expression.indexOf('+');
            sPos = expression.indexOf('-');

            if (mPos != -1 || dPos != -1) {
                String calc = getOperation(expression, Math.max(mPos, dPos));
                try {
                    expression = expression.replace(calc, "" + resolveFromStr(calc, mPos > dPos ? "*" : "/"));
                } catch (NullPointerException e) {
                    return null;
                }
            } else if (aPos != -1 || sPos != -1) {
                String calc = getOperation(expression, Math.max(aPos, sPos));
                try {
                    expression = expression.replace(calc, "" + resolveFromStr(calc, aPos > sPos ? "+" : "-"));
                } catch (NullPointerException e) {
                    return null;
                }
            }

        } while (expression.contains("_"));

        return expression;
    }


    private static String getOperation(String expression, int pos){
        int start = 0, end = expression.length();
        for (int i = pos - 2; i > 0; i--){
            if (expression.charAt(i) == '_'){
                start = i + 1;
                break;
            }
        }

        for (int i = pos + 2; i < expression.length(); i++){
            if (expression.charAt(i) == '_'){
                end = i;
                break;
            }
        }


        return expression.substring(start, end);
    }

    private static Double resolveFromStr(String calc, String operator){
        calc = calc.replaceAll("_", "");
        String[] tmp;
        switch (operator) {
            case "*" :
                tmp = calc.split("\\*");
                return Double.parseDouble(tmp[0]) * Double.parseDouble(tmp[1]);
            case "/" :
                tmp = calc.split("/");
                return divide(Double.parseDouble(tmp[0]), Double.parseDouble(tmp[1]));
            case "+" :
                tmp = calc.split("\\+");
                return Double.parseDouble(tmp[0]) + Double.parseDouble(tmp[1]);
            case "-" :
                tmp = calc.split("-");
                return Double.parseDouble(tmp[0]) - Double.parseDouble(tmp[1]);
            default: return null;
        }
    }

    private static Double divide(double x, double y){
        try{
            return x/y;
        }catch (Exception e){
            return null;
        }
    }


}
