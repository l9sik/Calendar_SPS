package com.bestgroup.calendar.controllers;

import com.bestgroup.calendar.AppHelper;
import com.bestgroup.calendar.CurrentTime;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javafx.scene.control.ComboBox;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    private NewScene nw = new NewScene();

    @FXML
    void initialize() {

        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            CurrentTime currentTime = new CurrentTime();
            Time.setText(currentTime.getCurrentTime("UTC+3"));
        }),
                new KeyFrame(Duration.seconds(1))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();


        MainMenuCurrentDateButton.setOnMouseClicked((event) -> {
            CurrentTime.setYear();
            CurrentTime.setMonthAndDay();
            nw.closeScene(MainMenuCurrentDateButton);
            nw.openNewScene("/com/bestgroup/calendar/DayMenu.fxml");
        });

        MainMenuSettingsButton.setOnMouseClicked((event) -> {
            nw.closeScene(MainMenuSettingsButton);
            nw.openNewScene("/com/bestgroup/calendar/Settings.fxml");
        });

        MainMenuAddEventButton.setOnMouseClicked((event) -> {
            CurrentTime.resetDate();
            nw.closeScene(MainMenuAddEventButton);
            nw.openNewScene("/com/bestgroup/calendar/AddEvent.fxml");
        });

        ChooseYear.getItems().setAll("2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028");

        MainMenuJanButton.setOnAction(actionEvent -> OpenMonthMenu(MainMenuJanButton, 1));
        MainMenuFebButton.setOnAction(actionEvent -> OpenMonthMenu(MainMenuFebButton, 2));
        MainMenuMarchButton.setOnAction(actionEvent -> OpenMonthMenu(MainMenuMarchButton, 3));
        MainMenuAprButton.setOnAction(actionEvent -> OpenMonthMenu(MainMenuAprButton, 4));
        MainMenuMayButton.setOnAction(actionEvent -> OpenMonthMenu(MainMenuMayButton, 5));
        MainMenuJuneButton.setOnAction(actionEvent -> OpenMonthMenu(MainMenuJuneButton, 6));
        MainMenuJulyButton.setOnAction(actionEvent -> OpenMonthMenu(MainMenuJulyButton, 7));
        MainMenuAugButton.setOnAction(actionEvent -> OpenMonthMenu(MainMenuAugButton, 8));
        MainMenuSeptButton.setOnAction(actionEvent -> OpenMonthMenu(MainMenuSeptButton, 9));
        MainMenuOctButton.setOnAction(actionEvent -> OpenMonthMenu(MainMenuOctButton, 10));
        MainMenuNovButton.setOnAction(actionEvent -> OpenMonthMenu(MainMenuNovButton, 11));
        MainMenuDecButton.setOnAction(actionEvent -> OpenMonthMenu(MainMenuFebButton, 12));


    }

    void OpenMonthMenu(Button btn, int monthNum) {
        boolean isYear = isYear();
        if (!isYear){
            nw.openNewScene("/com/bestgroup/calendar/FailedChoosingYear.fxml");
        } else {
            AppHelper.setMonthNumber(monthNum);
            AppHelper.setYear(Integer.parseInt(ChooseYear.getValue()));
            nw.closeScene(btn);
            nw.openNewScene("/com/bestgroup/calendar/Month.fxml");
        }
    }


    Boolean isYear(){
        boolean isYear = true;
        int year = 0;
        try {
            year = Integer.parseInt(ChooseYear.getValue());
        } catch (NumberFormatException e){
            isYear = false;
        }
        return isYear;
    }

}