/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.signcorporation.milesa.model.UTILS;

import CONTROLO.Empresa;
import MODELO.BEAN.EmpresaM;
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
 *
 * @author Hacker PC
 */
public class ColunaEditarEmpresa extends Object implements Callback<TableColumn<EmpresaM, String>, TableCell<EmpresaM, String>>{
    
    private Empresa controller;

    public ColunaEditarEmpresa(Empresa controller) {
        this.controller = controller;
    }

    @Override
    public TableCell<EmpresaM, String> call(TableColumn<EmpresaM, String> param) {

        TableCell<EmpresaM, String> cell = new TableCell<EmpresaM, String>() {

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
                        EmpresaM p = getTableView().getItems().get(getIndex());
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
