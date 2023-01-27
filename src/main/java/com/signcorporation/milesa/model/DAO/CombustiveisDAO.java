package com.signcorporation.milesa.model.DAO;

import BD.ConexaoBD;
import MODELO.BEAN.Bico;
import MODELO.BEAN.Combustivel;
import MODELO.UTILS.ExceptionValidacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CombustiveisDAO implements CRUD<Combustivel> {
    private Connection connection;
    private String sql;
    private PreparedStatement ps;
    private ResultSet rs;
    private ResultSet rs2;
    private ResultSet rs3;
    private ResultSet rs4;
    private ResultSet rs5;
    private ObservableList<Combustivel> listaCombustiveis;
    ConexaoBD con = new ConexaoBD();
    private int id_combustivel;
    private int id_tipoCombustivel;

    @Override
    public void guardar(Combustivel t) throws ExceptionValidacao, SQLException {
        if (t.getId_combustivel() == 0) {
            if (existe(t)) {
                throw new ExceptionValidacao("A Categoria já está cadastrada");
            }
            inserir(t);
        } else {
            alterar(t);
        }
    }

    @Override
    public boolean existe(Combustivel t) throws ExceptionValidacao, SQLException {
        String sql = "SELECT COUNT(CODIGO) FROM PRODUTO_CATEGORIA WHERE NOME=?, DESCRICAO=?, COR=? and STATUS=?";
        ConexaoBD c = new ConexaoBD();
        PreparedStatement ps = c.getInstance().getConnection().prepareStatement(sql);
        ps.setString(1, t.getBico().getDescricao());
        ps.setString(2, t.getDescricao());
        ps.setBigDecimal(4, t.getPreco_venda());
//        ps.setString(5, t.getStatus().getDescricao());
        ResultSet rs = ps.executeQuery();
        rs.next();
        return (rs.getInt(1) > 0);
    }

    @Override
    public void inserir(Combustivel Combustivel) throws ExceptionValidacao, SQLException {
        // TODO Auto-generated method stub

        // prepara conexão
        connection = con.getInstance().getConnection();

        // ADICIONA PESSOA
        sql = "insert into tb_combustivel(id_tipo_combustivel_fk, id_bomba_fk, id_bico_fk, descricao, preco_venda)values(?,?,?,?,?)";

        // chama a conexão e retorna id
        ps = connection.prepareStatement(sql);
        ps.setInt(1, Combustivel.getTipoCombustivel().getId_tipo_combustivel());
        ps.setInt(2, Combustivel.getBomba().getId_bomba());
        ps.setInt(3, Combustivel.getBico().getId_bico());
        ps.setString(4, Combustivel.getDescricao());
        ps.setBigDecimal(5, Combustivel.getPreco_venda());
        ps.execute();

        ps.close();
        connection.close();
    }

    @Override
    public void alterar(Combustivel Combustivel) throws SQLException, ExceptionValidacao {

        // prepara conexão
        connection = con.getInstance().getConnection();

        // ADICIONA PESSOA
        sql = "update tb_combustivel set id_tipo_combustivel_fk=?, id_bomba_fk=?, id_bico_fk=?, descricao=?, preco_venda=? where id_combustivel=?";

        // chama a conexão e retorna id
        ps = connection.prepareStatement(sql);
        ps.setInt(1, Combustivel.getTipoCombustivel().getId_tipo_combustivel());
        ps.setInt(2, Combustivel.getBomba().getId_bomba());
        ps.setInt(3, Combustivel.getBico().getId_bico());
        ps.setString(4, Combustivel.getDescricao());
        ps.setBigDecimal(5, Combustivel.getPreco_venda());
        ps.setInt(6, Combustivel.getId_combustivel());
        ps.execute();

        ps.close();
        connection.close();

    }

    @Override
    public void excluir(int codigo) throws ExceptionValidacao, SQLException {
        // TODO Auto-generated method stub
        connection = con.getInstance().getConnection();

        sql = "delete from tb_combustivel where id_combustivel=?";

        ps = connection.prepareStatement(sql);
        ps.setInt(1, codigo);
        ps.execute();

        connection.close();
        ps.close();

    }

    @Override
    public ObservableList<Combustivel> listar(boolean SomenteAtivos) throws ExceptionValidacao, SQLException {
        // TODO Auto-generated method stub

        listaCombustiveis = FXCollections.observableArrayList();

        connection = con.getInstance().getConnection();

        // combustivel
        sql = "SELECT * FROM tb_combustivel combustivel inner join tb_tipo_combustivel tipo on(combustivel.id_tipo_combustivel_fk = tipo.id_tipo_combustivel)";
        ps = connection.prepareStatement(sql);

        rs = ps.executeQuery();
        while (rs.next()) {

            sql = "select * from tb_unidade_medida where id_unidade_medida=?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, rs.getInt("id_unidade_medida_fk"));
            rs2 = ps.executeQuery();
            rs2.next();

            sql = "select * from tb_bomba where id_bomba=?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, rs.getInt("id_bomba_fk"));
            rs3 = ps.executeQuery();
            rs3.next();

            sql = "select * from tb_bico where id_bico=?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, rs.getInt("id_bico_fk"));
            rs4 = ps.executeQuery();
            rs4.next();

            sql = "select * from tb_bico where id_bomba_fk=?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, rs.getInt("id_bomba_fk"));
            rs5 = ps.executeQuery();

            ObservableList<Bico> lista_bicos = FXCollections.observableArrayList();

            while (rs5.next()) {
                lista_bicos.add(new Bico(rs5.getInt("id_bico"), rs5.getInt("id_bomba_fk"), rs5.getString("descricao")));
            }

//			listaCombustiveis.add(
//					new Combustivel(rs.getInt("id_combustivel"),
//							
//					new Tipo_combustivel(rs.getInt("id_tipo_combustivel"), 
//					new Unidade_medida(rs2.getInt("id_unidade_medida"), rs2.getString("nome")),
//					rs.getString("nome"), rs.getBigDecimal("quantidade"), rs.getBigDecimal("estoque_maximo"), rs.getBigDecimal("estoque_minimo")),
//					
//					new Bomba(rs3.getInt("id_bomba"), rs3.getString("descricao"), lista_bicos),
//					new Bico(rs4.getInt("id_bico"), rs4.getInt("id_bomba_fk"), rs4.getString("descricao")),
//					rs.getString("descricao"), rs.getBigDecimal("preco_venda"))); 
//			

            rs2.close();
            rs3.close();
            rs4.close();
            rs5.close();

        }
        connection.close();
        ps.close();
        rs.close();

        return listaCombustiveis;
    }

    public ObservableList<Combustivel> pesquisar(int id) throws ClassNotFoundException, SQLException {
        // TODO Auto-generated method stub

        listaCombustiveis = FXCollections.observableArrayList();

        connection = con.getInstance().getConnection();

        // combustivel
        sql = "SELECT * FROM tb_combustivel combustivel inner join tb_tipo_combustivel tipo on(combustivel.id_tipo_combustivel_fk = tipo.id_tipo_combustivel) where id_combustivel=?";
        ps = connection.prepareStatement(sql);
        ps.setInt(1, id);

        rs = ps.executeQuery();
        while (rs.next()) {

            sql = "select * from tb_unidade_medida where id_unidade_medida=?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, rs.getInt("id_unidade_medida_fk"));
            rs2 = ps.executeQuery();
            rs2.next();

            sql = "select * from tb_bomba where id_bomba=?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, rs.getInt("id_bomba_fk"));
            rs3 = ps.executeQuery();
            rs3.next();

            sql = "select * from tb_bico where id_bico=?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, rs.getInt("id_bico_fk"));
            rs4 = ps.executeQuery();
            rs4.next();

            sql = "select * from tb_bico where id_bomba_fk=?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, rs.getInt("id_bomba_fk"));
            rs5 = ps.executeQuery();

            ObservableList<Bico> lista_bicos = FXCollections.observableArrayList();

            while (rs5.next()) {
                lista_bicos.add(new Bico(rs5.getInt("id_bico"), rs5.getInt("id_bomba_fk"), rs5.getString("descricao")));
            }

//			listaCombustiveis.add(
//					new Combustivel(rs.getInt("id_combustivel"),
//							
//					new Tipo_combustivel(rs.getInt("id_tipo_combustivel"), 
//					new Unidade_medida(rs2.getInt("id_unidade_medida"), rs2.getString("nome")),
//					rs.getString("nome"), rs.getBigDecimal("quantidade"), rs.getBigDecimal("estoque_maximo"), rs.getBigDecimal("estoque_minimo")),
//					
//					new Bomba(rs3.getInt("id_bomba"), rs3.getString("descricao"), lista_bicos),
//					new Bico(rs4.getInt("id_bico"), rs4.getInt("id_bomba_fk"), rs4.getString("descricao")),
//					rs.getString("descricao"), rs.getBigDecimal("preco_venda"))); 
//			

            rs2.close();
            rs3.close();
            rs4.close();
            rs5.close();

        }
        connection.close();
        ps.close();
        rs.close();

        return listaCombustiveis;
    }

}