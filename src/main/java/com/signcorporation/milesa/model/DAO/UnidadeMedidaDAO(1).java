package com.signcorporation.milesa.model.DAO;

import BD.ConexaoBD;
import MODELO.BEAN.Status;
import MODELO.BEAN.Unidade_medida;
import MODELO.UTILS.ExceptionValidacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UnidadeMedidaDAO implements CRUD<Unidade_medida>{

	ConexaoBD con =new ConexaoBD();
	private PreparedStatement statement;
        private Connection connetion = con.getInstance ().getConnection ();
       
	private String sql;
	private ResultSet rs;
	 @Override
    public void guardar(Unidade_medida t) throws ExceptionValidacao, SQLException {
       if (t.getCodUnidade () == 0) {
            if (existe(t)) {
                throw new ExceptionValidacao("A Categoria já está cadastrada");
            }
            inserir(t);
        } else {
            alterar(t);
        }
    }

    @Override
    public boolean existe(Unidade_medida U) throws ExceptionValidacao,SQLException {
      String sql = "SELECT COUNT(CODUN_MEDIDA) FROM produto_unidade_medida WHERE NOME_UNIDADE=?";
        ConexaoBD c = new ConexaoBD();
        PreparedStatement ps = c.getInstance().getConnection().prepareStatement(sql);
        ps.setString(1, U.getNOME_UNIDADE ());
        ps.setString(2, U.getDESCRICAO ());
//        ps.setString(4, t.getCor());
//        ps.setString(5, t.getStatus().getDescricao());
        ResultSet rs = ps.executeQuery();
        rs.next();
        return (rs.getInt(1) > 0);
    }
	
        @Override
	public void inserir(Unidade_medida UN) throws ExceptionValidacao, SQLException{ 
		connetion = con.getInstance().getConnection();
		
		sql = "INSERT INTO produto_unidade_medida(NOME_UNIDADE)VALUES(?)";
		
		statement = connetion.prepareStatement(sql);
		
		statement.setString(1, UN.NOME_UNIDADEProperty ().get ());
                statement.setString(2, UN.DESCRICAOProperty ().get ());
		
		statement.execute();
		
		connetion.close();
		statement.close();
		
		
		
	}
        @Override
	public void alterar(Unidade_medida t) throws SQLException, ExceptionValidacao {
		// TODO Auto-generated method stub
		
	}
        @Override
	public void excluir(int id) throws ExceptionValidacao, SQLException{
		connetion = con.getInstance().getConnection();
		
		sql = "DELETE FROM produto_unidade_medida WHERE CODUN_MEDIDA=?";
		
		statement = connetion.prepareStatement(sql);
		
		statement.setInt(1, id);
		statement.execute();
		
		statement.close();
		connetion.close();
		
	}
        @Override
        public ObservableList<Unidade_medida> listar(boolean SomenteAtivos) throws ExceptionValidacao, SQLException{
		ObservableList<Unidade_medida> lista_unidade_medida = FXCollections.observableArrayList();
		
//		connetion = con.getInstance().getConnection();
		
		sql = "select * from produto_unidade_medida";
                sql += ((SomenteAtivos) ? " where status='A' " : " ");
                sql += " order by NOME_UNIDADE";
		 Connection conexao = con.getInstance ().getConnection ();
                 PreparedStatement ps = conexao.prepareStatement(sql);
                //statement = conexao.prepareStatement(sql);
		
		rs = ps.executeQuery();
		Unidade_medida U = null;
		while (rs.next()) {
                    U = new Unidade_medida ();
                    U.setCodUnidade (rs.getInt ("CODUN_MEDIDA"));
                    U.setNOME_UNIDADE (rs.getString ("NOME_UNIDADE"));
                    U.setDESCRICAO (rs.getString ("DESCRICAO"));
                    U.setStatus (Status.get (rs.getString ("STATUS")));
                    lista_unidade_medida.add(U);
		}
		
//		connetion.close();
//		statement.close();
//		rs.close();
		
		return lista_unidade_medida;
	}
        
	
	

        public static Unidade_medida get(int codTipo) throws Exception {
             String sql = "select * from produto_unidade_medida where CODUN_MEDIDA=? ";
                ConexaoBD con = new ConexaoBD ();
                Connection conexao = con.getInstance ().getConnection ();
                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setInt(1, codTipo);
                ResultSet rs = ps.executeQuery();
                Unidade_medida s = new Unidade_medida ();;
                    while (rs.next()) {      
                        s.setCodUnidade (rs.getInt("CODUN_MEDIDA"));
                        s.setNOME_UNIDADE (rs.getString("NOME_UNIDADE"));
                        s.setDESCRICAO (rs.getString("NOME_UNIDADE"));
                        s.setStatus (Status.get (rs.getString("STATUS")));
                }
            return s;
            }
}
