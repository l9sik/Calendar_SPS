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
    private Button AddEventCancelButton;

    @FXML
    private Button MainMenuSettingsButton;

    @FXML
    private Button AddEventButton;

    @FXML
    public DatePicker TextData;

    @FXML
    public TextField TextDescription;

    @FXML
    public TextField TextTheme;

    @FXML
    public TextField TextTimeNotification;


    @FXML
    void initialize() {
        setInitialTextData();
        NewScene nw = new NewScene();
        AddEventCancelButton.setOnAction(actionEvent -> {
            nw.closeScene(AddEventButton);
            nw.openNewScene("/com/bestgroup/calendar/hello-view.fxml");
        });

        MainMenuSettingsButton.setOnAction(actionEvent -> {
            nw.closeScene(AddEventButton);
            nw.openNewScene("/com/bestgroup/calendar/Settings.fxml");
        });

        AddEventButton.setOnAction(actionEvent -> {
            boolean isCorrect;
            resetStyles();
            setStyles();
            isCorrect = isStylesApplied();
            if (!isCorrect) {
                nw.openNewScene("/com/bestgroup/calendar/FailedWriting.fxml");
            } else {
                writeToFile();
                nw.closeScene(AddEventButton);
                nw.openNewScene("/com/bestgroup/calendar/SuccessWriting.fxml");
            }
        });

    }

    private void resetStyles(){
        TextTheme.setStyle("-fx-border-color: none");
        TextDescription.setStyle("-fx-border-color: none");
        TextTimeNotification.setStyle("-fx-border-color: none");
        TextData.setStyle("-fx-border-color: none");
    }

    private Boolean isStylesApplied(){
        Boolean isCorrect = true;
        if(TextTheme.getLength() < 1){
            isCorrect = false;
        }
        if (TextTheme.getLength() < 1){
            isCorrect = false;
        }
        String timeNotification = TextTimeNotification.getText();
        try{
            LocalTime.parse(timeNotification);
        } catch (DateTimeParseException | NullPointerException e) {
            isCorrect = false;
        }
        try {
            TextData.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } catch (NullPointerException e) {
            isCorrect = false;
        }
        return isCorrect;
    }

    private void setStyles(){
        if(TextTheme.getLength() < 1){
            TextTheme.setStyle("-fx-border-color: red");
        }
        if (TextDescription.getLength() < 1){
            TextDescription.setStyle("-fx-border-color: red");
        }
        String timeNotification = TextTimeNotification.getText();
        try{
            LocalTime.parse(timeNotification);
        } catch (DateTimeParseException | NullPointerException e) {
            TextTimeNotification.setPromptText("Пример: 09:30");
            TextTimeNotification.setStyle("-fx-border-color: red");
        }
        try {
            TextData.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } catch (NullPointerException e) {
            TextData.setStyle("-fx-border-color: red");
        }
    }

    private void writeToFile(){

        File log = new File("Events.txt");
        try {
            if (!log.exists()) {
                System.out.println("We had to make a new file.");
                System.out.println(log.createNewFile());
            }
            FileWriter fileWriter = new FileWriter(log, true);
            BufferedWriter bw = new BufferedWriter(fileWriter);
            bw.write(TextData.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + "\n");
            bw.write(TextTheme.getText() + "\n");
            bw.write(TextDescription.getText() + "\n");
            bw.write(TextTimeNotification.getText() + "\n");
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private void setInitialTextData(){
        try {
            if (!Objects.isNull(AppHelper.getFullDate())) {
                TextData.setValue(LocalDate.parse(AppHelper.getFullDate()));
            }
        } catch (NumberFormatException e){
            e.getMessage();
        }
        if (!Objects.isNull(CurrentTime.getCurrentDate())){
            TextData.setValue(LocalDate.parse(CurrentTime.getCurrentDate()));
        }
    }
}


