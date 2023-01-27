/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.signcorporation.milesa.model.UTILS;

import MODELO.BEAN.PlanoConta;
import MODELO.BEAN.Status;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.image.ImageView;
import javafx.util.Callback;

/**
 * @author Hacker PC
 */
public class StatusColuna implements Callback<TableColumn<PlanoConta, Status>, TableCell<PlanoConta, Status>> {


    @Override
    public TableCell<PlanoConta, Status> call(TableColumn<PlanoConta, Status> param) {

        TableCell<PlanoConta, Status> cell = new TableCell<PlanoConta, Status>() {

            @Override
            public void updateItem(Status status, boolean empty) {
                super.updateItem(status, empty);

                if (empty) {
                    setGraphic(null);
                    setText(null);
                } else {
                    ImageView img = null;

                    if (status == Status.ATIVO) {
                        img = new ImageView("/VIEW/IMG/ativo.png");
                    } else {
                        img = new ImageView("/VIEW/IMG/inativo.png");
                    }

                    setGraphic(img);
                    setText(null);
                    setAlignment(Pos.CENTER);
                    setCursor(Cursor.HAND);
                }
            }
        };
        return cell;
    }

}
