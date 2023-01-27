/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.signcorporation.milesa.model.UTILS;

import com.jfoenix.controls.JFXButton;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;

/**
 * @author AEM Sign corp
 */
public class Popover implements Initializable {
    private JFXButton theme;

    @FXML
    public VBox options;

    public static Popover ctrl;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ctrl = this;
    }
}



