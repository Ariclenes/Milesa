package com.signcorporation.milesa.model.BEAN;

import java.security.InvalidParameterException;
import java.util.Date;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author AEM Sign
 */
public class PessoaFisica {
	private IntegerProperty codPessoaFisica;
	private Date dataNascimento;
	private StringProperty NIF;
	private StringProperty BI;


	//Metodos atributo: codPessoaFisica
	public int getCodPessoaFisica() {
		return codPessoaFisica.get();
	}
	public void setCodPessoaFisica(int codPessoaFisica) {
            if (codPessoaFisica < 0) {
            throw new InvalidParameterException("Código inválido.");
        }
            this.codPessoaFisica = new SimpleIntegerProperty(codPessoaFisica);
	}
	public IntegerProperty CodPessoaFisicaProperty() {
		return codPessoaFisica;
	}
	//Metodos atributo: dataNascimento
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		 if (dataNascimento == null || dataNascimento.after(new Date())) {
            throw new InvalidParameterException("Data de nascimento inválida.");
        }
        this.dataNascimento = dataNascimento;
	}
	//Metodos atributo: NIF
	public String getNIF() {
		return NIF.get();
	}
	public void setNIF(String NIF) {
		this.NIF = new SimpleStringProperty(NIF);
	}
	public StringProperty NIFProperty() {
		return NIF;
	}
	//Metodos atributo: BI
	public String getBI() {
		return BI.get();
	}
	public void setBI(String BI) {
		this.BI = new SimpleStringProperty(BI);
	}
	public StringProperty BIProperty() {
		return BI;
	}
   

   



  

}
