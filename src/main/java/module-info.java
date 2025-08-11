module org.usanchez.procesa_xml_sat {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.usanchez.procesa_xml_sat to javafx.fxml;
    exports org.usanchez.procesa_xml_sat;
}