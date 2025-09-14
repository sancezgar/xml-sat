package org.usanchez.procesa_xml_sat.controller;

import javafx.fxml.Initializable;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import org.usanchez.procesa_xml_sat.App;

import javax.swing.*;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class AppController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public String importar(){
        String ruta="";
        DirectoryChooser dc = new DirectoryChooser();
        File selectedDirectory =  dc.showDialog(null);
        if(selectedDirectory != null){
            ruta =  selectedDirectory.getAbsolutePath();
            System.out.println("ruta: " + ruta);
        }else{
            System.out.println("No se escogio la ruta.");
        }
        return ruta;
    }

}
