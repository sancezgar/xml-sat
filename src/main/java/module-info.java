module org.usanchez.procesa_xml_sat {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.usanchez.procesa_xml_sat to javafx.fxml;
    exports org.usanchez.procesa_xml_sat;
    opens org.usanchez.procesa_xml_sat.controller to javafx.fxml;
    exports org.usanchez.procesa_xml_sat.controller;
}