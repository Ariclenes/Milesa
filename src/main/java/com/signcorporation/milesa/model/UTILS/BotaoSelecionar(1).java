/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.signcorporation.milesa.model.UTILS;

import CONTROLO.Controller;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;

/**
 *
 * @author Hacker PC
 */
public class BotaoSelecionar implements Callback<TableColumn<Object, Integer>, TableCell<Object, Integer>> {

    private Controller controller;

    public BotaoSelecionar(Controller controller) {
        this.controller = controller;
    }

    @Override
    public TableCell<Object, Integer> call(TableColumn<Object, Integer> param) {
        TableCell<Object, Integer> cell = new TableCell<Object, Integer>() {

            @Override
            public void updateItem(Integer item, boolean empty) {
                super.updateItem(item, empty);

                if (empty) {
                    setGraphic(null);
                    setText(null);
                    return;
                }
//ableColumn colCheck = new TableColumn();
//colCheck.setCellFactory(CheckBoxTableCell.forTableColumn(colCheck));
//
//CheckBox cbk = new CheckBox();
//cbk.selectedProperty().addListener(new ChangeListener<Boolean>() {
//    @Override
//    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
//         TODO Auto-generated method stub
//        if (!tbView.getItems().isEmpty())
//            if (newValue)
//                for (int i = 0; i < tbView.getItems().size(); i++) {
//
//                    ((CheckBox) ((TableColumn) tbView.getColumns().get(0)).getGraphic()).selectedProperty().get();
//                }
//    }
//});
//
//colCheck.setGraphic(cbk);
                Button btn = new Button();
                Image img = new Image(getClass().getResourceAsStream("/VIEW/IMG/Excluir.png"));
                btn.setTooltip(new Tooltip("Excluir Produto"));
                btn.setGraphic(new ImageView(img));
                btn.setStyle("-fx-background-color: transparent;");
                btn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        controller.excluir(item);
                    }
                });
                if (item == null) {
                    btn.setDisable(true);
                }
                setGraphic(btn);
                setText(null);
            }
        };
        return cell;
    } 
    
}
