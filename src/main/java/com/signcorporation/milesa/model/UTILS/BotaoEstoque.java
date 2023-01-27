/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.signcorporation.milesa.model.UTILS;

import CONTROLO.Controller;
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
 * @author Hacker PC
 */
public class BotaoEstoque implements Callback<TableColumn<Object, String>, TableCell<Object, String>> {

    private Controller controller;

    public BotaoEstoque(Controller controller) {
        this.controller = controller;
    }

    @Override
    public TableCell<Object, String> call(TableColumn<Object, String> param) {
        TableCell<Object, String> cell = new TableCell<Object, String>() {

            @Override
            public void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);

                if (empty) {
                    setGraphic(null);
                    setText(null);
                    return;
                }

                Button btn = new Button();
                Image img = new Image(getClass().getResourceAsStream("/VIEW/IMG/Produto.png"));
                btn.setGraphic(new ImageView(img));
                btn.setStyle("-fx-background-color: transparent;");
                btn.setOnAction((ActionEvent event) -> {
                    Object p = getTableView().getItems().get(getIndex());
//                    controller.estoque(p);

                });
//                if (item == 0) {
//                    btn.setDisable(true);
//                }
                setGraphic(btn);
                setText(null);
                setAlignment(Pos.CENTER);
                setCursor(Cursor.HAND);
            }
        };
        return cell;
    }
}
