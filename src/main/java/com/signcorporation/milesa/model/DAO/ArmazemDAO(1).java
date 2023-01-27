/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.signcorporation.milesa.model.DAO;

import BD.ConexaoBD;
import MODELO.BEAN.Armazem;
import MODELO.UTILS.ExceptionValidacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Hacker PC
 */
public class ArmazemDAO implements CRUD<Armazem>{

    @Override  public void guardar (Armazem t) throws ExceptionValidacao, SQLException {
        if (!existe(t)) {
            inserir(t);
        }
    }

    @Override  public boolean existe (Armazem t) throws ExceptionValidacao, SQLException {
      String sql = "select count(COD_UNIDADE) from SUB_UNIDADE where COD_UNIDADE=?";
        ConexaoBD con = new ConexaoBD();
        Connection conexao = con.getInstance ().getConnection ();
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, t.getCodArmazem ());
         ps.setInt(1, t.getCodArmazem ());
                ps.setString(1, t.getNome_Armazem ());
                ps.setString(2, t.getDescricao_Armazem ());
                ps.setInt (3, t.getEmpresa ().getCodEmpresa ());
                ps.setString(3, t.getResponsavel ());
                ps.setString(4, t.getNif ());
                ps.setString(5, t.getMorada ());
                ps.setString(6, t.getTelefone ());
                ps.setString(7, t.getFax ());
                ps.setString(8, t.getCod_postal ());
                ps.setString(9, t.getEmail ());
                ps.setString(10, t.getLogo_marca ());
                ps.setInt(11, t.getCidade ().getCodCidade ());
        ResultSet rs = ps.executeQuery();
        rs.next();
        return (rs.getInt(1) > 0);
    }

    @Override  public void inserir (Armazem t) throws ExceptionValidacao, SQLException {
         ConexaoBD con = new ConexaoBD (); Connection conexao;
        conexao = con.getInstance ().getConnection ();
        String sql = "insert into cliente (codpessoa) values (?)";
        PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setInt(1, t.getCodArmazem ());
                ps.setInt (2, t.getEmpresa ().getCodEmpresa ());
                ps.setString(1, t.getNome_Armazem ());
                ps.setString(2, t.getDescricao_Armazem ());
                ps.setString(3, t.getResponsavel ());
                ps.setString(4, t.getNif ());
                ps.setString(5, t.getMorada ());
                ps.setString(6, t.getTelefone ());
                ps.setString(7, t.getFax ());
                ps.setString(8, t.getCod_postal ());
                ps.setString(9, t.getEmail ());
                ps.setString(10, t.getLogo_marca ());
                ps.setInt(11, t.getCidade ().getCodCidade ());
                
        ps.execute();
    }

    @Override  public void alterar (Armazem t) throws ExceptionValidacao, SQLException {
        ConexaoBD con = new ConexaoBD ();
        
       Connection connetion = con.getInstance().getConnection();

		String sql = "update UNIDADE set NOME_UNIDADE=?, DESCRICAO=? RESPONSAVEL=?,NIF=?,MORADA=?,TELF=?,FAX=?,CP=?,E_MAIL=?,LOGO_EMPRESA=?,PROVINCIA_ID=?,CIDADE_ID=?,IVA_INSESAO_ID=?,INSS=? where COD_UNIDADE=?";
//                                    
		PreparedStatement ps = connetion.prepareStatement(sql);

		ps.setString(1, t.getNome_Armazem ());
                ps.setString(2, t.getDescricao_Armazem ());
                ps.setInt (3, t.getEmpresa ().getCodEmpresa ());
                ps.setString(3, t.getResponsavel ());
                ps.setString(4, t.getNif ());
                ps.setString(5, t.getMorada ());
                ps.setString(6, t.getTelefone ());
                ps.setString(7, t.getFax ());
                ps.setString(8, t.getCod_postal ());
                ps.setString(9, t.getEmail ());
                ps.setString(10, t.getLogo_marca ());
                ps.setInt(11, t.getCidade ().getCodCidade ());
                
		ps.setInt(11, t.getCodArmazem ());
		ps.execute();

		connetion.close();
		ps.close();
    }

    @Override  public void excluir (int codigo) throws ExceptionValidacao, SQLException {
      ConexaoBD con = new ConexaoBD ();Connection conexao;
        conexao = con.getInstance ().getConnection ();
        String sql = "delete from sub_unidade where cod_sub_unidade=?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, codigo);
        ps.execute();
    }

    @Override  public ObservableList<Armazem> listar (boolean somenteAtivos) throws ExceptionValidacao, Exception {
                ObservableList<Armazem> lista_de_empresas = FXCollections.observableArrayList();
                        ConexaoBD con = new ConexaoBD ();
                        Connection conexao = con.getInstance().getConnection();

                        String sql = "select * from SUB_UNIDADE";

                        PreparedStatement ps = conexao.prepareStatement(sql);

                        ResultSet rs = ps.executeQuery();

                        while (rs.next()) {
        			Armazem e = new Armazem ();
                                        e.setCodArmazem (rs.getInt("COD_SUB_UNIDADE"));
                                        e.setNome_Armazem (rs.getString("NOME_SUB_UNIDADE"));
                                        e.setDescricao_Armazem (rs.getString ("DESCRICAO_SUB_UNIDADE")); 
//                                        e.setResponsavel (rs.getString("RESPONSAVEL"));
                                        e.setNif (rs.getString("NIF"));
                                        e.setMorada (rs.getString("MORADA"));
                                        e.setTelefone (rs.getString ("TELF"));
                                        e.setFax (rs.getString("FAX"));
                                        e.setCod_postal ("CP");
                                        e.setEmail ("E_MAIL");
                                        e.setLogo_marca ("LOGO_EMPRESA");
//                                        e.setBairro (rs.getString("BAIRO"));
                                        e.setCidade (CidadeDAO.get(rs.getInt("CIDADE_ID")));
                                        e.setEmpresa (EmpresaDAO.get (rs.getInt ("COD_UNIDADE")));
//                                        e.setSite (rs.getString (""));
//                                        e.setPermitir_exclir (rs.getBoolean ("PERMITIR_APAGAR"));
                                        lista_de_empresas.add(e);
		}


		return lista_de_empresas;
    }
    
    public static ObservableList<Armazem> lista(boolean somenteAtivos) throws Exception {
            ObservableList<Armazem> lista_cidade = FXCollections.observableArrayList();
             String sql = "select * from SUB_UNIDADE";
//             sql += ((somenteAtivos) ? " where STATUS='A' " : " ");
//             sql += " order by NOME_PROVINCIA";
                 ConexaoBD con= new ConexaoBD ();
                 Connection conexao =  con.getInstance ().getConnection ();
		 PreparedStatement ps = conexao.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                  Armazem e = new Armazem();
                                        e.setCodArmazem (rs.getInt("COD_SUB_UNIDADE"));
                                        e.setEmpresa (EmpresaDAO.get (rs.getInt ("COD_UNIDADE")));
                                        e.setNome_Armazem (rs.getString("NOME_SUB_UNIDADE"));
                                        e.setDescricao_Armazem (rs.getString ("DESCRICAO_SUB_UNIDADE")); 
//                                        e.setResponsavel (rs.getString("RESPONSAVEL"));
                                        e.setNif (rs.getString("NIF"));
                                        e.setMorada (rs.getString("MORADA"));
                                        e.setTelefone (rs.getString ("TELF"));
                                        e.setFax (rs.getString("FAX"));
                                        e.setCod_postal ("CP");
                                        e.setEmail ("E_MAIL");
                                        e.setLogo_marca ("LOGO_EMPRESA");
//                                        e.setBairro (rs.getString("BAIRO"));
//                                        e.setCidade (CidadeDAO.get(rs.getInt("CIDADE_ID")));
                                     
                                        lista_cidade.add(e);        
		}
        System.out.println ("Armazem: "+ lista_cidade);
		return lista_cidade;
    }
       public static Armazem get(int codEmpresa) throws Exception {
//String SQL = "SELECT P.CODBARRA, P.NOME_PRODUTO, P.CODPRODUTO, P.PCM, P.PVP,P.UN_MEDIDA, P.FOTO_PRODUTO,P.CODSUBGRUPO,P.TIPO_PRODUTO,P.CATEGORIA, E.CODIGO,E.QTD,  U.NOME_UNIDADE,C.NOME_CATEGORIA,T.NOME_TIPO,S.NOME_SUB_GRUPO FROM PRODUTO P JOIN PRODUTO_TIPO  T JOIN PRODUTO_SUB_GRUPO S ON(1=1) JOIN PRODUTO_CATEGORIA  C ON(1=1) JOIN PRODUTO_UNIDADE_MEDIDA  U ON(1=1) INNER JOIN  PRODUTO_ESTOQUE E ON (1=1)"
//                  + "WHERE E.COD_PRODUTO=P.CODPRODUTO AND P.TIPO_PRODUTO = T.CODIGO AND  P.CODSUBGRUPO = S.CODSUBGRUPO AND P.TIPO_PRODUTO = T.CODIGO AND P.CATEGORIA = C.CODIGO AND P.UN_MEDIDA = U.CODIGO "
//                  + "ORDER BY NOME_PRODUTO LIMIT 100";
                String SQL = "SELECT * FROM SUB_UNIDADE WHERE COD_SUB_UNIDADE=? ";
                ConexaoBD con = new ConexaoBD ();
                Connection conexao = con.getInstance ().getConnection ();
                PreparedStatement ps = conexao.prepareStatement(SQL);
                ps.setInt(1, codEmpresa);
                ResultSet rs = ps.executeQuery();
                Armazem e =  new Armazem ();;
                if (rs.next()) {
                   
                    e.setCodArmazem (rs.getInt("COD_SUB_UNIDADE"));
                     e.setEmpresa (EmpresaDAO.get (rs.getInt("COD_UNIDADE")));
                                        e.setNome_Armazem(rs.getString("NOME_SUB_UNIDADE"));
                                        e.setDescricao_Armazem (rs.getString ("DESCRICAO_SUB_UNIDADE")); 
//                                        e.setResponsavel (rs.getString("RESPONSAVEL"));
                                        e.setNif (rs.getString("NIF"));
                                        e.setMorada (rs.getString("MORADA"));
                                        e.setTelefone (rs.getString ("TELF"));
                                        e.setFax (rs.getString("FAX"));
                                        e.setCod_postal ("CP");
                                        e.setEmail ("E_MAIL");
                                        e.setLogo_marca ("LOGO_EMPRESA");
//                                        e.setBairro (rs.getString("BAIRO"));
                                        e.setCidade (CidadeDAO.get(rs.getInt("CIDADE_ID")));             
//                                        e.setSite (rs.getString (""));
                                        e.setPermitir_exclir (rs.getBoolean ("PERMITIR_APAGAR"));
                                       
                }
                return e;
            }

}
