package com.signcorporation.milesa.model.DAO;

import BD.ConexaoBD;
import MODELO.BEAN.Departamento;
import MODELO.UTILS.ExceptionValidacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @author AEM Sign corp
 */
public class DepartamentoDAO implements CRUD<Departamento> {
    ConexaoBD con = new ConexaoBD();
    Connection conexao = con.getInstance().getConnection();

    //  PreparedStatement ps;
    @Override
    public void guardar(Departamento p) throws ExceptionValidacao, SQLException {
        if (p.getCodigo() == 0) {
            if (existe(p)) {
                throw new ExceptionValidacao("A Produto já está cadastrada");
            }
            inserir(p);
        } else {
            alterar(p);
        }
    }

    @Override
    public boolean existe(Departamento t) throws ExceptionValidacao, SQLException {
        String sql = "SELECT COUNT(CODIGO) FROM DEPARTAMENTO WHERE CODIGO=?";
//       codigo int(11) AI PK 
//DEPARTAMENTO
        ConexaoBD con = new ConexaoBD();
//       Connection conexao = con.getInstance().getConnection();
        PreparedStatement ps = conexao.prepareStatement(sql);

        ps.setString(1, t.getDepartamento());
//        ps.setString(2, t.getNOME_ARTIGO());

        ResultSet rs = ps.executeQuery();
        rs.next();
        return (rs.getInt(1) > 0);
    }

    @Override
    public void inserir(Departamento t) throws ExceptionValidacao, SQLException {
        String SQL = "INSERT INTO PRODUTO (DEFAULT,DEPARTAMENTO)values (?,?)";
        try {
//            ConexaoBD con = new ConexaoBD();
//            Connection conexao = con.getInstance().getConnection();
            PreparedStatement ps = conexao.prepareStatement(SQL);
            ps.setString(1, t.getDepartamento());
            ps.execute();
//          connetion.close();
            ps.close();

        } catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void alterar(Departamento t) throws ExceptionValidacao, SQLException {
        String sql = "UPDATE PRODUTO SET DEPARTAMENTO=?  WHERE CODPRODUTO=?";

        PreparedStatement ps = conexao.prepareStatement(sql);
//     ps.setString(1, p.getCODBARRA ());
        ps.setString(2, t.getDepartamento());
        ps.setString(12, t.getStatus().getSIGLA());
        ps.setInt(14, t.getCodigo());
        ps.execute();
        con.confirmar();
    }

    @Override
    public void excluir(int codigo) throws ExceptionValidacao, SQLException {
        PreparedStatement ps = conexao.prepareStatement("DELETE FROM DEPARTAMENTO WHERE CODPRODUTO=?");
        ps.setInt(1, codigo);
        ps.execute();
        ps.close();
    }

    @Override
    public ObservableList<Departamento> listar(boolean somenteAtivos) throws ExceptionValidacao, Exception {
        ObservableList<Departamento> LISTAR_PRODUTOS = FXCollections.observableArrayList();
        String SQL = "SELECT * FROM DEPARTAMENTO";
//            SQL+= ((somenteAtivos) ? " WHERE status='A' " : " ");
//            SQL += "ORDER BY NOME_PRODUTO LIMIT 100";
        PreparedStatement ps = conexao.prepareStatement(SQL);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Departamento p = new Departamento();
            p.setCodigo(rs.getInt("CODIGO"));
            p.setDepartamento(rs.getString("DEPARTAMENTO"));
            LISTAR_PRODUTOS.add(p);
        }
        return LISTAR_PRODUTOS;
    }

    public static Departamento get(int codPessoa) throws Exception {
        String sql = "select * from DEPARTAMENTO where CODIGO=? ";
        ConexaoBD con = new ConexaoBD();
        Connection conexao = con.getInstance().getConnection();
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, codPessoa);
        ResultSet rs = ps.executeQuery();
        Departamento fu = null;
        if (rs.next()) {
            fu = new Departamento();
            fu.setCodigo(rs.getInt("CODIGO"));
            fu.setDepartamento(rs.getString("DEPARTAMENTO"));
        }
        return fu;
    }
}
