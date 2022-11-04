package com.company.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class CalculatorController {
    @FXML
    private TextArea field;
    @FXML
    private Label expressionLabel;
    private StringBuilder expression = new StringBuilder();

    private boolean result = false;


    public void zero(ActionEvent actionEvent) {
        field.appendText("0");
    }

    public void one(ActionEvent actionEvent) {
        field.appendText("1");
    }

    public void two(ActionEvent actionEvent) {
        field.appendText("2");
    }

    public void tree(ActionEvent actionEvent){
        field.appendText("3");
    }

    public void four(ActionEvent actionEvent){
        field.appendText("4");
    }

    public void five(ActionEvent actionEvent){
        field.appendText("5");
    }

    public void six(ActionEvent actionEvent) {
        field.appendText("6");
    }

    public void seven(ActionEvent actionEvent){
        field.appendText("7");
    }

    public void eight(ActionEvent actionEvent) {
        field.appendText("8");
    }

    public void nine(ActionEvent actionEvent) {
        field.appendText("9");
    }



    public void add(ActionEvent actionEvent) {
        if(!canPut()) {
            if (expressionLabel.getText().length() == 0)
                return;

            expression.delete(expression.length() - 3, expression.length());
        }
        expression.append(field.getText()).append("_+_");
        expressionLabel.setText(expression.toString().replaceAll("_", " "));
        clear();

    }

    public void subtract(ActionEvent actionEvent) {
        if(!canPut()) {
            if (expressionLabel.getText().length() == 0)
                return;

            expression.delete(expression.length() - 3, expression.length());
        }
        expression.append(field.getText()).append("_-_");
        expressionLabel.setText(expression.toString().replaceAll("_", " "));
        clear();

    }

    public void multiply(ActionEvent actionEvent) {
        if(!canPut()) {
            if (expressionLabel.getText().length() == 0)
                return;

            expression.delete(expression.length() - 3, expression.length());
        }
        expression.append(field.getText()).append("_*_");
        expressionLabel.setText(expression.toString().replaceAll("_", " "));
        clear();

    }


    public void divide(ActionEvent actionEvent) {
        if(!canPut()) {
            if (expressionLabel.getText().length() == 0)
                return;

            expression.delete(expression.length() - 3, expression.length());
        }
        expression.append(field.getText()).append("_/_");
        expressionLabel.setText(expression.toString().replaceAll("_", " "));
        clear();

    }


    public void frazionario(ActionEvent actionEvent) {//@TODO da fare :)
    }

    public void percentBtn(ActionEvent actionEvent) {//@TODO da fare :)
    }

    public void square(ActionEvent actionEvent) {//@TODO da fare :)
    }

    public void sqrt(ActionEvent actionEvent) {//@TODO da fare :)
    }

    public void comma(ActionEvent actionEvent) {//@TODO da fare :)
    }

    public void negative(ActionEvent actionEvent) {//@TODO da fare :)
    }



    public void ce(ActionEvent actionEvent) {
        clear();
    }

    public void delete(ActionEvent actionEvent) {
        if(field.getLength() != 0)
            field.setText(field.getText(0, field.getLength()-1));
    }

    public void canc(ActionEvent actionEvent) {
        expression.delete(0, expression.length());
        expressionLabel.setText("");
        clear();
    }

    public void equals(ActionEvent actionEvent) {
        expression.append(field.getText());
        String ris = Calculator.resolve(expression.toString());
        field.setText(ris != null ? ris : "Err");
        result = true;
        expressionLabel.setText(expression.toString().replaceAll("_", " ") + " =");

    }

    private String getLast(){
        return field.getText(field.getLength()-1, field.getLength());
    }

    private boolean isNumber(String s){
        if (s == null)
            return false;

        try{
            Integer.parseInt(s);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    private boolean isNumber(Character s){
        if (s == null)
            return false;

        try{
            Integer.parseInt(s.toString());
            return true;
        }catch (Exception e){
            return false;
        }
    }

    private boolean isEmpty(){
        return expression.length() == 0;
    }

    private boolean canPut(){
        if (isEmpty() && field.getLength() == 0)
            return false;

        try {
            return isNumber(expression.charAt(expression.length() - 1));
        }catch (Exception e){
            return false;
        }
    }

    private void clear(){
        field.setText("");
    }

    /**
     * Update Expression Label
     */
    private void updateEL(){
        expressionLabel.setText(expression.toString().replaceAll("_", " "));
    }

}
