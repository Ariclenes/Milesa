package com.signcorporation.milesa.model.UTILS;

import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;

/**
 *
 * @author Bruna
 */
public class Alerta {
  static final ImageView DIALOG_HEADER_ALERTA = new ImageView("/VIEW/IMG/Favorites (1)/bugs.png");
//    DIALOG_HEADER_ALERTA.setFitHeight(48); // Set size to API recommendation.
//    DIALOG_HEADER_ALERTA.setFitWidth(48);
//    alert.getDialogPane().setGraphic(DIALOG_HEADER_ALERTA);  
    public static void erro(String titulo, Exception e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(titulo);
        alert.setContentText(e.getMessage());
        alert.show();
    }

    public static void alerta(String titulo, Exception e) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.getDialogPane ().setGraphic(DIALOG_HEADER_ALERTA);
        alert.setHeaderText(titulo);
        alert.setContentText(e.getMessage());
        alert.show();
    }

    public static void alerta(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
         alert.getDialogPane ().setGraphic(DIALOG_HEADER_ALERTA);
        alert.setHeaderText(mensagem);
        alert.show();
    }

    public static void sucesso(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.getDialogPane ().setGraphic(DIALOG_HEADER_ALERTA);
        alert.setHeaderText(mensagem);
        alert.show();
    }
}
