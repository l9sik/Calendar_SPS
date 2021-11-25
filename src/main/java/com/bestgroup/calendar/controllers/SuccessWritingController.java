package com.bestgroup.calendar.controllers;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

/**
 * Controller for SuccessWriting.fxml
 *
 * @author eviv2206
 */
public class SuccessWritingController {

    @FXML
    private Button buttonOk;

    /**
     * Initialize.
     */
    @FXML
    void initialize() {
        NewScene nw = new NewScene();
        buttonOk.setOnMouseClicked(event -> {
            nw.closeScene(buttonOk);
            nw.openNewScene("/com/bestgroup/calendar/MainMenu.fxml");
        });

    }

}
