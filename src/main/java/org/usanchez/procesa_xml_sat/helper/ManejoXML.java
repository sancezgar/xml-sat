package org.usanchez.procesa_xml_sat.helper;

import org.usanchez.procesa_xml_sat.domain.Comprobante;
import org.usanchez.procesa_xml_sat.domain.Pagos;
import org.usanchez.procesa_xml_sat.domain.TimbreFiscalDigital;
import org.usanchez.procesa_xml_sat.domain.XmlInfo;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ManejoXML {

    private final static String ISR = "001";
    private final static String IVA = "002";
    private final static String IEPS = "003";

    private static TimbreFiscalDigital obtenerDatosTimbre(List<Object> objs) {
        for (Object obj : objs) {
            if (obj instanceof TimbreFiscalDigital) {
                return (TimbreFiscalDigital) obj;
            }
        }
        return null;
    }

    private static Pagos obtenerDatosPagos(List<Object> objs) {
        for (Object obj : objs) {
            if (obj instanceof Pagos) {
                return (Pagos) obj;
            }
        }
        return null;
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

        Optional<Comprobante.Impuestos> impuestosOptional = Optional.ofNullable(comprobante.getImpuestos());
        impuestosOptional.ifPresent(impuestos -> {
            Optional<Comprobante.Impuestos.Retenciones> retencion = Optional.ofNullable(impuestos.getRetenciones());
            retencion.ifPresent(retencions -> retencions.getRetencion().forEach(rete -> {
                switch (rete.getImpuesto()) {
                    case ISR -> {
                        xml.setIsrRet(rete.getImporte().toString());
                    }
                    case IVA -> {
                        xml.setIvaRet(rete.getImporte().toString());
                    }
                    case IEPS -> {
                        xml.setIepsRet(rete.getImporte().toString());
                    }
                }
            }));

            Optional<Comprobante.Impuestos.Traslados> traslado = Optional.ofNullable(impuestos.getTraslados());
            traslado.ifPresent(traslados -> traslados.getTraslado().forEach(tras -> {
                switch (tras.getImpuesto()) {
                    case ISR -> {
                        if ((tras.getImporte() != null)) xml.setIsr(tras.getImporte().toString());
                        else xml.setIsr("0");
                    }
                    case IVA -> {
                        if ((tras.getImporte() != null)) xml.setIva(tras.getImporte().toString());
                        else xml.setIva("0");
                    }
                    case IEPS -> {
                        if ((tras.getImporte() != null)) xml.setIeps(tras.getImporte().toString());
                        else xml.setIeps("0");
                    }
                }
            }));
        });

        xml.setSubtotal(comprobante.getSubTotal().toString());
        xml.setTotal(comprobante.getTotal().toString());
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
        StringBuilder isrRetConcepto = new StringBuilder();
        StringBuilder ivaRetConcepto = new StringBuilder();
        StringBuilder iepsRetConcepto = new StringBuilder();
        StringBuilder importeConcepto = new StringBuilder();

        Optional<Comprobante.Conceptos> concepto = Optional.ofNullable(comprobante.getConceptos());
        concepto.ifPresent(conceptos -> {
            conceptos.getConcepto().forEach(con -> {
                claveProdServ.append(con.getClaveProdServ().concat("\n"));
                claveUnidad.append(con.getClaveUnidad().concat("\n"));
                descripcion.append(con.getDescripcion().concat("\n"));
                objetoImp.append(con.getObjetoImp().concat("\n"));
                cantidad.append(String.valueOf(con.getCantidad()).concat("\n"));
                valorUnitario.append(String.valueOf(con.getValorUnitario()).concat("\n"));
                importeConcepto.append(String.valueOf(con.getImporte()).concat("\n"));

                Optional<Comprobante.Conceptos.Concepto.Impuestos> ImpuestosCon = Optional.ofNullable(con.getImpuestos());
                ImpuestosCon.ifPresent(impuestos -> {
                    Optional<Comprobante.Conceptos.Concepto.Impuestos.Traslados> trasladoCon = Optional.ofNullable(impuestos.getTraslados());
                    trasladoCon.ifPresent(traslados -> traslados.getTraslado().forEach(tras -> {
                        String tipo = tras.getImpuesto();
                        switch (tipo) {
                            case ISR -> isrRetConcepto.append(String.valueOf(tras.getImporte()).concat("\n"));
                            case IVA -> ivaConcepto.append(String.valueOf(tras.getImporte()).concat("\n"));
                            case IEPS -> isrConcepto.append(String.valueOf(tras.getImporte()).concat("\n"));
                        }
                    }));
                    Optional<Comprobante.Conceptos.Concepto.Impuestos.Retenciones> retencionCon = Optional.ofNullable(con.getImpuestos().getRetenciones());
                    retencionCon.ifPresent(retencions -> retencions.getRetencion().forEach(ret -> {
                        String tipo = ret.getImpuesto();
                        switch (tipo) {
                            case ISR -> isrRetConcepto.append(String.valueOf(ret.getImporte()).concat("\n"));
                            case IVA -> ivaRetConcepto.append(String.valueOf(ret.getImporte()).concat("\n"));
                            case IEPS -> iepsRetConcepto.append(String.valueOf(ret.getImporte()).concat("\n"));
                        }
                    }));
                });
            });
        });

        xml.setClaveProdServ(claveProdServ.toString());
        xml.setClaveUnidad(claveUnidad.toString());
        xml.setDescripcion(descripcion.toString());
        xml.setObjetoImp(objetoImp.toString());
        xml.setCantidad(cantidad.toString());
        xml.setValorUnitario(valorUnitario.toString());
        xml.setIsrConcepto(isrConcepto.toString());
        xml.setIvaConcepto(ivaConcepto.toString());
        xml.setIsrRetConcepto(isrRetConcepto.toString());
        xml.setIvaRetConcepto(ivaRetConcepto.toString());
        xml.setIepsRetConcepto(iepsRetConcepto.toString());
        xml.setImporteConcepto(importeConcepto.toString());

        StringBuilder tipoRelacion = new StringBuilder();
        StringBuilder uuidRelacionados = new StringBuilder();

        Optional<List<Comprobante.CfdiRelacionados>> cfdiRelacionados = Optional.ofNullable(comprobante.getCfdiRelacionados());
        cfdiRelacionados.ifPresent(cfdiRelacionados1 -> cfdiRelacionados1.forEach(rels -> {
            tipoRelacion.append(rels.getTipoRelacion().concat("\n"));
            rels.getCfdiRelacionado().forEach(rel -> {
                uuidRelacionados.append(rel.getUUID().concat("\n"));
            });
        }));

        xml.setTipoRelacion(tipoRelacion.toString());
        xml.setUuidRelacionados(uuidRelacionados.toString());

        return xml;
    }
}


