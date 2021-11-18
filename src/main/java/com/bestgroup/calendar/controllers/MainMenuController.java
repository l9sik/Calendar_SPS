package com.bestgroup.calendar.controllers;

import com.bestgroup.calendar.AppHelper;
import com.bestgroup.calendar.CurrentTime;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javafx.scene.control.ComboBox;
import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuController {

    @FXML
    private Button events;

    @FXML
    private ComboBox<String> chooseYear;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button mainMenuAddEventButton;

    @FXML
    private Button mainMenuAprButton;

    @FXML
    private Button mainMenuAugButton;

    @FXML
    private Button mainMenuCurrentDateButton;

    @FXML
    private Button mainMenuDecButton;

    @FXML
    private Button mainMenuFebButton;

    @FXML
    private Button mainMenuJanButton;

    @FXML
    private Button mainMenuJulyButton;

    @FXML
    private Button mainMenuJuneButton;

    @FXML
    private Button mainMenuMarchButton;

    @FXML
    private Button mainMenuMayButton;

    @FXML
    private Button mainMenuNovButton;

    @FXML
    private Button mainMenuOctButton;

    @FXML
    private Button mainMenuSeptButton;

    @FXML
    private Button mainMenuSettingsButton;

    @FXML
    private Text time;

    private final NewScene nw = new NewScene();

    @FXML

    void initialize() {

        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> time.setText(CurrentTime.getCurrentTime("UTC+3"))),
                new KeyFrame(Duration.seconds(1))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();


        mainMenuCurrentDateButton.setOnMouseClicked((event) -> {
            CurrentTime.setYear();
            CurrentTime.setMonthAndDay();
            nw.closeScene(mainMenuCurrentDateButton);
            nw.openNewScene("/com/bestgroup/calendar/DayMenu.fxml");
        });

        mainMenuSettingsButton.setOnMouseClicked((event) -> {
            nw.closeScene(mainMenuSettingsButton);
            nw.openNewScene("/com/bestgroup/calendar/Settings.fxml");
        });

        mainMenuAddEventButton.setOnMouseClicked((event) -> {
            CurrentTime.resetDate();
            nw.closeScene(mainMenuAddEventButton);
            nw.openNewScene("/com/bestgroup/calendar/AddEvent.fxml");
        });

        chooseYear.getItems().setAll("2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028");

        mainMenuJanButton.setOnAction(actionEvent -> OpenMonthMenu(mainMenuJanButton, 1));
        mainMenuFebButton.setOnAction(actionEvent -> OpenMonthMenu(mainMenuFebButton, 2));
        mainMenuMarchButton.setOnAction(actionEvent -> OpenMonthMenu(mainMenuMarchButton, 3));
        mainMenuAprButton.setOnAction(actionEvent -> OpenMonthMenu(mainMenuAprButton, 4));
        mainMenuMayButton.setOnAction(actionEvent -> OpenMonthMenu(mainMenuMayButton, 5));
        mainMenuJuneButton.setOnAction(actionEvent -> OpenMonthMenu(mainMenuJuneButton, 6));
        mainMenuJulyButton.setOnAction(actionEvent -> OpenMonthMenu(mainMenuJulyButton, 7));
        mainMenuAugButton.setOnAction(actionEvent -> OpenMonthMenu(mainMenuAugButton, 8));
        mainMenuSeptButton.setOnAction(actionEvent -> OpenMonthMenu(mainMenuSeptButton, 9));
        mainMenuOctButton.setOnAction(actionEvent -> OpenMonthMenu(mainMenuOctButton, 10));
        mainMenuNovButton.setOnAction(actionEvent -> OpenMonthMenu(mainMenuNovButton, 11));
        mainMenuDecButton.setOnAction(actionEvent -> OpenMonthMenu(mainMenuFebButton, 12));
        events.setOnAction(actionEvent -> {
            nw.closeScene(events);
            nw.openNewScene("/com/bestgroup/calendar/Events.fxml");
        });


    }

    void OpenMonthMenu(Button btn, int monthNum) {
        boolean isYear = isYear();
        if (!isYear){
            nw.openNewScene("/com/bestgroup/calendar/FailedChoosingYear.fxml");
        } else {
            AppHelper.setMonthNumber(monthNum);
            AppHelper.setYear(Integer.parseInt(chooseYear.getValue()));
            nw.closeScene(btn);
            nw.openNewScene("/com/bestgroup/calendar/Month.fxml");
        }
    }


    Boolean isYear(){
        boolean isYear = true;
        int year = 0;
        try {
            year = Integer.parseInt(chooseYear.getValue());
        } catch (NumberFormatException e){
            isYear = false;
        }
        return isYear;
    }

}