package com.signcorporation.milesa.model.UTILS;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.StageStyle;

/**
 * @author Ariclenes Evaristo Maciel <arymonster@gmail.com><+244 933 934 838>
 */
public class MensagemAlerta {
    public MensagemAlerta(String title, String content, AlertType type) {
        Alert alert = new Alert(type, content);
        alert.initStyle(StageStyle.UTILITY);
        alert.setTitle(title);
        alert.showAndWait();
    }

    public static boolean AlertMessageConfirmation() {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Sucesso");
        alert.setHeaderText("Excluir projeto");
        alert.setContentText("Tem certeza de excluir este projeto?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            return true;
        } else {
            return false;
        }
    }

}
