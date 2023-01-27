
package com.signcorporation.milesa.model.UTILS;

import CONTROLO.Exportar;
import CONTROLO.PessoaC;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author AEM SIGN Corporation <>
 */
public class AbrirExportacao {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/VIEW/Pessoa.fxml"));
    PessoaC PESSOAS = loader.getController();

    public AbrirExportacao() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/VIEW/Exportar.fxml"));
        Parent bpExportar = null;
        try {
            bpExportar = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Exportar exportar = loader.getController();
        Stage stage = new Stage();

        exportar.btnCancelar.setOnAction(e -> {
            stage.close();
        });

        exportar.btnExcel.setOnAction(e -> {

        });

        exportar.btnCSV.setOnAction(e -> {
//            createFile(stage, "csv");
        });

        Scene scene = new Scene(bpExportar, 520, 205);
        scene.setFill(Color.TRANSPARENT);
        scene.getStylesheets().add(getClass().getResource(Variaveis.TEMA).toExternalForm());
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

}
