/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.signcorporation.milesa.model.UTILS;

import javafx.scene.paint.Color;
import javafx.util.Duration;
import javax.print.event.PrintJobAdapter;
import javax.print.event.PrintJobEvent;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 *
 * @author Hacker PC
 */
public class MonitorizaTrabalho extends PrintJobAdapter {
    
    public void impressaoTrabalhoCompleta (PrintJobEvent evento) {
        TrayNotification ntf = new TrayNotification ();
        ntf.setNotificationType (NotificationType.SUCCESS);
        ntf.setMessage ("Fatura criada com sucesso!");
        ntf.setAnimationType (AnimationType.FADE);
        ntf.showAndDismiss (Duration.millis (1500.0D));
        ntf.setRectangleFill (Color.valueOf ("green"));
        //           ntf.setImage(new Image("VIEW/IMG/guest.png"));
        ntf.showAndWait ();
        //            Notificacao notifica = new Notificacao("Fatura Imprensa com sucesso!");
        //            notifica.setTipo(NotificacaoTipo.SUCESSO);
        //            notifica.setBotao(BotaoTipo.NAO_BTN);
    }

    public void impressaoTrabalhoFalha (PrintJobEvent eveto) {
        TrayNotification ntf = new TrayNotification ();
        ntf.setNotificationType (NotificationType.ERROR);
        ntf.setMessage ("Falha na Imprensão da factura!");
        ntf.setAnimationType (AnimationType.FADE);
        ntf.showAndDismiss (Duration.millis (1500.0D));
        ntf.setRectangleFill (Color.valueOf ("orange"));
        //           ntf.setImage(new Image("VIEW/IMG/guest.png"));
        ntf.showAndWait ();
        //            Notificacao notifica = new Notificacao("Falha na Imprensão da factura!");
        //            notifica.setTipo(NotificacaoTipo.ERRO);
        //            notifica.setBotao(BotaoTipo.NAO_BTN);
    }
    
}
