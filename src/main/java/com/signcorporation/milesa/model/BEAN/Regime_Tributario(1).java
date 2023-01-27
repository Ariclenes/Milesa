/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.signcorporation.milesa.model.BEAN;


import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Hacker PC
 */
public class Regime_Tributario {
        private IntegerProperty ID;
        private DoubleProperty TAXA;
        private DoubleProperty TAXA_RETORNO;
        private StringProperty CODIGO;
	private StringProperty MOTIVO;
	private StringProperty TEXTO;
        private Status status = Status.ATIVO;
        private boolean ALTERACAO_ANUAL;
//    Columns:
//ID int(11) AI PK 
//TAXA decimal(10,2) 
//TAXA_RETORNO decimal(10,2) 
//CODIGO varchar(45) 
//MOTIVO text 
//TEXTO varchar(45) 
//ALTERACAO_ANUAL tinyint(4)

    /**
     * @return the ID
     */
    public int getID () {
        return ID.get ();
    }

    /**
     * @param ID the ID to set
     */
    public void setID (int ID) {
        this.ID =new SimpleIntegerProperty (ID) ;
    }

    /**
     * @return the TAXA
     */
    public Double getTAXA () {
        return TAXA.get ();
    }

    /**
     * @param TAXA the TAXA to set
     */
    public void setTAXA (Double TAXA) {
        this.TAXA =new SimpleDoubleProperty (TAXA) ;
    }

    /**
     * @return the TAXA_RETORNO
     */
    public Double getTAXA_RETORNO () {
        return TAXA_RETORNO.get ();
    }

    /**
     * @param TAXA_RETORNO the TAXA_RETORNO to set
     */
    public void setTAXA_RETORNO (Double TAXA_RETORNO) {
        this.TAXA_RETORNO =new SimpleDoubleProperty (TAXA_RETORNO) ;
    }

    /**
     * @return the CODIFO
     */
    public String getCODIGO () {
        return CODIGO.get ();
    }

    /**
     * @param CODIGO the CODIFO to set
     */
    public void setCODIGO (String CODIGO) {
        this.CODIGO =new SimpleStringProperty (CODIGO) ;
    }

    /**
     * @return the MOTIVO
     */
    public String getMOTIVO () {
        return MOTIVO.get ();
    }

    /**
     * @param MOTIVO the MOTIVO to set
     */
    public void setMOTIVO (String MOTIVO) {
        this.MOTIVO =new SimpleStringProperty (MOTIVO) ;
    }

    /**
     * @return the TEXTO
     */
    public String getTEXTO () {
        return TEXTO.get ();
    }

    /**
     * @param TEXTO the TEXTO to set
     */
    public void setTEXTO (String TEXTO) {
        this.TEXTO =new SimpleStringProperty (TEXTO) ;
    }

    /**
     * @return the status
     */
    public Status getStatus () {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus (Status status) {
        this.status = status;
    }

    /**
     * @return the ALTERACAO_ANUAL
     */
    public boolean isALTERACAO_ANUAL () {
        return ALTERACAO_ANUAL;
    }

    /**
     * @param ALTERACAO_ANUAL the ALTERACAO_ANUAL to set
     */
    public void setALTERACAO_ANUAL (boolean ALTERACAO_ANUAL) {
        this.ALTERACAO_ANUAL = ALTERACAO_ANUAL;
    }
       @Override
    public boolean equals(Object obj) {
        if (obj instanceof Regime_Tributario) {
            return ((Regime_Tributario) obj).getID () == getID ();
        }
        return false;
    }
 

    @Override
    public String toString() {
        return getMOTIVO ();
    }
 
}
