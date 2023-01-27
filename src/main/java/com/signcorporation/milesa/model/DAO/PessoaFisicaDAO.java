package com.signcorporation.milesa.model.DAO;

import BD.ConexaoBD;
import MODELO.BEAN.PessoaFisica;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author AEM SIGN
 */
public class PessoaFisicaDAO {

    public static int salvar(PessoaFisica pf, Connection conexao) throws Exception {
        if (existe(pf)) {
            throw new Exception("Nif já cadastrado.");
        }
        if (pf.getCodPessoaFisica() == 0) {
            return inserir(pf, conexao);
        } else {
            return alterar(pf, conexao);
        }
    }

    private static boolean existe(PessoaFisica pf) throws Exception {

        String sql = "select count(codpessoafisica) from pessoafisica where BI=? AND NIF=? and codpessoafisica<>?";
        ConexaoBD c = new ConexaoBD();

        PreparedStatement ps = c.getInstance().getConnection().prepareStatement(sql);
        ps.setString(1, pf.getBI());
        ps.setString(2, sql);
        ps.setInt(3, pf.getCodPessoaFisica());

        ResultSet rs = ps.executeQuery();
        rs.next();
        return (rs.getInt(1) > 0);
    }

    private static int inserir(PessoaFisica pf, Connection conexao) throws Exception {
        ConexaoBD con = new ConexaoBD();
        conexao = con.getInstance().getConnection();
        String sql = "insert into pessoafisica (BI,NIF,datanascimento) values (?,?,?)";
        PreparedStatement ps = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        ps.setString(1, pf.getBI());
        ps.setString(2, pf.getNIF());
        ps.setDate(3, new Date(pf.getDataNascimento().getTime()));
        ps.execute();

        ResultSet rs = ps.getGeneratedKeys();
        rs.next();
        return rs.getInt(1);
    }

    private static int alterar(PessoaFisica pf, Connection conexao) throws Exception {
        ConexaoBD con = new ConexaoBD();
        conexao = con.getInstance().getConnection();
        String sql = "update pessoafisica set BI=?,NIF=?,datanascimento=? where codpessoafisica=?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, pf.getBI());
        ps.setString(2, pf.getNIF());
        ps.setDate(3, new Date(pf.getDataNascimento().getTime()));
        ps.setInt(4, pf.getCodPessoaFisica());
        ps.execute();

        return pf.getCodPessoaFisica();
    }

    public static int excluir(int codPessoaFisica, Connection conexao) throws Exception {
        ConexaoBD con = new ConexaoBD();
        conexao = con.getInstance().getConnection();
        String sql = "delete from pessoafisica where codpessoafisica=?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, codPessoaFisica);
        ps.execute();

        return 0;
    }

    public static PessoaFisica get(int codPessoaFisica) throws Exception {

        String sql = "select * from pessoafisica where codpessoafisica=? ";
        ConexaoBD con = new ConexaoBD();
        PreparedStatement ps = con.getConnection().prepareStatement(sql);
        ps.setInt(1, codPessoaFisica);
        ResultSet rs = ps.executeQuery();
        PessoaFisica pf = null;
        if (rs.next()) {
            pf = new PessoaFisica();
            pf.setCodPessoaFisica(rs.getInt("codpessoafisica"));
            pf.setBI(rs.getString("BI"));
            pf.setNIF(rs.getString("NIF"));
            pf.setDataNascimento(rs.getDate("dataNascimento"));
        }

        return pf;
    }
}
