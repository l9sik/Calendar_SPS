package com.bestgroup.calendar.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;


public class SettingController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button SettingsCancelButton;

    @FXML
    public ComboBox<String> ChooseTimeZone;

    @FXML
    void initialize() {
        FXMLLoader fxmlLoader = new FXMLLoader();
        SettingsCancelButton.setOnMouseClicked((event) -> {
            SettingsCancelButton.getScene().getWindow().hide();
            try {
                fxmlLoader.setLocation(getClass().getResource("/com/bestgroup/calendar/hello-view.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 400.0D, 600.0D);
                Stage stage = new Stage();
                stage.setTitle("Calendar SPS");
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        });
        ChooseTimeZone.setPromptText("UTC+3");
        ChooseTimeZone.getItems().setAll("UTC+1", "UTC+2", "UTC+3", "UTC+4");

    }

}
