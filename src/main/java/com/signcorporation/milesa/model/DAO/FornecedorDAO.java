package com.signcorporation.milesa.model.DAO;

//

import BD.ConexaoBD;
import MODELO.BEAN.Fornecedor;
import MODELO.BEAN.Pessoa;
import MODELO.BEAN.Status;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FornecedorDAO extends Pessoa {
    ConexaoBD con = new ConexaoBD();
    Connection conexao = con.getInstance().getConnection();

    public static void salvar(Fornecedor f, Connection conexao) throws Exception {
        if (!existe(f, conexao)) {
            inserir(f, conexao);
        }
    }

    private static boolean existe(Fornecedor f, Connection conexao) throws Exception {
        ConexaoBD con = new ConexaoBD();
        conexao = con.getInstance().getConnection();
        String sql = "select count(codpessoa) from fornecedor where codpessoa=?";

        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, f.getCodPessoa());
        ResultSet rs = ps.executeQuery();
        rs.next();
        return (rs.getInt(1) > 0);
    }

    private static void inserir(Fornecedor f, Connection conexao) throws Exception {
        String sql = "insert into fornecedor (codpessoa) values (?)";
        ConexaoBD con = new ConexaoBD();
        conexao = con.getInstance().getConnection();
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, f.getCodPessoa());
        ps.execute();
    }

    public static void excluir(int codPessoa, Connection conexao) throws Exception {
        String sql = "delete from fornecedor where codpessoa=?";
        ConexaoBD con = new ConexaoBD();
        conexao = con.getInstance().getConnection();
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, codPessoa);
        ps.execute();
    }

    public static Fornecedor recuperar(int codigo) throws Exception {
        ConexaoBD c = new ConexaoBD();
        Connection conexao = c.getInstance().getConnection();
        String sql = "SELECT * FROM PESSOA WHERE CODPESSOA=?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, codigo);
        ResultSet rs = ps.executeQuery();
        Fornecedor p = new Fornecedor();
        while (rs.next()) {

            p.setCodPessoa(rs.getInt("codpessoa"));
            if (rs.getInt("codpessoafisica") != 0) {
                p.setPessoaFisica(PessoaFisicaDAO.get(rs.getInt("codpessoafisica")));
            } else {
                p.setPessoaJuridica(PessoaJuridicaDAO.get(rs.getInt("codpessoajuridica")));
            }
            p.setCidade(CidadeDAO.get(rs.getInt("codcidade")));
            p.setCliente(rs.getInt("cliente") != 0);
            p.setFornecedor(rs.getInt("fornecedor") != 0);
            p.setFuncionario(rs.getInt("funcionario") != 0);
            p.setNome(rs.getString("nome"));
            p.setEndereco(rs.getString("endereco"));
            p.setEmail(rs.getString("email"));
            p.setTelefone(rs.getString("telefone"));
            p.setDataCadastro(rs.getDate("datacadastro"));
            p.setStatus(Status.get(rs.getString("status")));

        }

        return p;
    }
}
