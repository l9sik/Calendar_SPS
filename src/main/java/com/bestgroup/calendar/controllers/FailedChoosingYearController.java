package com.bestgroup.calendar.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * Controller for FailedChoosingYear.fxml
 *
 * @author eviv2206
 */
public class FailedChoosingYearController {

	@FXML
	private Button buttonOk;

    /**
     * Initialize.
     */
    @FXML
	void initialize() {
		buttonOk.setOnMouseClicked(event -> buttonOk.getScene().getWindow().hide());
	}

}
