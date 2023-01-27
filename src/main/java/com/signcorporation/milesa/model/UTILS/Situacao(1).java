/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.signcorporation.milesa.model.UTILS;

/**
 *
 * @author AEM Sign Angola
 */
public enum Situacao {
    
    ABERTA(1, "Aberta"),
    PENDENTE(2, "Pendente"),  
    ANULADA(3, "ANULADA"),
    FINALIZADA(4, "Finalizada"),
    CANCELADA(5, "Cancelada");

    private final int ID;
    private final String DESCRICAO;

    private Situacao(int id, String descricao) {
        this.ID = id;
        this.DESCRICAO = descricao;
    }

    public int getId() {
        return ID;
    }

    @Override
    public String toString() {
        return this.DESCRICAO;
    }

}
