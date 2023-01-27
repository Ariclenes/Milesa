package com.signcorporation.milesa.model.UTILS;

import CONTROLO.PessoaC;
import MODELO.BEAN.Pessoa;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;

/**
 * @author AEM Sign Angola
 */
public class ColunaEditar extends Object implements Callback<TableColumn<Pessoa, String>, TableCell<Pessoa, String>> {

    private PessoaC controller;

    public ColunaEditar(PessoaC controller) {
        this.controller = controller;
    }

    @Override
    public TableCell<Pessoa, String> call(TableColumn<Pessoa, String> param) {

        TableCell<Pessoa, String> cell = new TableCell<Pessoa, String>() {

            @Override
            public void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);

                if (empty) {
                    setGraphic(null);
                    setText(null);
                } else {
                    Button btn = new Button();
                    Image img = new Image(getClass().getResourceAsStream("/VIEW/IMG/editar-arquivo.png"));
                    btn.setGraphic(new ImageView(img));
                    btn.setStyle("-fx-background-color: transparent;");
                    btn.setOnAction((ActionEvent event) -> {
                        Pessoa p = getTableView().getItems().get(getIndex());
                        controller.onActionBtnEditar(p);
                    });

                    setGraphic(btn);
                    setText(null);
                    setAlignment(Pos.CENTER);
                    setCursor(Cursor.HAND);
                }
            }
        };
        return cell;
    }

}
