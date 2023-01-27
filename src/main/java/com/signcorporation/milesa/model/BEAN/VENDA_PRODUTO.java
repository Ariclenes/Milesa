package com.signcorporation.milesa.model.BEAN;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.TextField;

/**
 * @author Hacker PC
 */
public class VENDA_PRODUTO {

    private StringProperty NOME, PRECO, UNIDADE, DESCONTO, PRECO_DO_LOTE, COR;
    private IntegerProperty CODIGO, VENDA;
    private TextField QUANTIDADE = new TextField("1"), PRECO_V = new TextField("");
//    private Double SUB_TOTAL;


    //    private codigo int AI PK 
//
//FATURA_ID int(6) UN zerofill 
//DOC_NUMERO varchar(45) 
//DOC_TIPO_ID int 
//DOC_SERIE varchar(45) 
//ARMAZEM_ID int 
//DESCRICAO varchar(45) 
//UN varchar(45) 
//NR_LOTE varchar(45) 
//COR varchar(45) 
//DESCONTO decimal(10,0) 
//DEB_CRED tinyint 
//FOB int 
//CIF int 
//TAXA_CONV decimal(10,0) 
//LANCADO tinyint 
//OBS text 
//PVP_MANUAL tinyint 
//MOV_STK tinyint 
//IPC_PROCESSADO tinyint 
//ARTG_ENCARGOS tinyint 
//ARTG_ENCARGOS_PROCESSADOS tinyint 
//ARTG_ENCARGOS_TOTAL decimal(10,0) 
//PCM_PROCESSADO tinyint 
//VEICULO_ID int 
//VEICULO_OBS text 
//TOTAL_ITEM decimal(10,0) 
//TOTAL_ITEM_DESCONTO decimal(10,0) 
//TOTAL_PAGO_ITEM decimal(10,0) 
//DOC_ORIGEM_ITEM int 
//CURSO_INSCRICAO_ID int 
//ENCARGOS_DOC_ID int 
//ENCARGOS_FOB decimal(10,0) 
//SERVICO_RETENCAO tinyint 
//SERVICO_RETENCAO_PORC decimal(10,0) 
//SERVICO_RETENCAO_VLR decimal(10,0) 
//ENCARGOS_CO_EFICIENTE decimal(10,0) 
//PCM0 decimal(10,0) 
//PCU0 decimal(10,0) 
//PVP0 decimal(10,0) 
//P_UN int 
//TIPO_PROD_ID int 
//DATA_MOV datetime 
//DATA_INSERCAO datetime 
//DATA_ULT_MODIFICACAO datetime 
//TIPO_MOV_STK int 
//FINANCEIRO_TIPO_ID int 
//QUNT_FORMULA int 
//STOCK_ATUAL int 
//ARTIGO_SUJEITO_ENCARGO tinyint 
//UNIDADE_BASE_ID int 
//UNIDADE_MOV_ID int 
//LINHA_NR int 
//NIVEL_LINHA int 
//VENDEDOR_ID int 
//DATA_ENTREGA datetime 
//DATA_PRODUCAO datetime 
//DATA_VALIDADE datetime 
//QTD_CAIXA int 
//CAIXA_ID int 
//PART_NUMBER varchar(45) 
//STK_ATUALIZADO tinyint 
//QTD_ORIGINAL varchar(45) 
//TIPO_UN_MEDIDA int 
//STK_INICIAL tinyint 
//IMPRIMIR_EM_DOC tinyint 
//IMPRIMIR_EM_CONSULTA tinyint 
//INPRIMIR_EM_CONSULTA tinyint 
//ARTIGO_PAI_ID int 
//HORA_INICIO datetime 
//HORA_FIM datetime 
//DESCONTO_FINANCEIRO_LINHA int 
//CATEGORIA_ID int 
//DOC_ANULADO tinyint 
//IPC decimal(10,0) 
//VLR_IPC decimal(10,0) 
//ID_ORIGINAL int 
//ID_REG_EXPORTADO int 
//IVA decimal(10,0) 
//IVA_VLR decimal(10,0) 
//IVA_ID
// public double getSubtotal() {
//            return PRECO.get ()  QUANTIDADE.getText();
//        }
    public VENDA_PRODUTO(int CODIGO, String NOME, String PRECO, String UNIDADE) {
        this.NOME = new SimpleStringProperty(NOME);
        this.CODIGO = new SimpleIntegerProperty(CODIGO);
        this.PRECO = new SimpleStringProperty(PRECO);
        this.UNIDADE = new SimpleStringProperty(UNIDADE);

    }


    public String getNOME() {
        return NOME.get();
    }

    public void setNOME(String NOME) {
        this.NOME = new SimpleStringProperty(NOME);
    }

    public String getPRECO() {
        return PRECO.get();
    }

    public void setPRECO(String PRECO) {
        this.PRECO = new SimpleStringProperty(PRECO);
    }

    public String getUNIDADE() {
        return UNIDADE.get();
    }

    public void setUNIDADE(String UNIDADE) {
        this.UNIDADE = new SimpleStringProperty(UNIDADE);
    }

    public String getDESCONTO() {
        return DESCONTO.get();
    }

    public void setDESCONTO(String DESCONTO) {
        this.DESCONTO = new SimpleStringProperty(DESCONTO);
    }

    public String getPRECO_DO_LOTE() {
        return PRECO_DO_LOTE.get();
    }

    public void setPRECO_DO_LOTE(String PRECO_DO_LOTE) {
        this.PRECO_DO_LOTE = new SimpleStringProperty(PRECO_DO_LOTE);
    }

    public int getCODIGO() {
        return CODIGO.get();
    }

    public void setCODIGO(int CODIGO) {
        this.CODIGO = new SimpleIntegerProperty(CODIGO);
    }

    public int getVENDA() {
        return VENDA.get();
    }

    public void setVENDA(int VENDA) {
        this.VENDA = new SimpleIntegerProperty(VENDA);
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
