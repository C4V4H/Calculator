package com.company.calculator;

public class Calculator {

    public Calculator(){}

    public void resolve(String expression){
        if(expression.contains("*")){

        }
        if(expression.contains("/")){

        }
        if(expression.contains("+")){

        }
        if(expression.contains("-")){

        }
    }


    private void search(String expression, char toSearch){
        int position = expression.indexOf(toSearch);

    }

    private Double add(double x, double y){
        return x+y;
    }

    private Double subtract(double x, double y){
        return x-y;
    }

    private Double multiply(double x, double y){
        return x*y;
    }

    private Double divide(double x, double y){
        try{
            return x/y;
        }catch (Exception e){
            return null;
        }
    }


}
