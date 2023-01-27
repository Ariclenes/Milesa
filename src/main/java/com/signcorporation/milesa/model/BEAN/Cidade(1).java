package com.signcorporation.milesa.model.BEAN;

import java.security.InvalidParameterException;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author AEM SIGN ANGOLA
 */

public class Cidade {  
        private IntegerProperty codCidade;
	private StringProperty nome;
	private Provincia provincia;
	private Status status;

//	public Cidade(int codCidade, String nome, Provincia provincia,Status status) { 
//		this.codCidade = new SimpleIntegerProperty(codCidade);
//		this.nome = new SimpleStringProperty(nome);
//		this.provincia = provincia;
//		this.status = status;
//	}

	//Metodos atributo: codCidade
	public int getCodCidade() {
		return codCidade.get();
	}
	public void setCodCidade(int codCidade) {
              if (codCidade < 0) {
            throw new InvalidParameterException("Código inválido.");
        }
		this.codCidade = new SimpleIntegerProperty(codCidade);
	}
	public IntegerProperty CodCidadeProperty() {
		return codCidade;
	}
	//Metodos atributo: nome
	public String getNome() {
		return nome.get();
	}
	public void setNome(String nome) {
//             if (nome.trim().length() < 3 || nome.trim().length() > 200) {
//            throw new InvalidParameterException("Nome inválido.");
//        }
     
		this.nome = new SimpleStringProperty(nome.trim ());
	}
	public StringProperty NomeProperty() {
		return nome;
	}
	//Metodos atributo: provincia
	public Provincia getProvincia() {
            return provincia;
	}
	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
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
            if (obj instanceof Cidade) {
                return ((Cidade) obj).getCodCidade() == getCodCidade();
            }
            return false;
        }
        @Override
        public String toString() {
        return getNome();
    }


}
