package com.signcorporation.milesa.model.BEAN;

import java.io.File;
import java.time.LocalDate;

/**
 *
 * @author AEM Sign Angola
 */
public class Licenca {

    private int codigo_licenca, M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13;
    private String entidade_licenca,descricao, descricao_responsavel_renovacao,informacao_adicional,KEY1,KEY2,KEY3,KEY4;
    private Funcionario funcionario;
    private LocalDate data_inicio;
    private LocalDate data_expiracao;
    private Status status;


    private File arquivo_pdf;
    

    public int getCodigo_licenca() {
        return codigo_licenca;
    }

    public void setCodigo_licenca(int codigo_licenca) {
        this.codigo_licenca = codigo_licenca;
    }

    public String getEntidade_licenca() {
        return entidade_licenca;
    }

    public void setEntidade_licenca(String entidade_licenca) {
        this.entidade_licenca = entidade_licenca;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(LocalDate data_inicio) {
        this.data_inicio = data_inicio;
    }

    public LocalDate getData_expiracao() {
        return data_expiracao;
    }

    public void setData_expiracao(LocalDate data_expiracao) {
        this.data_expiracao = data_expiracao;
    }



    public String getDescricao_responsavel_renovacao() {
        return descricao_responsavel_renovacao;
    }

    public void setDescricao_responsavel_renovacao(String descricao_responsavel_renovacao) {
        this.descricao_responsavel_renovacao = descricao_responsavel_renovacao;
    }

    public String getInformacao_adicional() {
        return informacao_adicional;
    }

    public void setInformacao_adicional(String informacao_adicional) {
        this.informacao_adicional = informacao_adicional;
    }

    public File getArquivo_pdf() {
        return arquivo_pdf;
    }

    public void setArquivo_pdf(File arquivo_pdf) {
        this.arquivo_pdf = arquivo_pdf;
    }

    public Licenca(int codigo_licenca, String entidade_licenca, Funcionario funcionario, String descricao, LocalDate data_inicio, LocalDate data_expiracao, String status, String descricao_responsavel_renovacao, String informacao_adicional, File arquivo_pdf) {
        this.codigo_licenca = codigo_licenca;
        this.entidade_licenca = entidade_licenca;
        this.funcionario = funcionario;
        this.descricao = descricao;
        this.data_inicio = data_inicio;
        this.data_expiracao = data_expiracao;
  
        this.descricao_responsavel_renovacao = descricao_responsavel_renovacao;
        this.informacao_adicional = informacao_adicional;
        this.arquivo_pdf = arquivo_pdf;
    }

}
