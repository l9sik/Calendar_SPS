package com.bestgroup.calendar.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import com.bestgroup.calendar.AppHelper;
import com.bestgroup.calendar.EventHelper;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class DayMenuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button DayMenuCancelButton;

    @FXML
    private Button DayMenuSettingsButton;

    @FXML
    private Button DayMenuAddEvent;

    @FXML
    private Button DayMenuShowEvent;

    @FXML
    private AnchorPane t;

    @FXML
    private Text textMonthAndDay;

    @FXML
    private Text textYear;

    @FXML
    void initialize() {
        NewScene nw = new NewScene();
        textYear.setText(String.valueOf(AppHelper.getYear()));
        textMonthAndDay.setText(AppHelper.getMonthAndDay());
        DayMenuCancelButton.setOnAction(actionEvent -> {
            nw.closeScene(DayMenuCancelButton);
            nw.openNewScene("/com/bestgroup/calendar/hello-view.fxml");
        });
        DayMenuSettingsButton.setOnAction(actionEvent -> {
            nw.closeScene(DayMenuSettingsButton);
            nw.openNewScene("/com/bestgroup/calendar/Settings.fxml");
        });

        DayMenuShowEvent.setDisable(isDisabled());

        DayMenuShowEvent.setOnAction(actionEvent -> {
            nw.closeScene(DayMenuShowEvent);
            nw.openNewScene("/com/bestgroup/calendar/FilledEvent.fxml");
        });

        DayMenuAddEvent.setOnAction(actionEvent -> {
            nw.closeScene(DayMenuAddEvent);
            nw.openNewScene("/com/bestgroup/calendar/AddEvent.fxml");
        });
    }

    public static Boolean isDisabled(){
        EventHelper ev = new EventHelper();
        return !ev.isEventExist();
    }

}
