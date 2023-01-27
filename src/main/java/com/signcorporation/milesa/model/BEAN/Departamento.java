package com.signcorporation.milesa.model.BEAN;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author AEM Sign corp
 */
public class Departamento {

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo.get();
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = new SimpleIntegerProperty(codigo);
    }

    /**
     * @return the departamento
     */
    public String getDepartamento() {
        return departamento.get();
    }

    /**
     * @param departamento the departamento to set
     */
    public void setDepartamento(String departamento) {
        this.departamento = new SimpleStringProperty(departamento);
    }

    /**
     * @return the status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    private IntegerProperty codigo;
    private StringProperty departamento;
    private Status status;

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Departamento) {
            return ((Departamento) obj).getCodigo() == getCodigo();
        }
        return false;
    }

    @Override
    public String toString() {
        return getDepartamento();
    }
}
