/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.signcorporation.milesa.model.UTILS;

/**
 * @author AEM Sign corp
 */
public class Sessao {

    private boolean logged;
    private String userLogged;

    public Sessao() {
    }

    public Sessao(boolean logged, String userLogged) {
        this.logged = logged;
        this.userLogged = userLogged;
    }

    public String getUserLogged() {
        return userLogged;
    }

    public void setUserLogged(String userLogged) {
        this.userLogged = userLogged;
    }

    public boolean isLogged() {
        return logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }

    @Override
    public String toString() {
        return "Section[logged = " + logged + ", userLogged = " + userLogged + "]";
    }
}




