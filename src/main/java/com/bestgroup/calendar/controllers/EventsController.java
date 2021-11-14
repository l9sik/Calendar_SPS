package com.bestgroup.calendar.controllers;

import com.bestgroup.calendar.CurrentTime;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.Desktop;

/**
 * Controller for Events.fxml. Contains button to open excel file
 * @author l9sik
 */
public class EventsController {

    @FXML
    private Button mainMenuAddEventButton;

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
            }catch (IOException e){
                System.out.println("There is something wrong with excel file.");
            }
        });
        mainMenuSettingsButton.setOnAction(actionEvent ->  {
            newScene.closeScene(mainMenuAddEventButton);
            newScene.openNewScene("/com/bestgroup/calendar/Settings.fxml");
        });
        mainMenuAddEventButton.setOnAction(actionEvent -> {
            newScene.closeScene(mainMenuAddEventButton);
            newScene.openNewScene("/com/bestgroup/calendar/AddEvent.fxml");
        });
        mainMenuCurrentDateButton.setOnMouseClicked((event) -> {
            CurrentTime.setYear();
            CurrentTime.setMonthAndDay();
            newScene.closeScene(mainMenuCurrentDateButton);
            newScene.openNewScene("/com/bestgroup/calendar/DayMenu.fxml");
        });
    }

}
