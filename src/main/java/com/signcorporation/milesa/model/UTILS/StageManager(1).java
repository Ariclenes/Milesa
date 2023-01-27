package com.signcorporation.milesa.model.UTILS;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author AEM Sign Angola
 */
public class StageManager {

    private double x;
    private double y;
    
    public StageManager(Stage stage) throws IOException {
        this.nav = new Navegacao();
    

        Arrastar arrastar = new Arrastar();
        ResourceBundle rb = null;
        Properties prop = new Properties();
       
        prop.load(new FileInputStream(System.getProperty("user.home") + "/SmartERP/config/idioma_tema.properties"));
        Variaveis.TEMA = prop.getProperty("tema").equals("Dark") ? "/VIEW/CSS/temaEscuro.css" : "/VIEW/CSS/temaClaro.css";
        if (prop.getProperty("Idioma").equals("Portugues")) {
            rb = ResourceBundle.getBundle("IDIOMAS.Language_pt", new Locale("pt", "PT"));
        } else if (prop.getProperty("Idioma").equals("English")) {
            rb = ResourceBundle.getBundle("IDIOMAS.Language_en", new Locale("en", "EN"));
        }
        StageManager.stage = stage;
        stage.setTitle(rb.getString("marca2") );
        stage.initStyle(StageStyle.UNDECORATED);
        Parent root = (Parent) FXMLLoader.load(TelaController.class.getResource("/VIEW/Login.fxml"), rb);
        Scene scene = new Scene(root, 550.0D, 320.0D);
        scene.getStylesheets().add(getClass().getResource(Variaveis.TEMA).toExternalForm());
        
        stage.getIcons().add(this.nav.IconeAplicacao);
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();
    }
    Navegacao nav;
    private static Stage stage;
    private static BorderPane pane;

    public static Stage getStage() {
        return stage;
    }

    public static void setRoot(Parent root) {
        stage.getScene().setRoot(root);
    }

    public static void setPane(BorderPane pane) {
        StageManager.pane = pane;
    }

    public static void setPaneFragment(Parent root) {
        pane.getChildren().setAll(new Node[]{root});
    }
}
