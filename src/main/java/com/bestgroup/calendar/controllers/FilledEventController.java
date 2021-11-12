package com.bestgroup.calendar.controllers;

import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.bestgroup.calendar.EventHelper;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;


public class FilledEventController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button CancelButton;

    @FXML
    private Button DeleteEventButton;

    @FXML
    private Button SettingsButton;

    @FXML
    private DatePicker TextData;

    @FXML
    private TextField TextDescription;

    @FXML
    private TextField TextTheme;

    @FXML
    private TextField TextTimeNotification;

    @FXML
    void initialize() {
        NewScene nw = new NewScene();
        filedFields();
        CancelButton.setOnAction(actionEvent -> {
            nw.closeScene(CancelButton);
            nw.openNewScene("/com/bestgroup/calendar/hello-view.fxml");
        });
        SettingsButton.setOnAction(actionEvent -> {
            nw.closeScene(SettingsButton);
            nw.openNewScene("/com/bestgroup/calendar/Settings.fxml");
        });
        DeleteEventButton.setOnAction(actionEvent -> {
            nw.closeScene(DeleteEventButton);
            nw.openNewScene("/com/bestgroup/calendar/SuccessDelete.fxml");
            try {
                deleteEvent();
            } catch (IOException e){
                System.out.println(e.getMessage());
            }
        });

    }

    public void filedFields() {
        EventHelper ev = new EventHelper();
        ev.getEvent();
        TextData.setValue(LocalDate.parse(ev.getFullDate()));
        TextDescription.setText(ev.getDescription());
        TextTheme.setText(ev.getTheme());
        TextTimeNotification.setText(ev.getTimeNotification());

    }

    public void deleteEvent() throws IOException {
        String line;
        String outputLine = String.valueOf(TextData.getValue());
        File sourceFile = new File("Events.txt");
        File outputFile = new File("Dictio2.txt");
        BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
        while ((line = reader.readLine()) != null) {
            if (!line.equals(outputLine)) {
                writer.write(line);
                writer.newLine();
            } else {
                reader.readLine();
                reader.readLine();
                reader.readLine();
            }
        }
        reader.close();
        writer.close();
        sourceFile.delete();
        outputFile.renameTo(sourceFile);
    }

}
