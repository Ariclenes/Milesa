package com.signcorporation.milesa.model.DAO;

import BD.ConexaoBD;
import MODELO.BEAN.Cidade;
import MODELO.BEAN.Provincia;
import MODELO.BEAN.Status;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @author AEM Sign Corporation
 * @version 1.3
 */
public class CidadeDAO {

    public static Cidade get(int codCidade) throws Exception {
        String sql = "SELECT * FROM CIDADE WHERE CODCIDADE=? ";
        ConexaoBD con = new ConexaoBD();
        Connection conexao = con.getInstance().getConnection();
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, codCidade);
        ResultSet rs = ps.executeQuery();
        Cidade cidade = cidade = new Cidade();
        if (rs.next()) {
            cidade.setCodCidade(rs.getInt("CODCIDADE"));
            cidade.setProvincia(ProvinciaDAO.get(rs.getInt("CODPROVINCIA")));
            cidade.setNome(rs.getString("NOME_CIDADE"));
            cidade.setStatus(Status.get(rs.getString("STATUS")));
        }
        return cidade;
    }

    public static ObservableList<Cidade> listar(boolean somenteAtivos, Provincia provincia) throws Exception {
        String sql = "select * from cidade ";
        sql += " where codprovincia=?";
        sql += ((somenteAtivos) ? " and status='A' " : " ");
        sql += " order by nome_cidade";
        ConexaoBD con = new ConexaoBD();
        Connection conexao = con.getInstance().getConnection();
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, provincia.getCodProvincia());
        ResultSet rs = ps.executeQuery();
        ObservableList<Cidade> lista = FXCollections.observableArrayList();
        while (rs.next()) {
            Cidade cidade = new Cidade();
            cidade.setCodCidade(rs.getInt("codcidade"));
            cidade.setNome(rs.getString("nome_cidade"));
            cidade.setProvincia(ProvinciaDAO.get(rs.getInt("codprovincia")));
            cidade.setStatus(rs.getString("status"));
            lista.add(cidade);

        }
        System.out.println("A Lista" + lista);
        return lista;

    }

    public static ObservableList<Cidade> lista(boolean SomenteAtivos, Provincia provincia) throws Exception {
        ObservableList<Cidade> lista = FXCollections.observableArrayList();
        String sql = "select * from cidade";
        sql += " where codprovincia=?";
        sql += ((SomenteAtivos) ? " where status='A' " : " ");
        ConexaoBD con = new ConexaoBD();
        Connection conexao = con.getInstance().getConnection();
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, provincia.getCodProvincia());
        ResultSet rs = ps.executeQuery();
//		Cidade U = null;
        while (rs.next()) {
            Cidade cidade = new Cidade();
            cidade.setCodCidade(rs.getInt("codcidade"));
            cidade.setNome(rs.getString("nome_cidade"));
            cidade.setProvincia(ProvinciaDAO.get(rs.getInt("codprovincia")));
            cidade.setStatus(rs.getString("status"));
            lista.add(cidade);
        }

        return lista;
    }

}