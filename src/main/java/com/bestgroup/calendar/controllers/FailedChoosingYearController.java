package com.bestgroup.calendar.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class FailedChoosingYearController {

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
        text.setText("Ошибка! Выберите год.");
        buttonOk.setOnMouseClicked((event) -> {
            buttonOk.getScene().getWindow().hide();
        });


    }

}
