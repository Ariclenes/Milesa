package com.signcorporation.milesa.model.BEAN;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author AEM Sign Angola
 */
public class ProdutoTipo {
private Status status;
	private IntegerProperty codTipo;
	private StringProperty tipo_produto;
	private DoubleProperty IPC;
	private DoubleProperty TAXA_IVA;
    @Override
	public String toString(){
		return tipo_produto.get();
                        
	}
	//Metodos atributo: status
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	//Metodos atributo: codTipo
	public int getCodTipo() {
		return codTipo.get();
	}
	public void setCodTipo(int codTipo) {
		this.codTipo = new SimpleIntegerProperty(codTipo);
	}
	public IntegerProperty CodTipoProperty() {
		return codTipo;
	}
	//Metodos atributo: tipo_produto
	public String getTipo_produto() {
		return tipo_produto.get();
	}
	public void setTipo_produto(String tipo_produto) {
		this.tipo_produto = new SimpleStringProperty(tipo_produto);
	}
	public StringProperty Tipo_produtoProperty() {
		return tipo_produto;
	}
	//Metodos atributo: IPC
	public Double getIPC() {
		return IPC.get();
	}
	public void setIPC(Double IPC) {
		this.IPC = new SimpleDoubleProperty(IPC);
	}
	public DoubleProperty IPCProperty() {
		return IPC;
	}
	//Metodos atributo: TAXA_IVA
	public Double getTAXA_IVA() {
		return TAXA_IVA.get();
	}
	public void setTAXA_IVA(Double TAXA_IVA) {
		this.TAXA_IVA = new SimpleDoubleProperty(TAXA_IVA);
	}
	public DoubleProperty TAXA_IVAProperty() {
		return TAXA_IVA;
	}
        

}
