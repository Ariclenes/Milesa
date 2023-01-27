/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.signcorporation.milesa.model.DAO;

import BD.ConexaoBD;
import MODELO.BEAN.Moeda;
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
public class MoedaDAO {

    public static int guardar(Moeda m) throws ExceptionValidacao, SQLException {
        if (m.getCod_moeda() == 0) {
            inserir(m);
        } else {
            alterar(m);
        }
        return m.getCod_moeda();
    }

    public boolean existe(Moeda t) throws ExceptionValidacao, SQLException {
        String sql = "select count(COD_MOEDA) from MOEDA where MOEDA_ID=?";
        ConexaoBD con = new ConexaoBD();
        Connection conexao = con.getInstance().getConnection();
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, t.getMoeda());
        ps.setString(2, t.getSingular());
        ps.setString(3, t.getPlural());
        ps.setString(4, t.getSimbolo());
        ps.setInt(5, t.getCod_moeda());
        ResultSet rs = ps.executeQuery();
        rs.next();
        return (rs.getInt(1) > 0);
    }

    public static void inserir(Moeda t) throws ExceptionValidacao, SQLException {
        ConexaoBD con = new ConexaoBD();
        Connection conexao;
        conexao = con.getInstance().getConnection();
        String sql = "insert into moeda (moeda_id,moeda,singular,plural,simbolo) values (NULL,?,?,?,?)";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, t.getCod_moeda());
        ps.setString(1, t.getMoeda());
        ps.setString(2, t.getSingular());
        ps.setString(3, t.getPlural());
        ps.setString(4, t.getSimbolo());
        ps.execute();
    }

    public static void alterar(Moeda m) throws ExceptionValidacao, SQLException {
        ConexaoBD con = new ConexaoBD();
        Connection conexao;
        conexao = con.getInstance().getConnection();
        String sql = "update moeda set moeda=?,singular=?,plural=?,simbolo=? where moeda_id=?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, m.getMoeda());
        ps.setString(2, m.getSingular());
        ps.setString(3, m.getPlural());
        ps.setString(4, m.getSimbolo());
        ps.setInt(5, m.getCod_moeda());
        ps.execute();
    }

    public static void excluir(int codigo) throws ExceptionValidacao, SQLException {
        ConexaoBD con = new ConexaoBD();
        Connection conexao;
        conexao = con.getInstance().getConnection();
        String sql = "delete from MOEDA where MOEDA_ID=?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, codigo);
        ps.execute();
    }

    public static ObservableList<Moeda> listar(boolean somenteAtivos) throws ExceptionValidacao, Exception {
        ObservableList<Moeda> lista_de_moedas = FXCollections.observableArrayList();
        ConexaoBD con = new ConexaoBD();
        Connection connetion = con.getInstance().getConnection();
        String sql = "select * from MOEDA";
        PreparedStatement ps = connetion.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Moeda a = new Moeda();
            a.setCod_moeda(rs.getInt("MOEDA_ID"));
            a.setMoeda(rs.getString("MOEDA"));
            a.setSingular(rs.getString("SINGULAR"));
            a.setPlural(rs.getString("PLURAL"));
            a.setSimbolo(rs.getString("SIMBOLO"));
        }
        return lista_de_moedas;
    }

    public static Moeda get(int cod_moeda) throws Exception {
        String SQL = "SELECT * FROM MOEDA WHERE MOEDA_ID =? ";
        ConexaoBD con = new ConexaoBD();
        Connection conexao = con.getInstance().getConnection();
        PreparedStatement ps = conexao.prepareStatement(SQL);
        ps.setInt(1, cod_moeda);
        ResultSet rs = ps.executeQuery();
        Moeda m = new Moeda();
        if (rs.next()) {
            m.setCod_moeda(rs.getInt("MOEDA_ID"));
            m.setMoeda(rs.getString("MOEDA"));
            m.setSingular(rs.getString("SINGULAR"));
            m.setPlural(rs.getString("PLURAL"));
            m.setSimbolo(rs.getString("SIMBOLO"));

        }
        return m;
    }

}
