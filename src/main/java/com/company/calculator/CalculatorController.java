package com.company.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
/**
 * @author Cavallero Lorenzo
 * With a littel of help from Ermanno Oliveri
 *
 * Class CalculatorController
 */
public class CalculatorController {
    @FXML
    private TextArea field;
    @FXML
    private Label expressionLabel;
    private StringBuilder expression = new StringBuilder();

    private boolean result = false;
    private boolean canPut = false;
    private int enterCounter = 0;

    @FXML
    void keyPressed(KeyEvent event) {
        field.setEditable(false);
        switch (event.getCode()) {
            case DIGIT0, NUMPAD0 -> zero();
            case DIGIT1, NUMPAD1 -> one();
            case DIGIT2, NUMPAD2 -> two();
            case DIGIT3, NUMPAD3 -> tree();
            case DIGIT4, NUMPAD4 -> four();
            case DIGIT5, NUMPAD5 -> five();
            case DIGIT6, NUMPAD6 -> six();
            case DIGIT7, NUMPAD7 -> seven();
            case DIGIT8, NUMPAD8 -> eight();
            case DIGIT9, NUMPAD9 -> nine();
            case ADD, PLUS -> add();
            case MINUS, SUBTRACT -> subtract();
            case MULTIPLY -> multiply();
            case DIVIDE -> divide();
            case DELETE -> ce();
            case DECIMAL, COMMA, PERIOD -> comma();
            case BACK_SPACE -> delete();
            case ENTER -> {
                enterCounter++;
                if (enterCounter % 2 == 0)
                    equals();
            }
        }
    }

    public void zero() {
        field.appendText("0");
        canPut = true;
    }

    public void one() {
        field.appendText("1");
        canPut = true;
    }

    public void two() {
        field.appendText("2");
        canPut = true;
    }

    public void tree() {
        field.appendText("3");
        canPut = true;
    }

    public void four() {
        field.appendText("4");
        canPut = true;
    }

    public void five() {
        field.appendText("5");
        canPut = true;
    }

    public void six() {
        field.appendText("6");
        canPut = true;
    }

    public void seven() {
        field.appendText("7");
        canPut = true;
    }

    public void eight() {
        field.appendText("8");
        canPut = true;
    }

    public void nine() {
        field.appendText("9");
        canPut = true;
    }


    public void add() {
        if (!canPut) {
            if (expressionLabel.getText().length() == 0)
                return;

            expression.delete(expression.length() - 3, expression.length());
        }

        if (!result) {
            expression.append(field.getText());
        }
        expression.append("_+_");
        result = false;

        expressionLabel.setText(expression.toString().replaceAll("_", " "));
        clear();

    }

    public void subtract() {
        if (!canPut) {
            if (expressionLabel.getText().length() == 0)
                return;

            expression.delete(expression.length() - 3, expression.length());
        }
        if (!result) {
            expression.append(field.getText());
        }
        expression.append("_-_");
        result = false;

        expressionLabel.setText(expression.toString().replaceAll("_", " "));
        clear();

    }

    public void multiply() {
        if (!canPut) {
            if (expressionLabel.getText().length() == 0)
                return;

            expression.delete(expression.length() - 3, expression.length());
        }
        if (!result) {
            expression.append(field.getText());
        }
        expression.append("_*_");
        result = false;

        expressionLabel.setText(expression.toString().replaceAll("_", " "));
        clear();

    }


    public void divide() {
        if (!canPut) {
            if (expressionLabel.getText().length() == 0)
                return;

            expression.delete(expression.length() - 3, expression.length());
        }
        if (!result) {
            expression.append(field.getText());
        }
        expression.append("_/_");
        result = false;

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

    public void comma() {

    }

    public void negative() {
        if(!result) {
            if (!field.getText().contains("-"))
                field.setText("-" + field.getText());
            else
                field.setText(field.getText().replace("-", ""));
        }
    }


    public void ce() {
        clear();
    }

    public void delete() {
        if (!result) {
            if (field.getLength() != 0)
                field.setText(field.getText(0, field.getLength() - 1));
        }
    }

    public void canc() {
        expression.delete(0, expression.length());
        expressionLabel.setText("");
        clear();
    }

    public void equals() {
        if(!result){
            try{
                if(!canPut){
                    if (expressionLabel.getText().length() == 0)
                        return;

                    expression.delete(expression.length() - 3, expression.length());
                }
                expression.append(field.getText());
                String ris = Calculator.resolve(expression.toString());
                field.setText(ris);
                result = true;
                expressionLabel.setText(expression.toString().replaceAll("_", " ") + " =");
                expression.delete(0, expression.length()).append(ris); }
            catch (Exception e){
                System.out.println("An error occured :(");
                canc();
            }
        }
    }

    private void clear(){
        field.setText("");
        canPut = false;
    }
}
/*
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
        if (s.toString().length() == 0)
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

    private void updateEL(){
        expressionLabel.setText(expression.toString().replaceAll("_", " "));
    }
*/
