package org.usanchez.procesa_xml_sat.helper;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class FormatoCantidades {
    public static String formatoMontos(BigDecimal monto){
        DecimalFormat df = new DecimalFormat("###,###,##0.00####");
        return df.format(monto);
    }

    public static String formatoEnteros(int entero){
        DecimalFormat df = new DecimalFormat("###,###,##0");
        return df.format(entero);
    }
}
