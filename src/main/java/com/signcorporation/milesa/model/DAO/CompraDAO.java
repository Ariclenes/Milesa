package com.signcorporation.milesa.model.DAO;

import BD.ConexaoBD;
import MODELO.BEAN.Compra;
import MODELO.BEAN.Compra.ItemCompra;
import MODELO.UTILS.Situacao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @author Hacker PC
 */
public class CompraDAO {
    public static void salvar(Compra compra) throws Exception {
        if (compra.getCodigo() == 0) {
            inserir(compra);
        } else {
            alterar(compra);
        }
    }

    private static void inserir(Compra compra) throws Exception {
        ConexaoBD c = new ConexaoBD();
        Connection conexao = c.getInstance().getConnection();
        String sql = "INSERT INTO FATURA_COMPRA (CODIGOFORNECEDOR, DATACOMPRA, VALORTOTAL, SITUACAO) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, compra.getFornecedor().getCodPessoa());
        ps.setDate(2, new Date(compra.getDataCompra().getTime()));
        ps.setDouble(3, compra.getValorTotal());
        ps.setInt(4, compra.getSituacao().getId());
        ps.execute();

        ResultSet rs = ps.getGeneratedKeys();
        rs.next();
        int idCompra = rs.getInt(1);

        for (Compra.ItemCompra iv : compra.getItens()) {
            sql = "INSERT INTO ENTRADA_PRODUTO (COD_PRODUTO, COD_COMPRA, QUANTIDADE, VALORUNITARIO) VALUES (?, ?, ?, ?)";
            ps = conexao.prepareStatement(sql);
            ps.setInt(1, iv.getProduto().getCODPRODUTO());
            ps.setInt(2, idCompra);
            ps.setInt(3, iv.getQuantidade());
            ps.setDouble(4, iv.getValorUnitario());
            ps.execute();

            if (compra.getSituacao() == Situacao.FINALIZADA) {
                ProdutoEstoqueDAO.entradaEstoque(conexao, iv.getProduto().getCODPRODUTO(), iv.getQuantidade());
            }
        }
        c.confirmar();
    }

    private static void alterar(Compra compra) throws Exception {
        ConexaoBD c = new ConexaoBD();
        Connection conexao = c.getInstance().getConnection();
        String sql = "UPDATE FATURA_COMPRA SET CODIGOFORNECEDOR=?, DATACOMPRA=?, VALORTOTAL=?, SITUACAO=? WHERE CODIGO=?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, compra.getFornecedor().getCodPessoa());
        ps.setDate(2, new Date(compra.getDataCompra().getTime()));
        ps.setDouble(3, compra.getValorTotal());
        ps.setInt(4, compra.getSituacao().getId());
        ps.setInt(5, compra.getCodigo());
        ps.execute();

        for (Compra.ItemCompra iv : compra.getItensRemover()) {
            sql = "DELETE FROM ENTRADA_PRODUTO WHERE CODIGO=?";
            ps = conexao.prepareStatement(sql);
            ps.setInt(1, iv.getCodigo());
            ps.execute();
        }

        for (Compra.ItemCompra iv : compra.getItens()) {
            if (iv.getCodigo() == 0) {
                sql = "INSERT INTO ENTRADA_PRODUTO (CODPRODUTO, CODCOMPRA, QUANTIDADE, VALORUNITARIO) VALUES (?, ?, ?, ?)";
                ps = conexao.prepareStatement(sql);
                ps.setInt(1, iv.getProduto().getCODPRODUTO());
                ps.setInt(2, compra.getCodigo());
                ps.setInt(3, iv.getQuantidade());
                ps.setDouble(4, iv.getValorUnitario());
                ps.execute();
            } else {
                sql = "UPDATE ENTRADA_PRODUTO SET COD_PRODUTO=?, COD_COMPRA=?, QUANTIDADE=?, VALORUNITARIO=? WHERE CODIGO=?";
                ps = conexao.prepareStatement(sql);
                ps.setInt(1, iv.getProduto().getCODPRODUTO());
                ps.setInt(2, compra.getCodigo());
                ps.setInt(3, iv.getQuantidade());
                ps.setDouble(4, iv.getValorUnitario());
                ps.setInt(5, iv.getCodigo());
                ps.execute();
            }

            if (compra.getSituacao() == Situacao.FINALIZADA) {
                ProdutoEstoqueDAO.entradaEstoque(conexao, iv.getProduto().getCODPRODUTO(), iv.getQuantidade());
            }
        }

        c.confirmar();
    }

    public static void excluir(Compra compra) throws Exception {
        ConexaoBD c = new ConexaoBD();
        Connection conexao = c.getInstance().getConnection();
        String sql = "UPDATE FATURAS SET CODIGOFORNECEDOR=?, DATACOMPRA=?, VALORTOTAL=?, SITUACAO=? WHERE CODIGO=?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, compra.getFornecedor().getCodPessoa());
        ps.setDate(2, new Date(compra.getDataCompra().getTime()));
        ps.setDouble(3, compra.getValorTotal());
        ps.setInt(4, Situacao.CANCELADA.getId());
        ps.setInt(5, compra.getCodigo());
        ps.execute();
        c.confirmar();
    }

    public static int quantidade(String filtro) throws Exception {
        ConexaoBD c = new ConexaoBD();
        Connection conexao = c.getInstance().getConnection();
        String sql = ""
                + " SELECT COUNT(1) "
                + " FROM FATURAS AS C"
                + " INNER JOIN PESSOA AS F "
                + " ON F.CODPESSOA = C.FORNECEDOR_ID "
                + " WHERE F.NOME LIKE ? ";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, "%" + filtro + "%");
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return rs.getInt(1);
        }

        return 0;
    }

    public static ObservableList<Compra> listar(String filtro, int quantidade, int pagina) throws Exception {
        ConexaoBD c = new ConexaoBD();
        Connection conexao = c.getInstance().getConnection();
        String sql = ""
                + " SELECT C.* "
                + " FROM FATURAS AS C"
                + " INNER JOIN FORNECEDOR AS F "
                + " INNER JOIN PESSOA AS P "
                + " ON F.CODPESSOA = C.FORNECEDOR_ID "
                + " WHERE P.NOME LIKE ? "
                + " ORDER BY C.SITUACAO ASC, C.DATA DESC "
                + " LIMIT ?,? ";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, "%" + filtro + "%");
        ps.setInt(2, pagina * quantidade);
        ps.setInt(3, quantidade);
        ResultSet rs = ps.executeQuery();

        ObservableList listaCompras = FXCollections.observableArrayList();
        while (rs.next()) {
            Compra compra = new Compra();
            compra.setCodigo(rs.getInt("CODIGO"));
            compra.setFornecedor(FornecedorDAO.recuperar(rs.getInt("FORNECEDOR_ID")));
            compra.setDataCompra(rs.getDate("DATACOMPRA"));
            compra.setSituacao(rs.getInt("SITUACAO"));

            String sqlItem = "SELECT * FROM FATURA_ITEM WHERE COD_COMPRA=?";
            PreparedStatement psItem = conexao.prepareStatement(sqlItem);
            psItem.setInt(1, compra.getCodigo());
            ResultSet rsItem = psItem.executeQuery();

            while (rsItem.next()) {
                Compra.ItemCompra iv = compra.new ItemCompra();
                iv.setCodigo(rsItem.getInt("CODIGO"));
                iv.setProduto(ProdutoDAO.get(rsItem.getInt("COD_PRODUTO")));
                iv.setQuantidade(rsItem.getInt("QUANTIDADE"));
                iv.setValorUnitario(rsItem.getDouble("VALORUNITARIO"));
                compra.addItem(iv);
            }

            listaCompras.add(compra);
        }

        return listaCompras;
    }

    public static Compra recuperar(int codigo) throws Exception {
        ConexaoBD c = new ConexaoBD();
        Connection conexao = c.getInstance().getConnection();

        String sql = "SELECT * FROM FATURA_COMPRA WHERE CODIGO=?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, codigo);
        ResultSet rs = ps.executeQuery();

        Compra compra = new Compra();
        if (rs.next()) {
            compra.setCodigo(rs.getInt("CODIGO"));
//            compra.setFornecedor(FornecedorDAO.get(rs.getInt("CODIGOFORNECEDOR")));
            compra.setDataCompra(rs.getDate("DATACOMPRA"));
            compra.setSituacao(rs.getInt("SITUACAO"));

            String sqlItem = "SELECT * FROM TBITEMCOMPRA WHERE CODIGOCOMPRA=?";
            PreparedStatement psItem = conexao.prepareStatement(sqlItem);
            psItem.setInt(1, compra.getCodigo());
            ResultSet rsItem = psItem.executeQuery();

            while (rsItem.next()) {
                Compra.ItemCompra iv = compra.new ItemCompra();
                iv.setCodigo(rsItem.getInt("CODIGO"));
                iv.setProduto(ProdutoDAO.get(rsItem.getInt("CODPRODUTO")));
                iv.setQuantidade(rsItem.getInt("QUANTIDADE"));
                iv.setValorUnitario(rsItem.getDouble("VALORUNITARIO"));
                compra.addItem(iv);
            }
        }

        return compra;
    }


}







