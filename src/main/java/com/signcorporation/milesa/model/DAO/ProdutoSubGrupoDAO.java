package com.signcorporation.milesa.model.DAO;

import BD.ConexaoBD;
import MODELO.BEAN.ProdutoGrupo;
import MODELO.BEAN.ProdutoSubGrupo;
import MODELO.BEAN.Status;
import MODELO.UTILS.ExceptionValidacao;

import java.sql.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @author AEM Sign Angola
 */
public class ProdutoSubGrupoDAO implements CRUD<ProdutoSubGrupo> {

    ConexaoBD con = new ConexaoBD();
    PreparedStatement ps = null;
    Connection conexao = con.getInstance().getConnection();
    ResultSet rs = null;
    private String sql;

    @Override
    public void guardar(ProdutoSubGrupo t) throws ExceptionValidacao, SQLException {
        if (t.getCodSubGrupo() == 0) {
            if (existe(t)) {
                throw new ExceptionValidacao("A Sub Familia já está cadastrada");
            }
            inserir(t);
        } else {
            alterar(t);
        }
    }

    @Override
    public boolean existe(ProdutoSubGrupo t) throws ExceptionValidacao, SQLException {
        String sql = "SELECT COUNT(CODIGO) FROM PRODUTO_SUB_GRUPO WHERE NOME=? AND CODIGO=?";

        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, t.getNOME_SUB_GRUPO());
        ps.setInt(2, t.getGrupo().getCodGrupo());
        ps.setString(3, t.getStatus().getSIGLA());
        ResultSet rs = ps.executeQuery();
        rs.next();
        return (rs.getInt(1) > 0);
    }

    @Override
    public void inserir(ProdutoSubGrupo t) throws ExceptionValidacao, SQLException {

        sql = "INSERT INTO  PRODUTO_SUB_GRUPO(NOME_SUB_GRUPO)VALUES(?)";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, t.getNOME_SUB_GRUPO());
        ps.setInt(2, t.getGrupo().getCodGrupo());
        ps.setString(3, t.getStatus().getSIGLA());
        ps.execute();
//		connetion.close();
        ps.close();
    }

    @Override
    public void alterar(ProdutoSubGrupo t) throws ExceptionValidacao, SQLException {
        String sql = "UPDATE PRODUTO_SUB_GRUPO SET NOME=?, WHERE CODIGO=?";

        conexao = con.getInstance().getConnection();
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, t.getNOME_SUB_GRUPO());
        ps.setInt(2, t.getGrupo().getCodGrupo());
        ps.setString(2, t.getStatus().getSIGLA());
        ps.setInt(3, t.getCodSubGrupo());
        ps.execute();
    }

    @Override
    public void excluir(int codigo) throws ExceptionValidacao, SQLException {
        conexao = con.getInstance().getConnection();
        PreparedStatement ps = conexao.prepareStatement("DELETE FROM PRODUTO_SUB_GRUPO WHERE CODIGO=?");
        ps.setInt(1, codigo);
        ps.execute();
        ps.close();
//		connetion.close();
    }

    public ObservableList<ProdutoSubGrupo> listar(boolean somenteAtivos, ProdutoGrupo grupo) throws ExceptionValidacao, Exception {
        ObservableList<ProdutoSubGrupo> lista = FXCollections.observableArrayList();
        String SQL = "select * from PRODUTO_SUB_GRUPO ";
        SQL += " where CODGRUPO=?";
        SQL += ((somenteAtivos) ? " and status='A' " : " ");
        SQL += " order by NOME_SUB_GRUPO";
//           String SQL="SELECT *  FROM PRODUTO_SUB_GRUPO S INNER JOIN PRODUTO_GRUPO G ON(S.CODGRUPO= G.CODGRUPO ) ORDER BY S.NOME_SUB_GRUPO";
        ps = conexao.prepareStatement(SQL);
        ps.setInt(1, grupo.getCodGrupo());
        rs = ps.executeQuery();
        ProdutoSubGrupo s = new ProdutoSubGrupo();
        while (rs.next()) {

            s.setCodSubGrupo(rs.getInt("CODSUBGRUPO"));
            s.setGrupo(ProdutoGrupoDAO.get(rs.getInt("CODGRUPO")));
            s.setNOME_SUB_GRUPO(rs.getString("NOME_SUB_GRUPO"));
            s.setStatus(Status.get(rs.getString("STATUS")));
            lista.add(s);
        }

//		rs.close();
        return lista;
    }

    @Override
    public ObservableList<ProdutoSubGrupo> listar(boolean somenteAtivos) throws ExceptionValidacao, Exception {
        ObservableList<ProdutoSubGrupo> lista = FXCollections.observableArrayList();
        String SQL = "select * from PRODUTO_SUB_GRUPO ";
//                    SQL += " where CODGRUPO=?";
        SQL += ((somenteAtivos) ? " WHERE status='A' " : " ");
        SQL += " order by NOME_SUB_GRUPO";
        PreparedStatement ps = conexao.prepareStatement(SQL);
        ResultSet rs = ps.executeQuery();
        ProdutoSubGrupo s = null;
        while (rs.next()) {
            s = new ProdutoSubGrupo();
            s.setCodSubGrupo(rs.getInt("CODSUBGRUPO"));
            s.setGrupo(ProdutoGrupoDAO.get(rs.getInt("CODGRUPO")));
            s.setNOME_SUB_GRUPO(rs.getString("NOME_SUB_GRUPO"));
            s.setStatus(Status.get(rs.getString("STATUS")));
            lista.add(s);
        }

        return lista;
    }

    public static ProdutoSubGrupo get(int codSubGrupo) throws Exception {

        String sql = "select * from PRODUTO_SUB_GRUPO where CODSUBGRUPO =? ";
        ConexaoBD con = new ConexaoBD();
        Connection conexao = con.getInstance().getConnection();
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, codSubGrupo);
        ResultSet rs = ps.executeQuery();
        ProdutoSubGrupo s = new ProdutoSubGrupo();
        ;
        while (rs.next()) {
            s.setCodSubGrupo(rs.getInt("CODSUBGRUPO"));
            s.setGrupo(ProdutoGrupoDAO.get(rs.getInt("CODGRUPO")));
            s.setNOME_SUB_GRUPO(rs.getString("NOME_SUB_GRUPO"));
            s.setStatus(Status.get(rs.getString("STATUS")));

        }
        ps.close();
        rs.close();
        return s;
    }

    public ObservableList<ProdutoSubGrupo> listar_tree_view(boolean somenteAtivos, ProdutoGrupo grupo) throws ExceptionValidacao, Exception {
        ObservableList<ProdutoSubGrupo> lista = FXCollections.observableArrayList();
        String SQL = "select * from PRODUTO_SUB_GRUPO ";
        SQL += " where CODGRUPO=?";
        SQL += ((somenteAtivos) ? " and status='A' " : " ");
        SQL += " order by NOME_SUB_GRUPO";
//           String SQL="SELECT *  FROM PRODUTO_SUB_GRUPO S INNER JOIN PRODUTO_GRUPO G ON(S.CODGRUPO= G.CODGRUPO ) ORDER BY S.NOME_SUB_GRUPO";
        ps = conexao.prepareStatement(SQL);
        ps.setInt(1, grupo.getCodGrupo());
        rs = ps.executeQuery();
        ProdutoSubGrupo s = new ProdutoSubGrupo();
        while (rs.next()) {

            s.setCodSubGrupo(rs.getInt("CODSUBGRUPO"));
            s.setGrupo(ProdutoGrupoDAO.get(rs.getInt("CODGRUPO")));
            s.setNOME_SUB_GRUPO(rs.getString("NOME_SUB_GRUPO"));
            s.setStatus(Status.get(rs.getString("STATUS")));
            lista.add(s);
        }

//		rs.close();
        return lista;
    }

}
