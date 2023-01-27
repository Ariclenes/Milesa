package com.signcorporation.milesa.model.BEAN;

import java.security.InvalidParameterException;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author AEM SIGN
 */
public class Provincia  {
   
	private IntegerProperty codProvincia;
	private StringProperty nome;
	private StringProperty sigla;
        private Status status = Status.ATIVO;

	//Metodos atributo: codProvincia
	public int getCodProvincia() {
            return codProvincia.get ();
	}
	public void setCodProvincia(int codProvincia) {
             if (codProvincia < 0) {
            throw new InvalidParameterException("Código inválido.");
        }
            this.codProvincia = new SimpleIntegerProperty(codProvincia);
	}
	public IntegerProperty CodProvinciaProperty() {
		return codProvincia;
	}
	//Metodos atributo: nome
	public String getNome() {
		return nome.get();
	}
	public void setNome(String nome) {
              if (nome.trim().length() < 3 || nome.trim().length() > 200) {
                throw new InvalidParameterException("Nome inválido.");
        }
		this.nome = new SimpleStringProperty(nome.trim ());
	}
	public StringProperty NomeProperty() {
		return nome;
	}
	//Metodos atributo: sigla
	public String getSigla() {
		return sigla.get();
	}
	public void setSigla(String sigla) {
            if (sigla.trim().length() != 2) {
            throw new InvalidParameterException("Sigla inválida.");
        }
       
		this.sigla = new SimpleStringProperty(sigla.trim ().toUpperCase ());
	}
	public StringProperty SiglaProperty() {
		return sigla;
	}
	//Metodos atributo: status
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
        public void setStatus(String status) {
            this.status = Status.get(status);
        }
        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Provincia) {
                return ((Provincia) obj).getCodProvincia() == getCodProvincia();
            }
            return false;
        }
        @Override
        public String toString() {
        return getNome();
    }
 

}
