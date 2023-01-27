package com.signcorporation.milesa.model.UTILS;

import CONTROLO.Controller;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;

/**
 *
 * @author AEM Sign Angola
 */
public class BotaoExcluir implements Callback<TableColumn<Object, Integer>, TableCell<Object, Integer>> {

    private final Controller controller;

    public BotaoExcluir(Controller controller) {
        this.controller = controller;
    }

    @Override
    public TableCell<Object, Integer> call(TableColumn<Object, Integer> param) {
        TableCell<Object, Integer> cell;
        cell = new TableCell<Object, Integer>() {
            
            @Override
            public void updateItem(Integer item, boolean empty) {
                super.updateItem(item, empty);

                if (empty) {
                    setGraphic(null);
                    setText(null);
                    return;
                }
                Image img =  new Image(getClass().getResourceAsStream("/VIEW/IMG/apagar.png"));
               
                ImageView iv = new ImageView(img);
                Button btn = new Button();
             
                iv.setPreserveRatio(true);
                iv.setFitHeight(16);
                iv.setFitWidth(16);
                btn.setTooltip(new Tooltip("Excluir Produto"));
                btn.setGraphic(iv);
                btn.setStyle("-fx-background-color: transparent;");
                btn.setOnAction((ActionEvent event) -> {
                    controller.excluir(item);
                });
                if (item == null) {
                    btn.setDisable(true);
                }
                setGraphic(btn);
                setText(null);
                setAlignment(Pos.CENTER);
                setCursor(Cursor.HAND);
            }
        };
        return cell;
    }

}
