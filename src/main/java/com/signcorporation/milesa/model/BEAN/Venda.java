/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.signcorporation.milesa.model.BEAN;

import MODELO.UTILS.Situacao;

import java.util.Date;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @author Hacker PC
 */
public class Venda {
    private IntegerProperty codVenda;
    private Cliente codCliente;
    private Fornecedor codFornecedor;
    private Date dataVenda;

    private DoubleProperty ValorTotal;
    private Situacao situacao;
    private ObservableList<ItemVenda> itens;
    private ObservableList<ItemVenda> itensRemover;

    //
    //Metodos atributo: codVenda
    public int getCodVenda() {
        return codVenda.get();
    }

    public void setCodVenda(int codVenda) {
        this.codVenda = new SimpleIntegerProperty(codVenda);
    }

    public int getCodigoEdicao() {
        if (getSituacao() == Situacao.ABERTA) {
            return codVenda.get();
        } else {
            return 0;
        }
    }

    public IntegerProperty CodVendaProperty() {
        return codVenda;
    }

    //Metodos atributo: codCliente
    public Cliente getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Cliente codCliente) {
        this.codCliente = codCliente;
    }

    //Metodos atributo: dataVenda
    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    //Metodos atributo: ValorTotal
    public Double getValorTotal() {
        return ValorTotal.get();
    }

    public void setValorTotal(Double ValorTotal) {
        this.ValorTotal = new SimpleDoubleProperty(ValorTotal);
    }

    public DoubleProperty ValorTotalProperty() {
        return ValorTotal;
    }

    //Metodos atributo: situacao
    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public void setSituacao(int situacao) {
        if (situacao == Situacao.ABERTA.getId()) {
            setSituacao(Situacao.ABERTA);
        } else if (situacao == Situacao.FINALIZADA.getId()) {
            setSituacao(Situacao.FINALIZADA);
        } else if (situacao == Situacao.PENDENTE.getId()) {
            setSituacao(Situacao.PENDENTE);
        } else if (situacao == Situacao.CANCELADA.getId()) {
            setSituacao(Situacao.CANCELADA);
        }
    }

    //Classe de Itens para venda Dentro da classe de Venda        
    public class ItemVenda {
        private IntegerProperty codigo;
        private Produto produto;
        private Unidade_medida UN;
        private ProdutoCategoria categoria;
        private IntegerProperty quantidade;
        private DoubleProperty ValorUnitario;

//	FATURA_ITENS (COD_PRODUTO, QTD, PVP, FATURA_ID,DOC_NUMERO,DOC_TIPO_ID,"
//                    + "DOC_SERIE,ARMAZEM_ID,DESCRICAO,UN,NR_LOTE,"
//                    + "COR,DESCONTO,DEB_CRED,FOB,CIF,TAXA_CONV, LANCADO,OBS,PVP_MANUAL,MOV_STK,IPC_PROCESSADO,ARTG_ENCARGOS,ARTG_ENCARGOS_PROCESSADOS,"
//                    + "ARTG_ENCARGOS_TOTAL,PCM_PROCESSADO,VEICULO_ID,VEICULO_OBS,TOTAL_ITEM,TOTAL_ITEM_DESCONTO,TOTAL_PAGO_ITEM,DOC_ORIGEM_ITEM"
//                    + "CURSO_INSCRICAO_ID,,ENCARGOS_DOC_ID,ENCARGOS_FOB,SERVICO_RETENCAO,SERVICO_RETENCAO_PORC,SERVICO_RETENCAO_VLR"
//                    + "ENCARGOS_CO_EFICIENTE,PCM0,PCU0,PVP0,P_UN,TIPO_PROD_ID,DATA_MOV,DATA_INSERCAO,DATA_ULT_MODIFICACAO,TIPO_MOV_STK

        //Metodos atributo: codigo
        public int getCodigo() {
            return codigo.get();
        }

        public void setCodigo(int codigo) {
            this.codigo = new SimpleIntegerProperty(codigo);
        }

        public IntegerProperty CodigoProperty() {
            return codigo;
        }

        //Metodos atributo: produto
        public Produto getProduto() {
            return produto;
        }

        public void setProduto(Produto produto) {
            this.produto = produto;
        }

        //Metodos atributo: quantidade
        public int getQuantidade() {
            return quantidade.get();
        }

        public void setQuantidade(int quantidade) {
            this.quantidade = new SimpleIntegerProperty(quantidade);
        }

        public IntegerProperty QuantidadeProperty() {
            return quantidade;
        }

        //Metodos atributo: ValorUnitario
        public Double getValorUnitario() {
            return ValorUnitario.get();
        }

        public void setValorUnitario(Double ValorUnitario) {
            this.ValorUnitario = new SimpleDoubleProperty(ValorUnitario);
        }

        public DoubleProperty ValorUnitarioProperty() {
            return ValorUnitario;
        }

        public double getSubtotal() {
            return ValorUnitario.get() * quantidade.get();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof ItemVenda) {
                ItemVenda i = (ItemVenda) obj;
                return i.getCodigo() == getCodigo();
            }
            return false;
        }

    }

    public void addItem(ItemVenda itemVenda) {
        itens.add(itemVenda);
    }

    public void removeItem(ItemVenda itemVenda) {
        itens.remove(itemVenda);
        if (itemVenda.getCodigo() != 0) {
            itensRemover.add(itemVenda);
        }
    }

    public int quantidadeItens() {
        return itens.size();
    }

    @Override
    public String toString() {
        return String.valueOf(this.codVenda);
    }

    /**
     * @return the itens
     */
    public ObservableList<ItemVenda> getItens() {
        return itens;
    }

    /**
     * @param itens the itens to set
     */
    public void setItens(ObservableList<ItemVenda> itens) {
        this.itens = itens;
    }

    /**
     * @return the itensRemover
     */
    public ObservableList<ItemVenda> getItensRemover() {
        return itensRemover;
    }

    /**
     * @param itensRemover the itensRemover to set
     */
    public void setItensRemover(ObservableList<ItemVenda> itensRemover) {
        this.itensRemover = itensRemover;
    }

    public Venda() {
        this.codVenda = new SimpleIntegerProperty(0);
        ;
        this.itens = FXCollections.observableArrayList();
        this.itensRemover = FXCollections.observableArrayList();
    }

    public Venda(int codigo) {
        this.codVenda = new SimpleIntegerProperty(codigo);
        this.itens = FXCollections.observableArrayList();
        this.itensRemover = FXCollections.observableArrayList();

    }

}









