package com.signcorporation.milesa.model.DAO;

import BD.ConexaoBD;
import MODELO.BEAN.Provincia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Bruna
 */
public class ProvinciaDAO {

    public static ObservableList<Provincia> listar(boolean somenteAtivos) throws SQLException {
            ObservableList<Provincia> lista_cidade = FXCollections.observableArrayList();
             String sql = "select * from PROVINCIA";
             sql += ((somenteAtivos) ? " where STATUS='A' " : " ");
             sql += " order by NOME_PROVINCIA";
                 ConexaoBD con= new ConexaoBD ();
                 Connection conexao =  con.getInstance ().getConnection ();
		 PreparedStatement ps = conexao.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
	while(rs.next()) {
                  Provincia provincia = new Provincia();
                  provincia.setCodProvincia (rs.getInt("CODPROVINCIA")); 
                  provincia.setNome (rs.getString("NOME_PROVINCIA")); 
                  provincia.setSigla(rs.getString("SIGLA"));
                  provincia.setStatus(rs.getString("STATUS"));
                lista_cidade.add(provincia);        
		}
        System.out.println ("Provincia: "+ lista_cidade);
		return lista_cidade;
    }
    public static Provincia get(int codProvincia) throws SQLException {
        String SQL = "SELECT * FROM PROVINCIA WHERE CODPROVINCIA=? ";
        ConexaoBD con = new ConexaoBD();
        Connection conexao = con.getInstance ().getConnection ();
        PreparedStatement ps = conexao.prepareStatement(SQL);
        ps.setInt(1, codProvincia);
        ResultSet rs = ps.executeQuery();
        Provincia provincia = new Provincia ();  ;
        if (rs.next()) {     
        provincia.setCodProvincia(rs.getInt("CODPROVINCIA"));
        provincia.setNome(rs.getString("NOME_PROVINCIA"));
        provincia.setSigla(rs.getString("SIGLA"));
        provincia.setStatus(rs.getString("STATUS"));
        }
        System.out.println ("Provincia: "+ provincia);
        return provincia;

    }

}
