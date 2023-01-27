package com.signcorporation.milesa.model.BEAN;

import java.security.InvalidParameterException;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Juliano
 */
public class PessoaJuridica {

   private StringProperty NIF;
	private IntegerProperty codPessoaJuridica;
	private StringProperty ie;
	private StringProperty razaoSocial;
        //Metodos atributo: codPessoaJuridica
	public int getCodPessoaJuridica() {
		return codPessoaJuridica.get();
	}
	public void setCodPessoaJuridica(int codPessoaJuridica) {
              if (codPessoaJuridica < 0) {
            throw new InvalidParameterException("Código inválido.");
        }
	this.codPessoaJuridica = new SimpleIntegerProperty(codPessoaJuridica);
	}
	public IntegerProperty CodPessoaJuridicaProperty() {
		return codPessoaJuridica;
	}
	//Metodos atributo: NIF
	public String getNIF_EMPRESA() {
		return NIF.get();
	}
	public void setNIF(String NIF) {
            if (NIF.trim().length() != 18) {
            throw new InvalidParameterException("Nº contribuinte empresa inválido.");
        }
		this.NIF = new SimpleStringProperty(NIF);
	}
	public StringProperty NIFProperty() {
		return NIF;
	}	
	//Metodos atributo: Incrição do Estado
	public String getIe() {
		return ie.get();
	}
	public void setIe(String ie) {
		this.ie = new SimpleStringProperty(ie);
	}
	public StringProperty IeProperty() {
		return ie;
	}
	//Metodos atributo: razaoSocial tipo de empresa se é comercio geral ou outro
	public String getRazaoSocial() {
		return razaoSocial.get();
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = new SimpleStringProperty(razaoSocial);
	}
	public StringProperty RazaoSocialProperty() {
		return razaoSocial;
	}
}
