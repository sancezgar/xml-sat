package org.usanchez.procesa_xml_sat.helper;

import org.usanchez.procesa_xml_sat.domain.*;

import static org.usanchez.procesa_xml_sat.helper.FormatoCantidades.*;
import static org.usanchez.procesa_xml_sat.helper.TransformarTexto.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

public class ManejoXML {

    private final static String ISR = "001";
    private final static String IVA = "002";
    private final static String IEPS = "003";

    //Se obtiene la estructura del timbre fiscal del xml
    private static TimbreFiscalDigital obtenerDatosTimbre(List<Object> objs) {
        for (Object obj : objs) {
            if (obj instanceof TimbreFiscalDigital) {
                return (TimbreFiscalDigital) obj;
            }
        }
        return null;
    }
    //Se obtiene la estructura del Pago20 del xml
    private static Pagos obtenerDatosPagos(List<Object> objs) {
        for (Object obj : objs) {
            if (obj instanceof Pagos) {
                return (Pagos) obj;
            }
        }
        return null;
    }

    //Obtenemos los impuestos de la factura.
    private static String obtenerImpuestos(Comprobante comprobante, String tipoImpuesto, boolean esTraslado){
        AtomicReference<Double> monto= new AtomicReference<>(0.0);
        Optional<Comprobante.Impuestos> impuestosOptional = Optional.ofNullable(comprobante.getImpuestos());
        if(impuestosOptional.isEmpty()) return formatoMontos(monto.get());
        if(esTraslado){ //Obtenemos los impuestos de traslados.
            Optional<Comprobante.Impuestos.Traslados> trasladosOptional = Optional.ofNullable(impuestosOptional.get().getTraslados());
            if(trasladosOptional.isEmpty()) return formatoMontos(monto.get());
            impuestosOptional.get().getTraslados().getTraslado().stream().filter(t -> tipoImpuesto.equals(t.getImpuesto()))
                    .forEach(t -> {
                        if(tipoImpuesto.equals(IVA) && t.getTipoFactor() == CTipoFactor.EXENTO){
                            monto.updateAndGet(v -> v + 0);
                        }else{
                            monto.updateAndGet(v -> v + t.getImporte().doubleValue());
                        }
                    });
        }else{//Obtenemos los impuestos retenidos.
            Optional<Comprobante.Impuestos.Retenciones> retencionesOptional = Optional.ofNullable(impuestosOptional.get().getRetenciones());
            if(retencionesOptional.isEmpty()) return formatoMontos(monto.get());
            impuestosOptional.get().getRetenciones().getRetencion().stream().filter(t -> tipoImpuesto.equals(t.getImpuesto()))
                    .forEach(r -> monto.updateAndGet(v -> v + r.getImporte().doubleValue()));
        }
        return formatoMontos(monto.get());
    }

    //Obtenemos los impuestos por concepto.
    private static String obtenerImpuestos(Comprobante.Conceptos.Concepto concepto, String tipoImpuesto, boolean esTraslado){
        AtomicReference<Double> monto= new AtomicReference<>(0.0);
        Optional<Comprobante.Conceptos.Concepto.Impuestos> impuestosOptional = Optional.ofNullable(concepto.getImpuestos());
        if(impuestosOptional.isEmpty()) return formatoMontos(monto.get());
        if(esTraslado){
            Optional<Comprobante.Conceptos.Concepto.Impuestos.Traslados> trasladosOptional = Optional.ofNullable(impuestosOptional.get().getTraslados());
            if(trasladosOptional.isEmpty()) return formatoMontos(monto.get());
            impuestosOptional.get().getTraslados().getTraslado().stream().filter(t -> tipoImpuesto.equals(t.getImpuesto()))
                    .forEach(t -> {
                        if(tipoImpuesto.equals(IVA) && t.getTipoFactor() == CTipoFactor.EXENTO){
                            monto.updateAndGet(v -> v + 0);
                        }else{
                            monto.updateAndGet(v -> v + t.getImporte().doubleValue());
                        }
                    });
        }else{
            Optional<Comprobante.Conceptos.Concepto.Impuestos.Retenciones> retencionesOptional = Optional.ofNullable(impuestosOptional.get().getRetenciones());
            if(retencionesOptional.isEmpty()) return formatoMontos(monto.get());
            impuestosOptional.get().getRetenciones().getRetencion().stream().filter(t -> tipoImpuesto.equals(t.getImpuesto()))
                    .forEach(r -> monto.updateAndGet(v -> v + r.getImporte().doubleValue()));
        }
        return formatoMontos(monto.get());
    }

    public static XmlInfo llenaXmlInfo(Comprobante comprobante) {
        XmlInfo xml = new XmlInfo();
        TimbreFiscalDigital timbre = obtenerDatosTimbre(comprobante.getComplemento().getAny());

        xml.setFecha(comprobante.getFecha().toString());
        xml.setUuid(timbre.getUUID());
        xml.setFormaPago(comprobante.getFormaPago());
        xml.setMetodoPago(comprobante.getMetodoPago().value());
        xml.setMoneda(comprobante.getMoneda().value());
        xml.setSerie(comprobante.getSerie());
        xml.setFolio(comprobante.getFolio());

        xml.setIsrRet(obtenerImpuestos(comprobante,ISR,false));
        xml.setIvaRet(obtenerImpuestos(comprobante,IVA,false));
        xml.setIepsRet(obtenerImpuestos(comprobante,IEPS,false));
        xml.setIsr(obtenerImpuestos(comprobante,ISR,true));
        xml.setIva(obtenerImpuestos(comprobante,IVA,true));
        xml.setIeps(obtenerImpuestos(comprobante,IEPS,true));

        xml.setSubtotal(formatoMontos(comprobante.getSubTotal()));
        if(comprobante.getDescuento() != null) xml.setDescuento(formatoMontos(comprobante.getDescuento()));
        else xml.setDescuento("0");
        xml.setTotal(formatoMontos(comprobante.getTotal()));
        xml.setTipoComprobante(comprobante.getTipoDeComprobante().value());
        xml.setVersion(comprobante.getVersion());
        xml.setRfcEmisor(comprobante.getEmisor().getRfc());
        xml.setNombreEmisor(comprobante.getEmisor().getNombre());
        xml.setRegimenFiscalEmisor(comprobante.getEmisor().getRegimenFiscal());
        xml.setRfcReceptor(comprobante.getReceptor().getRfc());
        xml.setNombreReceptor(comprobante.getReceptor().getNombre());
        xml.setRegimenFiscalReceptor(comprobante.getReceptor().getRegimenFiscalReceptor());

        StringBuilder claveProdServ = new StringBuilder();
        StringBuilder claveUnidad = new StringBuilder();
        StringBuilder descripcion = new StringBuilder();
        StringBuilder objetoImp = new StringBuilder();
        StringBuilder cantidad = new StringBuilder();
        StringBuilder valorUnitario = new StringBuilder();
        StringBuilder isrConcepto = new StringBuilder();
        StringBuilder ivaConcepto = new StringBuilder();
        StringBuilder iepsConcepto = new StringBuilder();
        StringBuilder isrRetConcepto = new StringBuilder();
        StringBuilder ivaRetConcepto = new StringBuilder();
        StringBuilder iepsRetConcepto = new StringBuilder();
        StringBuilder importeConcepto = new StringBuilder();
        StringBuilder descuentoConcepto = new StringBuilder();

        Optional<Comprobante.Conceptos> concepto = Optional.ofNullable(comprobante.getConceptos());
        concepto.ifPresent(conceptos -> {
            conceptos.getConcepto().forEach(con -> {
                claveProdServ.append(con.getClaveProdServ().concat("\n"));
                claveUnidad.append(con.getClaveUnidad().concat("\n"));
                descripcion.append(con.getDescripcion().concat("\n"));
                objetoImp.append(con.getObjetoImp().concat("\n"));
                cantidad.append(formatoMontos(con.getCantidad()).concat("\n"));
                valorUnitario.append(formatoMontos(con.getValorUnitario()).concat("\n"));
                importeConcepto.append(formatoMontos(con.getImporte()).concat("\n"));
                if(con.getDescuento() != null) descuentoConcepto.append(formatoMontos(con.getDescuento()).concat("\n"));
                else descuentoConcepto.append("0\n");

                isrConcepto.append(obtenerImpuestos(con,ISR,true).concat("\n"));
                ivaConcepto.append(obtenerImpuestos(con,IVA,true).concat("\n"));
                iepsConcepto.append(obtenerImpuestos(con,IEPS,true).concat("\n"));

                isrRetConcepto.append(obtenerImpuestos(con,ISR,false).concat("\n"));
                ivaRetConcepto.append(obtenerImpuestos(con,IVA,false).concat("\n"));
                iepsRetConcepto.append(obtenerImpuestos(con,IEPS,false).concat("\n"));
            });
        });

        xml.setClaveProdServ(quitarUltimoSaltoLinea(claveProdServ.toString()));
        xml.setClaveUnidad(quitarUltimoSaltoLinea(claveUnidad.toString()));
        xml.setDescripcion(quitarUltimoSaltoLinea(descripcion.toString()));
        xml.setObjetoImp(quitarUltimoSaltoLinea(objetoImp.toString()));
        xml.setCantidad(quitarUltimoSaltoLinea(cantidad.toString()));
        xml.setValorUnitario(quitarUltimoSaltoLinea(valorUnitario.toString()));
        xml.setIsrConcepto(quitarUltimoSaltoLinea(isrConcepto.toString()));
        xml.setIvaConcepto(quitarUltimoSaltoLinea(ivaConcepto.toString()));
        xml.setIepsConcepto(quitarUltimoSaltoLinea(iepsConcepto.toString()));
        xml.setIsrRetConcepto(quitarUltimoSaltoLinea(isrRetConcepto.toString()));
        xml.setIvaRetConcepto(quitarUltimoSaltoLinea(ivaRetConcepto.toString()));
        xml.setIepsRetConcepto(quitarUltimoSaltoLinea(iepsRetConcepto.toString()));
        xml.setImporteConcepto(quitarUltimoSaltoLinea(importeConcepto.toString()));
        xml.setDescuentoConcepto(quitarUltimoSaltoLinea(descuentoConcepto.toString()));

        StringBuilder tipoRelacion = new StringBuilder();
        StringBuilder uuidRelacionados = new StringBuilder();

        Optional<List<Comprobante.CfdiRelacionados>> cfdiRelacionados = Optional.ofNullable(comprobante.getCfdiRelacionados());
        cfdiRelacionados.ifPresent(cfdiRelacionados1 -> cfdiRelacionados1.forEach(rels -> {
            tipoRelacion.append(rels.getTipoRelacion().concat("\n"));
            rels.getCfdiRelacionado().forEach(rel -> {
                uuidRelacionados.append(rel.getUUID().concat("\n"));
            });
        }));

        xml.setTipoRelacion(quitarUltimoSaltoLinea(tipoRelacion.toString()));
        xml.setUuidRelacionados(quitarUltimoSaltoLinea(uuidRelacionados.toString()));

        return xml;
    }

    public static XmlPago llenaXmlPago(Comprobante comprobante){
        XmlPago xmlPago = new XmlPago("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "");
        TimbreFiscalDigital timbreFiscalDigital = obtenerDatosTimbre(comprobante.getComplemento().getAny());
        Pagos pagos = obtenerDatosPagos(comprobante.getComplemento().getAny());

        xmlPago.setUuid(timbreFiscalDigital.getUUID());
        xmlPago.setFechaTimbrado(timbreFiscalDigital.getFechaTimbrado().toString());
        xmlPago.setSerie(comprobante.getSerie());
        xmlPago.setFolio(comprobante.getFolio());
        xmlPago.setRfcEmisor(comprobante.getEmisor().getRfc());
        xmlPago.setNombreEmisor(comprobante.getEmisor().getNombre());
        xmlPago.setRegimenFiscalEmisor(comprobante.getEmisor().getRegimenFiscal());
        xmlPago.setRfcRecepor(comprobante.getReceptor().getRfc());
        xmlPago.setNombreReceptor(comprobante.getReceptor().getNombre());
        xmlPago.setRegimenFiscalReceptor(comprobante.getReceptor().getRegimenFiscalReceptor());
        xmlPago.setUsoCFDI(comprobante.getReceptor().getUsoCFDI().value());

        Optional<?> totales = Optional.ofNullable(pagos.getTotales());

        if(totales.isPresent()){
            //Obtener los subtotal, iva, monto, moneda, documento relacionado, tipo de cambio, forma de pago, UUID del complemento.
            Optional<BigDecimal> baseIva0 = Optional.ofNullable(pagos.getTotales().getTotalTrasladosBaseIVA0());
            Optional<BigDecimal> baseIva8 = Optional.ofNullable(pagos.getTotales().getTotalTrasladosBaseIVA8());
            Optional<BigDecimal> baseIva16 = Optional.ofNullable(pagos.getTotales().getTotalTrasladosBaseIVA16());

            BigDecimal subtotal = baseIva0.orElse(BigDecimal.valueOf(0)).add(baseIva8.orElse(BigDecimal.valueOf(0))).add(baseIva16.orElse(BigDecimal.valueOf(0)));
            xmlPago.setSubtotal(formatoMontos(subtotal));

            Optional<BigDecimal> iva0 = Optional.ofNullable(pagos.getTotales().getTotalTrasladosImpuestoIVA0());
            Optional<BigDecimal> iva8 = Optional.ofNullable(pagos.getTotales().getTotalTrasladosImpuestoIVA8());
            Optional<BigDecimal> iva16 = Optional.ofNullable(pagos.getTotales().getTotalTrasladosImpuestoIVA16());

            BigDecimal iva = iva0.orElse(BigDecimal.valueOf(0)).add(iva8.orElse(BigDecimal.valueOf(0))).add(iva16.orElse(BigDecimal.valueOf(0)));
            xmlPago.setIva(formatoMontos(iva));

            Optional<BigDecimal> retIva = Optional.ofNullable(pagos.getTotales().getTotalRetencionesIVA());
            Optional<BigDecimal> retIeps = Optional.ofNullable(pagos.getTotales().getTotalRetencionesIEPS());
            Optional<BigDecimal> retIsr = Optional.ofNullable(pagos.getTotales().getTotalRetencionesISR());

            xmlPago.setRetIva(formatoMontos(retIva.orElse(BigDecimal.valueOf(0))));
            xmlPago.setRetIeps(formatoMontos(retIeps.orElse(BigDecimal.valueOf(0))));
            xmlPago.setRetIsr(formatoMontos(retIsr.orElse(BigDecimal.valueOf(0))));
            xmlPago.setMonto(formatoMontos(pagos.getTotales().getMontoTotalPagos()));
        }

        StringBuilder UUIDRel = new StringBuilder();
        pagos.getPago().forEach(pago -> {
            pago.getDoctoRelacionado().forEach(docto -> {
                UUIDRel.append(docto.getIdDocumento()).append("\n");
            });
            xmlPago.setMoneda(pago.getMonedaP().value());
            Optional<BigDecimal> optionalTipoCambio = Optional.of(pago.getTipoCambioP());
            xmlPago.setTipoCambio(formatoMontos(optionalTipoCambio.orElse(BigDecimal.valueOf(0))));
            xmlPago.setFormaPago(pago.getFormaDePagoP());
            xmlPago.setFechaPago(pago.getFechaPago().toString());
        });

        xmlPago.setUuidRelacionado(quitarUltimoSaltoLinea(UUIDRel.toString()));

        return xmlPago;
    }
}


