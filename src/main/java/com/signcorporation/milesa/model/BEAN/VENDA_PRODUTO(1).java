package com.signcorporation.milesa.model.BEAN;

import javafx.scene.control.TextField;

/**
 *
 * @author Hacker PC
 */
public class VENDA_PRODUTO {
    
    private String  NOME, PRECO, UNIDADE, DESCONTO, PRECO_DO_LOTE ;
    private int CODIGO, VENDA;
    private TextField QUANTIDADE = new TextField("1"), PRECO_V = new TextField("");
    
    

    public VENDA_PRODUTO (int CODIGO, String NOME, String PRECO, String UNIDADE) {
        this.NOME = NOME;
        this.CODIGO = CODIGO;
        this.PRECO = PRECO;
        this.UNIDADE = UNIDADE;
      
    }

   

    public String getNOME() {
        return NOME;
    }

    public void setNOME(String NOME) {
        this.NOME = NOME;
    }

    public String getPRECO() {
        return PRECO;
    }

    public void setPRECO(String PRECO) {
        this.PRECO = PRECO;
    }

    public String getUNIDADE() {
        return UNIDADE;
    }

    public void setUNIDADE(String UNIDADE) {
        this.UNIDADE = UNIDADE;
    }

    public String getDESCONTO() {
        return DESCONTO;
    }

    public void setDESCONTO(String DESCONTO) {
        this.DESCONTO = DESCONTO;
    }

    public String getPRECO_DO_LOTE() {
        return PRECO_DO_LOTE;
    }

    public void setPRECO_DO_LOTE(String PRECO_DO_LOTE) {
        this.PRECO_DO_LOTE = PRECO_DO_LOTE;
    }

    public int getCODIGO() {
        return CODIGO;
    }

    public void setCODIGO(int CODIGO) {
        this.CODIGO = CODIGO;
    }

    public int getVENDA() {
        return VENDA;
    }

    public void setVENDA(int VENDA) {
        this.VENDA = VENDA;
    }

    public TextField getQUANTIDADE() {
        return QUANTIDADE;
    }

    public void setQUANTIDADE(TextField QUANTIDADE) {
        this.QUANTIDADE = QUANTIDADE;
    }

    public TextField getPRECO_V() {
        return PRECO_V;
    }

    public void setPRECO_V(TextField PRECO_V) {
        this.PRECO_V = PRECO_V;
    }

    
}
