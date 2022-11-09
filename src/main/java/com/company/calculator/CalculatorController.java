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
        switch (event.getCode()){
            case DIGIT0: case NUMPAD0:
                zero();
                break;
            case DIGIT1: case NUMPAD1:
                one();
                break;
            case DIGIT2: case NUMPAD2:
                two();
                break;
            case DIGIT3: case NUMPAD3:
                tree();
                break;

            case DIGIT4: case NUMPAD4:
                four();
                break;

            case DIGIT5: case NUMPAD5:
                five();
                break;
            case DIGIT6: case NUMPAD6:
                six();
                break;

            case DIGIT7: case NUMPAD7:
                seven();
                break;

            case DIGIT8: case NUMPAD8:
                eight();
                break;

            case DIGIT9: case NUMPAD9:
                nine();
                break;
            case ADD: case PLUS:
                add();
                break;
            case MINUS: case SUBTRACT:
                subtract();
                break;
            case MULTIPLY:
                multiply();
                break;
            case DIVIDE:
                divide();
                break;
            case DELETE:
                ce();
                break;
            case DECIMAL: case COMMA: case PERIOD:
                comma();
                break;
            case BACK_SPACE:
                delete();
                break;
            case ENTER:
                enterCounter++;
                if(enterCounter % 2 == 0)
                    equals();
                break;

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

    public void comma() {//@TODO da fare :)
    }

    public void negative() {//@TODO da fare :)
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
        expression.append(field.getText());
        String ris = Calculator.resolve(expression.toString());
        field.setText(ris != null ? ris : "Err");
        result = true;
        expressionLabel.setText(expression.toString().replaceAll("_", " ") + " =");
        expression.delete(0, expression.length()).append(ris);

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
