package com.signcorporation.milesa.model.BEAN;

import java.math.BigDecimal;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @author Hacker PC
 */
public class FATURA {
    private int CODIGO_FATURA;

    private String TEMPO, DATA, PRECO;
    private boolean STATUS, NEGOCIO, ANULADO;

    private int id_pedido_venda;
    private Funcionario funcionario;
    private Cliente cliente;
    private Fluxo_caixa2 fluxoCaixa;
    private BigDecimal total_pagar;
    private BigDecimal desconto;
    private String forma_pagamento;
    private ObservableList<FATURA_DETALHES> fatura_detalhes = FXCollections.observableArrayList();
//     public FATURA (int CODIGO, String FUNCIONARIO_NOME, String CLIENTE_NOME, boolean NEGOCIO, boolean STATUS, String DATA, String PRECO) {
//        this.STATUS = STATUS;
//        this.CODIGO = CODIGO;
//        this.FUNCIONARIO_NOME = FUNCIONARIO_NOME;
//        this.CLIENTE_NOME = CLIENTE_NOME;
//        this.NEGOCIO = NEGOCIO;
//        this.DATA = DATA;
//        this.PRECO = PRECO;
//    }
//
//    public FATURA (int CODIGO, String FUNCIONARIO_NOME, String CLIENTE_NOME, boolean NEGOCIO, boolean STATUS, String DATA, String PRECO, boolean ANULADO) {
//        this.STATUS = STATUS;
//        this.CODIGO = CODIGO;
//        this.FUNCIONARIO_NOME = FUNCIONARIO_NOME;
//        this.CLIENTE_NOME = CLIENTE_NOME;
//        this.NEGOCIO = NEGOCIO;
//        this.DATA = DATA;
//        this.PRECO = PRECO;
//        this.ANULADO = ANULADO;
//    }

    /**
     * @return the CODIGO
     */
    public int getCODIGO() {
        return CODIGO_FATURA;
    }

    /**
     * @param CODIGO the CODIGO to set
     */
    public void setCODIGO(int CODIGO) {
        this.CODIGO_FATURA = CODIGO;
    }


    /**
     * @return the TEMPO
     */
    public String getTEMPO() {
        return TEMPO;
    }

    /**
     * @param TEMPO the TEMPO to set
     */
    public void setTEMPO(String TEMPO) {
        this.TEMPO = TEMPO;
    }

    /**
     * @return the DATA
     */
    public String getDATA() {
        return DATA;
    }

    /**
     * @param DATA the DATA to set
     */
    public void setDATA(String DATA) {
        this.DATA = DATA;
    }

    /**
     * @return the PRECO
     */
    public String getPRECO() {
        return PRECO;
    }

    /**
     * @param PRECO the PRECO to set
     */
    public void setPRECO(String PRECO) {
        this.PRECO = PRECO;
    }

    /**
     * @return the STATUS
     */
    public boolean isSTATUS() {
        return STATUS;
    }

    /**
     * @param STATUS the STATUS to set
     */
    public void setSTATUS(boolean STATUS) {
        this.STATUS = STATUS;
    }

    /**
     * @return the NEGOCIO
     */
    public boolean isNEGOCIO() {
        return NEGOCIO;
    }

    /**
     * @param NEGOCIO the NEGOCIO to set
     */
    public void setNEGOCIO(boolean NEGOCIO) {
        this.NEGOCIO = NEGOCIO;
    }

    /**
     * @return the ANULADO
     */
    public boolean isANULADO() {
        return ANULADO;
    }

    /**
     * @param ANULADO the ANULADO to set
     */
    public void setANULADO(boolean ANULADO) {
        this.ANULADO = ANULADO;
    }
}



