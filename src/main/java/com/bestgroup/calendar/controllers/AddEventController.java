package com.bestgroup.calendar.controllers;

import com.bestgroup.calendar.AppHelper;
import com.bestgroup.calendar.CurrentTime;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Objects;
import java.util.ResourceBundle;

public class AddEventController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addEventCancelButton;
    @FXML
    private Button mainMenuSettingsButton;

    @FXML
    private Button addEventButton;

    @FXML
    public DatePicker textData;

    @FXML
    public TextField textDescription;

    @FXML
    public TextField textTheme;

    @FXML
    public TextField textTimeNotification;

    private static final String DATA_FORMAT = "yyyy-MM-dd";


    @FXML
    void initialize() {
        setInitialTextData();
        NewScene nw = new NewScene();
        addEventCancelButton.setOnAction(actionEvent -> {
            nw.closeScene(addEventButton);
            nw.openNewScene("/com/bestgroup/calendar/hello-view.fxml");
        });

        mainMenuSettingsButton.setOnAction(actionEvent -> {
            nw.closeScene(addEventButton);
            nw.openNewScene("/com/bestgroup/calendar/Settings.fxml");
        });

        addEventButton.setOnAction(actionEvent -> {
            boolean isCorrect;
            resetStyles();
            setStyles();
            isCorrect = isStylesApplied();
            if (!isCorrect) {
                nw.openNewScene("/com/bestgroup/calendar/FailedWriting.fxml");
            } else {
                writeToFile();
                nw.closeScene(addEventButton);
                nw.openNewScene("/com/bestgroup/calendar/SuccessWriting.fxml");
            }
        });

    }

    private void resetStyles() {
        String borderNone = "-fx-border-color: none";
        textTheme.setStyle(borderNone);
        textDescription.setStyle(borderNone);
        textTimeNotification.setStyle(borderNone);
        textData.setStyle(borderNone);
    }

    private Boolean isStylesApplied() {
        boolean isCorrect = true;
        if (textTheme.getLength() < 1) {
            isCorrect = false;
        }
        if (textDescription.getLength() < 1) {
            isCorrect = false;
        }
        String timeNotification = textTimeNotification.getText();
        try {
            LocalTime.parse(timeNotification);
        } catch (DateTimeParseException | NullPointerException e) {
            isCorrect = false;
        }
        try {
            textData.getValue().format(DateTimeFormatter.ofPattern(DATA_FORMAT));
        } catch (NullPointerException e) {
            isCorrect = false;
        }
        return isCorrect;
    }

    private void setStyles() {
        String borderRed = "-fx-border-color: red";
        if (textTheme.getLength() < 1) {
            textTheme.setStyle(borderRed);
        }
        if (textDescription.getLength() < 1) {
            textDescription.setStyle(borderRed);
        }
        String timeNotification = textTimeNotification.getText();
        try {
            LocalTime.parse(timeNotification);
        } catch (DateTimeParseException | NullPointerException e) {
            textTimeNotification.setPromptText("Пример: 09:30");
            textTimeNotification.setStyle(borderRed);
        }
        try {
            textData.getValue().format(DateTimeFormatter.ofPattern(DATA_FORMAT));
        } catch (NullPointerException e) {
            textData.setStyle(borderRed);
        }
    }

    private void writeToFile() {

        File log = new File("Events.txt");
        try {
            if (!log.exists()) {
                System.out.println("We had to make a new file.");
                System.out.println(log.createNewFile());
            }
            FileWriter fileWriter = new FileWriter(log, true);
            BufferedWriter bw = new BufferedWriter(fileWriter);
            bw.write(textData.getValue().format(DateTimeFormatter.ofPattern(DATA_FORMAT)) + "\n");
            bw.write(textTheme.getText() + "\n");
            bw.write(textDescription.getText() + "\n");
            bw.write(textTimeNotification.getText() + "\n");
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private void setInitialTextData() {
        try {
            if (!Objects.isNull(AppHelper.getFullDate())) {
                textData.setValue(LocalDate.parse(AppHelper.getFullDate()));
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        if (!Objects.isNull(CurrentTime.getCurrentDate())) {
            textData.setValue(LocalDate.parse(CurrentTime.getCurrentDate()));
        }
    }
}


