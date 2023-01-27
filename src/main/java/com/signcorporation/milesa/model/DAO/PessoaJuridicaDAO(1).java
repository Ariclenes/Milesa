package com.signcorporation.milesa.model.DAO;

import BD.ConexaoBD;
import MODELO.BEAN.PessoaJuridica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author AEM SIGN Angola Corporation
 */
public class PessoaJuridicaDAO {

    public static int salvar(PessoaJuridica pj, Connection conexao) throws Exception {

        if (existe(pj)) {
            throw new Exception("NIF de Empresa já cadastrado.");
        }

        if (pj.getCodPessoaJuridica() == 0) {
            return inserir(pj, conexao);
        } else {
            return alterar(pj, conexao);
        }
    }

    private static boolean existe(PessoaJuridica pj) throws Exception {
       

        String sql = "select count(codpessoajuridica) from pessoajuridica where nif=? and codpessoajuridica<>?";
        ConexaoBD c = new ConexaoBD();
        PreparedStatement ps = c.getInstance().getConnection().prepareStatement(sql);
        ps.setString(1, pj.getNIF_EMPRESA ());
        ps.setInt(2, pj.getCodPessoaJuridica());

        ResultSet rs = ps.executeQuery();
        rs.next();
        return (rs.getInt(1) > 0);

    }

    private static int inserir(PessoaJuridica pj, Connection conexao) throws Exception {
         ConexaoBD con = new ConexaoBD ();
        conexao = con.getInstance ().getConnection ();
        String sql = "insert into pessoajuridica (nif,ie,razaosocial) values (?,?,?)";
        PreparedStatement ps = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        ps.setString(1, pj.getNIF_EMPRESA ());
        ps.setString(2, pj.getIe());
        ps.setString(3, pj.getRazaoSocial());
        ps.execute();

        ResultSet rs = ps.getGeneratedKeys();
        rs.next();
        return rs.getInt(1);
//        return 0;
    }

    private static int alterar(PessoaJuridica pj, Connection conexao) throws Exception {
        ConexaoBD con = new ConexaoBD ();
        conexao = con.getInstance ().getConnection ();
        String sql = "update pessoajuridica set nif=?,ie=?,razaosocial=? where codpessoajuridica=?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, pj.getNIF_EMPRESA ());
        ps.setString(2, pj.getIe());
        ps.setString(3, pj.getRazaoSocial());
        ps.setInt(4, pj.getCodPessoaJuridica());
        ps.execute();

        return pj.getCodPessoaJuridica();
      
    }

    public static int excluir(int codPessoaJuridica, Connection conexao) throws Exception {
        ConexaoBD con = new ConexaoBD ();
        conexao = con.getInstance ().getConnection ();
                
        String sql = "delete from pessoajuridica where codpessoajuridica=?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, codPessoaJuridica);
        ps.execute();

        return 0;
    }

    public static PessoaJuridica get(int codPessoaJuridica) throws Exception {
            String sql = "select * from pessoajuridica where codpessoajuridica=? ";
            ConexaoBD con = new ConexaoBD ();
//        conexao = con.getInstance ().getConnection ();
            PreparedStatement ps = con.getInstance().getConnection().prepareStatement(sql);
            ps.setInt(1, codPessoaJuridica);
            ResultSet rs = ps.executeQuery();
            PessoaJuridica pj = null;
        if (rs.next()) {
            pj = new PessoaJuridica();
            pj.setCodPessoaJuridica(rs.getInt("codpessoajuridica"));
            pj.setNIF (rs.getString("NIF"));
            pj.setIe(rs.getString("IE"));
            pj.setRazaoSocial(rs.getString("RAZAOSOCIAL"));
        }

        return pj;
    }
}
