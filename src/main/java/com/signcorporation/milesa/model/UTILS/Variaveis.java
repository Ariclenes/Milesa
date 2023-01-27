package com.signcorporation.milesa.model.UTILS;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javafx.animation.RotateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import javafx.util.StringConverter;

/**
 * @author AEM Sign Angola
 */
public class Variaveis {
    public static int uid = 0;
    public static int uid2 = 0;
    //  static String uemri = "";
    public static boolean clientes;
    public static boolean produto;
    public static boolean PostodeVendas;
    public static boolean funcionario;
    public static boolean compras;
    public static boolean estatisticas;
    public static boolean HistoricoVendas;
    public static boolean Departamento;
    public static boolean despesas;
    public static boolean financas;
    public static boolean tabelas;
    public static boolean configuracoes;
    public static boolean licenca;
    public static boolean Empresa;

    //Botões de acesso aos perfiss
    public static boolean prod_adicionar;
    public static boolean prod_editar;
    public static boolean prod_excluir;

    public static boolean clic_adicionar;
    public static boolean clic_editar;
    public static boolean clic_excluir;

    public static boolean fun_adicionar;
    public static boolean fun_editar;
    public static boolean fun_excluir;

    public static boolean rel_editar;
    public static boolean rel_excluir;


    public static int funcionarios, funcionarios_Ativos, funcionarios_Intivos, cliente, venda, p, ps;

    public static String Moeda = "AKZ";

    public static String paraMoeda(double moeda) {
        if ("$".equals(Moeda))
            return USD.format(moeda);
        if ("€".equals(Moeda))
            return EURO.format(moeda);

        if ("ZAR".equals(Moeda))
            return zarNamibia.format(moeda);

        if ("R$".equals(Moeda))
            return REAISBRASIL.format(moeda);

        return AKZ.format(moeda);
    }

    public static String paraMoeda(BigDecimal moeda) {
        if ("$".equals(Moeda)) return USD.format(moeda);

        if ("€".equals(Moeda)) return EURO.format(moeda);

        if ("ZAR".equals(Moeda)) return zarNamibia.format(moeda);

        if ("R$".equals(Moeda)) return REAISBRASIL.format(moeda);

        return AKZ.format(moeda);
    }


    public static double daMoeda(String moeda) {
        if ("$".equals(Moeda)) {
            return Double.parseDouble(Moeda.substring(0, moeda.length() - 1));
        }
        if ("€".equals(Moeda)) {
            return Double.parseDouble(Moeda.substring(1, moeda.length() - 1));
        }
        if ("ZAR".equals(Moeda)) {
            return Double.parseDouble(Moeda.substring(2, moeda.length() - 1));
        }
        if ("R$".equals(Moeda)) {
            return Double.parseDouble(Moeda.substring(2, moeda.length() - 1));
        }
        return Double.parseDouble(Moeda.substring(0, moeda.length() - 1));
    }

    private static DecimalFormat AKZ = new DecimalFormat("###,###,##0.00AKZ");
    private static DecimalFormat EURO = new DecimalFormat("###,###,##0.00€");
    private static DecimalFormat decimalFormatLibra = new DecimalFormat("###,###,##0.00£");
    private static DecimalFormat USD = new DecimalFormat("$###,###,##0.00");
    private static DecimalFormat REAISBRASIL = new DecimalFormat("###,###,##0.00R$");
    private static DecimalFormat zarNamibia = new DecimalFormat("###,###,##0.00ZAR");
    public static DecimalFormat decimal = new DecimalFormat("###,###,###.#");
    public static DecimalFormat mkd = new DecimalFormat("ден###,###,##0.00");

    public static String BANCO;
    public static String IBAN;
    public static String CONTA_BANCARIA;
    public static String SWIFT;

    public static String ENDERECO;
    public static String IDIOMA;
    public static String TEMA;


    public static String NOME_EMPRESA;
    public static String NR_FISCAL;
    public static String Cli_tel = null;
    public static String Cli_email = null;
    public static String Cli_nome = null;
    public static Set<String> prod_Categoria = new HashSet();
    public static double IVA;
    public static double mes;
    public static double semana;
    public static double dia;
    public static Set<String> Cliente_nome = new HashSet();


    public static double meio;
    public static double receitaMes = 0.0D;
    public static double receitaSemana = 0.0D;
    public static double receitaDiaria = 0.0D;

    public static Map<Integer, String[]> contasVendas = new HashMap();
    public static Map<Integer, String> reverQuantidade = new HashMap();
    public static Map<String, Integer> Quantidade = new HashMap();

    public static int semanasporMes(int dias) {
        return dias / 7 + ((dias % 7 > 0) ? 1 : 0);
    }

    public static boolean saltarAno(int ano) {
        return (ano % 4 == 0) ? ((ano % 200 == 0) ? false : ((ano % 400 == 0))) : false;
    }

    public static int diasporMes(boolean salto, int mes) {
        return (mes % 2 == 1) ? ((mes >= 7) ? 30 : 31) : ((mes >= 8) ? 31 : 30);
    }


    public static Image spinning = new Image("/VIEW/IMG/spinner.png");
    public static Image doneSpinning = new Image("/VIEW/IMG/doneSpinning.png");

    @SuppressWarnings("unchecked")
    public static Map<Integer, String> dataMap = new HashMap();
    @SuppressWarnings("unchecked")
    public static Map<String, Integer> departamento = new HashMap();


    public static Map<Integer, String> revDepartamento = new HashMap();
    public static Map<String, Integer> revProdCATEGORIA = new HashMap();
    public static Map<String, Integer> revCLIENTE = new HashMap();
    public static Map<String, Integer> revUNIDADE = new HashMap();
    public static Map<String, Integer> revTIPO = new HashMap();
    public static Map<String, Integer> revGRUPO = new HashMap();
    public static Map<String, Integer> revSUB_GRUPO = new HashMap();
    public static Map<String, Integer> revUNIDADE_MEDIDA = new HashMap();
    public static Map<Integer, String> CarregarCategoria = new HashMap();
    public static Map<Integer, String> CarregarUNIDADE_MEDIDA = new HashMap();
    public static Map<Integer, String> CarregarTIPO = new HashMap();
    public static Map<Integer, String> CarregarGRUPO = new HashMap();

    public static Map<Integer, String> Carregar_SUB_GRUPO = new HashMap();
    public static String FUNCIONARIO_TELEFONE = null;
    public static String FUNCIONARIO_EMAIL = null;
    public static String FUNCIONARIO_NOME = null;
    public static String PESSOA_NOME = null;


    public static Set<String> prod_categoria = new HashSet();
    public static Set<String> nome_cliente = new HashSet();
    public static Set<String> OUTRO_TIPO = new HashSet();


    public static double receitasMes = 0.0D;
    public static double receitasSemana = 0.0D;
    public static double receitasDia = 0.0D;

    public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");


    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    public static SimpleDateFormat hms = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    public static StringConverter converter = new StringConverter<LocalDate>() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        @Override
        public String toString(LocalDate date) {
            if (date != null) {
                return this.formatter.format(date);
            }
            return "";
        }

        @Override
        public LocalDate fromString(String string) {
            if (string != null && !string.equals("")) {
                return LocalDate.parse(string, this.formatter);
            }
            return null;
        }
    };

    public static RotateTransition startSpinning(ImageView iv) {
        RotateTransition transition = new RotateTransition(Duration.millis(700.0D), iv);
        transition.setByAngle(360.0D);
        transition.setCycleCount(-1);
        return transition;
    }

    public static void stopSpinning(RotateTransition transition, ImageView iv) {
        transition.stop();
        iv.setImage(doneSpinning);
        iv.setRotate(0.0D);
    }

    public static Map<String, Integer> Provincia = new HashMap();
    public static Map<Integer, String> revProvincia = new HashMap();
    public static Map<String, Integer> Cidade = new HashMap();
    public static Map<Integer, String> revCidade = new HashMap();
    public static Map<Integer, String[]> Cliente_da_Venda = new HashMap<>();
    public static Map<Integer, String[]> TIPO_FATURA = new HashMap<>();
    public static Map<String, Integer> revTIPO_FATURA = new HashMap();
    public static Map<Integer, String> CarregarTIPO_FATURA = new HashMap();
}
