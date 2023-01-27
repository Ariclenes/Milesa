package com.signcorporation.milesa.model.DAO;
import BD.ConexaoBD;
import MODELO.BEAN.ProdutoGrupo;
import MODELO.BEAN.Status;
import MODELO.UTILS.ExceptionValidacao;
import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author AEM Sign Angola
 */
public class ProdutoGrupoDAO implements CRUD<ProdutoGrupo> {
    PreparedStatement ps = null;
    ConexaoBD con = new ConexaoBD();
    Connection conexao = con.getInstance ().getConnection ();
    private ResultSet rs=null;
    private String sql;

    @Override
    public void guardar(ProdutoGrupo t) throws ExceptionValidacao, SQLException {
          if (t.getCodGrupo ()== 0) {
            if (existe(t)) {
                throw new ExceptionValidacao("A Familia já está cadastrada");
            }
            inserir(t);
        } else {
            alterar(t);
        }
    }

    @Override
    public boolean existe(ProdutoGrupo t) throws ExceptionValidacao, SQLException {
      String sql = "SELECT COUNT(CODIGO) FROM PRODUTO_GRUPO WHERE NOME=? AND CODGRUPO=?";
        conexao = con.getInstance().getConnection();
        ps=conexao.prepareStatement(sql);
        ps.setString(1, t.getNOME_GRUPO ());
//        ps.setString(2, t.getCor_grupo());
        ps.setString(3, t.getStatus().getSIGLA ());
        ResultSet rs = ps.executeQuery();
        rs.next();
        return (rs.getInt(1) > 0);  
    }

    @Override
    public void inserir(ProdutoGrupo t) throws ExceptionValidacao, SQLException {
       conexao = con.getInstance().getConnection();
		sql = "INSERT INTO  PRODUTO_GRUPO(NOME)VALUES(?)";
		ps = conexao.prepareStatement(sql);
		ps.setString(1, t.getNOME_GRUPO ());
//                ps.setString(2, t.getCor_grupo());
//                ps.setString(3, t.getStatus().;
		ps.execute();
//		connetion.close();
		ps.close();
    }

    @Override
    public void alterar(ProdutoGrupo t) throws ExceptionValidacao, SQLException {
      String sql = "UPDATE PRODUTO_GRUPO SET NOME_GRUPO=?, WHERE CODGRUPO=?";
        ConexaoBD con = new ConexaoBD();
        conexao = con.getInstance().getConnection();
        ps =conexao.prepareStatement(sql);
        ps.setString(1, t.getNOME_GRUPO ());
        ps.setString(2, t.getStatus().getSIGLA ());
        ps.setInt(3, t.getCodGrupo ());
        ps.execute();
    }

    @Override
    public void excluir(int codigo) throws ExceptionValidacao, SQLException {
       conexao = con.getInstance().getConnection();
       ps = conexao.prepareStatement("DELETE FROM PRODUTO_GRUPO WHERE CODGRUPO=?");
       ps.setInt(1, codigo);
       ps.execute();
       ps.close();
//		connetion.close();
    }

    public  ObservableList<ProdutoGrupo> listar() throws ExceptionValidacao, SQLException {
            ObservableList<ProdutoGrupo> lista = FXCollections.observableArrayList();
	;
		PreparedStatement ps = conexao.prepareStatement("SELECT * FROM PRODUTO_GRUPO");
		ResultSet rs = ps.executeQuery();
                ProdutoGrupo g = null;
        if (rs.next()) {
                g = new ProdutoGrupo();
                g.setCodGrupo (rs.getInt("CODGRUPO"));
                g.setNOME_GRUPO (rs.getString("NOME_GRUPO"));
                g.setStatus(Status.get(rs.getString("status")));
                lista.add(g);           
		}
                ps.close();
		rs.close();
                return lista;
    }
    
    @Override
    public ObservableList<ProdutoGrupo> listar(boolean somenteAtivos) throws ExceptionValidacao, SQLException {
            ObservableList<ProdutoGrupo> lista_grupo = FXCollections.observableArrayList();
         String sql = "SELECT * FROM PRODUTO_GRUPO ";
        sql += ((somenteAtivos) ? " where STATUS='A' " : " ");
        sql += " order by nome";
		Connection conex = con.getInstance().getConnection();
		ps = conex.prepareStatement(sql);
		rs = ps.executeQuery();
		ProdutoGrupo g = null;
        if (rs.next()) {
            g = new ProdutoGrupo();
            g.setCodGrupo (rs.getInt("CODGRUPO"));
            g.setNOME_GRUPO (rs.getString("NOME_TIPO"));
            g.setStatus(Status.get(rs.getString("status")));
            lista_grupo .add(g);        
		}
                return lista_grupo;
    }

    public static ProdutoGrupo get(int codTipo) throws Exception {

        String sql = "select * from PRODUTO_GRUPO where CODGRUPO=? ";
         ConexaoBD con = new ConexaoBD ();
        Connection conexao = con.getInstance ().getConnection ();
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, codTipo);
        ResultSet rs = ps.executeQuery();
        ProdutoGrupo g = null;
        if (rs.next()) {
            g = new ProdutoGrupo();
            g.setCodGrupo (rs.getInt("CODGRUPO"));
            g.setNOME_GRUPO (rs.getString("NOME_GRUPO"));
            g.setStatus(Status.get(rs.getString("status")));
        }
        return g;
    }

}
