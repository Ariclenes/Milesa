/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.signcorporation.milesa.model.DAO;

import BD.ConexaoBD;
import MODELO.BEAN.ProdutoTipo;
import MODELO.BEAN.Status;
import MODELO.UTILS.ExceptionValidacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @author Hacker PC
 */
public class ProdutoTipoDAO implements CRUD<ProdutoTipo> {
    ConexaoBD con = new ConexaoBD();
    Connection conexao = con.getInstance().getConnection();


    @Override
    public void guardar(ProdutoTipo t) throws ExceptionValidacao, SQLException {
        if (t.getCodTipo() == 0) {
            if (existe(t)) {
                throw new ExceptionValidacao("A Tipo de produto já está cadastrada");
            }
            inserir(t);
        } else {
            alterar(t);
        }
    }

    @Override
    public boolean existe(ProdutoTipo t) throws ExceptionValidacao, SQLException {
        String sql = "SELECT COUNT(CODIGO) FROM PRODUTO_TIPO WHERE NOME=? ";
        ConexaoBD c = new ConexaoBD();
        PreparedStatement ps = c.getInstance().getConnection().prepareStatement(sql);
        ps.setString(1, t.getTipo_produto());
        ResultSet rs = ps.executeQuery();
        rs.next();
        return (rs.getInt(1) > 0);
    }

    @Override
    public void inserir(ProdutoTipo t) throws ExceptionValidacao, SQLException {
        try {

            PreparedStatement ps = conexao.prepareStatement("INSERT INTO PRODUTO_CATEGORIA(NOME) VALUES(?) ");
            ps.setString(1, t.getTipo_produto());
//           ps.setString(2, t.getCor());
            ps.execute();
//	   connetion.close();
            ps.close();

        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    @Override
    public void alterar(ProdutoTipo t) throws ExceptionValidacao, SQLException {
        String SQL = "UPDATE PRODUTO_TIPO SET NOME_TIPO=?,  IPC=?, IVA=? WHERE CODIGO=?";
        PreparedStatement ps = conexao.prepareStatement(SQL);
        ps.setString(1, t.getTipo_produto());
//        ps.setString(2, t.getDescricao());
//        ps.setString(2, t.getCor());
//        ps.setString(4, t.getStatus().getDescricao());
        ps.setInt(2, t.getCodTipo());
        ps.execute();
    }

    @Override
    public void excluir(int codigo) throws ExceptionValidacao, SQLException {

        PreparedStatement ps = conexao.prepareStatement("DELETE FROM PRODUTO_CATEGORIA WHERE CODIGO=?");
        ps.setInt(1, codigo);
        ps.execute();
        ps.close();
    }


    @Override
    public ObservableList<ProdutoTipo> listar(boolean somenteAtivos) throws ExceptionValidacao, SQLException {
        ObservableList<ProdutoTipo> lista_tipo_produto = FXCollections.observableArrayList();

        PreparedStatement ps = conexao.prepareStatement("SELECT * FROM PRODUTO_TIPO");
        ResultSet rs = ps.executeQuery();
        ProdutoTipo t = null;
        while (rs.next()) {
            t = new ProdutoTipo();
            t.setCodTipo(rs.getInt("CODIGO"));
            t.setTipo_produto(rs.getString("NOME_TIPO"));
            t.setIPC(rs.getDouble("IPC"));
//                    t.setTAXA_IVA (rs.getDouble ("IVA"));
            t.setStatus(Status.get(rs.getString("status")));
            lista_tipo_produto.add(t);
        }
//		connetion.close();
//		ps.close();
//		rs.close();
        return lista_tipo_produto;
    }

    public static ProdutoTipo get(int codTipo) throws Exception {
        String sql = "select * from PRODUTO_TIPO where CODIGO=? ";
        ConexaoBD con = new ConexaoBD();
        Connection conexao = con.getInstance().getConnection();
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, codTipo);
        ResultSet rs = ps.executeQuery();
        ProdutoTipo t = new ProdutoTipo();
        if (rs.next()) {
            t.setCodTipo(rs.getInt("CODIGO"));
            t.setTipo_produto(rs.getString("NOME_TIPO"));
            t.setIPC(rs.getDouble("IPC"));
//            t.setTAXA_IVA (rs.getDouble ("IVA"));
            t.setStatus(Status.get(rs.getString("status")));
        }
        return t;
    }
}

//CODIGO int(11) AI PK 
//NOME_TIPO varchar(45) 
//CONTA varchar(45) 
//TAXA decimal(11,2) 
//STATUS char(1) 
//IPC decimal(10,0) 
//SERVICORETENCAO tinyint(4) 
//SELOPAGO tinyint(4) 
//IVA_ID int(11) 
//SAFTProductType varchar(4) 
//IPCINCLUIDO
