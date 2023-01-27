package com.signcorporation.milesa.model.UTILS;

import static MODELO.UTILS.StageManager.getStage;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;

public class EcranPequeno {

    public static void setEcranPequeno() {
        getStage().setWidth(1107);
        getStage().setHeight(675);
        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        getStage().setX((primScreenBounds.getWidth() - getStage().getWidth()) / 2);
        getStage().setY((primScreenBounds.getHeight() - getStage().getHeight()) / 2);
    }

}
