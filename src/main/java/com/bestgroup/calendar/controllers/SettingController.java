package com.bestgroup.calendar.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


import com.bestgroup.calendar.CurrentTime;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.text.Text;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javafx.util.Duration;


public class SettingController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button SettingsCancelButton;

    @FXML
    public ComboBox<String> ChooseTimeZone;

    @FXML
    private Text time;

    @FXML
    private Text string;


    @FXML
    void initialize() {
        FXMLLoader fxmlLoader = new FXMLLoader();
        SettingsCancelButton.setOnMouseClicked((event) -> {
            SettingsCancelButton.getScene().getWindow().hide();
            try {
                fxmlLoader.setLocation(getClass().getResource("/com/bestgroup/calendar/hello-view.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 400.0D, 600.0D);
                Stage stage = new Stage();
                stage.setTitle("Calendar SPS");
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        });
        ChooseTimeZone.setPromptText("UTC+3");
        ChooseTimeZone.getItems().setAll("UTC-9","UTC-3","UTC-2","UTC-1","UTC+0", "UTC+1", "UTC+2", "UTC+3", "UTC+4", "UTC+5");

        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            CurrentTime currentTime = new CurrentTime();
            if (ChooseTimeZone.getValue() == null){
                String str = "UTC+3";
                time.setText(currentTime.getCurrentTime("UTC+3"));
                string.setText("Текущее время в часовом поясе " + str);
            } else{
                String str = ChooseTimeZone.getValue();
                time.setText(currentTime.getCurrentTime(ChooseTimeZone.getValue()));
                string.setText("Текущее время в часовом поясе " + str);
            }

        }),
                new KeyFrame(Duration.seconds(1))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();

    }

}
