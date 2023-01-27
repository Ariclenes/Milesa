/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.signcorporation.milesa.model.BEAN;

import java.util.Date;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author Hacker PC
 */
public class Armazem {
    private IntegerProperty codArmazem;
    private Cidade cidade;
    private EmpresaM empresa;
    private Regime_Tributario regime_tributario;
    //    private Pais pais;
    private StringProperty nome_armazem, descricao_armazem, nif, email, telefone, fax, site, responsavel, morada, bairro, cod_postal, inss, logo_marca;
    private Date dataRegistro;
    private boolean permitir_exclir;
    private Status status = Status.ATIVO;
    private Moeda moeda;

    /**
     * @return the codEmpresa
     */
    public int getCodArmazem() {
        return codArmazem.get();
    }

    /**
     * @param codArmazem the codEmpresa to set
     */
    public void setCodArmazem(int codArmazem) {
        this.codArmazem = new SimpleIntegerProperty(codArmazem);
    }

    /**
     * @return the cidade
     */
    public Cidade getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the regime_tributario
     */
    public Regime_Tributario getRegime_tributario() {
        return regime_tributario;
    }

    /**
     * @param regime_tributario the regime_tributario to set
     */
    public void setRegime_tributario(Regime_Tributario regime_tributario) {
        this.regime_tributario = regime_tributario;
    }

    /**
     * @return the nome_empresa
     */
    public String getNome_Armazem() {
        return nome_armazem.get();
    }

    /**
     * @param nome_armazem the nome_empresa to set
     */
    public void setNome_Armazem(String nome_armazem) {
        this.nome_armazem = new SimpleStringProperty(nome_armazem);
    }

    /**
     * @return the nif
     */
    public String getNif() {
        return nif.get();
    }

    /**
     * @param nif the nif to set
     */
    public void setNif(String nif) {
        this.nif = new SimpleStringProperty(nif);
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email.get();
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = new SimpleStringProperty(email);
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone.get();
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = new SimpleStringProperty(telefone);
    }

    /**
     * @return the fax
     */
    public String getFax() {
        return fax.get();
    }

    /**
     * @param fax the fax to set
     */
    public void setFax(String fax) {
        this.fax = new SimpleStringProperty(fax);
    }

    /**
     * @return the site
     */
    public String getSite() {
        return site.get();
    }

    /**
     * @param site the site to set
     */
    public void setSite(String site) {
        this.site = new SimpleStringProperty(site);
    }

    /**
     * @return the responsavel
     */
    public String getResponsavel() {
        return responsavel.get();
    }

    /**
     * @param responsavel the responsavel to set
     */
    public void setResponsavel(String responsavel) {
        this.responsavel = new SimpleStringProperty(responsavel);
    }

    /**
     * @return the morada
     */
    public String getMorada() {
        return morada.get();
    }

    /**
     * @param morada the morada to set
     */
    public void setMorada(String morada) {
        this.morada = new SimpleStringProperty(morada);
    }

    /**
     * @return the bairro
     */
    public StringProperty getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = new SimpleStringProperty(bairro);
    }

    /**
     * @return the cod_postal
     */
    public String getCod_postal() {
        return cod_postal.get();
    }

    /**
     * @param cod_postal the cod_postal to set
     */
    public void setCod_postal(String cod_postal) {
        this.cod_postal = new SimpleStringProperty(cod_postal);
    }

    /**
     * @return the inss
     */
    public String getInss() {
        return inss.get();
    }

    /**
     * @param inss the inss to set
     */
    public void setInss(String inss) {
        this.inss = new SimpleStringProperty(inss);
    }

    /**
     * @return the logo_marca
     */
    public String getLogo_marca() {
        return logo_marca.get();
    }

    /**
     * @param logo_marca the logo_marca to set
     */
    public void setLogo_marca(String logo_marca) {
        this.logo_marca = new SimpleStringProperty(logo_marca);
    }

    /**
     * @return the dataRegistro
     */
    public Date getDataRegistro() {
        return dataRegistro;
    }

    /**
     * @param dataRegistro the dataRegistro to set
     */
    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    /**
     * @return the status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * @return the permitir_exclir
     */
    public boolean isPermitir_exclir() {
        return permitir_exclir;
    }

    /**
     * @param permitir_exclir the permitir_exclir to set
     */
    public void setPermitir_exclir(boolean permitir_exclir) {
        this.permitir_exclir = permitir_exclir;
    }

    /**
     * @return the descricao_empresa
     */
    public String getDescricao_Armazem() {
        return descricao_armazem.get();
    }

    /**
     * @param descricao_Armazem the descricao_empresa to set
     */
    public void setDescricao_Armazem(String descricao_Armazem) {
        this.descricao_armazem = new SimpleStringProperty(descricao_Armazem);
    }

    /**
     * @return the empresa
     */
    public EmpresaM getEmpresa() {
        return empresa;
    }

    /**
     * @param empresa the empresa to set
     */
    public void setEmpresa(EmpresaM empresa) {
        this.empresa = empresa;
    }

    /**
     * @return the moeda
     */
    public Moeda getMoeda() {
        return moeda;
    }

    /**
     * @param moeda the moeda to set
     */
    public void setMoeda(Moeda moeda) {
        this.moeda = moeda;
    }
}
