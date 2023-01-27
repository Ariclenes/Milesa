package com.signcorporation.milesa.model.DAO;

import BD.ConexaoBD;
import MODELO.BEAN.Pessoa;
import MODELO.BEAN.Status;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @author AEM Sign Angola
 */
public class PessoaDAO {
//implements DAO

    public static int salvar(Pessoa p, Connection conexao) throws Exception {
        if (p.getCodPessoa() == 0) {
            inserir(p, conexao);
        } else {
            alterar(p, conexao);
        }
        return p.getCodPessoa();
    }

    private static void inserir(Pessoa p, Connection conexao) throws Exception {
        ConexaoBD con = new ConexaoBD();

        String sql = "insert into pessoa (" + (p.getPessoaFisica() != null ? "codpessoafisica" : "codpessoajuridica") + ",codcidade,nome,endereco,telefone,datacadastro,email,status) values (?,?,?,?,?,?,?,?)";
        conexao = con.getInstance().getConnection();
        PreparedStatement ps = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        if (p.getPessoaFisica() != null) {
            ps.setInt(1, p.getPessoaFisica().getCodPessoaFisica());
        } else {
            ps.setInt(1, p.getPessoaJuridica().getCodPessoaJuridica());
        }
        ps.setInt(2, p.getCidade().getCodCidade());
        ps.setString(3, p.getNome());
        ps.setString(4, p.getEndereco());
        ps.setString(5, p.getTelefone());
        ps.setDate(6, new Date(p.getDataCadastro().getTime()));
        ps.setString(7, p.getEmail());
        ps.setString(8, p.getStatus().getSIGLA());
        ps.execute();

        ResultSet rs = ps.getGeneratedKeys();
        rs.next();
        rs.getInt(1);
    }

    private static void alterar(Pessoa p, Connection conexao) throws Exception {
        ConexaoBD con = new ConexaoBD();
        conexao = con.getInstance().getConnection();
        String sql = "update pessoa set codpessoafisica=?,codpessoajuridica=?,codcidade=?,nome=?,endereco=?,telefone=?,datacadastro=?,email=?,status=? where codpessoa=?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        if (p.getPessoaFisica() != null) {
            ps.setInt(1, p.getPessoaFisica().getCodPessoaFisica());
            ps.setNull(2, Types.INTEGER);
        } else {
            ps.setNull(1, Types.INTEGER);
            ps.setInt(2, p.getPessoaJuridica().getCodPessoaJuridica());
        }
        ps.setInt(3, p.getCidade().getCodCidade());
        ps.setString(4, p.getNome());
        ps.setString(5, p.getEndereco());
        ps.setString(6, p.getTelefone());
        ps.setDate(7, new Date(p.getDataCadastro().getTime()));
        ps.setString(8, p.getEmail());
        ps.setString(9, p.getStatus().getSIGLA());
        ps.setInt(10, p.getCodPessoa());
        ps.execute();

        p.getCodPessoa();
    }

    public static ObservableList<Pessoa> listar(boolean somenteAtivos, boolean clientes, boolean fornecedores, boolean funcionarios, String filtro) throws Exception {
        String sql = "SELECT P.*, C.CODPESSOA AS CLIENTE, FO.CODPESSOA AS FORNECEDOR, FU.CODPESSOA AS FUNCIONARIO ";
        sql += "FROM PESSOA AS P ";
        sql += "LEFT JOIN PESSOAFISICA AS PF ON PF.CODPESSOAFISICA = P.CODPESSOAFISICA ";
        sql += "LEFT JOIN PESSOAJURIDICA AS PJ ON PJ.CODPESSOAJURIDICA = P.CODPESSOAJURIDICA ";
        sql += (clientes ? "INNER" : "LEFT") + " JOIN CLIENTE AS C ON C.CODPESSOA = P.CODPESSOA ";
        sql += (fornecedores ? "INNER" : "LEFT") + " JOIN FORNECEDOR AS FO ON FO.CODPESSOA = P.CODPESSOA ";
        sql += (funcionarios ? "INNER" : "LEFT") + " JOIN FUNCIONARIO AS FU ON FU.CODPESSOA = P.CODPESSOA ";
        sql += " WHERE 1=1 ";
        sql += (somenteAtivos) ? " AND P.STATUS = 'A' " : " ";
        sql += (!filtro.trim().isEmpty()) ? " "
                + "AND (p.nome LIKE ? "
                + "OR replace(replace(PF.BI,'.',''),'-','') = ? "
                + "OR replace(replace(replace(PJ.NIF,'.',''),'-',''),'/','') = ?)" : " ";
        sql += "order by p.nome";
        ConexaoBD con = new ConexaoBD();
        Connection conexao = con.getInstance().getConnection();
        PreparedStatement ps = conexao.prepareStatement(sql);
//        PreparedStatement ps = con.getInstance().getConnection().prepareStatement(sql);
        if (!filtro.trim().isEmpty()) {
            ps.setString(1, "%" + filtro + "%");
            ps.setString(2, filtro.replaceAll("-", "").replaceAll("\\.", ""));
            ps.setString(3, filtro.replaceAll("-", "").replaceAll("\\.", "").replaceAll("/", ""));
        }
        ResultSet rs = ps.executeQuery();
        ObservableList<Pessoa> lista = FXCollections.observableArrayList();

        while (rs.next()) {
            Pessoa p = new Pessoa();
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
            lista.add(p);
        }
        return lista;
    }

    public static Pessoa recuperar(int codigo) throws Exception {
        ConexaoBD c = new ConexaoBD();
        Connection conexao = c.getInstance().getConnection();
        String sql = "SELECT * FROM PESSOA WHERE CODPESSOA=?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, codigo);
        ResultSet rs = ps.executeQuery();
        Pessoa p = new Pessoa();
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
