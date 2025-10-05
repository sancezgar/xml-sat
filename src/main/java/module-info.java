module org.usanchez.procesa_xml_sat {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires jakarta.xml.bind;
    requires javafx.base;
    requires org.apache.poi.poi;
    requires org.apache.poi.ooxml;


    opens org.usanchez.procesa_xml_sat to javafx.fxml;
    exports org.usanchez.procesa_xml_sat;
    opens org.usanchez.procesa_xml_sat.controller to javafx.fxml;
    exports org.usanchez.procesa_xml_sat.controller;
    opens org.usanchez.procesa_xml_sat.domain to jakarta.xml.bind, javafx.base;
}