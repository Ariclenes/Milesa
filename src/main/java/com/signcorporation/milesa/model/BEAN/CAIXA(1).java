/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.signcorporation.milesa.model.BEAN;

import BD.ConexaoBD;
import java.sql.Connection;
import java.util.Date;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Hacker PC
 */
public class CAIXA {
    
    
    ConexaoBD con = new ConexaoBD ();
    Connection conexao = con.getInstance ().getConnection ();
  private IntegerProperty codFuncionario;
	private IntegerProperty codCaixa;
	private DoubleProperty VALOR_INICIAL;
	private DoubleProperty VALOR_ATUAL;
	private DoubleProperty VALOR_SAIDA;
	private DoubleProperty VALOR_LUCRO;
	private Date DATA_CAIXA;
	private IntegerProperty CAIXA_TERMINAL;
        private boolean SITUACAO;
	private StringProperty FORMA_PGTO;

//	public CAIXA(int codFuncionario, int codCaixa, Double VALOR_INICIAL, 
//Double VALOR_ATUAL, Double VALOR_SAIDA, Double VALOR_LUCRO, 
//Date DATA_CAIXA, int CAIXA_TERMINAL, String FORMA_PGTO) { 
//		this.codFuncionario = new SimpleIntegerProperty(codFuncionario);
//		this.codCaixa = new SimpleIntegerProperty(codCaixa);
//		this.VALOR_INICIAL = new SimpleDoubleProperty(VALOR_INICIAL);
//		this.VALOR_ATUAL = new SimpleDoubleProperty(VALOR_ATUAL);
//		this.VALOR_SAIDA = new SimpleDoubleProperty(VALOR_SAIDA);
//		this.VALOR_LUCRO = new SimpleDoubleProperty(VALOR_LUCRO);
//		this.DATA_CAIXA = DATA_CAIXA;
//		this.CAIXA_TERMINAL = new SimpleIntegerProperty(CAIXA_TERMINAL);
//		this.FORMA_PGTO = new SimpleStringProperty(FORMA_PGTO);
//	}

	//Metodos atributo: codFuncionario
	public int getCodFuncionario() {
		return codFuncionario.get();
	}
	public void setCodFuncionario(int codFuncionario) {
		this.codFuncionario = new SimpleIntegerProperty(codFuncionario);
	}
	public IntegerProperty CodFuncionarioProperty() {
		return codFuncionario;
	}
	//Metodos atributo: codCaixa
	public int getCodCaixa() {
		return codCaixa.get();
	}
	public void setCodCaixa(int codCaixa) {
		this.codCaixa = new SimpleIntegerProperty(codCaixa);
	}
	public IntegerProperty CodCaixaProperty() {
		return codCaixa;
	}
	//Metodos atributo: VALOR_INICIAL
	public Double getVALOR_INICIAL() {
		return VALOR_INICIAL.get();
	}
	public void setVALOR_INICIAL(Double VALOR_INICIAL) {
		this.VALOR_INICIAL = new SimpleDoubleProperty(VALOR_INICIAL);
	}
	public DoubleProperty VALOR_INICIALProperty() {
		return VALOR_INICIAL;
	}
	//Metodos atributo: VALOR_ATUAL
	public Double getVALOR_ATUAL() {
		return VALOR_ATUAL.get();
	}
	public void setVALOR_ATUAL(Double VALOR_ATUAL) {
		this.VALOR_ATUAL = new SimpleDoubleProperty(VALOR_ATUAL);
	}
	public DoubleProperty VALOR_ATUALProperty() {
		return VALOR_ATUAL;
	}
	//Metodos atributo: VALOR_SAIDA
	public Double getVALOR_SAIDA() {
		return VALOR_SAIDA.get();
	}
	public void setVALOR_SAIDA(Double VALOR_SAIDA) {
		this.VALOR_SAIDA = new SimpleDoubleProperty(VALOR_SAIDA);
	}
	public DoubleProperty VALOR_SAIDAProperty() {
		return VALOR_SAIDA;
	}
	//Metodos atributo: VALOR_LUCRO
	public Double getVALOR_LUCRO() {
		return VALOR_LUCRO.get();
	}
	public void setVALOR_LUCRO(Double VALOR_LUCRO) {
		this.VALOR_LUCRO = new SimpleDoubleProperty(VALOR_LUCRO);
	}
	public DoubleProperty VALOR_LUCROProperty() {
		return VALOR_LUCRO;
	}
	//Metodos atributo: DATA_CAIXA
	public Date getDATA_CAIXA() {
		return DATA_CAIXA;
	}
	public void setDATA_CAIXA(Date DATA_CAIXA) {
		this.DATA_CAIXA = DATA_CAIXA;
	}
	//Metodos atributo: CAIXA_TERMINAL
	public int getCAIXA_TERMINAL() {
		return CAIXA_TERMINAL.get();
	}
	public void setCAIXA_TERMINAL(int CAIXA_TERMINAL) {
		this.CAIXA_TERMINAL = new SimpleIntegerProperty(CAIXA_TERMINAL);
	}
	public IntegerProperty CAIXA_TERMINALProperty() {
		return CAIXA_TERMINAL;
	}
        
	//Metodos atributo: FORMA_PGTO
	public String getFORMA_PGTO() {
		return FORMA_PGTO.get();
	}
	public void setFORMA_PGTO(String FORMA_PGTO) {
		this.FORMA_PGTO = new SimpleStringProperty(FORMA_PGTO);
	}
	public StringProperty FORMA_PGTOProperty() {
		return FORMA_PGTO;

//    // abrir Caixa
//    public void AbrirCaixa(CAIXA caixa) {
//        try {
//            PreparedStatement abrir = conexao.prepareStatement("insert into Caixa (valorInicial, valorAtual, valorSaida, valorLucro, dataCaixa,caixaTerminal, Vendedor_idVendedor, situacao) values (?,?,?,?,?,?,?,?)");
//            abrir.setDouble(1, caixa.getVALOR_INICIAL ());
//            abrir.setDouble(2, caixa.getVALOR_ATUAL ());
//            abrir.setDouble(3, caixa.getVALOR_SAIDA ());
//            abrir.setDouble(4, caixa.getVALOR_LUCRO ());
//            abrir.setDate (5, caixa.getDATA_CAIXA ());
//            abrir.setInt(6, caixa.getCAIXA_TERMINAL ());
//            abrir.setInt(7, caixa.getCodFuncionario ());
//            abrir.setBoolean(8, caixa.get);
//            abrir.execute();
//            System.out.println("Caixa Aberto com sucesso!");
//
//        } catch (SQLException ex) {
//            System.out.println("Erro ao Abrir Caixa");
//        }
//
//    }

    // abrir Caixa
//    public CAIXA BuscarCaixaPorData() {
//        Date data = new Date();
//        SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
//        formatador.format(data);
//        String dataAtual = formatador.format(data);
//
//        try {
//            PreparedStatement buscar = conexao.prepareStatement("select *from Caixa where dataCaixa='" + dataAtual + "'");
//            ResultSet res = buscar.executeQuery();
//
//            while (res.next()) {
//                CAIXA caixa = new CAIXA();
//                caixa.setCodVendedor(res.getInt(8));
//                if (caixa.getCodVendedor() == Home.getCodVendedor()) {
//                  
//                    caixa.setCodCaixa(res.getInt(1));
//                    caixa.setValorInicial(res.getInt(2));
//                    caixa.setValorAtual(res.getInt(3));
//                    caixa.setValorSaida(res.getInt(4));
//                    caixa.setValorLucro(res.getInt(5));
//                    caixa.setData(res.getString(6));
//                    caixa.setCaixaTerminal(res.getInt(7));
//                    caixa.setCodVendedor(res.getInt(8));
//                    caixa.setSituacao(res.getBoolean(9));
//                    return caixa;
//
//                }
//
//            }
//
//        } catch (SQLException ex) {
//            System.out.println("Erro ao Buscar  Caixa");
//        }
//        return null;
//
//    }

    // fechar caixa
//    public void situacaoCaixa(boolean situacao) {
//        Date data = new Date();
//        SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
//        formatador.format(data);
//        String dataAtual = formatador.format(data);
////        Home.setAltorizado(situacao);
//        PreparedStatement fechar;
//        try {
//            fechar = conexao.prepareStatement("update Caixa set situacao =? where dataCaixa='" + dataAtual + "'");
//            fechar.setBoolean(1, situacao);
//            fechar.execute();
//
//            if (situacao) {
//                System.out.println("Caixa Aberto");
//            } else {
//                System.out.println("Caixa fechado");
//
//            }
//
//        } catch (SQLException ex) {
//            System.out.println("Erro ao fechar o caixa");
//        }
//
//    }
//    
//    
//    

    // fechar caixa
//    public void AtualizarDados(CAIXA caixa, int codVendedor) {
//        Date data = new Date();
//        SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
//        formatador.format(data);
//        String dataAtual = formatador.format(data);
//
//        PreparedStatement atualiza;
//        try {
//            atualiza = conexao.prepareStatement("update Caixa set valorAtual =?, valorSaida=?, valorLucro=? where dataCaixa='" + dataAtual + "' and Vendedor_idVendedor ="+codVendedor);
//            atualiza.setDouble(1, caixa.getValorAtual());
//            atualiza.setDouble(2, caixa.getValorSaida());
//            atualiza.setDouble(3, caixa.getValorLucro());
//
//            atualiza.execute();
//
//            System.out.println("Atualizador com sucesso");
//
//        } catch (SQLException ex) {
//            System.out.println("Erro ao atualizar o caixa");
//        }
//
//    }

    // verificando se existe caixa iguais
//    public boolean verificar() {
//        Date data = new Date();
//        SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
//        formatador.format(data);
//        String dataAtual = formatador.format(data);
//        try {
//            PreparedStatement buscar = conexao.prepareStatement("select * from Caixa where dataCaixa='" + dataAtual + "'");
//            ResultSet res = buscar.executeQuery();
//
//            while (res.next()) {
//                CAIXA caixa = new CAIXA();
//                caixa.setCodFuncionario (res.getInt(8));
////                if (caixa.getCodVendedor() == Home.getCodVendedor()) {
////                    return true;
////                }
//            }
//
//        } catch (SQLException ex) {
//            System.out.println("Erro ao Buscar  Caixa");
//        }
//        return false;
//
    }
}
