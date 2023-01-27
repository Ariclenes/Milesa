package com.signcorporation.milesa.model.BEAN;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author AEM Sign Angola
 */
@Entity
@Table(name = "Idioma")
public class Idioma {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codigo_Idioma")
    private long codigo;

    @Column(name = "nome_Idioma")
    private String nomeIdioma;

    @Column(name = "codigo_Idioma")
    private String codigoIdioma;

    @Column(name = "codigo_pais")
    private String codigo_pais;

    @Column(name = "esta_predefinido")
//    @Type(type = "true_false")
    private boolean estaPredefinido;

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNomeIdioma() {
        return nomeIdioma;
    }

    public void setNomeIdioma(String nomeIdioma) {
        this.nomeIdioma = nomeIdioma;
    }

    public String getCodigoIdioma() {
        return codigoIdioma;
    }

    public void setCodigoIdioma(String codigoIdioma) {
        this.codigoIdioma = codigoIdioma;
    }

    public String getCodigo_pais() {
        return codigo_pais;
    }

    public void setCodigo_pais(String codigo_pais) {
        this.codigo_pais = codigo_pais;
    }

    public boolean isEstaPredefinido() {
        return estaPredefinido;
    }

    public void setEstaPredefinido(boolean estaPredefinido) {
        this.estaPredefinido = estaPredefinido;
    }

    public boolean equal(Object obj) {
        if (obj != null) {
            Idioma idioma = (Idioma) obj;
            return idioma.getCodigo() == getCodigo();
        }
        return false;
    }

    @Override
    public String toString() {
        return getNomeIdioma();
    }

}
