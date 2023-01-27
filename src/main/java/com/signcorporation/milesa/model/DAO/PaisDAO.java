package com.signcorporation.milesa.model.DAO;

import BD.ConexaoBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @author AEM Sign
 */
public class PaisDAO {

    public static ObservableList<Paises> listar(boolean somenteAtivos) throws SQLException {
        ObservableList<Paises> lista_pais = FXCollections.observableArrayList();
        String sql = "select * from paises ";
        sql += ((somenteAtivos) ? " where status='A' " : " ");
        sql += " order by nome_pais";
        ConexaoBD con = new ConexaoBD();
        Connection conexao = con.getInstance().getConnection();
        PreparedStatement ps = conexao.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Paises pais = new Paises();
            pais.setCodPais(rs.getInt("CODPAIS"));
            pais.setNome_Pais(rs.getString("NOME_PAIS"));
            pais.setSIGLA(rs.getString("SIGLA"));
            pais.setSIGLA(rs.getString("STATUS"));
            lista_pais.add(pais);
        }
        return lista_pais;
    }

    public static Paises get(int codPais) throws SQLException {
        String SQL = "select * from pais where codpais=? ";
        ConexaoBD con = new ConexaoBD();
        Connection conexao = con.getInstance().getConnection();
        PreparedStatement ps = con.getInstance().getConnection().prepareStatement(SQL);
        ps.setInt(1, codPais);
        ResultSet rs = ps.executeQuery();
        Paises pais = null;
        if (rs.next()) {
            pais = new Paises();
            pais.setCodPais(rs.getInt("CODPAIS"));
            pais.setNome_Pais(rs.getString("NOME_PAIS"));
            pais.setSIGLA(rs.getString("SIGLA"));
            pais.setSIGLA(rs.getString("STATUS"));
        }
        return pais;

    }

}
