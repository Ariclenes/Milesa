/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.signcorporation.milesa.model.UTILS.Buttons;

import com.gn.decorator.buttons.GNFullscreen;
import com.sun.javafx.css.converters.PaintConverter;
import com.sun.javafx.scene.control.skin.ButtonSkin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.css.CssMetaData;
import javafx.css.SimpleStyleableObjectProperty;
import javafx.css.Styleable;
import javafx.css.StyleableObjectProperty;
import javafx.css.StyleableProperty;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Skin;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

/**
 * @author AEM Sign corp
 */
public class Fullscreen extends Button {
    private final ImageView viewFullScreen = new ImageView(new Image("/VIEW/IMG/fullscreen.png"));
    private final ImageView viewUnFullScreen = new ImageView(new Image("/VIEW/IMG/unfullscreen.png"));

    public Fullscreen() {
        getStyleClass().add("gn-full-screen");
        this.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        this.setGraphic(viewFullScreen);
    }

    public void updateState(boolean fullscreen) {
        if (fullscreen) {
            this.setGraphic(viewFullScreen);
        } else {
            this.setGraphic(viewUnFullScreen);
        }
    }

    @Override
    protected Skin<?> createDefaultSkin() {
        return new ButtonSkin(Fullscreen.this);
    }

    @Override
    public String getUserAgentStylesheet() {
        return getClass().getResource("/VIEW/CSS/buttons.css").toExternalForm();
    }

    private final StyleableObjectProperty<Paint> defaultFill = new SimpleStyleableObjectProperty<>(StyleableProperties.DEFAULT_FILL,
            Fullscreen.this,
            "defaultFill",
            Color.WHITE);

    public Paint getdefaultFill() {
        return defaultFill.get();
    }

    public StyleableObjectProperty<Paint> defaultFillProperty() {
        return this.defaultFill;
    }

    public void setdefaultFill(Paint color) {
        this.defaultFill.set(color);
    }

    private static class StyleableProperties {

        private static final CssMetaData<Fullscreen, Paint> DEFAULT_FILL
                = new CssMetaData<Fullscreen, Paint>("-gn-fill",
                PaintConverter.getInstance(), Color.RED) {
            @Override
            public boolean isSettable(Fullscreen control) {
                return control.defaultFill == null || !control.defaultFill.isBound();
            }

            @Override
            public StyleableProperty<Paint> getStyleableProperty(Fullscreen control) {
                return control.defaultFillProperty();
            }
        };

        private static final List<CssMetaData<? extends Styleable, ?>> CHILD_STYLEABLES;

        static {
            final List<CssMetaData<? extends Styleable, ?>> styleables
                    = new ArrayList<>(Button.getClassCssMetaData());
            Collections.addAll(styleables,
                    DEFAULT_FILL);
            CHILD_STYLEABLES = Collections.unmodifiableList(styleables);
        }
    }

    // inherit the styleable properties from parent
    private List<CssMetaData<? extends Styleable, ?>> STYLEABLES;

    @Override
    public List<CssMetaData<? extends Styleable, ?>> getControlCssMetaData() {
        if (STYLEABLES == null) {
            final List<CssMetaData<? extends Styleable, ?>> styleables
                    = new ArrayList<>(Button.getClassCssMetaData());
            styleables.addAll(getClassCssMetaData());
            styleables.addAll(GNFullscreen.getClassCssMetaData());
            STYLEABLES = Collections.unmodifiableList(styleables);
        }
        return STYLEABLES;
    }

    public static List<CssMetaData<? extends Styleable, ?>> getClassCssMetaData() {
        return StyleableProperties.CHILD_STYLEABLES;
    }

}








