package com.signcorporation.milesa.model.UTILS;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class MetroPasswordFieldSkin extends TextFieldWithButtonPele{
    private boolean shouldMaskText = true;

    public MetroPasswordFieldSkin(TextField textField) {
        super(textField);
    }

    @Override
    protected void rightButtonPressed() {
        TextField textField = getSkinnable();
        shouldMaskText = false;
        textField.setText(textField.getText());
        shouldMaskText = true;
    }

    @Override
    protected  void rightButtonReleased()
    {
        TextField textField = getSkinnable();
        textField.setText(textField.getText());
        textField.end();
    }

    @Override protected String maskText(String txt) {
        if (getSkinnable() instanceof PasswordField && shouldMaskText) {
            int n = txt.length();
            StringBuilder passwordBuilder = new StringBuilder(n);
            for (int i = 0; i < n; i++) {
                passwordBuilder.append(BULLET);
            }

            return passwordBuilder.toString();
        } else {
            return txt;
        }
    }
}
