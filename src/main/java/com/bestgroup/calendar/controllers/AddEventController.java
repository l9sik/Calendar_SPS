package com.bestgroup.calendar.controllers;

import javafx.scene.control.TextField;
import com.bestgroup.calendar.Events;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
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
        FXMLLoader loader = new FXMLLoader();
        AddEventCancelButton.setOnAction(actionEvent -> {
            AddEventCancelButton.getScene().getWindow().hide();
            loader.setLocation(getClass().getResource("/com/bestgroup/calendar/hello-view.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("MYError.");
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setTitle("Calendar SPS");
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
        MainMenuSettingsButton.setOnAction(actionEvent -> {
            AddEventCancelButton.getScene().getWindow().hide();
            loader.setLocation(getClass().getResource("/com/bestgroup/calendar/Settings.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("MYError.");
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setTitle("Calendar SPS");
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });

        AddEventButton.setOnAction(actionEvent -> {
            String description = TextDescription.getText();
            String theme = TextTheme.getText();
            String date = TextData.getPromptText();
            String time = TextTimeNotification.getText();
            BufferedWriter writer = null;
            String filePath = "E:\\Events.txt";
            try {
                writer = new BufferedWriter(new FileWriter(filePath));
                writer.write(date);
                writer.newLine();
                writer.write(theme);
                writer.newLine();
                writer.write(description);
                writer.newLine();
                writer.write(time);
                writer.newLine();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            } finally {
                try {
                    writer.close();
                } catch (IOException e){
                    System.err.println(e.getMessage());
                }
            }
        });
    }



}
