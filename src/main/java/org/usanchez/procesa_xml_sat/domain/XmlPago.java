package org.usanchez.procesa_xml_sat.domain;

public class XmlPago {
    private String uuid;
    private String fechaTimbrado;
    private String serie;
    private String folio;
    private String rfcEmisor;
    private String nombreEmisor;
    private String regimenFiscalEmisor;
    private String rfcRecepor;
    private String nombreReceptor;
    private String regimenFiscalReceptor;
    private String usoCFDI;
    private String subtotal;
    private String iva;
    private String retIva;
    private String retIeps;
    private String retIsr;
    private String monto;
    private String moneda;
    private String uuidRelacionado;
    private String tipoCambio;
    private String fechaPago;
    private String formaPago;


    public XmlPago() {
    }

    public XmlPago(String uuid, String fechaTimbrado, String serie, String folio, String rfcEmisor, String nombreEmisor, String regimenFiscalEmisor, String rfcRecepor, String nombreReceptor, String regimenFiscalReceptor, String usoCFDI, String subtotal, String iva, String retIva, String retIeps, String retIsr, String monto, String moneda, String uuidRelacionado, String tipoCambio, String fechaPago, String formaPago) {
        this.uuid = uuid;
        this.fechaTimbrado = fechaTimbrado;
        this.serie = serie;
        this.folio = folio;
        this.rfcEmisor = rfcEmisor;
        this.nombreEmisor = nombreEmisor;
        this.regimenFiscalEmisor = regimenFiscalEmisor;
        this.rfcRecepor = rfcRecepor;
        this.nombreReceptor = nombreReceptor;
        this.regimenFiscalReceptor = regimenFiscalReceptor;
        this.usoCFDI = usoCFDI;
        this.subtotal = subtotal;
        this.iva = iva;
        this.retIva = retIva;
        this.retIeps = retIeps;
        this.retIsr = retIsr;
        this.monto = monto;
        this.moneda = moneda;
        this.uuidRelacionado = uuidRelacionado;
        this.tipoCambio = tipoCambio;
        this.fechaPago = fechaPago;
        this.formaPago = formaPago;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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
        return rfcEmisor;
    }

    public void setRfcEmisor(String rfcEmisor) {
        this.rfcEmisor = rfcEmisor;
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
        return rfcRecepor;
    }

    public void setRfcRecepor(String rfcRecepor) {
        this.rfcRecepor = rfcRecepor;
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

    public String getRetIva() {
        return retIva;
    }

    public void setRetIva(String retIva) {
        this.retIva = retIva;
    }

    public String getRetIeps() {
        return retIeps;
    }

    public void setRetIeps(String retIeps) {
        this.retIeps = retIeps;
    }

    public String getRetIsr() {
        return retIsr;
    }

    public void setRetIsr(String retIsr) {
        this.retIsr = retIsr;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getUuidRelacionado() {
        return uuidRelacionado;
    }

    public void setUuidRelacionado(String uuidRelacionado) {
        this.uuidRelacionado = uuidRelacionado;
    }

    public String getTipoCambio() {
        return tipoCambio;
    }

    public void setTipoCambio(String tipoCambio) {
        this.tipoCambio = tipoCambio;
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
