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
 * @author AEM Sign Corporation <arymonster@gmail.com><+244 933 934 838>
 */
public class PlanoContaGrupo {
    	private IntegerProperty Codigo;
	private StringProperty Sigla;
	private StringProperty Descricao;
        private Status STATUS;

        //Metodo return:DADOS
         @Override
        public String toString() {
        return "("+getSigla()+")";
    }   
	//Metodos atributo: Codigo
	public int getCodigo() {
		return Codigo.get();
	}
	public void setCodigo(int Codigo) {
		this.Codigo = new SimpleIntegerProperty(Codigo);
	}
	public IntegerProperty CodigoProperty() {
		return Codigo;
	}
	//Metodos atributo: Sigla
	public String getSigla() {
		return Sigla.get();
	}
	public void setSigla(String Sigla) {
		this.Sigla = new SimpleStringProperty(Sigla);
	}
	public StringProperty SiglaProperty() {
		return Sigla;
	}
	//Metodos atributo: Descricao
	public String getDescricao() {
		return Descricao.get();
	}
	public void setDescricao(String Descricao) {
		this.Descricao = new SimpleStringProperty(Descricao);
	}
	public StringProperty DescricaoProperty() {
		return Descricao;
	}
        //Metodos atributo: STATUS
        public Status getSTATUS () {
            return STATUS;
        }
        public void setSTATUS (Status STATUS) {
        this.STATUS = STATUS;
    }
}
