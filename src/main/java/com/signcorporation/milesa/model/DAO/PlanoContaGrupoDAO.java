/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.signcorporation.milesa.model.DAO;

import BD.ConexaoBD;
import MODELO.BEAN.PlanoContaGrupo;
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
public class PlanoContaGrupoDAO implements CRUD<PlanoContaGrupo> {
    ConexaoBD con = new ConexaoBD();
    Connection conexao = con.getInstance().getConnection();

    @Override
    public void guardar(PlanoContaGrupo t) throws ExceptionValidacao, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean existe(PlanoContaGrupo t) throws ExceptionValidacao, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void inserir(PlanoContaGrupo t) throws ExceptionValidacao, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(PlanoContaGrupo t) throws ExceptionValidacao, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(int codigo) throws ExceptionValidacao, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObservableList<PlanoContaGrupo> listar(boolean somenteAtivos) throws ExceptionValidacao, Exception {
        ObservableList<PlanoContaGrupo> LISTAR_PLANO_CONTAS = FXCollections.observableArrayList();
        String SQL = "SELECT * FROM PLANO_CONTA_GRUPO";
        SQL += ((somenteAtivos) ? " WHERE STATUS='A' " : " ");
        SQL += " order by CODGRUPO";
        PreparedStatement ps = conexao.prepareStatement(SQL);
        ResultSet rs = ps.executeQuery();
        System.out.println("sql: " + SQL);

        while (rs.next()) {
            System.out.println("RESULTADOS SQL: ");
            PlanoContaGrupo plano_de_contas = new PlanoContaGrupo();
            plano_de_contas.setCodigo(rs.getInt("CODGRUPO"));
            plano_de_contas.setSigla(rs.getString("SIGLA"));
            plano_de_contas.setDescricao(rs.getString("DESCRICAO"));
            plano_de_contas.setSTATUS(Status.get(rs.getString("STATUS")));
        }
        ps.close();
        rs.close();
        return LISTAR_PLANO_CONTAS;
    }

    public static PlanoContaGrupo get(int codPlanoConta) throws Exception {

        String sql = "select * from PLANO_CONTA_GRUPO where CODGRUPO =?";
        ConexaoBD con = new ConexaoBD();
        Connection conexao = con.getInstance().getConnection();
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, codPlanoConta);
        ResultSet rs = ps.executeQuery();
        PlanoContaGrupo plano_de_contas = new PlanoContaGrupo();
        if (rs.next()) {
            plano_de_contas.setCodigo(rs.getInt("CODGRUPO"));
            plano_de_contas.setSigla(rs.getString("SIGLA"));
            plano_de_contas.setDescricao(rs.getString("DESCRICAO"));
            plano_de_contas.setSTATUS(Status.get(rs.getString("STATUS")));
        }
        return plano_de_contas;
    }
}
