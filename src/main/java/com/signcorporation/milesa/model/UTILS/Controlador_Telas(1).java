/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.signcorporation.milesa.model.UTILS;

import javafx.event.ActionEvent;

/**
 *
 * @author Hacker PC
 */
public abstract class Controlador_Telas {
     protected abstract void atualizarGrade(int paginaAtual);

    protected abstract void setParent(Controlador_Telas controller);
    
    protected abstract void setObject(Object object);

    protected abstract void onActionNovo(ActionEvent event);

    protected abstract void onActionEditar(ActionEvent event);

    protected abstract void onActionSelecionar(ActionEvent event);

    protected abstract void onActionPesquisar(ActionEvent event);

    protected abstract void onActionBtnSalvar(ActionEvent event);

    protected abstract void onActionBtnCancelar(ActionEvent event);
}
