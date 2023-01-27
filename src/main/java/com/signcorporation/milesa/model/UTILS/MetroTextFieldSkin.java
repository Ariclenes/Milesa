package com.signcorporation.milesa.model.UTILS;

import javafx.scene.control.TextField;


public class MetroTextFieldSkin extends TextFieldWithButtonPele {
    public MetroTextFieldSkin(TextField textField) {
        super(textField);
    }

    @Override
    protected void rightButtonPressed() {
        getSkinnable().setText("");
    }

}