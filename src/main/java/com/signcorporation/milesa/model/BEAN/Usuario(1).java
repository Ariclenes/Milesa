package com.signcorporation.milesa.model.BEAN;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author AEM Sign Angola
 */
public class Usuario {

    public String getSenha() {
        return senha.get();
    }

    public StringProperty senhaProperty() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha.set(senha);
    }

    public String getNome() {
        return nome.get();
    }

    public StringProperty nomeProperty() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome.set(nome);
    }

    public String getPerfil() {
        return perfil.get();
    }

    public StringProperty perfilProperty() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil.set(perfil);
    }

    public String getLogin() {
        return login.get();
    }

    public StringProperty loginProperty() {
        return login;
    }

    public void setLogin(String login) {
        this.login.set(login);
    }

    public String getCodigo() {
        return codigo.get();
    }

    public StringProperty idProperty() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo.set(codigo);
    }

    StringProperty login = new SimpleStringProperty();
    StringProperty senha = new SimpleStringProperty();
    StringProperty nome = new SimpleStringProperty();
    StringProperty perfil = new SimpleStringProperty();
    StringProperty codigo = new SimpleStringProperty();
}
