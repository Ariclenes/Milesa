package com.signcorporation.milesa.model.BEAN;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author AEM Sign Angola
 */
public class ProdutoCategoria {

    private IntegerProperty codCategoria;
    private StringProperty nome_categoria;
    private StringProperty background;
    private StringProperty foreground;
    private Status status = Status.ATIVO;


    //Metodos atributo: codCategoria
    public int getCodCategoria() {
        return codCategoria.get();
    }

    public void setCodCategoria(int codCategoria) {
        this.codCategoria = new SimpleIntegerProperty(codCategoria);
    }

    public IntegerProperty CodCategoriaProperty() {
        return codCategoria;
    }

    //Metodos atributo: nome_categoria
    public String getNome_categoria() {
        return nome_categoria.get();
    }

    public void setNome_categoria(String nome_categoria) {
        this.nome_categoria = new SimpleStringProperty(nome_categoria);
    }

    public StringProperty Nome_categoriaProperty() {
        return nome_categoria;
    }

    //Metodos atributo: background
    public String getBackground() {
        return background.get();
    }

    public void setBackground(String background) {
        this.background = new SimpleStringProperty(background);
    }

    public StringProperty BackgroundProperty() {
        return background;
    }

    //Metodos atributo: foreground
    public String getForeground() {
        return foreground.get();
    }

    public void setForeground(String foreground) {
        this.foreground = new SimpleStringProperty(foreground);
    }

    public StringProperty ForegroundProperty() {
        return foreground;
    }

    //Metodos atributo: status
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {

        return nome_categoria.get();

    }


}
