package com.signcorporation.milesa.model.BEAN;

import BD.ConexaoBD;
import java.sql.Connection;
import java.text.NumberFormat;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


/**
 *
 * @author AEM Sign Angola
 */


public class Produto {
     ConexaoBD con = new ConexaoBD();
     Connection conexao = con.getInstance().getConnection();
	private IntegerProperty CODPRODUTO;
	private StringProperty NOME_ARTIGO,CODBARRA,FOTO_ARTIGO,ESTOQUE_MINIMO,ESTOQUE_MAXIMO;
	private DoubleProperty PRECO_COMPRA,PRECO_VENDA;
	private ProdutoCategoria PRODUTO_CATEGORIA;
	private ProdutoTipo PRODUTO_TIPO;
	private ProdutoGrupo PRODUTO_GRUPO;
	private ProdutoSubGrupo PRODUTO_SUB_GRUPO;
	private Unidade_medida UNIDADE_MEDIDA;
        private Status STATUS;
        private ProdutoEstoque PRODUTO_ESTOQUE;
        private boolean CONTROLA_ESTOQUE;
        
	//Metodos atributo: CODPRODUTO
	public int getCODPRODUTO() {
		return CODPRODUTO.get();
	}
	public void setCODPRODUTO(int CODPRODUTO) {
		this.CODPRODUTO = new SimpleIntegerProperty(CODPRODUTO);
	}
	public IntegerProperty CODPRODUTOProperty() {
		return CODPRODUTO;
	}
	//Metodos atributo: NOME_ARTIGO
	public String getNOME_ARTIGO() {
		return NOME_ARTIGO.get();
	}
	public void setNOME_ARTIGO(String NOME_ARTIGO) {
		this.NOME_ARTIGO = new SimpleStringProperty(NOME_ARTIGO);
	}
	public StringProperty NOME_ARTIGOProperty() {
		return NOME_ARTIGO;
	}
	//Metodos atributo: CODBARRA
	public String getCODBARRA() {
		return CODBARRA.get();
	}
	public void setCODBARRA(String CODBARRA) {
		this.CODBARRA = new SimpleStringProperty(CODBARRA);
	}
	public StringProperty CODBARRAProperty() {
		return CODBARRA;
	}
	//Metodos atributo: FOTO_ARTIGO
	public String getFOTO_ARTIGO() {
		return FOTO_ARTIGO.get();
	}
	public void setFOTO_ARTIGO(String FOTO_ARTIGO) {
		this.FOTO_ARTIGO = new SimpleStringProperty(FOTO_ARTIGO);
	}
	public StringProperty FOTO_ARTIGOProperty() {
		return FOTO_ARTIGO;
	}
	//Metodos atributo: PRECO_COMPRA
	public Double getPRECO_COMPRA() {
		return PRECO_COMPRA.get();
	}
	public void setPRECO_COMPRA(Double PRECO_COMPRA) {
		this.PRECO_COMPRA = new SimpleDoubleProperty(PRECO_COMPRA);
	}
        public String getPrecoCompraFormatado() {
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMinimumFractionDigits(2);
        nf.setMaximumFractionDigits(2);
        return nf.format(PRECO_COMPRA);
    }
	public DoubleProperty PRECO_COMPRAProperty() {
		return PRECO_COMPRA;
	}
	//Metodos atributo: PRECO_VENDA
	public Double getPRECO_VENDA() {
		return PRECO_VENDA.get();
	}
	public void setPRECO_VENDA(Double PRECO_VENDA) {
		this.PRECO_VENDA = new SimpleDoubleProperty(PRECO_VENDA);
	}
        public String getPrecoVendaFormatado() {
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMinimumFractionDigits(2);
        nf.setMaximumFractionDigits(2);
        return nf.format(PRECO_VENDA);
    }
	public DoubleProperty PRECO_VENDAProperty() {
		return PRECO_VENDA;
	}
	//Metodos atributo: PRODUTO_CATEGORIA
	public ProdutoCategoria getPRODUTO_CATEGORIA() {
		return PRODUTO_CATEGORIA;
	}
	public void setPRODUTO_CATEGORIA(ProdutoCategoria PRODUTO_CATEGORIA) {
		this.PRODUTO_CATEGORIA = PRODUTO_CATEGORIA;
	}
	//Metodos atributo: PRODUTO_TIPO
	public ProdutoTipo getPRODUTO_TIPO() {
		return PRODUTO_TIPO;
	}
	public void setPRODUTO_TIPO(ProdutoTipo PRODUTO_TIPO) {
		this.PRODUTO_TIPO = PRODUTO_TIPO;
	}
	//Metodos atributo: PRODUTO_GRUPO
	public ProdutoGrupo getPRODUTO_GRUPO() {
		return PRODUTO_GRUPO;
	}
	public void setPRODUTO_GRUPO(ProdutoGrupo PRODUTO_GRUPO) {
		this.PRODUTO_GRUPO = PRODUTO_GRUPO;
	}
	//Metodos atributo: PRODUTO_SUB_GRUPO
	public ProdutoSubGrupo getPRODUTO_SUB_GRUPO() {
		return PRODUTO_SUB_GRUPO;
	}
	public void setPRODUTO_SUB_GRUPO(ProdutoSubGrupo PRODUTO_SUB_GRUPO) {
		this.PRODUTO_SUB_GRUPO = PRODUTO_SUB_GRUPO;
	}
	//Metodos atributo: UNIDADE_MEDIDA
	public Unidade_medida getUNIDADE_MEDIDA() {
		return UNIDADE_MEDIDA;
	}
	public void setUNIDADE_MEDIDA(Unidade_medida UNIDADE_MEDIDA) {
		this.UNIDADE_MEDIDA = UNIDADE_MEDIDA;
	}
	//Metodos atributo: ESTOQUE_MINIMO
	public String getESTOQUE_MINIMO() {
		return ESTOQUE_MINIMO.get();
	}
	public void setESTOQUE_MINIMO(String ESTOQUE_MINIMO) {
		this.ESTOQUE_MINIMO = new SimpleStringProperty(ESTOQUE_MINIMO);
	}
	public StringProperty ESTOQUE_MINIMOProperty() {
		return ESTOQUE_MINIMO;
	}
	//Metodos atributo: ESTOQUE_MAXIMO
	public String getESTOQUE_MAXIMO() {
		return ESTOQUE_MAXIMO.get();
	}
	public void setESTOQUE_MAXIMO(String ESTOQUE_MAXIMO) {
		this.ESTOQUE_MAXIMO = new SimpleStringProperty(ESTOQUE_MAXIMO);
	}
	public StringProperty ESTOQUE_MAXIMOProperty() {
		return ESTOQUE_MAXIMO;
	}
        /**
     * @return the STATUS
     */
        public Status getSTATUS () {
            return STATUS;
        }
        /**
         * @param STATUS the STATUS to set
         */
        public void setSTATUS (Status STATUS) {
            this.STATUS = STATUS;
        }
        /**
         * @return the CONTROLA_ESTOQUE
         */
        public boolean isCONTROLA_ESTOQUE () {
            return CONTROLA_ESTOQUE;
        }
        /**
         * @param CONTROLA_ESTOQUE the CONTROLA_ESTOQUE to set
         */
        public void setCONTROLA_ESTOQUE (boolean CONTROLA_ESTOQUE) {
            this.CONTROLA_ESTOQUE = CONTROLA_ESTOQUE;
        }
        @Override
	public String toString(){
		return NOME_ARTIGO.get() + " ("+CODBARRA.get()+")";
	}

    /**
     * @return the PRODUTO_ESTOQUE
     */
    public ProdutoEstoque getPRODUTO_ESTOQUE () {
        return PRODUTO_ESTOQUE;
    }

    /**
     * @param PRODUTO_ESTOQUE the PRODUTO_ESTOQUE to set
     */
    public void setPRODUTO_ESTOQUE (ProdutoEstoque PRODUTO_ESTOQUE) {
        this.PRODUTO_ESTOQUE = PRODUTO_ESTOQUE;
    }
   
        
        
   

    



}