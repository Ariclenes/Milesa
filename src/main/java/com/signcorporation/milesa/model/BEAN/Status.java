package com.signcorporation.milesa.model.BEAN;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author Juliano
 */
public enum Status {

    ATIVO("A", "Ativo"),
    INATIVO("I", "Inativo");


    private StringProperty DESCRICAO;
    private StringProperty SIGLA;

    private Status(String SIGLA, String DESCRICAO) {
        this.SIGLA = new SimpleStringProperty(SIGLA);
        this.DESCRICAO = new SimpleStringProperty(DESCRICAO);
    }

    //Metodos atributo: DESCRICAO
    public String getDESCRICAO() {
        return DESCRICAO.get();
    }

    public void setDESCRICAO(String DESCRICAO) {
        this.DESCRICAO = new SimpleStringProperty(DESCRICAO);
    }

    public StringProperty DESCRICAOProperty() {
        return DESCRICAO;
    }

    //Metodos atributo: SIGLA
    public String getSIGLA() {
        return SIGLA.get();
    }

    public void setSIGLA(String SIGLA) {
        this.SIGLA = new SimpleStringProperty(SIGLA);
    }

    public StringProperty SIGLAProperty() {
        return SIGLA;
    }


    public static Status get(String obj) {
        for (Status status : Status.values()) {
            if (status.getSIGLA().equals(obj)) {
                return status;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return SIGLA.get();
    }

}
