package com.signcorporation.milesa.model.UTILS;

import static MODELO.UTILS.StageManager.getStage;

import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;

public class EcranLargo {

    public static void setEcranLargo() {
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        getStage().setX(bounds.getMinX());
        getStage().setY(bounds.getMinY());
        getStage().setWidth(bounds.getWidth());
        getStage().setHeight(bounds.getHeight());
    }
}
