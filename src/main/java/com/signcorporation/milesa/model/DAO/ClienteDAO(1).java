package com.signcorporation.milesa.model.DAO;

import BD.ConexaoBD;
import MODELO.BEAN.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author AEM Sign Angola Corporation
 */
public class ClienteDAO {

    public static void salvar(Cliente c, Connection conexao) throws Exception {
        if (!existe(c)) {
            inserir(c, conexao);
        }
    }

    private static boolean existe(Cliente c) throws Exception {

        String sql = "select count(codpessoa) from cliente where codpessoa=?";
        ConexaoBD con = new ConexaoBD();
        Connection conexao = con.getInstance ().getConnection ();
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, c.getCodPessoa());
        ResultSet rs = ps.executeQuery();
        rs.next();
        return (rs.getInt(1) > 0);
    }

    private static void inserir(Cliente p, Connection conexao) throws Exception {
        ConexaoBD con = new ConexaoBD ();
        conexao = con.getInstance ().getConnection ();
        String sql = "insert into cliente (codpessoa) values (?)";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, p.getCodPessoa());
        ps.execute();
    }

    public static void excluir(int codPessoa, Connection conexao) throws Exception {
        ConexaoBD con = new ConexaoBD ();
        conexao = con.getInstance ().getConnection ();
        String sql = "delete from cliente where codpessoa=?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, codPessoa);
        ps.execute();
    }
}
