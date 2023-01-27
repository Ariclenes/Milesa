package com.signcorporation.milesa.model.UTILS;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.print.*;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;

/**
 *
 * @author AEM Sign Angola
 */
public class PrintReceipt {
    private PrintService [] servicos = null;    
    
    public void PrintReceipt(String texto) {
        PrintService impressoraServico = PrintServiceLookup.lookupDefaultPrintService();
        InputStream is = new ByteArrayInputStream((texto + "\f").getBytes());

        System.out.println(texto);

        PrintRequestAttributeSet par = new HashPrintRequestAttributeSet();
        par.add(new Copies(1));

        DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;

        if (impressoraServico != null) {
            DocPrintJob impressaoTrabalho = impressoraServico.createPrintJob();
//            impressaoTrabalho.addPrintJobAttributeListener (new ImpressaoVisual ());
            Doc doc = new SimpleDoc(is, flavor, null);

            try {
                impressaoTrabalho.print(doc, par);
                is.close();
            } catch (IOException | PrintException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean avaliadorImpressao() {
        PrintService[] impressoraServico = PrintServiceLookup.lookupMultiDocPrintServices(null, null);
        return impressoraServico.length > 0;
    }
 /**
 *  
 * NOVO METODO DE BUSCA DE IMPRESSORAS
 * 
*/

    public PrintService[] getImpressoras(){
    
    servicos = PrintServiceLookup.lookupPrintServices (null, null);
    for(PrintService ps : servicos){
        System.out.println ("Impressoara em uso é "+ps.getName ());
    }
    return servicos;
    }
    
    /**
 * 
 * PEGAR TODAS IMPRESSORAS  E EXIBIR
 * 
*/
     public PrintService[] getImpressorasInstaladas(){
     return servicos;
     }
/**
 * 
 * 
 * 
*/

}
