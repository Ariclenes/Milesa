package com.signcorporation.milesa.model.DAO;

import BD.ConexaoBD;
import MODELO.BEAN.Tipo_combustivel;
import MODELO.UTILS.ExceptionValidacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TipoCombustivelDAO implements CRUD<Tipo_combustivel>{
	
	private Connection connetion;
	private PreparedStatement statement;
	private String sql;
	private ResultSet rs;
	private ResultSet rs2;
        ConexaoBD con = new ConexaoBD();
    
        @Override
    public void guardar(Tipo_combustivel t) throws ExceptionValidacao, SQLException {
       if (t.getId_tipo_combustivel() == 0) {
            if (existe(t)) {
                throw new ExceptionValidacao("A Categoria já está cadastrada");
            }
            inserir(t);
        } else {
            alterar(t);
        }
    }

    @Override
    public boolean existe(Tipo_combustivel t) throws ExceptionValidacao,SQLException {
      String sql = "SELECT COUNT(CODIGO) FROM PRODUTO_CATEGORIA WHERE NOME=?, DESCRICAO=?, COR=? and STATUS=?";
        ConexaoBD c = new ConexaoBD();
        PreparedStatement ps = c.getInstance().getConnection().prepareStatement(sql);
        ps.setString(1, t.getNome());
//        ps.setString(2, t.getDescricao());
//        ps.setString(4, t.getCor());
//        ps.setString(5, t.getStatus().getDescricao());
        ResultSet rs = ps.executeQuery();
        rs.next();
        return (rs.getInt(1) > 0);
    }
	
        @Override
	public void inserir(Tipo_combustivel tipo_combustivel) throws ExceptionValidacao, SQLException{
		connetion = con.getInstance().getConnection();
		
		sql = "insert into tb_tipo_combustivel(id_unidade_medida_fk,nome, quantidade, estoque_maximo, estoque_minimo)values(?,?,?,?,?)";
		
		statement = connetion.prepareStatement(sql);
		
//		statement.setInt(1, tipo_combustivel.getUnidade_medida().getId_unidade_medida());
		statement.setString(2, tipo_combustivel.getNome());
		statement.setBigDecimal(3, tipo_combustivel.getQuantidade());
		statement.setBigDecimal(4, tipo_combustivel.getEstoque_maximo());
		statement.setBigDecimal(5, tipo_combustivel.getEstoque_minimo());
		
		statement.execute();
		
		connetion.close();
		statement.close();
		
		
		
	}
        @Override
	public void alterar(Tipo_combustivel tipo_combustivel) throws ExceptionValidacao, SQLException{
		connetion = con.getInstance().getConnection();
		
		sql = "update tb_tipo_combustivel set id_unidade_medida_fk=?,nome=?, quantidade=?, estoque_maximo=?, estoque_minimo=? where id_tipo_combustivel=?";
		
		statement = connetion.prepareStatement(sql);
		
//		statement.setInt(1, tipo_combustivel.getUnidade_medida().getId_unidade_medida());
		statement.setString(2, tipo_combustivel.getNome());
		statement.setBigDecimal(3, tipo_combustivel.getQuantidade());
		statement.setBigDecimal(4, tipo_combustivel.getEstoque_maximo());
		statement.setBigDecimal(5, tipo_combustivel.getEstoque_minimo());
		statement.setDouble(6, tipo_combustivel.getId_tipo_combustivel());
		
		statement.execute();
		
		connetion.close();
		statement.close();
		
		
		
	}
        @Override
	public void excluir(int id) throws ExceptionValidacao, SQLException{
		connetion = con.getInstance().getConnection();
		
		sql = "delete from tb_tipo_combustivel where id_tipo_combustivel=?";
		
		statement = connetion.prepareStatement(sql);
		
		statement.setInt(1, id);
		statement.execute();
		
		statement.close();
		connetion.close();
		
	}
        @Override
	public ObservableList<Tipo_combustivel> listar(boolean SomenteAtivos) throws ExceptionValidacao, SQLException{
		ObservableList<Tipo_combustivel> lista_tipo_combustivel = FXCollections.observableArrayList();
		
		connetion = con.getInstance().getConnection();
		
		sql = "select * from tb_tipo_combustivel";
		
		statement = connetion.prepareStatement(sql);
		
		rs = statement.executeQuery();
		
		while (rs.next()) {
			
			sql = "select * from tb_unidade_medida where id_unidade_medida=?";
			
			statement = connetion.prepareStatement(sql);
			statement.setInt(1, rs.getInt("id_unidade_medida_fk")); 
			rs2 = statement.executeQuery();
			rs2.next();
//			lista_tipo_combustivel.add(new Tipo_combustivel(rs.getInt("id_tipo_combustivel"), 
//					new Unidade_medida(rs2.getInt("id_unidade_medida"), rs2.getString("nome")),
//					rs.getString("nome"), rs.getBigDecimal("quantidade"), rs.getBigDecimal("estoque_maximo"), rs.getBigDecimal("estoque_minimo")));
////			
			rs2.close();
		}
		
		connetion.close();
		statement.close();
		rs.close();
		
		return lista_tipo_combustivel;
	}


}
