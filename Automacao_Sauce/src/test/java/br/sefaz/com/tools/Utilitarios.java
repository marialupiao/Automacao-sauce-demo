package br.sefaz.com.tools;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Utilitarios {
	public Utilitarios() {
    }

    public static String dataAtual() {
        Date data = Calendar.getInstance().getTime();
        DateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return sdf.format(data);
    }

    public static String normalizaString(String texto) {
        return texto.toUpperCase().replaceAll("[^A-Z\\d]+", "");
    }

    public static String normalizaStringBooleano(String texto) {
        return texto.toUpperCase().replaceAll("[^A-Z\\d]+", "");
    }

    public static String geradorPalavra(int tamanho) {
        String[] consoantes = new String[]{"b", "c", "d", "f", "g", "h", "j", "k", "l", "m", "n", "p", "r", "s", "t", "v", "w", "x", "z"};
        String[] vogais = new String[]{"a", "e", "i", "o", "u"};
        StringBuilder palavra = new StringBuilder();

        for(int i = 0; i <= tamanho / 2; ++i) {
            palavra.append(vogais[(int) Math.round(Math.random() * 4.0D)]).append(consoantes[(int) Math.round(Math.random() * 18.0D)]);
        }

        String var10000 = palavra.substring(0, 1).toUpperCase();
        return var10000 + palavra.substring(1, tamanho - 1);
    }
}
