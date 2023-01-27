/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.signcorporation.milesa.model.DAO;

import BD.ConexaoBD;
import MODELO.BEAN.ProdutoEstoque;
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
public class ProdutoEstoqueDAO implements CRUD<ProdutoEstoque> {
    ConexaoBD con = new ConexaoBD();
    private PreparedStatement statement;
    private Connection connetion = con.getInstance().getConnection();

    private String sql;
    private ResultSet rs;

    @Override
    public void guardar(ProdutoEstoque t) throws ExceptionValidacao, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean existe(ProdutoEstoque t) throws ExceptionValidacao, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void inserir(ProdutoEstoque t) throws ExceptionValidacao, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(ProdutoEstoque t) throws ExceptionValidacao, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(int codigo) throws ExceptionValidacao, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObservableList<ProdutoEstoque> listar(boolean somenteAtivos) throws ExceptionValidacao, Exception {
        ObservableList<ProdutoEstoque> lista_unidade_medida = FXCollections.observableArrayList();

        connetion = con.getInstance().getConnection();

        sql = "select * from PRODUTO_ESTOQUE";

        statement = connetion.prepareStatement(sql);

        rs = statement.executeQuery();
        ProdutoEstoque stock;
        while (rs.next()) {
            stock = new ProdutoEstoque();
            stock.setCODIGO(rs.getInt("CODIGO"));
            stock.setCOD_PRODUTO(ProdutoDAO.get(rs.getInt("COD_PRODUTO")));
            stock.setQTD(rs.getInt("DESCRICAO"));
            stock.setStatus(Status.get(rs.getString("STATUS")));
            lista_unidade_medida.add(stock);
        }

        connetion.close();
        statement.close();
        rs.close();

        return lista_unidade_medida;
    }

    public static ProdutoEstoque get(int codTipo) throws Exception {

        String sql = "select * from PRODUTO_ESTOQUE where codigo=? ";
        ConexaoBD con = new ConexaoBD();
        Connection conexao = con.getInstance().getConnection();
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, codTipo);
        ResultSet rs = ps.executeQuery();
        ProdutoEstoque stock = null;
        if (rs.next()) {
            stock = new ProdutoEstoque();
            stock.setCODIGO(rs.getInt("CODIGO"));
            stock.setCOD_PRODUTO(ProdutoDAO.get(rs.getInt("COD_PRODUTO")));
            stock.setQTD(rs.getInt("QTD"));
            stock.setStatus(Status.get(rs.getString("STATUS")));

        }
        return stock;
    }

    public static void entradaEstoque(Connection conexao, int codigo, int quantidade) throws Exception {
        ConexaoBD c = new ConexaoBD();
        conexao = c.getInstance().getConnection();
        String sql = "UPDATE PRODUTO SET STOCK_ATUAL= STOCK_ATUAL  + ? WHERE COD_PRODUTO=?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, quantidade);
        ps.setInt(2, codigo);
        ps.execute();
    }

    public static void saidaEstoque(Connection conexao, int codigo, int quantidade) throws Exception {
        ConexaoBD c = new ConexaoBD();
        conexao = c.getInstance().getConnection();
        String sql = "UPDATE PRODUTO SET STOCK_ATUAL= STOCK_ATUAL  - ? WHERE COD_PRODUTO=?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, quantidade);
        ps.setInt(2, codigo);
        ps.execute();
    }

}




