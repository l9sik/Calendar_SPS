package com.bestgroup.calendar.controllers;

import javafx.fxml.FXML;

import javafx.scene.control.Button;


public class FailedWritingController {

    @FXML
    private Button buttonOk;

    @FXML
    void initialize() {
        buttonOk.setOnMouseClicked(event -> buttonOk.getScene().getWindow().hide());

    }

}
