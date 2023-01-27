package com.signcorporation.milesa.model.UTILS;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author AEM Sign Angola
 */
public class Data_Hora {

    public String dataNormal() {
        Date data = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
        return (sdf.format(data));
    }

    public String Mes() {
        Date mes = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM");
        return (sdf.format(mes));
    }

    public String Ano() {
        Date data = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        return (sdf.format(data));
    }

    public String Dia() {
        Date dia = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd");
        return (sdf.format(dia));
    }
}
