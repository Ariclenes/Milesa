package com.signcorporation.milesa.model.UTILS;

import CONTROLO.MsgPositivaController;

import java.io.FileInputStream;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import javafx.animation.PauseTransition;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 * @author AEM Sign Angola
 */
public class Notificacao {

    private int segundos = 4;
    private String mensagem = "";
    private BotaoTipo btnTipo = BotaoTipo.NAO_BTN;
    private NotificacaoTipo ntfTipo = NotificacaoTipo.SUCESSO;

    private boolean excluir;
    ResourceBundle bundle;

    public Notificacao() {

    }

    public boolean getExcluir() {
        return this.excluir;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public void setDuracao(int segundos) {
        this.segundos = segundos;
    }

    public void setTipo(NotificacaoTipo nt) {
        this.ntfTipo = nt;
    }

    public void setBotao(BotaoTipo bt) {
        this.btnTipo = bt;
    }

    public void setTodos(String mensagem, BotaoTipo btnTipo, NotificacaoTipo mTipo, int segundos) {
        this.mensagem = mensagem;
        this.segundos = segundos;
        this.ntfTipo = mTipo;
        this.btnTipo = btnTipo;
    }

    public Notificacao(String mensagem) {
        this.mensagem = mensagem;
    }

    public void mostrarEAguardar() {
        Properties propriedades = new Properties();
        try {
            Rectangle2D rec = Screen.getPrimary().getBounds();
            String fxml = "";

            switch (ntfTipo) {
                case SUCESSO:
                    switch (btnTipo) {
                        case NAO_BTN:
                            fxml = "/VIEW/MsgPositiv.fxml";
                            break;
                        case SIM:
                            fxml = "/VIEW/MsgPositivaBTN.fxml";
                            break;
                    }
                    break;
                case ERRO:
                    switch (btnTipo) {
                        case NAO_BTN:
                            fxml = "/VIEW/MsgERRO.fxml";
                            break;
                        case SIM:
                            fxml = "/VIEW/MsgErroBTN.fxml";
                            break;
                    }
                    break;
            }
            propriedades.load(new FileInputStream(System.getProperty("user.home") + "/SmartERP/config/idioma_tema.properties"));
            if (propriedades.getProperty("Idioma").equals("Portugues")) {
                bundle = ResourceBundle.getBundle("IDIOMAS.Language_pt", new Locale("pt", "PT"));
            } else if (propriedades.getProperty("Idioma").equals("English")) {
                this.bundle = ResourceBundle.getBundle("IDIOMAS.Language_en", new Locale("en", "EN"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void mostra() {
        try {
            Rectangle2D rect = Screen.getPrimary().getBounds();
            String fxml = "";

            switch (this.ntfTipo) {
                case SUCESSO:
                    switch (btnTipo) {
                        case NAO_BTN:
                            fxml = "/VIEW/MsgPositiv.fxml";
                            break;
                        case SIM:
                            fxml = "/VIEW/MsgPositivaBTN.fxml";
                            break;
                    }
                    break;
                case ERRO:
                    switch (this.btnTipo) {
                        case NAO_BTN:
                            fxml = "/VIEW/MsgERRO.fxml";
                            break;
                        case SIM:
                            fxml = "/VIEW/MsgErroBTN.fxml";
                            break;
                    }
                    break;
            }
            FXMLLoader loader = new FXMLLoader(Notificacao.class.getResource(fxml));
            Parent parent = (Parent) loader.load();
            MsgPositivaController msg;
            msg = loader.getController();
            msg.setMensagem(mensagem);
            Stage stage = new Stage();
            Scene scene = new Scene(parent, 400.0D, 150.0D);

            msg.setStage(stage);

            scene.setOnKeyPressed(e -> {
                if (e.getCode().equals(KeyCode.ENTER) || e.getCode().equals(KeyCode.ESCAPE)) {
                    stage.close();
                }
            });
            scene.getStylesheets().add(Notificacao.class.getResource(Variaveis.TEMA).toExternalForm());
            scene.setFill(Color.TRANSPARENT);
            stage.setX(rect.getMinX() + rect.getWidth() - 380.0D);
            stage.setY(rect.getMinY());

            PauseTransition pause = new PauseTransition(Duration.seconds((this.segundos < 1) ? 1.0D : this.segundos));
            pause.setOnFinished(e -> stage.close());

            stage.setAlwaysOnTop(true);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setScene(scene);
            stage.setResizable(false);
            if (this.segundos > 1) {
                pause.play();
            }
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
