package com.signcorporation.milesa.model.BEAN;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author AEM Sign Angola
 */
public class ProdutoTipo {
    private Status status;
    private IntegerProperty codTipo;
    private StringProperty tipo_produto;
    private DoubleProperty IPC;
    private DoubleProperty TAXA_IVA;
    private Regime_Tributario iva_regime;
    private boolean servico_retencao;
    private boolean selo_pago;
    private boolean ipc_incluido;
    private String SAFTproductType;


    @Override
    public String toString() {
        return tipo_produto.get();

    }

    //Metodos atributo: status
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    //Metodos atributo: codTipo
    public int getCodTipo() {
        return codTipo.get();
    }

    public void setCodTipo(int codTipo) {
        this.setCodTipo(new SimpleIntegerProperty(codTipo));
    }

    public IntegerProperty CodTipoProperty() {
        return codTipo;
    }

    //Metodos atributo: tipo_produto
    public String getTipo_produto() {
        return tipo_produto.get();
    }

    public void setTipo_produto(String tipo_produto) {
        this.setTipo_produto(new SimpleStringProperty(tipo_produto));
    }

    public StringProperty Tipo_produtoProperty() {
        return tipo_produto;
    }

    //Metodos atributo: IPC
    public Double getIPC() {
        return IPC.get();
    }

    public void setIPC(Double IPC) {
        this.setIPC(new SimpleDoubleProperty(IPC));
    }

    public DoubleProperty IPCProperty() {
        return IPC;
    }

    //Metodos atributo: TAXA_IVA
    public Double getTAXA_IVA() {
        return TAXA_IVA.get();
    }

    public void setTAXA_IVA(Double TAXA_IVA) {
        this.setTAXA_IVA(new SimpleDoubleProperty(TAXA_IVA));
    }

    public DoubleProperty TAXA_IVAProperty() {
        return TAXA_IVA;
    }

    /**
     * @param codTipo the codTipo to set
     */
    public void setCodTipo(IntegerProperty codTipo) {
        this.codTipo = codTipo;
    }

    /**
     * @param tipo_produto the tipo_produto to set
     */
    public void setTipo_produto(StringProperty tipo_produto) {
        this.tipo_produto = tipo_produto;
    }

    /**
     * @param IPC the IPC to set
     */
    public void setIPC(DoubleProperty IPC) {
        this.IPC = IPC;
    }

    /**
     * @param TAXA_IVA the TAXA_IVA to set
     */
    public void setTAXA_IVA(DoubleProperty TAXA_IVA) {
        this.TAXA_IVA = TAXA_IVA;
    }

    /**
     * @return the iva_regime
     */
    public Regime_Tributario getIva_regime() {
        return iva_regime;
    }

    /**
     * @param iva_regime the iva_regime to set
     */
    public void setIva_regime(Regime_Tributario iva_regime) {
        this.iva_regime = iva_regime;
    }

    /**
     * @return the servico_retencao
     */
    public boolean isServico_retencao() {
        return servico_retencao;
    }

    /**
     * @param servico_retencao the servico_retencao to set
     */
    public void setServico_retencao(boolean servico_retencao) {
        this.servico_retencao = servico_retencao;
    }

    /**
     * @return the selo_pago
     */
    public boolean isSelo_pago() {
        return selo_pago;
    }

    /**
     * @param selo_pago the selo_pago to set
     */
    public void setSelo_pago(boolean selo_pago) {
        this.selo_pago = selo_pago;
    }

    /**
     * @return the ipc_incluido
     */
    public boolean isIpc_incluido() {
        return ipc_incluido;
    }

    /**
     * @param ipc_incluido the ipc_incluido to set
     */
    public void setIpc_incluido(boolean ipc_incluido) {
        this.ipc_incluido = ipc_incluido;
    }

    /**
     * @return the SAFTproductType
     */
    public String getSAFTproductType() {
        return SAFTproductType;
    }

    /**
     * @param SAFTproductType the SAFTproductType to set
     */
    public void setSAFTproductType(String SAFTproductType) {
        this.SAFTproductType = SAFTproductType;
    }


}
