package com.signcorporation.milesa.model.BEAN;

import java.security.InvalidParameterException;
import java.util.Date;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Funcionario extends Pessoa {
        private Date dataAdmissao;
	private Date dataDemissao;
//	private Departamento departamento;
	private StringProperty USR;
	private StringProperty PW;
	private Status status;
	private DoubleProperty Salario_Base;

//	public Funcionario(Date dataAdmissao, Date dataDemissao, Departamento departamento, 
//String USR, String PW, Status status, 
//Double Salario_Base) { 
//		this.dataAdmissao = dataAdmissao;
//		this.dataDemissao = dataDemissao;
//		this.departamento = departamento;
//		this.USR = new SimpleStringProperty(USR);
//		this.PW = new SimpleStringProperty(PW);
//		this.status = status;
//		this.Salario_Base = new SimpleDoubleProperty(Salario_Base);
//	}

	//Metodos atributo: dataAdmissao
	public Date getDataAdmissao() {
		return dataAdmissao;
	}
	public void setDataAdmissao(Date dataAdmissao) {
             if (dataAdmissao == null) {
            throw new InvalidParameterException("Data de admissão inválida.");
        }
		this.dataAdmissao = dataAdmissao;
	}
	//Metodos atributo: dataDemissao
	public Date getDataDemissao() {
		return dataDemissao;
	}
	public void setDataDemissao(Date dataDemissao) {
		this.dataDemissao = dataDemissao;
	}
	//Metodos atributo: departamento
//	public Departamento getDepartamento() {
//		return departamento;
//	}
//	public void setDepartamento(Departamento departamento) {
//		this.departamento = departamento;
//	}
	//Metodos atributo: USR
	public String getUSR() {
		return USR.get();
	}
	public void setUSR(String USR) {
		this.USR = new SimpleStringProperty(USR);
	}
	public StringProperty USRProperty() {
		return USR;
	}
	//Metodos atributo: PW
	public String getPW() {
		return PW.get();
	}
	public void setPW(String PW) {
		this.PW = new SimpleStringProperty(PW);
	}
	public StringProperty PWProperty() {
		return PW;
	}
	//Metodos atributo: status
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	//Metodos atributo: Salario_Base
	public Double getSalario_Base() {
		return Salario_Base.get();
	}
	public void setSalario_Base(Double Salario_Base) {
		this.Salario_Base = new SimpleDoubleProperty(Salario_Base);
	}
	public DoubleProperty Salario_BaseProperty() {
		return Salario_Base;
	}

}
