package com.signcorporation.milesa.model.UTILS;

import MODELO.BEAN.Pessoa;
import MODELO.BEAN.Status;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.image.ImageView;
import javafx.util.Callback;

public class ColunaStatus implements Callback<TableColumn<Pessoa, Status>, TableCell<Pessoa, Status>> {

    @Override
    public TableCell<Pessoa, Status> call(TableColumn<Pessoa, Status> param) {

        TableCell<Pessoa, Status> cell = new TableCell<Pessoa, Status>() {

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
