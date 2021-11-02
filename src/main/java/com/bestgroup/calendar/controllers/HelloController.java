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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button MainMenuAddEvent;

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
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            CurrentTime currentTime = new CurrentTime();
            Time.setText(currentTime.receiveCurrentTime());
        }),
                new KeyFrame(Duration.seconds(1))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
        MainMenuAddEvent.setOnAction(actionEvent -> {
            MainMenuAddEvent.getScene().getWindow().hide();

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
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
    }

}