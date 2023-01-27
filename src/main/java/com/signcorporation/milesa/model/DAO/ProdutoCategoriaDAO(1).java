package com.signcorporation.milesa.model.DAO;

import BD.ConexaoBD;
import MODELO.BEAN.ProdutoCategoria;
import MODELO.BEAN.Status;
import MODELO.UTILS.ExceptionValidacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author AEM Sign Angola
 */
public class ProdutoCategoriaDAO implements CRUD<ProdutoCategoria> {
        private Connection conexao =null;
	private PreparedStatement ps =null;
	private ResultSet rs;
        ConexaoBD con = new ConexaoBD();

   @Override
    public void guardar(ProdutoCategoria t) throws ExceptionValidacao, SQLException {
       if (t.getCodCategoria ()== 0) {
            if (existe(t)) {
                throw new ExceptionValidacao("A Categoria já está cadastrada");
            }
            inserir(t);
        } else {
            alterar(t);
        }
    }

    @Override
    public boolean existe(ProdutoCategoria t) throws ExceptionValidacao,SQLException {
      String sql = "SELECT COUNT(CODIGO) FROM PRODUTO_CATEGORIA WHERE NOME=?, AND BG=? ";
        ConexaoBD c = new ConexaoBD();
        PreparedStatement ps = c.getInstance().getConnection().prepareStatement(sql);
        ps.setString(1, t.getNome_categoria ());
//        ps.setString(2, t.getDescricao());
        ps.setString(2, t.getBackground ());
//        ps.setString(5, t.getStatus().getDescricao());
        ResultSet rs = ps.executeQuery();
        rs.next();
        return (rs.getInt(1) > 0);
    }
    @Override
    public void inserir(ProdutoCategoria c)throws ExceptionValidacao {
        try {
           conexao =con.getInstance().getConnection();
           ps = conexao.prepareStatement("INSERT INTO PRODUTO_CATEGORIA(NOME,BG) VALUES(?,?) ");
           ps.setString(1, c.getNome_categoria ());
           ps.setString(2, c.getBackground ());
           ps.execute();
//	   connetion.close();
           ps.close();

        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
    
      @Override
    public void alterar(ProdutoCategoria t) throws ExceptionValidacao, SQLException {
       String sql = "UPDATE PRODUTO_CATEGORIA SET NOME=?,  COR=? WHERE CODIGO=?";
        ConexaoBD con = new ConexaoBD();
        conexao = con.getInstance().getConnection();
        ps=conexao.prepareStatement(sql);
        ps.setString(1, t.getNome_categoria ());
//        ps.setString(2, t.getDescricao());
        ps.setString(2, t.getBackground ());
//        ps.setString(4, t.getStatus().getDescricao());
        ps.setInt(3, t.getCodCategoria ());
        ps.execute();
    }
    
    @Override
    public void excluir(int codigo) throws ExceptionValidacao, SQLException {
       conexao = con.getInstance().getConnection();
        ps = conexao.prepareStatement("DELETE FROM PRODUTO_CATEGORIA WHERE CODIGO=?");
	ps.setInt(1, codigo);
	ps.execute();
	ps.close();
//		connetion.close();
    }
    public static ProdutoCategoria get(int codCategotia) throws Exception {

        String sql = "select * from PRODUTO_CATEGORIA where CODIGO=? ";
        ConexaoBD con = new ConexaoBD ();
        Connection conexao = con.getInstance ().getConnection ();
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, codCategotia);
        ResultSet rs = ps.executeQuery();
        ProdutoCategoria     c = new ProdutoCategoria();
        if (rs.next()) {
            c.setCodCategoria (rs.getInt("CODIGO"));
            c.setNome_categoria (rs.getString("NOME_CATEGORIA"));
            c.setBackground (rs.getString ("BG"));
            c.setForeground (rs.getString ("FG"));
            c.setStatus(Status.get(rs.getString("status")));
        }
        return c;
    }
     @Override
    public  ObservableList<ProdutoCategoria> listar(boolean somenteAtivos) throws ExceptionValidacao, SQLException {
            ObservableList<ProdutoCategoria> lista_categoria = FXCollections.observableArrayList();
		Connection conex = con.getInstance().getConnection();
		ps = conex.prepareStatement("SELECT * FROM PRODUTO_CATEGORIA");
		rs = ps.executeQuery();
                 ProdutoCategoria c = null;
		while (rs.next()) {
                c = new ProdutoCategoria();
                c.setCodCategoria (rs.getInt("CODIGO"));
                c.setNome_categoria (rs.getString("NOME_CATEGORIA"));
                c.setBackground (rs.getString ("BG"));
                c.setForeground (rs.getString ("FG"));
                c.setStatus(Status.get(rs.getString("status")));
               lista_categoria .add(c);        
		}
//                con.confirmar ();
//		connetion.close();
//		ps.close();
//		rs.close();
		return lista_categoria;
    }
}
