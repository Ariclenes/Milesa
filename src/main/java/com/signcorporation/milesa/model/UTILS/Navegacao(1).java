package com.signcorporation.milesa.model.UTILS;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.util.Duration;

/**
 *
 * @author Ariclenes Evaristo Maciel <arymonster@gmail.com><+244 933 934 838>
 */
public class Navegacao {

    private final String login = "/VIEW/Login.fxml";
    private final String MenuPrincipal = "/VIEW/MenuPrincipal.fxml";
    private final String dashboard = "/VIEW/Dashboard.fxml";
    private final String config_BaseDados = "/view/ConfigDB.fxml";
    private final String config_Sistema = "/view/ConfigSistema.fxml";

    private final String produtos = "/VIEW/Produtos.fxml";
    private final String categoria_produtos = "/VIEW/Produtos.fxml";
    private final String Grupo_produtos = "/VIEW/Produtos.fxml";
    private final String tipo_produtos = "/VIEW/TipoProduto.fxml";
    private final String marca_produtos = "/VIEW/Marca.fxml";

    private final String vendas = "/VIEW/Vendas.fxml";
    private final String compras = "/VIEW/Compras.fxml";

    private final String Funcionarios = "/VIEW/Funcionario.fxml";
    private final String Clientes = "/view/Cliente.fxml";
    private final String Fornecedores = "/view/Fornecedor.fxml";

    private final String visaoImpressao = "/VIEW/RelatorioView.fxml";
    private String nome_usuario, nomecompleto, email;

    public Image IconeAplicacao = new Image(getClass().getResourceAsStream("/VIEW/IMG/loja.png"));

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @return the MenuPrincipal
     */
    public String getMenuPrincipal() {
        return MenuPrincipal;
    }

    /**
     * @return the dashboard
     */
    public String getDashboard() {
        return dashboard;
    }

    /**
     * @return the config_BaseDados
     */
    public String getConfig_BaseDados() {
        return config_BaseDados;
    }

    /**
     * @return the config_Sistema
     */
    public String getConfig_Sistema() {
        return config_Sistema;
    }

    /**
     * @return the produtos
     */
    public String getProdutos() {
        return produtos;
    }

    /**
     * @return the categoria_produtos
     */
    public String getCategoria_produtos() {
        return categoria_produtos;
    }

    /**
     * @return the Grupo_produtos
     */
    public String getGrupo_produtos() {
        return Grupo_produtos;
    }

    /**
     * @return the tipo_produtos
     */
    public String getTipo_produtos() {
        return tipo_produtos;
    }

    /**
     * @return the marca_produtos
     */
    public String getMarca_produtos() {
        return marca_produtos;
    }

    /**
     * @return the vendas
     */
    public String getVendas() {
        return vendas;
    }

    /**
     * @return the compras
     */
    public String getCompras() {
        return compras;
    }

    /**
     * @return the Funcionarios
     */
    public String getFuncionarios() {
        return Funcionarios;
    }

    /**
     * @return the Clientes
     */
    public String getClientes() {
        return Clientes;
    }

    /**
     * @return the Fornecedores
     */
    public String getFornecedores() {
        return Fornecedores;
    }

    /**
     * @return the visaoImpressao
     */
    public String getVisaoImpressao() {
        return visaoImpressao;
    }

    /**
     * @return the nome_usuario
     */
    public String getNome_usuario() {
        return nome_usuario;
    }

    /**
     * @return the nomecompleto
     */
    public String getNomecompleto() {
        return nomecompleto;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    public void animationFade(Node e) {
        FadeTransition x = new FadeTransition(new Duration(1000), e);
        x.setFromValue(0);
        x.setToValue(100);
        x.setCycleCount(1);
        x.setInterpolator(Interpolator.LINEAR);
        x.play();
    }

}
