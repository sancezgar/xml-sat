package org.usanchez.procesa_xml_sat.controller;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.usanchez.procesa_xml_sat.App;
import org.usanchez.procesa_xml_sat.domain.*;
import static org.usanchez.procesa_xml_sat.helper.ManejoXML.*;
import static org.usanchez.procesa_xml_sat.helper.FormatoCantidades.*;
import static org.usanchez.procesa_xml_sat.helper.ExportarInfo.*;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class AppController implements Initializable {
    @FXML private TableView<XmlPago> pagoTableView;
    @FXML private TableColumn<XmlPago, String> uuidColumn;
    @FXML private TableColumn<XmlPago, String> fechaTimbradoColumn;
    @FXML private TableColumn<XmlPago, String> serieColumn;
    @FXML private TableColumn<XmlPago, String> folioColumn;
    @FXML private TableColumn<XmlPago, String> rfcEmisorColumn;
    @FXML private TableColumn<XmlPago, String> nombreEmisorColumn;
    @FXML private TableColumn<XmlPago, String> regimenFiscalEmisorColumn;
    @FXML private TableColumn<XmlPago, String> rfcReceporColumn;
    @FXML private TableColumn<XmlPago, String> nombreReceptorColumn;
    @FXML private TableColumn<XmlPago, String> regimenFiscalReceptorColumn;
    @FXML private TableColumn<XmlPago, String> usoCFDIColumn;
    @FXML private TableColumn<XmlPago, String> subtotalColumn;
    @FXML private TableColumn<XmlPago, String> ivaColumn;
    @FXML private TableColumn<XmlPago, String> retIvaColumn;
    @FXML private TableColumn<XmlPago, String> retIEPSColumn;
    @FXML private TableColumn<XmlPago, String> retISRColumn;
    @FXML private TableColumn<XmlPago, String> MontoColumn;
    @FXML private TableColumn<XmlPago, String> monedaColumn;
    @FXML private TableColumn<XmlPago, String> tipoCambioColumn;
    @FXML private TableColumn<XmlPago, String> uuidRelacionadoColumn;
    @FXML private TableColumn<XmlPago, String> fechaPagoColumn;
    @FXML private TableColumn<XmlPago, String> formaPagoColumn;

    @FXML private AnchorPane appWindow;

    //Tabla ingreso
    @FXML private TableView<XmlInfo> ingresoTablaView;
    @FXML private TableColumn<XmlInfo, String> cantidadColumnIngreso;
    @FXML private TableColumn<XmlInfo, String> claveProdServColumnIngreso;
    @FXML private TableColumn<XmlInfo, String> claveUnidadColumnIngreso;
    @FXML private TableColumn<XmlInfo, String> descripcionColumnIngreso;
    @FXML private TableColumn<XmlInfo, String> descuentoColumnIngreso;
    @FXML private TableColumn<XmlInfo, String> descuentoConceptoColumnIngreso;
    @FXML private TableColumn<XmlInfo, String> fechaColumnIngreso;
    @FXML private TableColumn<XmlInfo, String> folioColumnIngreso;
    @FXML private TableColumn<XmlInfo, String> formaPagoColumnIngreso;
    @FXML private TableColumn<XmlInfo, String> iepsColumnIngreso;
    @FXML private TableColumn<XmlInfo, String> iepsConceptoColumnIngreso;
    @FXML private TableColumn<XmlInfo, String> iepsRetColumnIngreso;
    @FXML private TableColumn<XmlInfo, String> iepsRetConceptoColumnIngreso;
    @FXML private TableColumn<XmlInfo, String> importeConceptoColumnIngreso;
    @FXML private TableColumn<XmlInfo, String> isrColumnIngreso;
    @FXML private TableColumn<XmlInfo, String> isrConceptoColumnIngreso;
    @FXML private TableColumn<XmlInfo, String> isrRetColumnIngreso;
    @FXML private TableColumn<XmlInfo, String> isrRetConceptoColumnIngreso;
    @FXML private TableColumn<XmlInfo, String> ivaColumnIngreso;
    @FXML private TableColumn<XmlInfo, String> ivaConceptoColumnIngreso;
    @FXML private TableColumn<XmlInfo, String> ivaRetColumnIngreso;
    @FXML private TableColumn<XmlInfo, String> ivaRetConceptoColumnIngreso;
    @FXML private TableColumn<XmlInfo, String> metodoPagoColumnIngreso;
    @FXML private TableColumn<XmlInfo, String> monedaColumnIngreso;
    @FXML private TableColumn<XmlInfo, String> nombreEmisorColumnIngreso;
    @FXML private TableColumn<XmlInfo, String> nombreReceptorColumnIngreso;
    @FXML private TableColumn<XmlInfo, String> objetoImpColumnIngreso;
    @FXML private TableColumn<XmlInfo, String> regimenFiscalEmisorColumnIngreso;
    @FXML private TableColumn<XmlInfo, String> regimenFiscalReceptorColumnIngreso;
    @FXML private TableColumn<XmlInfo, String> rfcEmisorColumnIngreso;
    @FXML private TableColumn<XmlInfo, String> rfcReceptorColumnIngreso;
    @FXML private TableColumn<XmlInfo, String> serieColumnIngreso;
    @FXML private TableColumn<XmlInfo, String> subtotalColumnIngreso;
    @FXML private TableColumn<XmlInfo, String> tipoComprobanteColumnIngreso;
    @FXML private TableColumn<XmlInfo, String> tipoRelacionColumnIngreso;
    @FXML private TableColumn<XmlInfo, String> totalColumnIngreso;
    @FXML private TableColumn<XmlInfo, String> uuidColumnIngreso;
    @FXML private TableColumn<XmlInfo, String> uuidRelacionadosColumnIngreso;
    @FXML private TableColumn<XmlInfo, String> valorUnitarioColumnIngreso;
    @FXML private TableColumn<XmlInfo, String> versionColumnIngreso;

    //Tabla egreso
    @FXML private TableView<XmlInfo> egresoTablaView;
    @FXML private TableColumn<XmlInfo, String> cantidadColumnEgreso;
    @FXML private TableColumn<XmlInfo, String> claveProdServColumnEgreso;
    @FXML private TableColumn<XmlInfo, String> claveUnidadColumnEgreso;
    @FXML private TableColumn<XmlInfo, String> descripcionColumnEgreso;
    @FXML private TableColumn<XmlInfo, String> descuentoColumnEgreso;
    @FXML private TableColumn<XmlInfo, String> descuentoConceptoColumnEgreso;
    @FXML private TableColumn<XmlInfo, String> fechaColumnEgreso;
    @FXML private TableColumn<XmlInfo, String> folioColumnEgreso;
    @FXML private TableColumn<XmlInfo, String> formaPagoColumnEgreso;
    @FXML private TableColumn<XmlInfo, String> iepsColumnEgreso;
    @FXML private TableColumn<XmlInfo, String> iepsConceptoColumnEgreso;
    @FXML private TableColumn<XmlInfo, String> iepsRetColumnEgreso;
    @FXML private TableColumn<XmlInfo, String> iepsRetConceptoColumnEgreso;
    @FXML private TableColumn<XmlInfo, String> importeConceptoColumnEgreso;
    @FXML private TableColumn<XmlInfo, String> isrColumnEgreso;
    @FXML private TableColumn<XmlInfo, String> isrConceptoColumnEgreso;
    @FXML private TableColumn<XmlInfo, String> isrRetColumnEgreso;
    @FXML private TableColumn<XmlInfo, String> isrRetConceptoColumnEgreso;
    @FXML private TableColumn<XmlInfo, String> ivaColumnEgreso;
    @FXML private TableColumn<XmlInfo, String> ivaConceptoColumnEgreso;
    @FXML private TableColumn<XmlInfo, String> ivaRetColumnEgreso;
    @FXML private TableColumn<XmlInfo, String> ivaRetConceptoColumnEgreso;
    @FXML private TableColumn<XmlInfo, String> metodoPagoColumnEgreso;
    @FXML private TableColumn<XmlInfo, String> monedaColumnEgreso;
    @FXML private TableColumn<XmlInfo, String> nombreEmisorColumnEgreso;
    @FXML private TableColumn<XmlInfo, String> nombreReceptorColumnEgreso;
    @FXML private TableColumn<XmlInfo, String> objetoImpColumnEgreso;
    @FXML private TableColumn<XmlInfo, String> regimenFiscalEmisorColumnEgreso;
    @FXML private TableColumn<XmlInfo, String> regimenFiscalReceptorColumnEgreso;
    @FXML private TableColumn<XmlInfo, String> rfcEmisorColumnEgreso;
    @FXML private TableColumn<XmlInfo, String> rfcReceptorColumnEgreso;
    @FXML private TableColumn<XmlInfo, String> serieColumnEgreso;
    @FXML private TableColumn<XmlInfo, String> subtotalColumnEgreso;
    @FXML private TableColumn<XmlInfo, String> tipoComprobanteColumnEgreso;
    @FXML private TableColumn<XmlInfo, String> tipoRelacionColumnEgreso;
    @FXML private TableColumn<XmlInfo, String> totalColumnEgreso;
    @FXML private TableColumn<XmlInfo, String> uuidColumnEgreso;
    @FXML private TableColumn<XmlInfo, String> uuidRelacionadosColumnEgreso;
    @FXML private TableColumn<XmlInfo, String> valorUnitarioColumnEgreso;
    @FXML private TableColumn<XmlInfo, String> versionColumnEgreso;

    @FXML private Tab ingresosTab;
    @FXML private Tab egresosTab;
    @FXML private Tab pagosTab;

    private JAXBContext jaxbContext;
    private Unmarshaller jaxbUnmarshaller;

    private final static String TIPO_INGRESOS = "I";
    private final static String TIPO_EGRESOS = "E";
    private final static String TIPO_PAGO = "P";

    private ObservableList<XmlInfo> tablaIngresos;
    private ObservableList<XmlInfo> tablaEgresos;
    private ObservableList<XmlPago> tablaPagos;

    private List<TableView<?>> tablas;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tablaIngresos = FXCollections.observableArrayList();
        tablaEgresos = FXCollections.observableArrayList();
        tablaPagos = FXCollections.observableArrayList();
        tablas = Arrays.asList(ingresoTablaView,egresoTablaView,pagoTableView);
    }

    public AppController() {
        inicializarJaxb();
    }

    public void inicializarJaxb(){
        try{
            jaxbContext = JAXBContext.newInstance(Comprobante.class, TimbreFiscalDigital.class, Pagos.class);
            jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        }catch (JAXBException e){
            App.mostrarMensajeError("Error al inicializar el lector XMl. " + e.getMessage());
        }
    }

    public void exportar(){
        //Obtenemos las fechas
        String fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss"));

        //Inicializamos el selector de archivos.
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Guardar Reporte");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));

        //Filtro para archivos Excel
        FileChooser.ExtensionFilter excelFilter = new FileChooser.ExtensionFilter("Archivos Excel (*.xlsx)","*.xlsx");
        fileChooser.getExtensionFilters().addAll(excelFilter);
        fileChooser.setInitialFileName("reporte_xml_sat_"+fecha);

        File file = fileChooser.showSaveDialog(null);
        if(file != null){
            String path = file.getAbsolutePath();
            String selectedExtension = fileChooser.getSelectedExtensionFilter().getExtensions().get(0);

            if(!path.toLowerCase().endsWith(selectedExtension.substring(1))){
                file = new File(path + selectedExtension.substring(1));
            }
            exportarExcel(tablas,file.getAbsolutePath());
            abrirArchivo(file);
        }else App.mostrarMensaje("No se seleccionó ningún archivo a guardar.");
    }

    public void importar(){
        DirectoryChooser dc = new DirectoryChooser();
        dc.setInitialDirectory(new File(System.getProperty("user.home")));
        File selectedDirectory =  dc.showDialog(null);
        if(selectedDirectory != null){
            limpiarListas();
            List<File> listaArchivos = Arrays.stream(selectedDirectory.listFiles()).toList();
            listaArchivos = listaArchivos.stream().filter(a -> a.getName().endsWith(".xml")).toList();
            listaArchivos.forEach(this::leerXML);
            obtenerCantidadTitulosTab();
            mostrarTablaIngresos();
            mostrarTablaEgresos();
            mostrarTablaPagos();
        }else{
            App.mostrarMensajeError("No se escogio la ruta.");
        }
    }

    public void leerXML(File archivo){
        try{
            Comprobante comprobante = (Comprobante) jaxbUnmarshaller.unmarshal(archivo);
            Optional<String> tipoOptional = Optional.ofNullable(String.valueOf(comprobante.getTipoDeComprobante()));

            if(tipoOptional.isPresent()){
                String tipoIngreso = tipoOptional.get();
                switch (tipoIngreso){
                    case TIPO_INGRESOS -> tablaIngresos.add(llenaXmlInfo(comprobante));
                    case TIPO_EGRESOS -> tablaEgresos.add(llenaXmlInfo(comprobante));
                    case TIPO_PAGO -> tablaPagos.add(llenaXmlPago(comprobante));
                }
            }
        }catch (JAXBException e){
            App.mostrarMensajeError("Mensaje de error: " + e.getMessage());
        }
    }

    public void mostrarTablaIngresos(){
        cantidadColumnIngreso.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        claveProdServColumnIngreso.setCellValueFactory(new PropertyValueFactory<>("claveProdServ"));
        claveUnidadColumnIngreso.setCellValueFactory(new PropertyValueFactory<>("claveUnidad"));
        descripcionColumnIngreso.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        fechaColumnIngreso.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        folioColumnIngreso.setCellValueFactory(new PropertyValueFactory<>("folio"));
        formaPagoColumnIngreso.setCellValueFactory(new PropertyValueFactory<>("formaPago"));
        iepsColumnIngreso.setCellValueFactory(new PropertyValueFactory<>("ieps"));
        iepsConceptoColumnIngreso.setCellValueFactory(new PropertyValueFactory<>("iepsConcepto"));
        iepsRetColumnIngreso.setCellValueFactory(new PropertyValueFactory<>("iepsRet"));
        iepsRetConceptoColumnIngreso.setCellValueFactory(new PropertyValueFactory<>("iepsRetConcepto"));
        importeConceptoColumnIngreso.setCellValueFactory(new PropertyValueFactory<>("importeConcepto"));
        isrColumnIngreso.setCellValueFactory(new PropertyValueFactory<>("isr"));
        isrConceptoColumnIngreso.setCellValueFactory(new PropertyValueFactory<>("isrConcepto"));
        isrRetColumnIngreso.setCellValueFactory(new PropertyValueFactory<>("isrRet"));
        isrRetConceptoColumnIngreso.setCellValueFactory(new PropertyValueFactory<>("isrRetConcepto"));
        ivaColumnIngreso.setCellValueFactory(new PropertyValueFactory<>("iva"));
        ivaConceptoColumnIngreso.setCellValueFactory(new PropertyValueFactory<>("ivaConcepto"));
        ivaRetColumnIngreso.setCellValueFactory(new PropertyValueFactory<>("ivaRet"));
        ivaRetConceptoColumnIngreso.setCellValueFactory(new PropertyValueFactory<>("ivaRetConcepto"));
        metodoPagoColumnIngreso.setCellValueFactory(new PropertyValueFactory<>("metodoPago"));
        monedaColumnIngreso.setCellValueFactory(new PropertyValueFactory<>("moneda"));
        nombreEmisorColumnIngreso.setCellValueFactory(new PropertyValueFactory<>("nombreEmisor"));
        nombreReceptorColumnIngreso.setCellValueFactory(new PropertyValueFactory<>("nombreReceptor"));
        objetoImpColumnIngreso.setCellValueFactory(new PropertyValueFactory<>("objetoImp"));
        regimenFiscalEmisorColumnIngreso.setCellValueFactory(new PropertyValueFactory<>("regimenFiscalEmisor"));
        regimenFiscalReceptorColumnIngreso.setCellValueFactory(new PropertyValueFactory<>("regimenFiscalReceptor"));
        rfcEmisorColumnIngreso.setCellValueFactory(new PropertyValueFactory<>("rfcEmisor"));
        rfcReceptorColumnIngreso.setCellValueFactory(new PropertyValueFactory<>("rfcReceptor"));
        serieColumnIngreso.setCellValueFactory(new PropertyValueFactory<>("serie"));
        subtotalColumnIngreso.setCellValueFactory(new PropertyValueFactory<>("subtotal"));
        tipoComprobanteColumnIngreso.setCellValueFactory(new PropertyValueFactory<>("tipoComprobante"));
        tipoRelacionColumnIngreso.setCellValueFactory(new PropertyValueFactory<>("tipoRelacion"));
        totalColumnIngreso.setCellValueFactory(new PropertyValueFactory<>("total"));
        uuidColumnIngreso.setCellValueFactory(new PropertyValueFactory<>("uuid"));
        uuidRelacionadosColumnIngreso.setCellValueFactory(new PropertyValueFactory<>("uuidRelacionados"));
        valorUnitarioColumnIngreso.setCellValueFactory(new PropertyValueFactory<>("valorUnitario"));
        versionColumnIngreso.setCellValueFactory(new PropertyValueFactory<>("version"));
        descuentoColumnIngreso.setCellValueFactory(new PropertyValueFactory<>("descuento"));
        descuentoConceptoColumnIngreso.setCellValueFactory(new PropertyValueFactory<>("descuentoConcepto"));

        ingresoTablaView.setItems(tablaIngresos);
    }

    public void mostrarTablaEgresos(){
        cantidadColumnEgreso.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        claveProdServColumnEgreso.setCellValueFactory(new PropertyValueFactory<>("claveProdServ"));
        claveUnidadColumnEgreso.setCellValueFactory(new PropertyValueFactory<>("claveUnidad"));
        descripcionColumnEgreso.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        fechaColumnEgreso.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        folioColumnEgreso.setCellValueFactory(new PropertyValueFactory<>("folio"));
        formaPagoColumnEgreso.setCellValueFactory(new PropertyValueFactory<>("formaPago"));
        iepsColumnEgreso.setCellValueFactory(new PropertyValueFactory<>("ieps"));
        iepsConceptoColumnEgreso.setCellValueFactory(new PropertyValueFactory<>("iepsConcepto"));
        iepsRetColumnEgreso.setCellValueFactory(new PropertyValueFactory<>("iepsRet"));
        iepsRetConceptoColumnEgreso.setCellValueFactory(new PropertyValueFactory<>("iepsRetConcepto"));
        importeConceptoColumnEgreso.setCellValueFactory(new PropertyValueFactory<>("importeConcepto"));
        isrColumnEgreso.setCellValueFactory(new PropertyValueFactory<>("isr"));
        isrConceptoColumnEgreso.setCellValueFactory(new PropertyValueFactory<>("isrConcepto"));
        isrRetColumnEgreso.setCellValueFactory(new PropertyValueFactory<>("isrRet"));
        isrRetConceptoColumnEgreso.setCellValueFactory(new PropertyValueFactory<>("isrRetConcepto"));
        ivaColumnEgreso.setCellValueFactory(new PropertyValueFactory<>("iva"));
        ivaConceptoColumnEgreso.setCellValueFactory(new PropertyValueFactory<>("ivaConcepto"));
        ivaRetColumnEgreso.setCellValueFactory(new PropertyValueFactory<>("ivaRet"));
        ivaRetConceptoColumnEgreso.setCellValueFactory(new PropertyValueFactory<>("ivaRetConcepto"));
        metodoPagoColumnEgreso.setCellValueFactory(new PropertyValueFactory<>("metodoPago"));
        monedaColumnEgreso.setCellValueFactory(new PropertyValueFactory<>("moneda"));
        nombreEmisorColumnEgreso.setCellValueFactory(new PropertyValueFactory<>("nombreEmisor"));
        nombreReceptorColumnEgreso.setCellValueFactory(new PropertyValueFactory<>("nombreReceptor"));
        objetoImpColumnEgreso.setCellValueFactory(new PropertyValueFactory<>("objetoImp"));
        regimenFiscalEmisorColumnEgreso.setCellValueFactory(new PropertyValueFactory<>("regimenFiscalEmisor"));
        regimenFiscalReceptorColumnEgreso.setCellValueFactory(new PropertyValueFactory<>("regimenFiscalReceptor"));
        rfcEmisorColumnEgreso.setCellValueFactory(new PropertyValueFactory<>("rfcEmisor"));
        rfcReceptorColumnEgreso.setCellValueFactory(new PropertyValueFactory<>("rfcReceptor"));
        serieColumnEgreso.setCellValueFactory(new PropertyValueFactory<>("serie"));
        subtotalColumnEgreso.setCellValueFactory(new PropertyValueFactory<>("subtotal"));
        tipoComprobanteColumnEgreso.setCellValueFactory(new PropertyValueFactory<>("tipoComprobante"));
        tipoRelacionColumnEgreso.setCellValueFactory(new PropertyValueFactory<>("tipoRelacion"));
        totalColumnEgreso.setCellValueFactory(new PropertyValueFactory<>("total"));
        uuidColumnEgreso.setCellValueFactory(new PropertyValueFactory<>("uuid"));
        uuidRelacionadosColumnEgreso.setCellValueFactory(new PropertyValueFactory<>("uuidRelacionados"));
        valorUnitarioColumnEgreso.setCellValueFactory(new PropertyValueFactory<>("valorUnitario"));
        versionColumnEgreso.setCellValueFactory(new PropertyValueFactory<>("version"));
        descuentoColumnEgreso.setCellValueFactory(new PropertyValueFactory<>("descuento"));
        descuentoConceptoColumnEgreso.setCellValueFactory(new PropertyValueFactory<>("descuentoConcepto"));

        egresoTablaView.setItems(tablaEgresos);
    }

    public void mostrarTablaPagos(){
        uuidColumn.setCellValueFactory(new PropertyValueFactory<>("uuid"));
        fechaTimbradoColumn.setCellValueFactory(new PropertyValueFactory<>("fechaTimbrado"));
        serieColumn.setCellValueFactory(new PropertyValueFactory<>("serie"));
        folioColumn.setCellValueFactory(new PropertyValueFactory<>("folio"));
        rfcEmisorColumn.setCellValueFactory(new PropertyValueFactory<>("RfcEmisor"));
        nombreEmisorColumn.setCellValueFactory(new PropertyValueFactory<>("nombreEmisor"));
        regimenFiscalEmisorColumn.setCellValueFactory(new PropertyValueFactory<>("regimenFiscalEmisor"));
        rfcReceporColumn.setCellValueFactory(new PropertyValueFactory<>("RfcRecepor"));
        nombreReceptorColumn.setCellValueFactory(new PropertyValueFactory<>("nombreReceptor"));
        regimenFiscalReceptorColumn.setCellValueFactory(new PropertyValueFactory<>("regimenFiscalReceptor"));
        usoCFDIColumn.setCellValueFactory(new PropertyValueFactory<>("usoCFDI"));
        subtotalColumn.setCellValueFactory(new PropertyValueFactory<>("subtotal"));
        ivaColumn.setCellValueFactory(new PropertyValueFactory<>("iva"));
        retIvaColumn.setCellValueFactory(new PropertyValueFactory<>("retIva"));
        retIEPSColumn.setCellValueFactory(new PropertyValueFactory<>("retIeps"));
        retISRColumn.setCellValueFactory(new PropertyValueFactory<>("retIsr"));
        MontoColumn.setCellValueFactory(new PropertyValueFactory<>("monto"));
        monedaColumn.setCellValueFactory(new PropertyValueFactory<>("moneda"));
        tipoCambioColumn.setCellValueFactory(new PropertyValueFactory<>("uuidRelacionado"));
        uuidRelacionadoColumn.setCellValueFactory(new PropertyValueFactory<>("tipoCambio"));
        fechaPagoColumn.setCellValueFactory(new PropertyValueFactory<>("fechaPago"));
        formaPagoColumn.setCellValueFactory(new PropertyValueFactory<>("formaPago"));

        pagoTableView.setItems(tablaPagos);
    }


    private void obtenerCantidadTitulosTab(){
        int ing = tablaIngresos.size();
        int egr = tablaEgresos.size();
        int pag = tablaPagos.size();

        ingresosTab.setText("Ingresos (" + formatoEnteros(ing) + ")");
        egresosTab.setText("Egresos (" + formatoEnteros(egr) + ")");
        pagosTab.setText("Pagos (" + formatoEnteros(pag) + ")");
    }



    public void minimizar(){
        Stage stage = (Stage) appWindow.getScene().getWindow();

        //Minimizar la ventana
        stage.setIconified(true);

    }

    public void maximizar(){
        Stage stage = (Stage) appWindow.getScene().getWindow();
        stage.setMaximized(!stage.isMaximized());
    }

    public void cerrarVentana(){
        System.exit(0);
    }

    private void limpiarListas(){
        tablaIngresos.clear();
        tablaEgresos.clear();
        tablaPagos.clear();
    }

    private void abrirArchivo(File archivo){
        System.out.println(archivo.getAbsolutePath());
        if(!App.mostrarConfirmacion("¿Deseas abrir el archivo?")) return;

        // 1. Verificar si el entorno de escritorio es soportado
        if (!Desktop.isDesktopSupported() || !Desktop.getDesktop().isSupported(Desktop.Action.OPEN)) {
            App.mostrarMensaje("La acción de abrir no es soportada en este sistema.");
            // Opcional: Mostrar una alerta al usuario.
            return;
        }

        if(!archivo.exists()){
            App.mostrarMensaje("No existe el archivo");
            return;
        }

        try{
            Desktop.getDesktop().open(archivo);
        }catch (IOException e){
            App.mostrarMensajeError("No se pudo abrir el archivo: " + e.getMessage());
        }
    }
}
