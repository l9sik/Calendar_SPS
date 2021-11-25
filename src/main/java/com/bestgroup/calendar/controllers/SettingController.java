package com.bestgroup.calendar.controllers;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

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

/**
 * Controller for Setting.fxml
 * @author eviv2206
 */
public class SettingController {

    private static final Logger logger = Logger.getLogger("SettingController.class");

    @FXML
    private Button settingsCancelButton;

    @FXML
    public ComboBox<String> chooseTimeZone;

    @FXML
    private Text time;

    @FXML
    private Text string;

    private static final String UTC_3 = "UTC+3";

    @FXML
    void initialize() {
        FXMLLoader fxmlLoader = new FXMLLoader();
        settingsCancelButton.setOnMouseClicked(event -> {
            settingsCancelButton.getScene().getWindow().hide();
            String errorMessage = "IOException is happened";
            try {
                fxmlLoader.setLocation(getClass().getResource("/com/bestgroup/calendar/MainMenu.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 400.0D, 600.0D);
                Stage stage = new Stage();
                stage.setTitle("Calendar SPS");
                stage.setScene(scene);
                stage.show();

            } catch (IOException e) {
                logger.log(Level.INFO, errorMessage);
            }
        });

        chooseTimeZone.setPromptText(UTC_3);
        chooseTimeZone.getItems().setAll("UTC-9", "UTC-3", "UTC-2", "UTC-1", "UTC+0", "UTC+1", "UTC+2", UTC_3, "UTC+4", "UTC+5");

        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            if (chooseTimeZone.getValue() == null) {
                time.setText(CurrentTime.getCurrentTime(UTC_3));
                string.setText("Текущее время в часовом поясе " + UTC_3);
            } else {
                String str = chooseTimeZone.getValue();
                time.setText(CurrentTime.getCurrentTime(chooseTimeZone.getValue()));
                string.setText("Текущее время в часовом поясе " + str);
            }

        }),
                new KeyFrame(Duration.seconds(1))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();

    }

}
