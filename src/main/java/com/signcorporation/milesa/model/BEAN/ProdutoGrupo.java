package com.signcorporation.milesa.model.BEAN;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author AEM Sign Angola
 */
public class ProdutoGrupo {


    private IntegerProperty codGrupo;
    private StringProperty NOME_GRUPO;
    private Status status = Status.ATIVO;

    @Override
    public String toString() {
        return NOME_GRUPO.get();

    }


    //Metodos atributo: codGrupo
    public int getCodGrupo() {
        return codGrupo.get();
    }

    public void setCodGrupo(int codGrupo) {
        this.codGrupo = new SimpleIntegerProperty(codGrupo);
    }

    public IntegerProperty CodGrupoProperty() {
        return codGrupo;
    }

    //Metodos atributo: NOME_GRUPO
    public String getNOME_GRUPO() {
        return NOME_GRUPO.get();
    }

    public void setNOME_GRUPO(String NOME_GRUPO) {
        this.NOME_GRUPO = new SimpleStringProperty(NOME_GRUPO);
    }

    public StringProperty NOME_GRUPOProperty() {
        return NOME_GRUPO;
    }

    //Metodos atributo: Status
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status Status) {
        this.status = Status;
    }

}
