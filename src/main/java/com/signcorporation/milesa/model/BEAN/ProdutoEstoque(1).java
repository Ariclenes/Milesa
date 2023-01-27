package com.signcorporation.milesa.model.BEAN;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class ProdutoEstoque {
        private IntegerProperty CODIGO;
	private Produto COD_PRODUTO;
	private IntegerProperty QTD;
	private DoubleProperty VALOR_UNITARIO;
        private Status status;

	 @Override
	public String toString(){
		return CODIGO.get() + " ("+QTD.get()+")";
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
	//Metodos atributo: COD_PRODUTO
	public Produto getCOD_PRODUTO() {
		return COD_PRODUTO;
	}
	public void setCOD_PRODUTO(Produto COD_PRODUTO) {
		this.COD_PRODUTO = COD_PRODUTO;
	}
	//Metodos atributo: QTD
	public int getQTD() {
		return QTD.get();
	}
	public void setQTD(int QTD) {
		this.QTD = new SimpleIntegerProperty(QTD);
	}
	public IntegerProperty QTDProperty() {
		return QTD;
	}
	//Metodos atributo: VALOR_UNITARIO
	public Double getVALOR_UNITARIO() {
		return VALOR_UNITARIO.get();
	}
	public void setVALOR_UNITARIO(Double VALOR_UNITARIO) {
		this.VALOR_UNITARIO = new SimpleDoubleProperty(VALOR_UNITARIO);
	}
	public DoubleProperty VALOR_UNITARIOProperty() {
		return VALOR_UNITARIO;
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
