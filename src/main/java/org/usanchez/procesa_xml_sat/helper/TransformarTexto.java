package org.usanchez.procesa_xml_sat.helper;

public class TransformarTexto {
    public static String quitarUltimoSaltoLinea(String texto){
        if(texto == null || texto.isBlank()){
            return texto;
        }
        if(texto.endsWith("\n")){
            texto = texto.substring(0,texto.length()-1);
        }
        if(texto.endsWith("\r")){
            texto = texto.substring(0,texto.length()-1);
        }
        return texto;
    }

    public static String encerrarEntreComillas(String texto){
        return "\""+texto+"\"";
    }
}
