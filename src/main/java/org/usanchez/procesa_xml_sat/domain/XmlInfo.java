package org.usanchez.procesa_xml_sat.domain;

public class XmlInfo {
    private String fecha;
    private String uuid;
    private String formaPago;
    private String metodoPago;
    private String moneda;
    private String serie;
    private String folio;
    private String isrConcepto;
    private String ivaConcepto;
    private String iepsConcepto;
    private String isrRet;
    private String ivaRet;
    private String iepsRet;
    private String subtotal;
    private String total;
    private String tipoComprobante;
    private String versión;
    private String rfcEmisor;
    private String nombreEmisor;
    private String regimenFiscalEmisor;
    private String rfcReceptor;
    private String nombreReceptor;
    private String regimenFiscalReceptor;
    private String claveProdServ;
    private String claveUnidad;
    private String descripcion;
    private String objetoImp;
    private String cantidad;
    private String valorUnitario;
    private String isr;
    private String iva;
    private String ieps;
    private String isrRetConcepto;
    private String ivaRetConcepto;
    private String iepsRetConcepto;
    private String importeConcepto;
    private String tipoRelacion;
    private String uuidRelacionados;

    public XmlInfo() {
    }

    public XmlInfo(String fecha, String uuid, String formaPago, String metodoPago, String moneda, String serie, String folio, String isrConcepto, String ivaConcepto, String iepsConcepto, String isrRet, String ivaRet, String iepsRet, String subtotal, String total, String tipoComprobante, String versión, String rfcEmisor, String nombreEmisor, String regimenFiscalEmisor, String rfcReceptor, String nombreReceptor, String regimenFiscalReceptor, String claveProdServ, String claveUnidad, String descripcion, String objetoImp, String cantidad, String valorUnitario, String isr, String iva, String ieps, String isrRetConcepto, String ivaRetConcepto, String iepsRetConcepto, String importeConcepto, String tipoRelacion, String uuidRelacionados) {
        this.fecha = fecha;
        this.uuid = uuid;
        this.formaPago = formaPago;
        this.metodoPago = metodoPago;
        this.moneda = moneda;
        this.serie = serie;
        this.folio = folio;
        this.isrConcepto = isrConcepto;
        this.ivaConcepto = ivaConcepto;
        this.iepsConcepto = iepsConcepto;
        this.isrRet = isrRet;
        this.ivaRet = ivaRet;
        this.iepsRet = iepsRet;
        this.subtotal = subtotal;
        this.total = total;
        this.tipoComprobante = tipoComprobante;
        this.versión = versión;
        this.rfcEmisor = rfcEmisor;
        this.nombreEmisor = nombreEmisor;
        this.regimenFiscalEmisor = regimenFiscalEmisor;
        this.rfcReceptor = rfcReceptor;
        this.nombreReceptor = nombreReceptor;
        this.regimenFiscalReceptor = regimenFiscalReceptor;
        this.claveProdServ = claveProdServ;
        this.claveUnidad = claveUnidad;
        this.descripcion = descripcion;
        this.objetoImp = objetoImp;
        this.cantidad = cantidad;
        this.valorUnitario = valorUnitario;
        this.isr = isr;
        this.iva = iva;
        this.ieps = ieps;
        this.isrRetConcepto = isrRetConcepto;
        this.ivaRetConcepto = ivaRetConcepto;
        this.iepsRetConcepto = iepsRetConcepto;
        this.importeConcepto = importeConcepto;
        this.tipoRelacion = tipoRelacion;
        this.uuidRelacionados = uuidRelacionados;
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

    public String getVersión() {
        return versión;
    }

    public void setVersión(String versión) {
        this.versión = versión;
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

    public String getIsr() {
        return isr;
    }

    public void setIsr(String isr) {
        this.isr = isr;
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
}
