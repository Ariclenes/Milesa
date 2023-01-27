/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.signcorporation.milesa.model.DAO;

import BD.ConexaoBD;
import MODELO.BEAN.EmpresaM;
import MODELO.UTILS.ExceptionValidacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @author Hacker PC
 */
public class EmpresaDAO {
    public static int guardar(EmpresaM t, Connection c) throws ExceptionValidacao, SQLException {
        if (t.getCodEmpresa() == 0) {
            inserir(t, c);
        } else {
            alterar(t, c);
        }
        return t.getCodEmpresa();
    }

    public boolean existe(EmpresaM t, Connection conexao) throws ExceptionValidacao, SQLException {
        String sql = "select count(COD_UNIDADE) from UNIDADE where COD_UNIDADE=?";
        ConexaoBD con = new ConexaoBD();
        conexao = con.getInstance().getConnection();
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, t.getCodEmpresa());
//        ps.setInt(1, t.getCodEmpresa ());
        ps.setString(1, t.getNome_empresa());
        ps.setString(2, t.getDescricao_empresa());
        ps.setString(3, t.getResponsavel());
        ps.setString(4, t.getNif());
        ps.setString(5, t.getMorada());
        ps.setString(6, t.getTelefone());
        ps.setString(7, t.getFax());
        ps.setString(8, t.getCod_postal());
        ps.setString(9, t.getEmail());
        ps.setString(10, t.getLogo_marca());
        ps.setInt(11, t.getCidade().getCodCidade());
        ps.setInt(12, t.getMoeda().getCod_moeda());
        ResultSet rs = ps.executeQuery();
        rs.next();
        return (rs.getInt(1) > 0);
    }

    public static void inserir(EmpresaM t, Connection conexao) throws ExceptionValidacao, SQLException {
        ConexaoBD con = new ConexaoBD();
        conexao = con.getInstance().getConnection();
        String sql = "insert into cliente (codpessoa) values (?)";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, t.getCodEmpresa());
        ps.setString(1, t.getNome_empresa());
        ps.setString(2, t.getDescricao_empresa());
        ps.setString(3, t.getResponsavel());
        ps.setString(4, t.getNif());
        ps.setString(5, t.getMorada());
        ps.setString(6, t.getTelefone());
        ps.setString(7, t.getFax());
        ps.setString(8, t.getCod_postal());
        ps.setString(9, t.getEmail());
        ps.setString(10, t.getLogo_marca());
        ps.setInt(11, t.getCidade().getCodCidade());
        ps.setInt(12, t.getMoeda().getCod_moeda());

        ps.execute();
    }

    public static void alterar(EmpresaM t, Connection conexao) throws ExceptionValidacao, SQLException {
        ConexaoBD con = new ConexaoBD();

        conexao = con.getInstance().getConnection();

        String sql = "update UNIDADE set NOME_UNIDADE=?, DESCRICAO=?"
                + " RESPONSAVEL=?,NIF=?,MORADA=?,TELF=?,FAX=?,CP=?,E_MAIL=?,LOGO_EMPRESA=?,PROVINCIA_ID=?,CIDADE_ID=?,IVA_INSESAO_ID=?,INSS=? where COD_UNIDADE=?";
        PreparedStatement ps = conexao.prepareStatement(sql);

        ps.setString(1, t.getNome_empresa());
        ps.setString(2, t.getDescricao_empresa());
        ps.setString(3, t.getResponsavel());
        ps.setString(4, t.getNif());
        ps.setString(5, t.getMorada());
        ps.setString(6, t.getTelefone());
        ps.setString(7, t.getFax());
        ps.setString(8, t.getCod_postal());
        ps.setString(9, t.getEmail());
        ps.setString(10, t.getLogo_marca());
        ps.setInt(11, t.getCidade().getCodCidade());
        ps.setInt(12, t.getMoeda().getCod_moeda());
        ps.setInt(13, t.getCodEmpresa());
        ps.execute();
        conexao.close();
        ps.close();
    }

    public void excluir(int codigo) throws ExceptionValidacao, SQLException {
        ConexaoBD con = new ConexaoBD();
        Connection conexao;
        conexao = con.getInstance().getConnection();
        String sql = "delete from unidade where cod_unidade=?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, codigo);
        ps.execute();
    }

    public ObservableList<EmpresaM> listar(boolean somenteAtivos) throws ExceptionValidacao, Exception {
        ObservableList<EmpresaM> lista_de_empresas = FXCollections.observableArrayList();
        ConexaoBD con = new ConexaoBD();
        Connection conexao = con.getInstance().getConnection();

        String sql = "select * from UNIDADE";

        PreparedStatement ps = conexao.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            EmpresaM e = new EmpresaM();
            e.setCodEmpresa(rs.getInt("COD_UNIDADE"));
            e.setNome_empresa(rs.getString("NOME_UNIDADE"));
            e.setDescricao_empresa(rs.getString("DESCRICAO"));
            e.setResponsavel(rs.getString("RESPONSAVEL"));
            e.setNif(rs.getString("NIF"));
            e.setMorada(rs.getString("MORADA"));
            e.setTelefone(rs.getString("TELF"));
            e.setFax(rs.getString("FAX"));
            e.setCod_postal(rs.getString("CP"));
            e.setEmail(rs.getString("E_MAIL"));
            e.setLogo_marca(rs.getString("LOGO_EMPRESA"));
            e.setRegime_tributario(RegimeIVADAO.get(rs.getInt("IVA_INSESAO_ID")));
//                                        e.setBairro (rs.getString("BAIRRO"));
            e.setInss(rs.getString("INSS"));
            e.setCidade(CidadeDAO.get(rs.getInt("CIDADE_ID")));
            e.setMoeda(MoedaDAO.get(rs.getInt("MOEDA_ID")));
            e.setSite(rs.getString("SITE"));
            e.setPermitir_exclir(rs.getBoolean("PERMITIR_APAGAR"));
            lista_de_empresas.add(e);
        }
        return lista_de_empresas;
    }

    public static EmpresaM get(int codEmpresa) throws Exception {
        String SQL = "SELECT * FROM UNIDADE WHERE COD_UNIDADE=? ";
        ConexaoBD con = new ConexaoBD();
        Connection conexao = con.getInstance().getConnection();
        PreparedStatement ps = conexao.prepareStatement(SQL);
        ps.setInt(1, codEmpresa);
        ResultSet rs = ps.executeQuery();
        EmpresaM e = new EmpresaM();
        if (rs.next()) {
            e.setCodEmpresa(rs.getInt("COD_UNIDADE"));
            e.setNome_empresa(rs.getString("NOME_UNIDADE"));
            e.setDescricao_empresa(rs.getString("DESCRICAO"));
            e.setResponsavel(rs.getString("RESPONSAVEL"));
            e.setNif(rs.getString("NIF"));
            e.setMorada(rs.getString("MORADA"));
            e.setTelefone(rs.getString("TELF"));
            e.setFax(rs.getString("FAX"));
            e.setCod_postal(rs.getString("CP"));
            e.setEmail(rs.getString("E_MAIL"));
            e.setLogo_marca(rs.getString("LOGO_EMPRESA"));
            e.setRegime_tributario(RegimeIVADAO.get(rs.getInt("IVA_INSESAO_ID")));
//                                        e.setBairro (rs.getString("BAIRRO"));
            e.setInss(rs.getString("INSS"));
            e.setCidade(CidadeDAO.get(rs.getInt("CIDADE_ID")));
            e.setMoeda(MoedaDAO.get(rs.getInt("MOEDA_ID")));
            e.setSite(rs.getString("SITE"));
            e.setPermitir_exclir(rs.getBoolean("PERMITIR_APAGAR"));
        }
        return e;
    }
}

