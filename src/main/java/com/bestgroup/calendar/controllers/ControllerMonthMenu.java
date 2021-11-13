package com.bestgroup.calendar.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import com.bestgroup.calendar.AppHelper;

public class ControllerMonthMenu {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private GridPane daysTable;

    @FXML
    private Button mainMenuSettingsButton;

    @FXML
    private Text textForMonth;

    @FXML
    private Text time;

    @FXML

    private Text textForYear;

    @FXML
    private Button mainMenuCancelButton;

    private final NewScene nw = new NewScene();

    @FXML
    void initialize() {
        textForYear.setText(Integer.toString(AppHelper.getYear()));
        textForMonth.setText(AppHelper.getMonthName());
        int[][] dateInIntArray = AppHelper.getWeekMatrix();
        for (int j = 0; j < 5; j++) {
            for (int i = 0; i < 7; i++) {
                String text = null;
                if (dateInIntArray[i][j] > 0)
                    text = Integer.toString(dateInIntArray[i][j]);
                Button btn = new Button(text);
                btn.setMaxHeight(30);
                btn.setMaxWidth(30);
                GridPane.setMargin(btn, new Insets(10));
                GridPane.setHalignment(btn, HPos.CENTER);
                if (text != null){
                    btn.setOnAction(actionEvent -> {
                        AppHelper.setDate(btn.getText());
                        AppHelper.setMonthAndDay(btn.getText(), AppHelper.getMonthName());
                        nw.closeScene(btn);
                        nw.openNewScene("/com/bestgroup/calendar/DayMenu.fxml");
                    });
                }else{
                    btn.setOnAction(actionEvent -> {
                        doNotCorrectDate();                                 //<---
                    });
                }
                daysTable.add(btn, i, j);
            }
        }
        mainMenuCancelButton.setOnAction(actionEvent -> {
            nw.closeScene(mainMenuCancelButton);
            nw.openNewScene("/com/bestgroup/calendar/hello-view.fxml");
        });
        mainMenuSettingsButton.setOnAction(actionEvent -> {
            nw.closeScene(mainMenuCancelButton);
            nw.openNewScene("/com/bestgroup/calendar/Settings.fxml");
        });
    }


    void doNotCorrectDate() {
        //InsertCodeHere

    }
}
