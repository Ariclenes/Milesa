package com.signcorporation.milesa.model.UTILS;

import java.io.IOException;

import javafx.fxml.FXMLLoader;

public class TelaController {

    public static enum ECRA {
        SPLASH,
        LOGIN,
        CONFIG,
        CONFIG_SISTEMA,
        GERAL,
        MENU,//
        DASHBOARD,
        PRINCIPAL,
        ADMINISTRATIVO,
        TABELAS,
        COMPRAS, VENDAS,
        TESORARIA, CONTABLIDADE,
        CLIENTES, FORNECEDORES, FUNCIONARIOS,
        PROJECTOS,
        MEUS_PROJECTOS,
        EQUIPE_PROJECTOS,
        RECURSOS_HUMANOS,
        M_HOTELEIRO,
        BANCOS,
        TIPO_PRODUTOS,
        PRODUTOS,
        GRUPO, SUB_GRUPOS, CATEGORIA,
        ACERCA,
    }

    public TelaController() {
    }

    public static void setTela(ECRA screen) throws IOException {
        switch (screen) {
            case SPLASH:
                StageManager.setRoot(FXMLLoader.load(TelaController.class.getResource("/VIEW/Splash.fxml")));
                Compartilhado.screen = ECRA.SPLASH;
                break;
            case LOGIN:
                StageManager.setRoot(FXMLLoader.load(TelaController.class.getResource("/VIEW/Login.fxml")));
                Compartilhado.screen = ECRA.LOGIN;
                break;
            case MENU:
                StageManager.setRoot(FXMLLoader.load(TelaController.class.getResource("/VIEW/Menu.fxml")));
                Compartilhado.screen = ECRA.MENU;
                break;
            case PRINCIPAL:
                StageManager.setPaneFragment(FXMLLoader.load(TelaController.class.getResource("/VIEW/DashBoard.fxml")));
                Compartilhado.screen = ECRA.PRINCIPAL;
                break;
            case MEUS_PROJECTOS:
                StageManager.setPaneFragment(FXMLLoader.load(TelaController.class.getResource("/VIEW/RelatorioView.fxml")));
                Compartilhado.screen = ECRA.MEUS_PROJECTOS;
                break;
            case EQUIPE_PROJECTOS:
                StageManager.setPaneFragment(FXMLLoader.load(TelaController.class.getResource("/VIEW/ConfigDB.fxml")));
                Compartilhado.screen = ECRA.EQUIPE_PROJECTOS;
                break;
            case ADMINISTRATIVO:
                StageManager.setPaneFragment(FXMLLoader.load(TelaController.class.getResource("/VIEW/Pessoa.fxml")));
                Compartilhado.screen = ECRA.ADMINISTRATIVO;
                break;
            case ACERCA:
                StageManager.setPaneFragment(FXMLLoader.load(TelaController.class.getResource("/VIEW/Acerca.fxml")));
                Compartilhado.screen = ECRA.ACERCA;
                break;
            case CLIENTES:
                StageManager.setRoot(FXMLLoader.load(TelaController.class.getResource("/VIEW/Pessoa.fxml")));
                Compartilhado.screen = ECRA.CLIENTES;
                break;
            case FORNECEDORES:
                StageManager.setRoot(FXMLLoader.load(TelaController.class.getResource("/VIEW/Pessoa.fxml")));
                Compartilhado.screen = ECRA.FORNECEDORES;
                break;
            case FUNCIONARIOS:
                StageManager.setRoot(FXMLLoader.load(TelaController.class.getResource("/VIEW/Pessoa.fxml")));
                Compartilhado.screen = ECRA.FUNCIONARIOS;
                break;
            case COMPRAS:
                StageManager.setRoot(FXMLLoader.load(TelaController.class.getResource("/VIEW/Compras.fxml")));
                Compartilhado.screen = ECRA.COMPRAS;
                break;
            case VENDAS:
                StageManager.setRoot(FXMLLoader.load(TelaController.class.getResource("/VIEW/Vendas.fxml")));
                Compartilhado.screen = ECRA.VENDAS;
                break;
            case CONFIG:
                StageManager.setPaneFragment(FXMLLoader.load(TelaController.class.getResource("/VIEW/ConfigDB.fxml")));
                Compartilhado.screen = ECRA.CONFIG;

            default:
                break;
        }
    }

}
