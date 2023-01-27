package com.signcorporation.milesa.model.BEAN;

public class Endereco {
	private int codigo_endereco;
	private String endereco;
	private String numero;
	private String complemento;
	private String bairro;
	private Cidade cidade;
	private Provincia provincia;
        
        public Endereco(int codigo_endereco, Provincia provincia){
		this.codigo_endereco = codigo_endereco;
		this.provincia = provincia;
	}
	public Endereco(int codigo_endereco,String endereco, String numero, String complemento, String bairro,
			Cidade cidade, Provincia provincia) {
		super();
		this.codigo_endereco = codigo_endereco;
		this.endereco = endereco;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.provincia = provincia;
	}
	@Override
	public String toString() {
		return "Endereco [id_endereco=" + codigo_endereco + ", endereco=" + endereco + ", numero=" + numero
				+ ", complemento=" + complemento + ", bairro=" + bairro + ", cidade=" + cidade + ", provincia=" + provincia
				+ "]";
	}

    /**
     * @return the codigo_endereco
     */
    public int getCodigo_endereco() {
        return codigo_endereco;
    }

    /**
     * @param codigo_endereco the codigo_endereco to set
     */
    public void setCodigo_endereco(int codigo_endereco) {
        this.codigo_endereco = codigo_endereco;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the complemento
     */
    public String getComplemento() {
        return complemento;
    }

    /**
     * @param complemento the complemento to set
     */
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return the cidade
     */
    public Cidade getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the provincia
     */
    public Provincia getProvincia() {
        return provincia;
    }

    /**
     * @param provincia the provincia to set
     */
    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }
	
}
