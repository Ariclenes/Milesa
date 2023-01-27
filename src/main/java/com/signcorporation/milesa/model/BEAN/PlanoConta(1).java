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
 *
 * @author Hacker PC
 */
public class PlanoConta {
        private IntegerProperty CODIGO;
	private StringProperty NOME_CONTA;
	private StringProperty COD_CONTA;
	private StringProperty TIPO_CONTA;
        private StringProperty NATUREZA_CONTA;
        private PlanoContaGrupo grupoConta;
        private Status STATUS;

        //Metodo return:DADOS
         @Override
    public String toString() {
        return getCOD_CONTA ()+"-"+ getNOME_CONTA ()+"";
    }
        //Metodos atributo: CODIGO
	public int getCODIGO() {
		return CODIGO.get();
	}
	public void setCODIGO(int CODIGO) {
		this.CODIGO = new SimpleIntegerProperty(CODIGO);
	}
	public IntegerProperty CODIGOProperty() {
		return CODIGO;
	}
	//Metodos atributo: NOME_CONTA
	public String getNOME_CONTA() {
		return NOME_CONTA.get();
	}
	public void setNOME_CONTA(String NOME_CONTA) {
		this.NOME_CONTA = new SimpleStringProperty(NOME_CONTA);
	}
	public StringProperty NOME_CONTAProperty() {
		return NOME_CONTA;
	}
	//Metodos atributo: COD_CONTA
	public String getCOD_CONTA() {
		return COD_CONTA.get();
	}
	public void setCOD_CONTA(String COD_CONTA) {
		this.COD_CONTA = new SimpleStringProperty(COD_CONTA);
	}
	public StringProperty COD_CONTAProperty() {
		return COD_CONTA;
	}
	//Metodos atributo: TIPO_CONTA
	public String getTIPO_CONTA() {
		return TIPO_CONTA.get();
	}
	public void setTIPO_CONTA(String TIPO_CONTA) {
		this.TIPO_CONTA = new SimpleStringProperty(TIPO_CONTA);
	}
	public StringProperty TIPO_CONTAProperty() {
		return TIPO_CONTA;
	}

    /**
     * @return the NATUREZA_CONTA
     */
    public String getNATUREZA_CONTA () {
        return NATUREZA_CONTA.get ();
    }

    /**
     * @param NATUREZA_CONTA the NATUREZA_CONTA to set
     */
    public void setNATUREZA_CONTA (String NATUREZA_CONTA) {
        this.NATUREZA_CONTA =new SimpleStringProperty( NATUREZA_CONTA);
    }

    /**
     * @return the STATUS
     */
    public Status getSTATUS () {
        return STATUS;
    }

    /**
     * @param STATUS the STATUS to set
     */
    public void setSTATUS (Status STATUS) {
        this.STATUS = STATUS;
    }

    /**
     * @return the grupoConta
     */
    public PlanoContaGrupo getGrupoConta () {
        return grupoConta;
    }

    /**
     * @param grupoConta the grupoConta to set
     */
    public void setGrupoConta (PlanoContaGrupo grupoConta) {
        this.grupoConta = grupoConta;
    }
}
