package com.bestgroup.calendar.controllers;

import com.bestgroup.calendar.AppHelper;
import com.bestgroup.calendar.EventHelper;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

/**
 * Controller for DayMenu.fxml
 *
 * @author eviv2206
 */
public class DayMenuController {

    @FXML
    private Button dayMenuCancelButton;

    @FXML
    private Button dayMenuSettingsButton;

    @FXML
    private Button dayMenuAddEvent;

    @FXML
    private Button dayMenuShowEvent;

    @FXML
    private Text textMonthAndDay;

    @FXML
    private Text textYear;

    /**
     * Initialize.
     */
    @FXML
    void initialize() {
        NewScene nw = new NewScene();
        textYear.setText(String.valueOf(AppHelper.getYear()));
        textMonthAndDay.setText(AppHelper.getMonthAndDay());
        dayMenuCancelButton.setOnAction(actionEvent -> {
            nw.closeScene(dayMenuCancelButton);
            nw.openNewScene("/com/bestgroup/calendar/MainMenu.fxml");
        });
        dayMenuSettingsButton.setOnAction(actionEvent -> {
            nw.closeScene(dayMenuSettingsButton);
            nw.openNewScene("/com/bestgroup/calendar/Settings.fxml");
        });

        dayMenuShowEvent.setDisable(isDisabled());

        dayMenuShowEvent.setOnAction(actionEvent -> {
            nw.closeScene(dayMenuShowEvent);
            nw.openNewScene("/com/bestgroup/calendar/FilledEvent.fxml");
        });

        dayMenuAddEvent.setOnAction(actionEvent -> {
            nw.closeScene(dayMenuAddEvent);
            nw.openNewScene("/com/bestgroup/calendar/AddEvent.fxml");
        });
    }

    /**
     * Is disabled boolean.
     *
     * @return the boolean
     */
    public static Boolean isDisabled(){
        EventHelper ev = new EventHelper();
        return !ev.isEventExist();
    }

}
