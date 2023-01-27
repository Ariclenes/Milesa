package com.signcorporation.milesa.model.DAO;

import BD.ConexaoBD;
import MODELO.BEAN.Produto;
import MODELO.BEAN.ProdutoCategoria;
import MODELO.UTILS.ExceptionValidacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @author AEM Sign Angola
 */
public class ProdutoDAO implements CRUD<Produto> {

    ConexaoBD con = new ConexaoBD();
    Connection conexao = con.getInstance().getConnection();

    @Override
    public void guardar(Produto p) throws ExceptionValidacao, SQLException {
        if (p.getCODPRODUTO() == 0) {
            if (existe(p)) {
                throw new ExceptionValidacao("A Produto já está cadastrada");
            }
            inserir(p);
        } else {
            alterar(p);
        }
    }

    @Override
    public boolean existe(Produto p) throws ExceptionValidacao, SQLException {
        String sql = "SELECT COUNT(CODPRODUTO) FROM PRODUTO WHERE CODPRODUTO=?";


        PreparedStatement ps = conexao.prepareStatement(sql);

        ps.setString(1, p.getCODBARRA());
        ps.setString(2, p.getNOME_ARTIGO());
        ps.setDouble(3, p.getPRECO_COMPRA());
        ps.setDouble(4, p.getPRECO_VENDA());
        ps.setString(5, p.getESTOQUE_MINIMO());
        ps.setString(6, p.getESTOQUE_MAXIMO());
        ps.setString(7, p.getFOTO_ARTIGO());
        ps.setInt(8, p.getPRODUTO_TIPO().getCodTipo());
        ps.setInt(9, p.getPRODUTO_SUB_GRUPO().getCodSubGrupo());
        ps.setInt(10, p.getPRODUTO_CATEGORIA().getCodCategoria());
        ps.setInt(11, p.getUNIDADE_MEDIDA().getCodUnidade());
        ps.setString(12, p.getSTATUS().getSIGLA());
        ps.setBoolean(13, p.isCONTROLA_ESTOQUE());
        ps.setString(14, p.getESTOQUE_ATUAL());
        con.confirmar();
        ResultSet rs = ps.executeQuery();
        rs.next();
        return (rs.getInt(1) > 0);
    }

    @Override
    public void inserir(Produto p) throws ExceptionValidacao, SQLException {
        String SQL = "INSERT INTO PRODUTO (CODIGOBARRA_RETALHO,NOME_PRODUTO,PCM,PVP,ESTOQUE_MINIMO,ESTOQUE_MAXIMO,STOCK_ATUAL,FOTO_PRODUTO, TIPO_PRODUTO_ID, SUBGRUPO_ID, CATEGORIA_ID,  CODUN_MEDIDA,   "
                + "CONTROLA_STOCK,MODIFICADO)values (?,?,?,?,?,?,?,?,?,?,?,?,?,CURRENT_TIMESTAMP())";
        try {
            PreparedStatement ps = conexao.prepareStatement(SQL);
            ps.setString(1, p.getCODBARRA());
            ps.setString(2, p.getNOME_ARTIGO());
            ps.setDouble(3, p.getPRECO_COMPRA());
            ps.setDouble(4, p.getPRECO_VENDA());
            ps.setString(5, p.getESTOQUE_MINIMO());
            ps.setString(6, p.getESTOQUE_MAXIMO());
            ps.setString(7, p.getESTOQUE_ATUAL());
            ps.setString(8, p.getFOTO_ARTIGO());
            ps.setInt(9, p.getPRODUTO_TIPO().getCodTipo());
            ps.setInt(10, p.getPRODUTO_SUB_GRUPO().getCodSubGrupo());
            ps.setInt(11, p.getPRODUTO_CATEGORIA().getCodCategoria());
            ps.setInt(12, p.getUNIDADE_MEDIDA().getCodUnidade());
//        ps.setString (12, p.getSTATUS ().getSIGLA ());
            ps.setBoolean(13, p.isCONTROLA_ESTOQUE());
//        con.confirmar ();

            ps.execute();
//          connetion.close();
            ps.close();

        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    @Override
    public void alterar(Produto p) throws ExceptionValidacao, SQLException {
        String sql = "UPDATE PRODUTO SET CODIGOBARRA_RETALHO=?, NOME_PRODUTO=?, PCM=?,PVP=?, ESTOQUE_MINIMO=? ,ESTOQUE_MAXIMO=?, STOCK_ATUAL, FOTO_PRODUTO=?, TIPO_PRODUTO_ID=?, SUBGRUPO_ID=?, CATEGORIA_ID=?, CODUN_MEDIDA=?, CONTROLA_STOCK=?, MODIFICADO=CURRENT_TIMESTAMP() ";

        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, p.getCODBARRA());
        ps.setString(2, p.getNOME_ARTIGO());
        ps.setDouble(3, p.getPRECO_COMPRA());
        ps.setDouble(4, p.getPRECO_VENDA());
        ps.setString(5, p.getESTOQUE_MINIMO());
        ps.setString(6, p.getESTOQUE_MAXIMO());
        ps.setString(7, p.getESTOQUE_ATUAL());
        ps.setString(8, p.getFOTO_ARTIGO());
        ps.setInt(9, p.getPRODUTO_TIPO().getCodTipo());
        ps.setInt(10, p.getPRODUTO_SUB_GRUPO().getCodSubGrupo());
        ps.setInt(11, p.getPRODUTO_CATEGORIA().getCodCategoria());
        ps.setInt(12, p.getUNIDADE_MEDIDA().getCodUnidade());
        ps.setString(13, p.getSTATUS().getSIGLA());
        ps.setBoolean(14, p.isCONTROLA_ESTOQUE());
        ps.setInt(15, p.getCODPRODUTO());
        ps.execute();
        con.confirmar();

    }

    @Override
    public void excluir(int codigo) throws ExceptionValidacao, SQLException {
        PreparedStatement ps = conexao.prepareStatement("DELETE FROM PRODUTO WHERE CODPRODUTO=?");
        ps.setInt(1, codigo);
        ps.execute();
        ps.close();
//		connetion.close();
    }

    @Override
    public ObservableList<Produto> listar(boolean somenteAtivos) throws ExceptionValidacao, Exception {
        ObservableList<Produto> LISTAR_PRODUTOS = FXCollections.observableArrayList();
        String SQL = "SELECT * FROM PRODUTO";
        SQL += ((somenteAtivos) ? " WHERE status='A' " : " ");
        SQL += "ORDER BY NOME_PRODUTO LIMIT 100";
//      String SQL = "SELECT P.CODBARRA, P.NOME_PRODUTO, P.CODPRODUTO, P.PCM, P.PVP,P.CODUN_MEDIDA, P.FOTO_PRODUTO,P.CODSUBGRUPO,P.TIPO_PRODUTO,P.CATEGORIA,E.QTD,E.CODIGO, U.NOME_UNIDADE,C.NOME_CATEGORIA,T.NOME_TIPO,S.NOME_SUB_GRUPO FROM PRODUTO P JOIN PRODUTO_TIPO  T JOIN PRODUTO_SUB_GRUPO S ON(1=1) JOIN PRODUTO_CATEGORIA  C ON(1=1) JOIN PRODUTO_UNIDADE_MEDIDA  U ON(1=1) INNER JOIN  PRODUTO_ESTOQUE E ON (1=1)"
//                  + "WHERE E.COD_PRODUTO=P.CODPRODUTO AND P.TIPO_PRODUTO = T.CODIGO AND  P.CODSUBGRUPO = S.CODSUBGRUPO AND P.TIPO_PRODUTO = T.CODIGO AND P.CATEGORIA = C.CODIGO AND P.CODUN_MEDIDA = U.CODUN_MEDIDA "
//                  + "ORDER BY NOME_PRODUTO LIMIT 100";
        PreparedStatement ps = conexao.prepareStatement(SQL);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Produto p = new Produto();
            p.setCODPRODUTO(rs.getInt("CODPRODUTO"));
            p.setCODBARRA(rs.getString("CODIGOBARRA_RETALHO"));
            p.setNOME_ARTIGO(rs.getString("NOME_PRODUTO"));
            p.setPRECO_COMPRA(rs.getDouble("PCM"));
            p.setPRECO_VENDA(rs.getDouble("PVP"));
            p.setPRODUTO_CATEGORIA(ProdutoCategoriaDAO.get(rs.getInt("CATEGORIA_ID")));
            p.setPRODUTO_TIPO(ProdutoTipoDAO.get(rs.getInt("TIPO_PRODUTO_ID")));
            p.setPRODUTO_SUB_GRUPO(ProdutoSubGrupoDAO.get(rs.getInt("SUBGRUPO_ID")));
            p.setUNIDADE_MEDIDA(UnidadeMedidaDAO.get(rs.getInt("CODUN_MEDIDA")));
            p.setESTOQUE_ATUAL(rs.getString("STOCK_ATUAL"));
            LISTAR_PRODUTOS.add(p);
        }
        return LISTAR_PRODUTOS;
    }

    public ObservableList<Produto> Filtrar(boolean somenteAtivos, String Filtro, ProdutoCategoria categoria) throws Exception {
        ObservableList<Produto> LISTAR_PRODUTOS = FXCollections.observableArrayList();
//             String sql = "SELECT P.*, C.CODPESSOA AS CLIENTE, FO.CODPESSOA AS FORNECEDOR, FU.CODPESSOA AS FUNCIONARIO ";
//        sql += "FROM PESSOA AS P ";
//        sql += "LEFT JOIN PESSOAFISICA AS PF ON PF.CODPESSOAFISICA = P.CODPESSOAFISICA ";
//        sql += "LEFT JOIN PESSOAJURIDICA AS PJ ON PJ.CODPESSOAJURIDICA = P.CODPESSOAJURIDICA ";
//        sql += (clientes ? "INNER" : "LEFT") + " JOIN CLIENTE AS C ON C.CODPESSOA = P.CODPESSOA ";
//        sql += (fornecedores ? "INNER" : "LEFT") + " JOIN FORNECEDOR AS FO ON FO.CODPESSOA = P.CODPESSOA ";
//        sql += (funcionarios ? "INNER" : "LEFT") + " JOIN FUNCIONARIO AS FU ON FU.CODPESSOA = P.CODPESSOA ";
//        sql += " WHERE 1=1 ";
//        sql += (somenteAtivos) ? " AND P.STATUS = 'A' " : " ";
//        sql += (!filtro.trim().isEmpty()) ? " "
//                + "AND (p.nome LIKE ? "
//                + "OR replace(replace(PF.BI,'.',''),'-','') = ? "
//                + "OR replace(replace(replace(PJ.NIF,'.',''),'-',''),'/','') = ?)" : " ";
//        sql += "order by p.nome";
//        ConexaoBD con = new ConexaoBD();
//        PreparedStatement ps = con.getInstance().getConnection().prepareStatement(sql);
//        if (!filtro.trim().isEmpty()) {
//            ps.setString(1, "%" + filtro + "%");
//            ps.setString(2, filtro.replaceAll("-", "").replaceAll("\\.", ""));
//            ps.setString(3, filtro.replaceAll("-", "").replaceAll("\\.", "").replaceAll("/", ""));
//        }
//        ResultSet rs = ps.executeQuery();
//        ObservableList<Pessoa> lista = FXCollections.observableArrayList();


//     String SQL = "SELECT * ,C.NOME_CATEGORIA,T.NOME_TIPO,U.NOME_UNIDADE, E.CODIGO,E.QTD FROM PRODUTO P INNER JOIN PRODUTO_CATEGORIA C ON(1=1)INNER JOIN PRODUTO_TIPO T ON(1=1)INNER JOIN PRODUTO_UNIDADE_MEDIDA U ON(1=1) INNER JOIN PRODUTO_ESTOQUE E ON(1=1)"
//                + " WHERE E.COD_PRODUTO = P.CODPRODUTO AND P.CATEGORIA =C.CODIGO AND P.UN_MEDIDA = U.CODUN_MEDIDA AND P.TIPO_PRODUTO = T.CODIGO AND CODBARRA " + 
//                 (!txtId.getText().isEmpty() ? "= ?" : "> ?") + " AND " +
//                "LOWER(NOME_PRODUTO) LIKE LOWER(?) and CATEGORIA " + (cbCat.getSelectionModel().getSelectedIndex()==0 ? "> ?" : "= ?") +
//           
//                " and PVP " + (txtPreco.getText().isEmpty() ? "> ?" : cbOp.getSelectionModel().getSelectedItem() + " ?") + " ORDER BY NOME_PRODUTO";
//    PreparedStatement ps = conexao.prepareStatement(SQL);
//		ResultSet rs = ps.executeQuery();
//		while (rs.next()) {
//                Produto p = new Produto ();
//                p.setCODPRODUTO (rs.getInt("CODPRODUTO"));
//                p.setCODBARRA (rs.getString("CODBARRA"));
//                p.setNOME_ARTIGO (rs.getString("NOME_PRODUTO"));
//                p.setPRECO_COMPRA (rs.getDouble("PCM"));
//                p.setPRECO_VENDA (rs.getDouble("PVP"));
//                p.setPRODUTO_CATEGORIA (ProdutoCategoriaDAO.get(rs.getInt("CATEGORIA_ID")));
//                p.setPRODUTO_TIPO (ProdutoTipoDAO.get(rs.getInt("TIPO_PRODUTO")));
////              p.setPRODUTO_GRUPO (ProdutoGrupoDAO.get(rs.getInt("CATEGORIA")));
//                p.setPRODUTO_SUB_GRUPO (ProdutoSubGrupoDAO.get(rs.getInt("CODSUBGRUPO")));
//                p.setUNIDADE_MEDIDA (UnidadeMedidaDAO.get(rs.getInt("UN_MEDIDA")));
////                p.setPRODUTO_ESTOQUE(ProdutoEstoqueDAO.get(rs.getInt("CODIGO")));
//                
//                LISTAR_PRODUTOS.add (p);
//		}
        return LISTAR_PRODUTOS;
    }

    public static Produto get(int codpProduto) throws Exception {
//String SQL = "SELECT P.CODBARRA, P.NOME_PRODUTO, P.CODPRODUTO, P.PCM, P.PVP,P.UN_MEDIDA, P.FOTO_PRODUTO,P.CODSUBGRUPO,P.TIPO_PRODUTO,P.CATEGORIA, E.CODIGO,E.QTD,  U.NOME_UNIDADE,C.NOME_CATEGORIA,T.NOME_TIPO,S.NOME_SUB_GRUPO FROM PRODUTO P JOIN PRODUTO_TIPO  T JOIN PRODUTO_SUB_GRUPO S ON(1=1) JOIN PRODUTO_CATEGORIA  C ON(1=1) JOIN PRODUTO_UNIDADE_MEDIDA  U ON(1=1) INNER JOIN  PRODUTO_ESTOQUE E ON (1=1)"
//                  + "WHERE E.COD_PRODUTO=P.CODPRODUTO AND P.TIPO_PRODUTO = T.CODIGO AND  P.CODSUBGRUPO = S.CODSUBGRUPO AND P.TIPO_PRODUTO = T.CODIGO AND P.CATEGORIA = C.CODIGO AND P.UN_MEDIDA = U.CODIGO "
//                  + "ORDER BY NOME_PRODUTO LIMIT 100";
        String SQL = "SELECT * FROM PRODUTO WHERE CODPRODUTO=? ";
        ConexaoBD con = new ConexaoBD();
        Connection conexao = con.getInstance().getConnection();
        PreparedStatement ps = conexao.prepareStatement(SQL);
        ps.setInt(1, codpProduto);
        ResultSet rs = ps.executeQuery();
        Produto p = new Produto();
        if (rs.next()) {
            p.setCODPRODUTO(rs.getInt("CODPRODUTO"));
            p.setCODBARRA(rs.getString("CODIGOBARRA_RETALHO"));
            p.setNOME_ARTIGO(rs.getString("NOME_PRODUTO"));
            p.setPRECO_COMPRA(rs.getDouble("PCM"));
            p.setPRECO_VENDA(rs.getDouble("PVP"));
            p.setFOTO_ARTIGO(rs.getString("FOTO_PRODUTO"));
            p.setESTOQUE_MINIMO(rs.getString("ESTOQUE_MINIMO"));
            p.setESTOQUE_MAXIMO(rs.getString("ESTOQUE_MAXIMO"));
            p.setPRODUTO_CATEGORIA(ProdutoCategoriaDAO.get(rs.getInt("CATEGORIA_ID")));
            p.setPRODUTO_TIPO(ProdutoTipoDAO.get(rs.getInt("TIPO_PRODUTO_ID")));
//                    p.setPRODUTO_GRUPO (ProdutoGrupoDAO.get(rs.getInt("CODGRUPO")));
            p.setPRODUTO_SUB_GRUPO(ProdutoSubGrupoDAO.get(rs.getInt("SUBGRUPO_ID")));
            p.setUNIDADE_MEDIDA(UnidadeMedidaDAO.get(rs.getInt("CODUN_MEDIDA")));
//                    p.setPRODUTO_ESTOQUE(ProdutoEstoqueDAO.get(rs.getInt("CODIGO")));
            p.setCONTROLA_ESTOQUE(true);
        }
        return p;
    }

    public static ObservableList<Produto> listar(String filtro, int quantidade, int pagina) throws Exception {
        ConexaoBD con = new ConexaoBD();
        Connection conexao = con.getInstance().getConnection();
        String sql = "SELECT * FROM PRODUTO WHERE NOME_PRODUTO LIKE ? ORDER BY NOME_PRODUTO LIMIT ?,?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, "%" + filtro + "%");
        ps.setInt(2, pagina * quantidade);
        ps.setInt(3, quantidade);
        ResultSet rs = ps.executeQuery();

        ObservableList<Produto> listaProdutos = FXCollections.observableArrayList();
        while (rs.next()) {
            Produto p = new Produto();
            p.setCODPRODUTO(rs.getInt("CODPRODUTO"));
            p.setCODBARRA(rs.getString("CODIGOBARRA_RETALHO"));
            p.setNOME_ARTIGO(rs.getString("NOME_PRODUTO"));
            p.setPRECO_COMPRA(rs.getDouble("PCM"));
            p.setPRECO_VENDA(rs.getDouble("PVP"));
            p.setPRODUTO_CATEGORIA(ProdutoCategoriaDAO.get(rs.getInt("CATEGORIA_ID")));
            p.setPRODUTO_TIPO(ProdutoTipoDAO.get(rs.getInt("TIPO_PRODUTO_ID")));
//              p.setPRODUTO_GRUPO (ProdutoGrupoDAO.get(rs.getInt("CATEGORIA")));
            p.setPRODUTO_SUB_GRUPO(ProdutoSubGrupoDAO.get(rs.getInt("SUBGRUPO_ID")));
            p.setUNIDADE_MEDIDA(UnidadeMedidaDAO.get(rs.getInt("CODUN_MEDIDA")));
            listaProdutos.add(p);
        }

        return listaProdutos;
    }
}














