package com.bestgroup.calendar.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class SuccessDeleteController {

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
        NewScene nw = new NewScene();
        buttonOk.setOnMouseClicked((event) -> {
            nw.closeScene(buttonOk);
            nw.openNewScene("/com/bestgroup/calendar/hello-view.fxml");
        });
    }
}