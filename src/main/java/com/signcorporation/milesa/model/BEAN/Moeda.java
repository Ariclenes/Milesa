/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.signcorporation.milesa.model.BEAN;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author Hacker PC
 */
public class Moeda {
    private IntegerProperty cod_moeda;
    private StringProperty moeda, singular, plural, simbolo;

    /**
     * @return the simbolo
     */
    public String getSimbolo() {
        return simbolo.get();
    }

    /**
     * @param simbolo the simbolo to set
     */
    public void setSimbolo(String simbolo) {
        this.simbolo = new SimpleStringProperty(simbolo);
    }

    /**
     * @return the cod_moeda
     */
    public int getCod_moeda() {
        return cod_moeda.get();
    }

    /**
     * @param cod_moeda the cod_moeda to set
     */
    public void setCod_moeda(int cod_moeda) {
        this.cod_moeda = new SimpleIntegerProperty(cod_moeda);
    }

    /**
     * @return the moeda
     */
    public String getMoeda() {
        return moeda.get();
    }

    /**
     * @param moeda the moeda to set
     */
    public void setMoeda(String moeda) {
        this.moeda = new SimpleStringProperty(moeda);
    }

    /**
     * @return the singular
     */
    public String getSingular() {
        return singular.get();
    }

    /**
     * @param singular the singular to set
     */
    public void setSingular(String singular) {
        this.singular = new SimpleStringProperty(singular);
    }

    /**
     * @return the plural
     */
    public String getPlural() {
        return plural.get();
    }

    /**
     * @param plural the plural to set
     */
    public void setPlural(String plural) {
        this.plural = new SimpleStringProperty(plural);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Moeda) {
            return ((Moeda) obj).getCod_moeda() == getCod_moeda();
        }
        return false;
    }

    @Override
    public String toString() {
        return getMoeda();
    }
}
