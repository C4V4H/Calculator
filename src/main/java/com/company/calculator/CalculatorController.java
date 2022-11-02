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
        if(canPut()){
            //@TODO string sopra al field
            expression.append(field.getText());
            expression.append("_+_");
            expressionLabel.setText(expression.toString().replaceAll("_", " "));
            clear();
        }else{
            System.out.println("err");
        }

    }

    public void subtract(ActionEvent actionEvent) {
        if(canPut()){
            //@TODO string sopra al field
            expression.append(field.getText());
            expression.append("_-_");
            expressionLabel.setText(expression.toString().replaceAll("_", " "));
            clear();
        }else{
            System.out.println("err");
        }
    }

    public void multiply(ActionEvent actionEvent) {
        if(canPut()){
            //@TODO string sopra al field
            expression.append(field.getText());
            expression.append("_*_");
            expressionLabel.setText(expression.toString().replaceAll("_", " "));
            clear();
        }else{
            System.out.println("err");
        }
    }


    public void divide(ActionEvent actionEvent) {
        if(canPut()){
            //@TODO string sopra al field
            expression.append(field.getText());
            expression.append("_/_");
            expressionLabel.setText(expression.toString().replaceAll("_", " "));
            clear();
        }else{
            System.out.println("err");
        }
    }



    public void frazionario(ActionEvent actionEvent) {
    }

    public void percentBtn(ActionEvent actionEvent) {
    }

    public void square(ActionEvent actionEvent) {
    }

    public void sqrt(ActionEvent actionEvent) {
    }

    public void comma(ActionEvent actionEvent) {
    }

    public void negative(ActionEvent actionEvent) {
    }



    public void ce(ActionEvent actionEvent) {
        clear();
    }

    public void delete(ActionEvent actionEvent) {
        if(!isEmpty())
            field.setText(field.getText(0, field.getLength()-1));
        else
            System.out.println("empty");
    }

    public void canc(ActionEvent actionEvent) {
        expression.delete(0, expression.length());
        clear();
    }

    public void equals(ActionEvent actionEvent) {
        expression.append(field.getText());
        System.out.println(expression);
        clear();
        expressionLabel.setText(expression.toString().replaceAll("_", " "));
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
        return field.getLength() == 0;
    }

    private boolean canPut(){
        if (isEmpty()){
            if(isNumber(expression.charAt(expression.length()-1)))
                return expression.length() != 0;
        }

        return isNumber(getLast());

    }

    private void clear(){
        field.setText("");
    }

}
