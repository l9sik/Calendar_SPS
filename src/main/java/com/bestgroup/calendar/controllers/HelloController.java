package com.bestgroup.calendar.controllers;

import com.bestgroup.calendar.CurrentTime;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.control.ComboBox;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController {

    @FXML
    private ComboBox<String> ChooseYear;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button MainMenuAddEventButton;

    @FXML
    private Button MainMenuAprButton;

    @FXML
    private Button MainMenuAugButton;

    @FXML
    private Button MainMenuCurrentDateButton;

    @FXML
    private Button MainMenuDecButton;

    @FXML
    private Button MainMenuFebButton;

    @FXML
    private Button MainMenuJanButton;

    @FXML
    private Button MainMenuJulyButton;

    @FXML
    private Button MainMenuJuneButton;

    @FXML
    private Button MainMenuMarchButton;

    @FXML
    private Button MainMenuMayButton;

    @FXML
    private Button MainMenuNovButton;

    @FXML
    private Button MainMenuOctButton;

    @FXML
    private Button MainMenuSeptButton;

    @FXML
    private Button MainMenuSettingsButton;

    @FXML
    private Text Time;


    @FXML
    void initialize() {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            CurrentTime currentTime = new CurrentTime();
            Time.setText(currentTime.receiveCurrentTime("UTC+3"));
        }),
                new KeyFrame(Duration.seconds(1))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();

        MainMenuSettingsButton.setOnMouseClicked((event) -> {
            MainMenuSettingsButton.getScene().getWindow().hide();
            try {
                fxmlLoader.setLocation(getClass().getResource("/com/bestgroup/calendar/Settings.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 400.0D, 600.0D);
                Stage stage = new Stage();
                stage.setTitle("Calendar SPS");
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        });

        MainMenuAddEventButton.setOnAction(actionEvent -> {
            MainMenuAddEventButton.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/com/bestgroup/calendar/AddEvent.fxml"));
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
            stage.show();
        });

        ChooseYear.getItems().setAll("2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028");

    }

}