/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.signcorporation.milesa.model.UTILS;

import CONTROLO.Produtos;
import MODELO.BEAN.Produto;
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
public class ColunaEditarProduto extends Object implements Callback<TableColumn<Produto, String>, TableCell<Produto, String>> {

    private final Produtos controller;

    public ColunaEditarProduto(Produtos controller) {
        this.controller = controller;
    }

    @Override
    public TableCell<Produto, String> call(TableColumn<Produto, String> param) {

        TableCell<Produto, String> cell = new TableCell<Produto, String>() {

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
                        Produto p = getTableView().getItems().get(getIndex());
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

