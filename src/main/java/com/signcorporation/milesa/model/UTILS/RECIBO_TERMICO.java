package com.signcorporation.milesa.model.UTILS;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Hacker PC
 */
public class RECIBO_TERMICO {

    private String produto;
    private double PRECO_UNITARIO, QTD, PAGAMENTO, VALOR_TOTAL = 0, DESCONTO = 0;
    private int TAXA_IVA = 0, len = 0;

    String[][] rec = new String[100][3];

    public void setPAGAMENTO(double PAGAMENTO) {
        this.PAGAMENTO = PAGAMENTO;
    }

    public void setTAXA(int TAXA_IVA) {
        this.TAXA_IVA = TAXA_IVA;
    }

    public void setDATA(String produto, double QTD, double preco, double desconto, int i) {
        this.produto = produto;
        this.PRECO_UNITARIO = preco;
        this.QTD = QTD;
        this.DESCONTO = desconto;
        this.VALOR_TOTAL = preco * QTD;
        rec[i][0] = produto;
        rec[i][1] = Variaveis.decimal.format(QTD);
        rec[i][2] = (preco) + "";
        len = i;
    }

    StringBuilder sb = new StringBuilder();

    public String CRIAR_RECIBO() {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        sb.append(String.format("\n\r\t\t%s\n\r\n\r\t%s\n\r\n\r", Variaveis.NOME_EMPRESA, sdf.format(date)));
        sb.append(String.format("%-22s%-6s %-9s\n\r------------------------------------\n\r", "Produto", "Qtd", "Preço", "Total"));
        for (int i = 0; i <= len; i++) {
            try {
                sb.append(String.format("%-22s%-6.2f%.2f\n\r", rec[i][0] + " x " +
                        rec[i][1], Double.parseDouble(rec[i][2]), (Double.parseDouble(rec[i][1]) *
                        Double.parseDouble(rec[i][2]))));
            } catch (Exception e) {
//                e.printStackTrace ();
                System.out.println("erro ao imprimir linha" + e);
                e.getMessage();
            }

        }
        sb.append("\n\r------------------------------------\n\r");
        sb.append(String.format("%-22s%10.2fAKZ\n\r%-18s%10d%%\n\r%-18s%10.2fAKZ\n\r\n\r", "Total sem IVA:", VALOR_TOTAL, "IVA", TAXA_IVA, "TOTAL:", VALOR_TOTAL + (VALOR_TOTAL * TAXA_IVA / 100)));
        sb.append(String.format("%-22s%10.2fAKZ\n\r%-18s%10.2fAKZ", "Pagemento:", PAGAMENTO, "Troco:", PAGAMENTO - (VALOR_TOTAL + (VALOR_TOTAL * TAXA_IVA / 100))));
        sb.append(String.format("\n\r\n\rOperador: %s", Variaveis.FUNCIONARIO_NOME));
        sb.append("\n\r\t\tOBRIDADO PELA PREFERENCIA");
        CRIAR_FICHEIRO(date);
        System.out.println("foi" + date);
        return sb.toString();

    }

    public void CRIAR_FICHEIRO(Date date) {
        File smsf = new File(System.getProperty("user.home") + "/SmartERP");
        smsf.mkdir();
        File fat = new File(smsf.getAbsolutePath() + "/RPT");
        fat.mkdir();
        File file = new File(fat.getAbsolutePath() + "/" + new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss").format(date) + ".txt");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException io) {
            io.printStackTrace();
        }
        try (FileWriter fw = new FileWriter(file); BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
