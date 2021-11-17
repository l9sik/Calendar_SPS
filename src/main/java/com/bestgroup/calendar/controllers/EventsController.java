package com.bestgroup.calendar.controllers;

import com.bestgroup.calendar.CurrentTime;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.File;
import java.io.IOException;
import java.awt.Desktop;

/**
 * Controller for Events.fxml. Contains button to open excel file
 *
 * @author l9sik
 */
public class EventsController {

    @FXML
    private Button mainMenuCancelButton;

    @FXML
    private Button mainMenuCurrentDateButton;

    @FXML
    private Button mainMenuSettingsButton;

    @FXML
    private Button openExcelButton;

    private final NewScene newScene = new NewScene();

    @FXML
    void initialize() {

        openExcelButton.setOnAction(actionEvent -> {
            try {
                Desktop desktop = Desktop.getDesktop();

                desktop.open(new File("Events.xls"));
            } catch (IOException e) {
                System.out.println("There is something wrong with excel file.");
            }
        });
        mainMenuSettingsButton.setOnAction(actionEvent -> {
            newScene.closeScene(mainMenuSettingsButton);
            newScene.openNewScene("/com/bestgroup/calendar/Settings.fxml");
        });
        mainMenuCancelButton.setOnAction(actionEvent -> {
            newScene.closeScene(mainMenuCancelButton);
            newScene.openNewScene("/com/bestgroup/calendar/MainMenu.fxml");
        });
        mainMenuCurrentDateButton.setOnMouseClicked((event) -> {
            CurrentTime.setYear();
            CurrentTime.setMonthAndDay();
            newScene.closeScene(mainMenuCurrentDateButton);
            newScene.openNewScene("/com/bestgroup/calendar/DayMenu.fxml");
        });
    }

}
