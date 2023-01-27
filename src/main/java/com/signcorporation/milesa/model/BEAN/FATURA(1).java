
package com.signcorporation.milesa.model.BEAN;

/**
 *
 * @author Hacker PC
 */
public class FATURA {
   private int CODIGO;
    private String FUNCIONARIO_NOME, CLIENTE_NOME, TEMPO, DATA, PRECO;
    private boolean STATUS, NEGOCIO, ANULADO;
    
    
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
        return CODIGO;
    }

    /**
     * @param CODIGO the CODIGO to set
     */
    public void setCODIGO(int CODIGO) {
        this.CODIGO = CODIGO;
    }

    /**
     * @return the FUNCIONARIO_NOME
     */
    public String getFUNCIONARIO_NOME() {
        return FUNCIONARIO_NOME;
    }

    /**
     * @param FUNCIONARIO_NOME the FUNCIONARIO_NOME to set
     */
    public void setFUNCIONARIO_NOME(String FUNCIONARIO_NOME) {
        this.FUNCIONARIO_NOME = FUNCIONARIO_NOME;
    }

    /**
     * @return the CLIENTE_NOME
     */
    public String getCLIENTE_NOME() {
        return CLIENTE_NOME;
    }

    /**
     * @param CLIENTE_NOME the CLIENTE_NOME to set
     */
    public void setCLIENTE_NOME(String CLIENTE_NOME) {
        this.CLIENTE_NOME = CLIENTE_NOME;
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
