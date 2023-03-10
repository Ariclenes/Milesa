package com.signcorporation.milesa.model.DAO;

import BD.ConexaoBD;
import MODELO.BEAN.Fluxo_caixa;
import MODELO.BEAN.Fluxo_caixa2;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CaixaDAO {

    private Connection connetion;
    private PreparedStatement statement;
    private String sql;
    private ResultSet rs;
    ConexaoBD con = new ConexaoBD();

    public void abrirCaixa() throws ClassNotFoundException, SQLException {
        connetion = con.getInstance().getConnection();

        sql = " insert into SUB_UNIDADE_CAIXA(saldo_atual,data_hora_inicial)values(?,?)";
        statement = connetion.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        statement.setBigDecimal(1, Fluxo_caixa.getSaldo_atual());
        statement.setTimestamp(2, Timestamp.valueOf(Fluxo_caixa.getData_hora_inicial()));
        statement.execute();

        rs = statement.getGeneratedKeys();
        if (rs.next()) {
            Fluxo_caixa.setId_fluxo_caixa(rs.getInt(1));
        }

        rs.close();
        connetion.close();
        statement.close();

    }

    public void fecharCaixa() throws ClassNotFoundException, SQLException {

        connetion = con.getInstance().getConnection();

        sql = "update tb_fluxo_caixa set saldo_final=?, data_hora_final=? where id_fluxo_caixa=?";
        statement = connetion.prepareStatement(sql);
        statement.setBigDecimal(1, Fluxo_caixa.getSaldo_final());
        statement.setTimestamp(2, Timestamp.valueOf(Fluxo_caixa.getData_hora_final()));
        statement.setInt(3, Fluxo_caixa.getId_fluxo_caixa());
        statement.execute();

        connetion.close();
        statement.close();

    }

    public ObservableList<Fluxo_caixa2> listar() throws ClassNotFoundException, SQLException {
        ObservableList<Fluxo_caixa2> lista_caixas = FXCollections.observableArrayList();

        connetion = con.getInstance().getConnection();

        sql = "select * from tb_fluxo_caixa";
        statement = connetion.prepareStatement(sql);

        rs = statement.executeQuery();

        while (rs.next()) {
            lista_caixas.add(new Fluxo_caixa2(rs.getInt("id_fluxo_caixa"), rs.getBigDecimal("saldo_atual"),
                    rs.getTimestamp("data_hora_inicial").toLocalDateTime(),
                    rs.getTimestamp("data_hora_final") != null ?
                            rs.getTimestamp("data_hora_final").toLocalDateTime() : null,
                    rs.getBigDecimal("saldo_final") != null ? rs.getBigDecimal("saldo_final") :
                            BigDecimal.ZERO
            ));
        }

        connetion.close();
        statement.close();

        return lista_caixas;

    }

    public ObservableList<Fluxo_caixa2> pesquisar(int id) throws ClassNotFoundException, SQLException {
        ObservableList<Fluxo_caixa2> lista_caixas = FXCollections.observableArrayList();

        connetion = con.getInstance().getConnection();

        sql = "select * from tb_fluxo_caixa where id_fluxo_caixa=?";
        statement = connetion.prepareStatement(sql);
        statement.setInt(1, id);

        rs = statement.executeQuery();

        while (rs.next()) {
            lista_caixas.add(new Fluxo_caixa2(rs.getInt("id_fluxo_caixa"), rs.getBigDecimal("saldo_atual"),
                    rs.getTimestamp("data_hora_inicial").toLocalDateTime(),
                    rs.getTimestamp("data_hora_final") != null ?
                            rs.getTimestamp("data_hora_final").toLocalDateTime()
                            : null,
                    rs.getBigDecimal("saldo_final") != null ?
                            rs.getBigDecimal("saldo_final") :
                            null));
        }

        connetion.close();
        statement.close();

        return lista_caixas;
    }
}
