package com.signcorporation.milesa.model.DAO;

import BD.ConexaoBD;
import MODELO.BEAN.Funcionario;
import MODELO.BEAN.Nivel;

/**
 *
 * @author AEM Sign Angola
 */
public class MenuPrincipalDAO {

    Funcionario fun = new Funcionario();
    ConexaoBD con = new ConexaoBD();

    public void setValoresUsuario(int codigo) {
//        try {
//            con.ConexaoBD();
////            con.RS = con.STMT.executeQuery("select * from funcionario where codigo='" + codigo + "'");
////            while (con.RS.next()) {
////                fun.setCodPessoa(con.RS.getInt(codigo));
////                fun.setNomeUsuario(con.RS.getString("nomeusuario"));
////                fun.setSenhaUsuario(con.RS.getString("senhausuario"));
//////                fun.setNivel( con.RS.getInt(""));
////                this.nome = con.RS.getString(4);
////                this.email = con.RS.getString(5);
////                this.nivel = con.RS.getString(6);
//            }
//        } catch (Exception ex) {
//            System.out.println(ex);
//        }

    }

    public void setStatus(int codigo) {
//        try {
//            con.ConexaoBD();
//            con.STMT.executeUpdate("updade funcionario set status = 'A' where codigo'" + codigo + "'");
//        } catch (Exception ex) {
//        }

    }

}
