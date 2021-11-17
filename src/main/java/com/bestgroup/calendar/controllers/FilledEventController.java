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
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;


public class FilledEventController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button cancelButton;

    @FXML
    private Button deleteEventButton;

    @FXML
    private Button settingsButton;

    @FXML
    private DatePicker textData;

    @FXML
    private TextField textDescription;

    @FXML
    private TextField textTheme;

    @FXML
    private TextField textTimeNotification;

    @FXML
    void initialize() {
        NewScene nw = new NewScene();
        filedFields();
        cancelButton.setOnAction(actionEvent -> {
            nw.closeScene(cancelButton);
            nw.openNewScene("/com/bestgroup/calendar/MainMenu.fxml");
        });
        settingsButton.setOnAction(actionEvent -> {
            nw.closeScene(settingsButton);
            nw.openNewScene("/com/bestgroup/calendar/Settings.fxml");
        });
        deleteEventButton.setOnAction(actionEvent -> {
            nw.closeScene(deleteEventButton);
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
        textData.setValue(LocalDate.parse(ev.getFullDate()));
        textDescription.setText(ev.getDescription());
        textTheme.setText(ev.getTheme());
        textTimeNotification.setText(ev.getTimeNotification());
    }

    public void deleteEvent() throws IOException {
        String line;
        String outputLine = String.valueOf(textData.getValue());
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
    public static void removeRow(HSSFSheet sheet, int rowIndex) {
        int lastRowNum = sheet.getLastRowNum();
        if (rowIndex >= 0 && rowIndex < lastRowNum) {
            sheet.shiftRows(rowIndex + 1, lastRowNum, -1);
        }
        if (rowIndex == lastRowNum) {
            HSSFRow removingRow = sheet.getRow(rowIndex);
            if (removingRow != null) {
                sheet.removeRow(removingRow);
            }
        }
    }

}
