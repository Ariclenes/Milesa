package com.signcorporation.milesa.model.UTILS;

/**
 * @author AEM Sign Angola
 */
public class Criptografia {
    // Classe com funções para trabalho com strings.

    public static String Cripto(String senha) {
        //Criptografa a String passada por parâmetro
        int contador, tamanho, codigoASCII;
        String senhaCriptografada = "";
        tamanho = senha.length();
        senha = senha.toUpperCase();
        contador = 0;
        while (contador < tamanho) {
            codigoASCII = senha.charAt(contador) + 130;
            senhaCriptografada = senhaCriptografada + (char) codigoASCII;
            contador++;
        }
        return senhaCriptografada;
    }

    public static String Decripto(String senha) {
        //Descriptografa a String passada por parâmetro
        int contador, tamanho, codigoASCII;
        String senhaCriptografada = "";
        tamanho = senha.length();
        senha = senha.toUpperCase();
        contador = 0;
        while (contador < tamanho) {
            codigoASCII = senha.charAt(contador) - 130;
            senhaCriptografada = senhaCriptografada + (char) codigoASCII;
            contador++;
        }
        return senhaCriptografada;
    }

}
