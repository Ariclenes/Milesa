package com.signcorporation.milesa.model.BEAN;

import java.security.InvalidParameterException;
import java.util.Date;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Pessoa {

    private IntegerProperty codPessoa;
    private PessoaFisica pessoaFisica;
    private PessoaJuridica pessoaJuridica;
    private Cidade cidade;
    private boolean cliente;
    private boolean fornecedor;
    private boolean funcionario;
    private StringProperty nome, email, telefone, endereco;
    private Date dataCadastro;
    private Status status = Status.ATIVO;

    //Metodos atributo: codPessoa
    public int getCodPessoa() {
        return codPessoa.get();
    }

    public void setCodPessoa(int codPessoa) {
        if (codPessoa < 0) {
            throw new InvalidParameterException("Código inválido.");
        }
        this.codPessoa = new SimpleIntegerProperty(codPessoa);
    }

    public IntegerProperty CodPessoaProperty() {
        return codPessoa;
    }

    //Metodos atributo: pessoaFisica
    public PessoaFisica getPessoaFisica() {
        return pessoaFisica;
    }

    public void setPessoaFisica(PessoaFisica pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
        this.pessoaJuridica = null;

    }

    //Metodos atributo: pessoaJuridica
    public PessoaJuridica getPessoaJuridica() {
        return pessoaJuridica;
    }

    public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
        this.pessoaJuridica = pessoaJuridica;
        this.pessoaFisica = null;
    }

    //Metodos atributo: cidade
    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        if (cidade == null) {
            throw new InvalidParameterException("Cidade inválida.");
        }
        this.cidade = cidade;
    }

    //Metodos atributo: cliente
    public boolean isCliente() {
        return cliente;
    }

    public boolean getCliente() {
        return cliente;
    }

    public void setCliente(boolean cliente) {
        this.cliente = cliente;
    }

    //Metodos atributo: fornecedor
    public boolean isFornecedor() {
        return fornecedor;
    }

    public boolean getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(boolean fornecedor) {
        this.fornecedor = fornecedor;
    }

    //Metodos atributo: funcionario
    public boolean isFuncionario() {
        return funcionario;
    }

    public boolean getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(boolean funcionario) {
        this.funcionario = funcionario;
    }

    //Metodos atributo: nome
    public String getNome() {
        return nome.get();
    }

    public void setNome(String nome) {
        if (nome.trim().length() < 3 || nome.trim().length() > 200) {
            throw new InvalidParameterException("Nome inválido.");
        }
        this.nome = new SimpleStringProperty(nome);
    }

    public StringProperty NomeProperty() {
        return nome;
    }

    //Metodos atributo: email
    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email = new SimpleStringProperty(email);
    }

    public StringProperty EmailProperty() {
        return email;
    }

    //Metodos atributo: telefone
    public String getTelefone() {
//            return telefone;
        return telefone.get();
    }

    public void setTelefone(String telefone) {
        this.telefone = new SimpleStringProperty(telefone);
    }

    public StringProperty TelefoneProperty() {
        return telefone;
    }

    //Metodos atributo: endereco
    public String getEndereco() {
        return endereco.get();
    }

    public void setEndereco(String endereco) {
        this.endereco = new SimpleStringProperty(endereco);
    }

    public StringProperty EnderecoProperty() {
        return endereco;
    }

    //Metodos atributo: dataCadastro
    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    //Metodos atributo: status
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDocumento() {
        if (pessoaFisica != null) {
            return pessoaFisica.getNIF();
        } else if (pessoaJuridica != null) {
            return pessoaJuridica.getNIF_EMPRESA();
        } else {
            return "";
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Pessoa) {
            return ((Pessoa) obj).getCodPessoa() == getCodPessoa();
        }
        return false;
    }

    @Override
    public String toString() {
        return getNome();
    }


}
