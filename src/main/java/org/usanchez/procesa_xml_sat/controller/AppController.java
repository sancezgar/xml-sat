package org.usanchez.procesa_xml_sat.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.usanchez.procesa_xml_sat.App;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class AppController implements Initializable {

    @FXML
    private AnchorPane appWindow;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public String importar(){
        String ruta="";
        DirectoryChooser dc = new DirectoryChooser();
        File selectedDirectory =  dc.showDialog(null);
        dc.setInitialDirectory(new File(System.getProperty("user.home")));
        if(selectedDirectory != null){
            ruta =  selectedDirectory.getAbsolutePath();
            System.out.println("ruta: " + ruta);
        }else{
            System.out.println("No se escogio la ruta.");
        }
        return ruta;
    }

    public void minimizar(){
        Stage stage = (Stage) appWindow.getScene().getWindow();

        //Minimizar la ventana
        stage.setIconified(true);

    }

    public void maximizar(){
        Stage stage = (Stage) appWindow.getScene().getWindow();

        if(stage.isMaximized()){
            stage.setMaximized(false);
        }else{
            stage.setMaximized(true);
        }
    }

    public void cerrarVentana(){
        System.exit(0);
    }

}
