package org.usanchez.procesa_xml_sat.domain;

public class XmlInfo {
    private String cantidad;
    private String claveProdServ;
    private String claveUnidad;
    private String descripcion;
    private String descuento;
    private String descuentoConcepto;
    private String fecha;
    private String folio;
    private String formaPago;
    private String ieps;
    private String iepsConcepto;
    private String iepsRet;
    private String iepsRetConcepto;
    private String importeConcepto;
    private String isr;
    private String isrConcepto;
    private String isrRet;
    private String isrRetConcepto;
    private String iva;
    private String ivaConcepto;
    private String ivaRet;
    private String ivaRetConcepto;
    private String metodoPago;
    private String moneda;
    private String nombreEmisor;
    private String nombreReceptor;
    private String objetoImp;
    private String regimenFiscalEmisor;
    private String regimenFiscalReceptor;
    private String rfcEmisor;
    private String rfcReceptor;
    private String serie;
    private String subtotal;
    private String tipoComprobante;
    private String tipoRelacion;
    private String total;
    private String uuid;
    private String uuidRelacionados;
    private String valorUnitario;
    private String version;

    public XmlInfo() {
        cantidad = ""; claveProdServ = ""; claveUnidad = ""; descripcion = ""; fecha = ""; folio = ""; formaPago = "";
        ieps = ""; iepsConcepto = ""; iepsRet = ""; iepsRetConcepto = ""; importeConcepto = ""; isr = ""; isrConcepto = "";
        isrRet = ""; isrRetConcepto = ""; iva = ""; ivaConcepto = ""; ivaRet = ""; ivaRetConcepto = ""; metodoPago = ""; moneda = "";
        nombreEmisor = ""; nombreReceptor = ""; objetoImp = ""; regimenFiscalEmisor = ""; regimenFiscalReceptor = ""; rfcEmisor = "";
        rfcReceptor = ""; serie = ""; subtotal = ""; tipoComprobante = ""; tipoRelacion = ""; total = ""; uuid = ""; uuidRelacionados = "";
        valorUnitario = ""; version = "";descuento="";descuentoConcepto="";
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
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

    public String getIsr() {
        return isr;
    }

    public void setIsr(String isr) {
        this.isr = isr;
    }

    public String getIsrConcepto() {
        return isrConcepto;
    }

    public void setIsrConcepto(String isrConcepto) {
        this.isrConcepto = isrConcepto;
    }

    public String getIvaConcepto() {
        return ivaConcepto;
    }

    public void setIvaConcepto(String ivaConcepto) {
        this.ivaConcepto = ivaConcepto;
    }

    public String getIepsConcepto() {
        return iepsConcepto;
    }

    public void setIepsConcepto(String iepsConcepto) {
        this.iepsConcepto = iepsConcepto;
    }

    public String getIsrRet() {
        return isrRet;
    }

    public void setIsrRet(String isrRet) {
        this.isrRet = isrRet;
    }

    public String getIvaRet() {
        return ivaRet;
    }

    public void setIvaRet(String ivaRet) {
        this.ivaRet = ivaRet;
    }

    public String getIepsRet() {
        return iepsRet;
    }

    public void setIepsRet(String iepsRet) {
        this.iepsRet = iepsRet;
    }

    public String getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getTipoComprobante() {
        return tipoComprobante;
    }

    public void setTipoComprobante(String tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
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

    public String getRfcReceptor() {
        return rfcReceptor;
    }

    public void setRfcReceptor(String rfcReceptor) {
        this.rfcReceptor = rfcReceptor;
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

    public String getClaveProdServ() {
        return claveProdServ;
    }

    public void setClaveProdServ(String claveProdServ) {
        this.claveProdServ = claveProdServ;
    }

    public String getClaveUnidad() {
        return claveUnidad;
    }

    public void setClaveUnidad(String claveUnidad) {
        this.claveUnidad = claveUnidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getObjetoImp() {
        return objetoImp;
    }

    public void setObjetoImp(String objetoImp) {
        this.objetoImp = objetoImp;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(String valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public String getIva() {
        return iva;
    }

    public void setIva(String iva) {
        this.iva = iva;
    }

    public String getIeps() {
        return ieps;
    }

    public void setIeps(String ieps) {
        this.ieps = ieps;
    }

    public String getIsrRetConcepto() {
        return isrRetConcepto;
    }

    public void setIsrRetConcepto(String isrRetConcepto) {
        this.isrRetConcepto = isrRetConcepto;
    }

    public String getIvaRetConcepto() {
        return ivaRetConcepto;
    }

    public void setIvaRetConcepto(String ivaRetConcepto) {
        this.ivaRetConcepto = ivaRetConcepto;
    }

    public String getIepsRetConcepto() {
        return iepsRetConcepto;
    }

    public void setIepsRetConcepto(String iepsRetConcepto) {
        this.iepsRetConcepto = iepsRetConcepto;
    }

    public String getImporteConcepto() {
        return importeConcepto;
    }

    public void setImporteConcepto(String importeConcepto) {
        this.importeConcepto = importeConcepto;
    }

    public String getTipoRelacion() {
        return tipoRelacion;
    }

    public void setTipoRelacion(String tipoRelacion) {
        this.tipoRelacion = tipoRelacion;
    }

    public String getUuidRelacionados() {
        return uuidRelacionados;
    }

    public void setUuidRelacionados(String uuidRelacionados) {
        this.uuidRelacionados = uuidRelacionados;
    }

    public String getDescuento() {
        return descuento;
    }

    public void setDescuento(String descuento) {
        this.descuento = descuento;
    }

    public String getDescuentoConcepto() {
        return descuentoConcepto;
    }

    public void setDescuentoConcepto(String descuentoConcepto) {
        this.descuentoConcepto = descuentoConcepto;
    }
}
