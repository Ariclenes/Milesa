/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.signcorporation.milesa.model.DAO;

import BD.ConexaoBD;
import MODELO.BEAN.Regime_Tributario;
import MODELO.UTILS.ExceptionValidacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Hacker PC
 */
public class RegimeIVADAO implements CRUD<Regime_Tributario>{
    ConexaoBD con = new ConexaoBD();
    Connection conexao = con.getInstance().getConnection();
    @Override
    public void guardar (Regime_Tributario t) throws ExceptionValidacao, SQLException {
       if (t.getID ()== 0) {
            if (existe(t)) {
                throw new ExceptionValidacao("O Regime Tributario já está cadastrada");
            }
            inserir(t);
        } else {
            alterar(t);
        }
    }

    @Override
    public boolean existe (Regime_Tributario p) throws ExceptionValidacao, SQLException {
       String SQL = "SELECT COUNT(ID) FROM FACTURA_IVA WHERE ID=?";
       
        
       PreparedStatement ps = conexao.prepareStatement(SQL);
       ps.setInt(1, p.getID ());
        ps.setDouble(1, p.getTAXA ());
        ps.setDouble(2, p.getTAXA_RETORNO ());
        ps.setString(3, p.getCODIGO ());
        ps.setString(4, p.getMOTIVO ());
        ps.setString (5, p.getTEXTO ());
        ps.setBoolean (6, p.isALTERACAO_ANUAL ());
        con.confirmar ();
        ResultSet rs = ps.executeQuery();
        rs.next();
        return (rs.getInt(1) > 0);
    }

    @Override
    public void inserir (Regime_Tributario p) throws ExceptionValidacao, SQLException {
        String SQL  = "INSERT INTO FACTURA_IVA (ID,TAXA,TAXA_RETORNO,CODIGO,MOTIVO,TEXTO,ALTERACAO_ANUAL  )values (NULL,?,?,?,?,?,?)";
       
      PreparedStatement  ps = conexao.prepareStatement(SQL);
//        ps.setInt(1, p.getID ());
        ps.setDouble(1, p.getTAXA ());
        ps.setDouble(2, p.getTAXA_RETORNO ());
        ps.setString(3, p.getCODIGO ());
        ps.setString(4, p.getMOTIVO ());
        ps.setString (5, p.getTEXTO ());
        ps.setBoolean (6, p.isALTERACAO_ANUAL ());
        ps.execute();
//          connetion.close();
       ps.close();
    }

    @Override
    public void alterar (Regime_Tributario p) throws ExceptionValidacao, SQLException {
       String SQL = "UPDATE FACTURA_IVA SET TAXA=?,TAXA_RETORNO=?,CODIGO=?,MOTIVO=?,TEXTO=?,  ALTERACAO_ANUAL=?  WHERE ID=?";
        PreparedStatement  ps = conexao.prepareStatement(SQL);
        ps.setInt(1, p.getID ());
        ps.setDouble(1, p.getTAXA ());
        ps.setDouble(2, p.getTAXA_RETORNO ());
        ps.setString(3, p.getCODIGO ());
        ps.setString(4, p.getMOTIVO ());
        ps.setString (5, p.getTEXTO ());
        ps.setBoolean (6, p.isALTERACAO_ANUAL ());
        ps.execute();
//          connetion.close();
       ps.close();
    }

    @Override
    public void excluir (int codigo) throws ExceptionValidacao, SQLException {
        PreparedStatement   ps = conexao.prepareStatement("DELETE FROM FACTURA_IVA WHERE ID=?");
	ps.setInt(1, codigo);
	ps.execute();
	ps.close();
    }

    @Override
    public ObservableList<Regime_Tributario> listar (boolean somenteAtivos) throws ExceptionValidacao, Exception {
      ObservableList<Regime_Tributario> lista_regime_iva_agt = FXCollections.observableArrayList();
            String SQL= "SELECT * FROM FACTURA_IVA";
//            SQL+= ((somenteAtivos) ? " WHERE status='A' " : " ");
//            SQL += "ORDER BY MOTIVO LIMIT 100";

		PreparedStatement ps = conexao.prepareStatement(SQL);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
                Regime_Tributario p = new Regime_Tributario ();
                p.setID ((rs.getInt("ID")));
                p.setTAXA (rs.getDouble("TAXA"));
                p.setTAXA_RETORNO (rs.getDouble ("TAXA_RETORNO"));
                p.setMOTIVO (rs.getString ("MOTIVO"));
                p.setTEXTO (rs.getString("TEXTO"));
                p.setALTERACAO_ANUAL (rs.getBoolean ("ALTERACAO_ANUAL"));
                
                lista_regime_iva_agt.add (p);
		}
		return lista_regime_iva_agt;
    }
      public static Regime_Tributario get(int codpProduto) throws Exception {
                String SQL = "SELECT * FROM FACTURA_IVA WHERE ID=? ";
                ConexaoBD con = new ConexaoBD ();
                Connection conexao = con.getInstance ().getConnection ();
                PreparedStatement ps = conexao.prepareStatement(SQL);
                ps.setInt(1, codpProduto);
                ResultSet rs = ps.executeQuery();
                Regime_Tributario p = new Regime_Tributario ();
                if (rs.next()) {
                    p.setID (rs.getInt("ID"));
                    p.setTAXA (rs.getDouble("TAXA"));
                    p.setTAXA_RETORNO (rs.getDouble("TAXA_RETORNO"));
                    p.setMOTIVO (rs.getString("MOTIVO"));
                    p.setTEXTO (rs.getString ("TEXTO"));
                    p.setALTERACAO_ANUAL (rs.getBoolean ("ALTERACAO_ANUAL"));
                }
                return p;
            }
}
