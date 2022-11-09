package com.company.calculator;

public class Calculator {
    public Calculator(){}

    public static String resolve(String expression) {
        //"*" position, "/" position, "+" position, "-" position;
        int mPos, dPos, aPos, sPos;
        String calc;
        do {
            mPos = expression.indexOf("_*_");
            dPos = expression.indexOf("_/_");
            aPos = expression.indexOf("_+_");
            sPos = expression.indexOf("_-_");

            if (mPos != -1 || dPos != -1) {
                if(mPos == -1) {
                    dPos++;
                    calc = getOperation(expression, dPos);
                    mPos = dPos + 1;
                }
                else if(dPos == -1) {
                    mPos++;
                    calc = getOperation(expression, mPos);
                    dPos = mPos + 1;
                }
                else {
                    mPos++;
                    dPos++;
                    calc = getOperation(expression, Math.min(mPos, dPos));
                }

                try {
                    expression = expression.replace(calc, "" + resolveFromStr(calc, mPos < dPos ? "*" : "/"));
                } catch (NullPointerException e) {
                    return null;
                }
            } else if (aPos != -1 || sPos != -1) {
                if(aPos == -1){
                    sPos++;
                    calc = getOperation(expression, sPos);
                    aPos = sPos + 1;
                }
                else if(sPos == -1){
                    aPos++;
                    calc = getOperation(expression, aPos);
                    sPos = aPos + 1;
                }
                else{
                    aPos++;
                    sPos++;
                    calc = getOperation(expression, Math.min(aPos, sPos));
                }

                try {
                    expression = expression.replace(calc, "" + resolveFromStr(calc, aPos < sPos ? "+" : "-"));
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
