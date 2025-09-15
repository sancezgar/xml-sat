package org.usanchez.procesa_xml_sat;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;

public class App extends Application {

    private double x=0;
    private double y=0;

    @Override
    public void start(Stage stage) throws IOException {
        showScreen("app");
    }

    public void showScreen(String fxml) throws IOException {
        URL url = App.class.getResource(fxml + ".fxml");
        Parent root = FXMLLoader.load(url);
        Stage stage = new Stage();
        Scene scene = new Scene(root);

        root.setOnMousePressed((MouseEvent event) ->{
            x = event.getSceneX();
            y = event.getSceneY();
            stage.setOpacity(0.8);
        });

        root.setOnMouseReleased((MouseEvent event)->{
            stage.setOpacity(1);
        });

        root.setOnMouseDragged((MouseEvent event) ->{
            stage.setX(event.getScreenX() - x);
            stage.setY(event.getScreenY() - y);
        });

        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}