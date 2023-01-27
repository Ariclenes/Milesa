package com.signcorporation.milesa.model.DAO;

import BD.ConexaoBD;
import MODELO.BEAN.Funcionario;
import java.sql.*;

public class FuncionarioDAO extends PessoaDAO {
    public static void salvar(Funcionario f,Connection conexao) throws Exception {
        if (!existe (f, conexao)) {
            inserir (f, conexao);
        } else {
            alterar(f, conexao);
        }
    }
    public static boolean existe(Funcionario f,Connection conexao) throws Exception {
        String sql = "select count(codpessoa) from funcionario where codpessoa=?";
        ConexaoBD con = new ConexaoBD();
        conexao = con.getInstance().getConnection();
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, f.getCodPessoa());

        ResultSet rs = ps.executeQuery();
        rs.next();
        return (rs.getInt(1) > 0);
    }
    public static void inserir(Funcionario f,Connection conexao) throws Exception {
         ConexaoBD con = new ConexaoBD();
         conexao = con.getInstance().getConnection();
         String sql = "insert into funcionario (codpessoa, data_admissao, data_demissao, USR,PW) values (?,?,?,?,?)";
         PreparedStatement ps = conexao.prepareStatement(sql);
         ps.setInt(1, f.getCodPessoa());
         ps.setDate(2, new Date(f.getDataAdmissao().getTime()));
        if (f.getDataDemissao() != null) {
            ps.setDate(3, new Date(f.getDataDemissao().getTime()));
        } else {
            ps.setNull(3, Types.DATE);
        }
        ps.setString (4, f.getUSR ());
        ps.setString (5, f.getPW ());
        ps.execute();
    }
//

    private static void alterar(Funcionario f,Connection conexao) throws Exception {
        String sql = "update funcionario set data_admissao=?, data_demissao=?,usr=?,pw=? where codpessoa=?";
        ConexaoBD con = new ConexaoBD();
         conexao = con.getInstance().getConnection();
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setDate(1, new Date(f.getDataAdmissao().getTime()));
        if (f.getDataDemissao() != null) {
            ps.setDate(2, new Date(f.getDataAdmissao().getTime()));
        } else {
            ps.setNull(2, Types.DATE);
        }
        ps.setString (3, f.getUSR ());
        ps.setString (4, f.getPW ());
        ps.setInt(5, f.getCodPessoa());
        ps.execute();
    }

    public static void excluir(int codPessoa,Connection conexao) throws Exception {
        String sql = "delete from funcionario where codpessoa=?";
        ConexaoBD con = new ConexaoBD();
        conexao = con.getInstance().getConnection();
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, codPessoa);
        ps.execute();
    }

    public static Funcionario get(int codPessoa,Connection conexao ) throws Exception {

        String sql = "select * from funcionario where codpessoa=? ";
        ConexaoBD con =  new ConexaoBD ();
        conexao = con.getInstance ().getConnection ();

        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, codPessoa);
        ResultSet rs = ps.executeQuery();
        Funcionario fu = null;
        if (rs.next()) {
            fu = new Funcionario();
            fu.setCodPessoa(rs.getInt("codpessoa"));
            fu.setDataAdmissao(rs.getDate("data_admissao"));
            fu.setDataDemissao(rs.getDate("data_demissao"));
            fu.setUSR (rs.getString ("USR"));
            fu.setPW (rs.getString ("PW"));
        }
        return fu;
    }

   
}
