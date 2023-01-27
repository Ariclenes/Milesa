package com.signcorporation.milesa.model.BEAN;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author AEM Sign Angola
 */
public class ProdutoSubGrupo {
	private Status Status;
	private IntegerProperty codSubGrupo;
	private StringProperty NOME_SUB_GRUPO;
	private ProdutoGrupo grupo;


	//Metodos atributo: Status
	public Status getStatus() {
		return Status;
	}
	public void setStatus(Status Status) {
		this.Status = Status;
	}
	//Metodos atributo: codSubGrupo
	public int getCodSubGrupo() {
		return codSubGrupo.get();
	}
	public void setCodSubGrupo(int codSubGrupo) {
		this.codSubGrupo = new SimpleIntegerProperty(codSubGrupo);
	}
	public IntegerProperty CodSubGrupoProperty() {
		return codSubGrupo;
	}
	//Metodos atributo: NOME_SUB_GRUPO
	public String getNOME_SUB_GRUPO() {
		return NOME_SUB_GRUPO.get();
	}
	public void setNOME_SUB_GRUPO(String NOME_SUB_GRUPO) {
		this.NOME_SUB_GRUPO = new SimpleStringProperty(NOME_SUB_GRUPO);
	}
	public StringProperty NOME_SUB_GRUPOProperty() {
		return NOME_SUB_GRUPO;
	}
	//Metodos atributo: Subgrupo
	public ProdutoGrupo getGrupo() {
		return grupo;
	}
	public void setGrupo(ProdutoGrupo grupo) {
		this.grupo = grupo;
	}


      @Override
    public String toString() {
        return NOME_SUB_GRUPO.get () ;
    }  
    


}
