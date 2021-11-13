package com.bestgroup.calendar.controllers;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class NewScene {
    public void openNewScene(String path){
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource(path));
        javafx.scene.Scene scene = null;
        try {
            scene = new javafx.scene.Scene(fxmlLoader.load());
        } catch (IOException er) {
            er.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setTitle("Calendar SPS");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public void closeScene(Button btn){
        btn.getScene().getWindow().hide();
    }
}
