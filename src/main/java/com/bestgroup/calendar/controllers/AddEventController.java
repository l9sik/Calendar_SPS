package com.bestgroup.calendar.controllers;

import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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
            MainMenuSettingsButton.getScene().getWindow().hide();
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
            boolean isCorrect = true;
            TextTheme.setStyle("-fx-border-color: none");
            TextDescription.setStyle("-fx-border-color: none");
            TextTimeNotification.setStyle("-fx-border-color: none");
            TextData.setStyle("-fx-border-color: none");

            if(TextTheme.getText() == ""){
                isCorrect = false;
                TextTheme.setStyle("-fx-border-color: red");
            }
            if (TextDescription.getText() == ""){
                isCorrect = false;
                TextDescription.setStyle("-fx-border-color: red");
            }
            String timeNotification = TextTimeNotification.getText();
            try{
                LocalTime.parse(timeNotification);
            } catch (DateTimeParseException | NullPointerException e) {
                isCorrect = false;
                TextTimeNotification.setPromptText("Пример: 09:30");
                TextTimeNotification.setStyle("-fx-border-color: red");
            }
            try {
                TextData.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            } catch (NullPointerException e) {
                isCorrect = false;
                TextData.setStyle("-fx-border-color: red");
            }
            if (isCorrect == false) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/com/bestgroup/calendar/FailedWriting.fxml"));
                Scene scene = null;
                try {
                    scene = new Scene(fxmlLoader.load());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Stage stage = new Stage();
                stage.setTitle("Calendar SPS");
                stage.setScene(scene);
                stage.show();
            } else {
                AddEventButton.getScene().getWindow().hide();
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/com/bestgroup/calendar/SuccessWriting.fxml"));
                Scene scene = null;
                try {
                    scene = new Scene(fxmlLoader.load());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Stage stage = new Stage();
                stage.setTitle("Calendar SPS");
                stage.setScene(scene);
                stage.show();
                File log = new File("Events.txt");
                try {
                    if (!log.exists()) {
                        System.out.println("We had to make a new file.");
                        log.createNewFile();
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
        });

    }
}


