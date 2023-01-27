/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.signcorporation.milesa.model.UTILS;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Hacker PC
 */
public enum TipoMovimento {
      RECEITA("R","Receita"), 
      DESPESA("D","Despesa");
    
    
        private StringProperty TIPOMOVIMENTO;
	private StringProperty DESCRICAOMOVIMENTO;

	private TipoMovimento(String TIPOMOVIMENTO,String DESCRICAOMOVIMENTO) { 
            this.TIPOMOVIMENTO = new SimpleStringProperty(TIPOMOVIMENTO);
            this.DESCRICAOMOVIMENTO = new SimpleStringProperty(DESCRICAOMOVIMENTO);
	}
            /**
     * @return the TIPOMOVIMENTO
     */
        public String getTIPOMOVIMENTO () {
            return TIPOMOVIMENTO.get ();
        }

        /**
         * @param TIPOMOVIMENTO the TIPOMOVIMENTO to set
         */
        public void setTIPOMOVIMENTO (String TIPOMOVIMENTO) {
            this.TIPOMOVIMENTO =  new SimpleStringProperty(TIPOMOVIMENTO);
        }

        /**
         * @return the DESCRICAOMOVIMENTO
         */
        public String getDESCRICAOMOVIMENTO () {
            return DESCRICAOMOVIMENTO.get ();
        }

        /**
         * @param DESCRICAOMOVIMENTO the DESCRICAOMOVIMENTO to set
         */
        public void setDESCRICAOMOVIMENTO (String DESCRICAOMOVIMENTO) {
            this.DESCRICAOMOVIMENTO =  new SimpleStringProperty(DESCRICAOMOVIMENTO);
        }

    public static TipoMovimento get(String obj) {
        for (TipoMovimento TIPO : TipoMovimento.values()) {
            if (TIPO.getTIPOMOVIMENTO ().equals(obj)) {
                return TIPO;
            }
        }
        return null;
    }
//
//    @Override
//    public String toString() {
//        return DESCRICAO.get ();
//    }
//    


}
