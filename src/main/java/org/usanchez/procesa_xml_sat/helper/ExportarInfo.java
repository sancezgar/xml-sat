package org.usanchez.procesa_xml_sat.helper;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.*;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ExportarInfo {
    public static<T> void exportarExcel(List<TableView<?>> tablas, String archivoRuta){

        try(Workbook workbook = new HSSFWorkbook();) {
            for (TableView<?> tabla : tablas) {
                exportaUnaTabla(tabla,workbook,archivoRuta);
            }
        }catch (Exception e){
            System.out.println("Mensaje Error -> " + e.getMessage());
        }
    }

    public static<T> void exportaUnaTabla(TableView<T> tabla, Workbook workbook, String archivoRuta){
        AtomicInteger rowNum = new AtomicInteger(0);
        Sheet hoja = workbook.createSheet(tabla.getAccessibleText());

                //Estilo cabecera
                CellStyle estiloCabecera = workbook.createCellStyle();
                Font fuenteCabecera = workbook.createFont();
                fuenteCabecera.setBold(true);
                estiloCabecera.setFont(fuenteCabecera);
                estiloCabecera.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
                estiloCabecera.setFillPattern(FillPatternType.SOLID_FOREGROUND);

                //Crear fila cabecera
                Row cabecera = hoja.createRow(rowNum.getAndIncrement());
                // --- 2. Escribir Encabezados (Header) ---
                AtomicInteger colNum = new AtomicInteger(0);
                // Iterar sobre las columnas
                for (TableColumn<?,?> column : tabla.getColumns()) {
                        Cell cell = cabecera.createCell(colNum.getAndIncrement());
                        // Usar el texto del encabezado de la columna
                        cell.setCellValue(column.getText());
                        cell.setCellStyle(estiloCabecera);
                }

                // --- Llenar datos ---
                // --- 3. Escribir Filas de Datos ---
                // Iterar sobre cada objeto de datos en la tabla
                for (T item : tabla.getItems()) {
                    Row row = hoja.createRow(rowNum.getAndIncrement());
                    colNum.set(0); // Reiniciar el contador de columnas para cada fila

                    // Iterar sobre las columnas para obtener el valor de la celda
                    for (TableColumn<T,?> column : tabla.getColumns()) {
                        Cell cell = row.createCell(colNum.getAndIncrement());

                        // Obtiene el valor de la celda. Esto invoca el CellValueFactory.
                        Object cellValue = column.getCellData(item);

                        if (cellValue != null) {
                            String stringValue = cellValue.toString();

                            // Intenta parsear como número. Esto es vital para que Excel pueda sumar.
                            try {
                                // Limpia el valor de cualquier separador de miles (,) o símbolos de moneda ($)
                                String cleanValue = stringValue.replace("$", "").replace(",", "").trim();
                                double numericValue = Double.parseDouble(cleanValue);
                                cell.setCellValue(numericValue);

                            } catch (NumberFormatException e) {
                                // Si no es un número, guárdalo como texto
                                cell.setCellValue(stringValue);
                            }
                        } else {
                            cell.setCellValue(""); // Celda vacía si el valor es null
                        }
                    }
                }

                // --- 4. Autoajustar Columnas (Opcional) ---
                // Mejora la presentación final en Excel
                for (int i = 0; i < tabla.getColumns().size(); i++) {
                    // Se puede limitar el autoajuste en tablas muy grandes para evitar lentitud
                    hoja.autoSizeColumn(i);
                }

                // --- Guardar archivo ---
                try (FileOutputStream fileOut = new FileOutputStream(archivoRuta)) {
                    workbook.write(fileOut);
                } catch (IOException e) {
                    System.out.println("Mensaje Error -> " + e.getMessage());
                }
    }
}
