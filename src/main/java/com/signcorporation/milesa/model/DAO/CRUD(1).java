package com.signcorporation.milesa.model.DAO;

import MODELO.UTILS.ExceptionValidacao;
import java.sql.SQLException;
import javafx.collections.ObservableList;

/**
 * Conceito CRUD dentro do CRUD
 *
 * @author AEM Sign Angola
 * @author Ariclenes Maciel
 * @param <T>
 */

public interface CRUD<T> {
    void  guardar(T t)throws ExceptionValidacao, SQLException;// Escolhe qual opção vai usar entre o processo crud 
   
    boolean existe(T t)throws ExceptionValidacao,SQLException;// Verifica se existe um numero igual ao actual
    
    void inserir(T t)throws ExceptionValidacao,SQLException;//Cria um novo objecto do CRUD Create
   
    void alterar(T t)throws ExceptionValidacao,SQLException;//Altera um novo Objecto do Crud Update
   
    void excluir(int codigo)throws ExceptionValidacao,SQLException;// Exclui um objecto do CRUD Delete
   
    ObservableList<T>listar(boolean somenteAtivos)throws ExceptionValidacao,Exception; // Lista todos os Objectos do CRUD Read

}
