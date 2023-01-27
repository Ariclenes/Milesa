/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.signcorporation.milesa.model.DAO;

import BD.ConexaoBD;
import MODELO.BEAN.PlanoConta;
import MODELO.BEAN.Status;
import MODELO.UTILS.ExceptionValidacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;

/**
 *
 * @author AEM SIGN ANGOLA<arymonster@gmail.com>
 * @1.1.2
 * 
 */
    public class PlanoContaDAO implements CRUD<PlanoConta>{
    ConexaoBD con = new ConexaoBD();
    Connection conexao = con.getInstance().getConnection();
    @Override
    public void guardar (PlanoConta t) throws ExceptionValidacao, SQLException {
        throw new UnsupportedOperationException ("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean existe (PlanoConta t) throws ExceptionValidacao, SQLException {
        throw new UnsupportedOperationException ("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void inserir (PlanoConta t) throws ExceptionValidacao, SQLException {
        throw new UnsupportedOperationException ("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar (PlanoConta t) throws ExceptionValidacao, SQLException {
        throw new UnsupportedOperationException ("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir (int codigo) throws ExceptionValidacao, SQLException {
        throw new UnsupportedOperationException ("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public TreeItem <PlanoConta> listar() throws ExceptionValidacao, SQLException {
            TreeItem <PlanoConta> LISTAR_PLANO_CONTAS =new TreeItem() ;
		String SQL = "SELECT * FROM PLANO_CONTAS";
              
             
		PreparedStatement ps = conexao.prepareStatement(SQL);
		ResultSet rs = ps.executeQuery();
                System.out.println("sql: " + SQL);

		while (rs.next()) {
                        PlanoConta plano_contas = new PlanoConta();
                        plano_contas.setCODIGO (rs.getInt("CODIGO"));
                        plano_contas.setCOD_CONTA (rs.getString("COD_CONTA"));
                        plano_contas.setNOME_CONTA (rs.getString("NOME_CONTA"));
                        plano_contas.setTIPO_CONTA (rs.getString("TIPO_CONTA"));
//                        LISTAR_PLANO_CONTAS.getChildren().addAll(plano_contas);
//TreeItem mercedes = new TreeItem(new Car("Mercedes", "..."));
//mercedes.getChildren().add(mercedes1);
//mercedes.getChildren().add(mercedes2);
//
//TreeItem audi1 = new TreeItem(new Car("Audi", "A1"));
//TreeItem audi2 = new TreeItem(new Car("Audi", "A5"));
//TreeItem audi3 = new TreeItem(new Car("Audi", "A7"));
//
//TreeItem audi = new TreeItem(new Car("Audi", "..."));
//audi.getChildren().add(audi1);
//audi.getChildren().add(audi2);
//audi.getChildren().add(audi3);
//
//TreeItem cars = new TreeItem(new Car("Cars", "..."));
//cars.getChildren().add(audi);
//cars.getChildren().add(mercedes);
		}
		ps.close();
		rs.close();
		return LISTAR_PLANO_CONTAS;
    }
    
    @Override
    public ObservableList<PlanoConta> listar (boolean somenteAtivos) throws ExceptionValidacao, Exception {
       ObservableList<PlanoConta> LISTAR_PLANO_CONTAS = FXCollections.observableArrayList();
		String SQL = "SELECT * FROM PLANO_CONTAS";
                       SQL += ((somenteAtivos) ? " WHERE STATUS='A' " : " ");
                       SQL += " order by COD_CONTA";
		PreparedStatement ps = conexao.prepareStatement(SQL);
		ResultSet rs = ps.executeQuery();
                System.out.println("sql: " + SQL);

		while (rs.next()) {
                        PlanoConta plano_de_contas = new PlanoConta();
                        plano_de_contas.setCODIGO (rs.getInt("CODIGO"));
                        plano_de_contas.setCOD_CONTA (rs.getString("COD_CONTA"));
                        plano_de_contas.setNOME_CONTA (rs.getString("NOME_CONTA"));
                        plano_de_contas.setTIPO_CONTA (rs.getString("TIPO_DE_CONTA"));
                        plano_de_contas.setNATUREZA_CONTA (rs.getString("NATUREZA_CONTA"));
                        plano_de_contas.setSTATUS (Status.get(rs.getString("STATUS")));
                        
                        LISTAR_PLANO_CONTAS.add(plano_de_contas);
		}
		ps.close();
		rs.close();
		return LISTAR_PLANO_CONTAS;
    }
   
    
     public static PlanoConta get(int codPlanoConta) throws Exception {

        String sql = "select * from PLANO_CONTAS where CODIGO =?";
        ConexaoBD con = new ConexaoBD ();
        Connection conexao = con.getInstance ().getConnection ();
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, codPlanoConta);
        ResultSet rs = ps.executeQuery();
        PlanoConta plano_de_contas = new PlanoConta();
        if (rs.next()) {
            plano_de_contas.setCODIGO (rs.getInt("CODIGO"));
            plano_de_contas.setCOD_CONTA (rs.getString("COD_CONTA"));
            plano_de_contas.setNOME_CONTA (rs.getString("NOME_CONTA"));
            plano_de_contas.setTIPO_CONTA (rs.getString("TIPO_DE_CONTA"));
            plano_de_contas.setNATUREZA_CONTA (rs.getString("NATUREZA_CONTA"));
//            plano_de_contas.setEstado(EstadoDAO.get(rs.getInt("codestado")));
            plano_de_contas.setSTATUS (Status.get(rs.getString("STATUS")));
        }
        return plano_de_contas;
    }

     private void listarTreeView(String idSys) {
    HashMap<Integer, PlanoConta> node = new HashMap<>(); //for child nodes
    HashMap<Integer, PlanoConta> pere = new HashMap<>(); //for parent nodes
    PlanoConta c; //object from component class
    
    String query = "SELECT * FROM composant WHERE id=?";
    ConexaoBD con = new ConexaoBD ();
    Connection conexao = con.getInstance ().getConnection ();
//    try {
//        
//        PreparedStatement ps = conexao.prepareStatement(query);
//        ps.setString(1, idSys);
//       ResultSet rs = ps.executeQuery();
//      
//
//}
}
    
}
