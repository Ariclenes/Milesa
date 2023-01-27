package com.signcorporation.milesa.model.BEAN;

import BD.ConexaoBD;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author AEM Sign Angola
 */
public class Login {

    ConexaoBD con = new ConexaoBD();

    private boolean Status_login = false;
    private String codigo;
    private String NOME;
    private String EMAIL;
    private String NIVEL;
    private String STATUS;

    public void setLOGIN(String nome_usuario, String senha_usuario) {

//        try {
//            int row = 0;
//            con.ConexaoBD();
//            con.RS = con.STMT.executeQuery("select codpessoa,nivel, nome , status from funcionario where nomeusuario= '"
//                    + nome_usuario + "'and senhausuario='" + senha_usuario + "'");
//            while (con.RS.next()) {
//                row = con.RS.getRow();
//                this.codigo = con.RS.getString("codpessoa");
//                this.NIVEL = con.RS.getString("nivel");
//                this.NOME = con.RS.getString("nome");
//                this.STATUS = con.RS.getString("status");
//            }
//            if (row == 1) {
//                Status_login = true;
//            } else {
//                Status_login = false;
//            }
//        } catch (Exception e) {
//
//        }
    }

    public void setSTATUS(String codigo) {
//        con.ConexaoBD();
        try {
//            con.STMT.executeUpdate("select funcionario set status ='A' where codpessoa ='" + codigo + "'");
        } catch (Exception e) {

        }
    }

    public boolean getLOGIN() {
        return Status_login;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNOME() {
        return NOME;
    }

    public String getNIVEL() {
        return NIVEL;
    }

    /**
     * @return the STATUS
     */
    public String getSTATUS() {
        return STATUS;
    }

    public void setValue(String codigo) {

//        try {
//            con.ConexaoBD();
//            con.RS = con.STMT.executeQuery("SELECT * FROM FUNCIONARIO WHERE CODPESSOA='" + codigo + "'");
//            while (con.RS.next()) {
//                this.codigo = con.RS.getString(1);
//                this.setNOME(con.RS.getString(2));
//                this.setEMAIL(con.RS.getString(3));
//                this.NIVEL = con.RS.getString(4);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }

    public void setStatus(String codigo) {

//        try {
//            con.ConexaoBD();
//            con.STMT.executeUpdate("UPDATE FUNCIONARIO SET STATUS= 'A' WHERE CODPESSOA='" + codigo + "'");
//        } catch (SQLException ex) {
//            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }

    /**
     * @return the EMAIL
     */
    public String getEMAIL() {
        return EMAIL;
    }

    /**
     * @param NOME the NOME to set
     */
    public void setNOME(String NOME) {
        this.NOME = NOME;
    }

    /**
     * @param EMAIL the EMAIL to set
     */
    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }
}
