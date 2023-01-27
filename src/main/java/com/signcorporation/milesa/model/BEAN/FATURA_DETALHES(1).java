package com.signcorporation.milesa.model.BEAN;

/**
 *
 * @author AEM SIGN 
 * 
 */
public class FATURA_DETALHES {
     
    private String NOME_ARTIGO, PRECO_VENDA, QTD, COD_BARRA, DESCONTO;

    
 
      public FATURA_DETALHES(String COD_BARRA, String NOME_ARTIGO, String PRECO_VENDA, String QTD){
         this.COD_BARRA = COD_BARRA;
         this.NOME_ARTIGO = NOME_ARTIGO;
         this.PRECO_VENDA = PRECO_VENDA;
         this.QTD = QTD;
//         this.DESCONTO = DESCONTO;
       }
    
    
    /**
     * @return the NOME_ARTIGO
     */
    public String getNOME_ARTIGO() {
        return NOME_ARTIGO;
    }

    /**
     * @param NOME_ARTIGO the NOME_ARTIGO to set
     */
    public void setNOME_ARTIGO(String NOME_ARTIGO) {
        this.NOME_ARTIGO = NOME_ARTIGO;
    }

    /**
     * @return the PRECO_VENDA
     */
    public String getPRECO_VENDA() {
        return PRECO_VENDA;
    }

    /**
     * @param PRECO_VENDA the PRECO_VENDA to set
     */
    public void setPRECO_VENDA(String PRECO_VENDA) {
        this.PRECO_VENDA = PRECO_VENDA;
    }

    /**
     * @return the QTD
     */
    public String getQTD() {
        return QTD;
    }

    /**
     * @param QTD the QTD to set
     */
    public void setQTD(String QTD) {
        this.QTD = QTD;
    }

    /**
     * @return the COD_BARRA
     */
    public String getCOD_BARRA() {
        return COD_BARRA;
    }

    /**
     * @param COD_BARRA the COD_BARRA to set
     */
    public void setCOD_BARRA(String COD_BARRA) {
        this.COD_BARRA = COD_BARRA;
    }

    /**
     * @return the DESCONTO
     */
    public String getDESCONTO() {
        return DESCONTO;
    }

    /**
     * @param DESCONTO the DESCONTO to set
     */
    public void setDESCONTO(String DESCONTO) {
        this.DESCONTO = DESCONTO;
    }

    
}
