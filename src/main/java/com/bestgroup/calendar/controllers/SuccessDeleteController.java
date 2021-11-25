package com.bestgroup.calendar.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * Controller for SuccessDelete.fxml
 * @author eviv2206
 */
public class SuccessDeleteController {

    @FXML
    private Button buttonOk;


    @FXML
    void initialize() {
        NewScene nw = new NewScene();
        buttonOk.setOnMouseClicked(event -> {
            nw.closeScene(buttonOk);
            nw.openNewScene("/com/bestgroup/calendar/MainMenu.fxml");
        });
    }
}