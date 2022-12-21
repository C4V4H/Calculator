package com.company.calculator;

public class MyLabel extends javafx.scene.control.Label {
    public void appendText(String text){
        setText(getText() + text);
    }

    public int getLength(){
        return getText().length();
    }

    public String getText(int start, int end) {
        return getText().substring(start, end);
    }
}
