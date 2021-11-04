package com.bestgroup.calendar.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SuccessWritingController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonOk;

    @FXML
    private Text text;

    @FXML
    void initialize() {
        FXMLLoader loader = new FXMLLoader();
        text.setText("Событие успешно добавлено!");
        buttonOk.setOnMouseClicked((event) -> {
            buttonOk.getScene().getWindow().hide();
            loader.setLocation(getClass().getResource("/com/bestgroup/calendar/hello-view.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("MYError.");
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setTitle("Calendar SPS");
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });

    }

}
