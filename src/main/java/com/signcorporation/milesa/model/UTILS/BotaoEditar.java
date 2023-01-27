package com.signcorporation.milesa.model.UTILS;

import CONTROLO.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;


/**
 * @author AEM Sign Angola
 */
public class BotaoEditar implements Callback<TableColumn<Object, Integer>, TableCell<Object, Integer>> {
    private Controller controller;

    public BotaoEditar(Controller controller) {
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

                Button btn = new Button();
                Image img = new Image(getClass().getResourceAsStream("/VIEW/IMG/editar-arquivo.png"));
                ImageView in = new ImageView(img);
                in.setFitHeight(16);
                in.setFitWidth(16);
                btn.setGraphic(new ImageView(img));
                btn.setStyle("-fx-background-color: transparent;");
                btn.setTooltip(new Tooltip("Editar Produto"));
                btn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        controller.editar(item);
                    }
                });
//                if(item == 0){
//                    btn.setDisable(true);
//                }
//                setGraphic(btn);
                setText(null);
            }
        };
        return cell;
    }
//                Image img = new Image(getClass().getResourceAsStream("/VIEW/IMG/editar-arquivo.png"));

//                ImageView in = new ImageView(img);
//                in.setFitHeight(16);
//                in.setFitWidth(16);
//                btn.setGraphic(new ImageView(img));
//                btn.setTooltip(new Tooltip("Editar Produto"));

}
