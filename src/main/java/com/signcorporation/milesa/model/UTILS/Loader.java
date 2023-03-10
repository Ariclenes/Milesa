/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.signcorporation.milesa.model.UTILS;

import com.jfoenix.controls.JFXProgressBar;

import java.io.IOException;

import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * @author AEM Sign corp
 */
public class Loader extends Preloader {
    private JFXProgressBar progressBar;
    private Parent view;
    private Stage stage;

    @Override
    public void init() {
        try {
            view = FXMLLoader.load(getClass().getResource("/VIEW/MODULO/loader/loader.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage primary) {
        stage = primary;
        primary.initStyle(StageStyle.TRANSPARENT);
        Scene scene = new Scene(view);
        scene.setFill(Color.TRANSPARENT);
        scene.getStylesheets().add(getClass().getResource("/VIEW/CSS/fonts.css").toExternalForm());
        progressBar = (JFXProgressBar) scene.lookup("#progressBar");
        primary.getIcons().add(new Image("/VIEW/IMG/icon.png"));
        primary.setScene(scene);
//        primary.setAlwaysOnTop(true);
        primary.show();

    }

    @Override
    public synchronized void handleApplicationNotification(PreloaderNotification info) {
        // Handle application notification in this point (see MyApplication#Init).

        if (info instanceof ProgressNotification) {
            double x = ((ProgressNotification) info).getProgress();

            double percent = x / 100f;
            progressBar.progressProperty().set(percent > 1 ? 1 : percent);
        }
    }

    @Override
    public void handleStateChangeNotification(StateChangeNotification info) {
        // Handle state change notifications.

        StateChangeNotification.Type type = info.getType();
        switch (type) {
            case BEFORE_LOAD:
                break;
            case BEFORE_INIT:
                break;
            case BEFORE_START:
                stage.close();
        }
    }
}












