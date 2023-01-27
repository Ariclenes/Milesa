
package com.signcorporation.milesa.model.BEAN;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Hacker PC
 */
public class Unidade_medida {
private Status status;
	private IntegerProperty codUnidade;
	private StringProperty NOME_UNIDADE;
	private StringProperty DESCRICAO;



	//Metodos atributo: status
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	//Metodos atributo: codUnidade
	public int getCodUnidade() {
		return codUnidade.get();
	}
	public void setCodUnidade(int codUnidade) {
		this.codUnidade = new SimpleIntegerProperty(codUnidade);
	}
	public IntegerProperty CodUnidadeProperty() {
		return codUnidade;
	}
	//Metodos atributo: NOME_UNIDADE
	public String getNOME_UNIDADE() {
		return NOME_UNIDADE.get();
	}
	public void setNOME_UNIDADE(String NOME_UNIDADE) {
		this.NOME_UNIDADE = new SimpleStringProperty(NOME_UNIDADE);
	}
	public StringProperty NOME_UNIDADEProperty() {
		return NOME_UNIDADE;
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
	@Override
	public String toString() {
		return NOME_UNIDADE.get ();
	}
	
}
