package org.usanchez.procesa_xml_sat.domain;

public class XmlPago {
    private String fechaTimbrado;
    private String serie;
    private String folio;
    private String RfcEmisor;
    private String nombreEmisor;
    private String regimenFiscalEmisor;
    private String RfcRecepor;
    private String nombreReceptor;
    private String regimenFiscalReceptor;
    private String usoCFDI;
    private String subtotal;
    private String iva;
    private String monto;
    private String fechaPago;
    private String formaPago;


    public XmlPago() {
    }

    public XmlPago(String fechaTimbrado, String serie, String folio, String rfcEmisor, String nombreEmisor, String regimenFiscalEmisor, String rfcRecepor, String nombreReceptor, String regimenFiscalReceptor, String usoCFDI, String subtotal, String iva, String monto, String fechaPago, String formaPago) {
        this.fechaTimbrado = fechaTimbrado;
        this.serie = serie;
        this.folio = folio;
        RfcEmisor = rfcEmisor;
        this.nombreEmisor = nombreEmisor;
        this.regimenFiscalEmisor = regimenFiscalEmisor;
        RfcRecepor = rfcRecepor;
        this.nombreReceptor = nombreReceptor;
        this.regimenFiscalReceptor = regimenFiscalReceptor;
        this.usoCFDI = usoCFDI;
        this.subtotal = subtotal;
        this.iva = iva;
        this.monto = monto;
        this.fechaPago = fechaPago;
        this.formaPago = formaPago;
    }

    public String getFechaTimbrado() {
        return fechaTimbrado;
    }

    public void setFechaTimbrado(String fechaTimbrado) {
        this.fechaTimbrado = fechaTimbrado;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getRfcEmisor() {
        return RfcEmisor;
    }

    public void setRfcEmisor(String rfcEmisor) {
        RfcEmisor = rfcEmisor;
    }

    public String getNombreEmisor() {
        return nombreEmisor;
    }

    public void setNombreEmisor(String nombreEmisor) {
        this.nombreEmisor = nombreEmisor;
    }

    public String getRegimenFiscalEmisor() {
        return regimenFiscalEmisor;
    }

    public void setRegimenFiscalEmisor(String regimenFiscalEmisor) {
        this.regimenFiscalEmisor = regimenFiscalEmisor;
    }

    public String getRfcRecepor() {
        return RfcRecepor;
    }

    public void setRfcRecepor(String rfcRecepor) {
        RfcRecepor = rfcRecepor;
    }

    public String getNombreReceptor() {
        return nombreReceptor;
    }

    public void setNombreReceptor(String nombreReceptor) {
        this.nombreReceptor = nombreReceptor;
    }

    public String getRegimenFiscalReceptor() {
        return regimenFiscalReceptor;
    }

    public void setRegimenFiscalReceptor(String regimenFiscalReceptor) {
        this.regimenFiscalReceptor = regimenFiscalReceptor;
    }

    public String getUsoCFDI() {
        return usoCFDI;
    }

    public void setUsoCFDI(String usoCFDI) {
        this.usoCFDI = usoCFDI;
    }

    public String getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal;
    }

    public String getIva() {
        return iva;
    }

    public void setIva(String iva) {
        this.iva = iva;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }
}
