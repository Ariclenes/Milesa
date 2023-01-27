/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.signcorporation.milesa.model.DAO;

import MODELO.BEAN.Status;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Hacker PC
 */
public class Paises {
        
	private IntegerProperty codPais;
	private StringProperty Nome_Pais;
        private StringProperty SIGLA;
        private Status status;
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
	//Metodos atributo: codPais
	public int getCodPais() {
		return codPais.get();
	}
	public void setCodPais(int codPais) {
		this.codPais = new SimpleIntegerProperty(codPais);
	}
	public IntegerProperty CodPaisProperty() {
		return codPais;
	}
	//Metodos atributo: Nome_Pais
	public String getNome_Pais() {
		return Nome_Pais.get();
	}
	public void setNome_Pais(String Nome_Pais) {
		this.Nome_Pais = new SimpleStringProperty(Nome_Pais);
	}
	public StringProperty Nome_PaisProperty() {
		return Nome_Pais;
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
}
