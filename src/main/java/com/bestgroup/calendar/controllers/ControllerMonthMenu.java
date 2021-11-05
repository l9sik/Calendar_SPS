package com.bestgroup.calendar.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import com.bestgroup.calendar.AppHelper;
import org.controlsfx.control.spreadsheet.Grid;

public class ControllerMonthMenu {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private GridPane DaysTable;

    @FXML
    private Button MainMenuCorrentDateButton;

    @FXML
    private Button MainMenuSettingsButton;

    @FXML
    private Text TextForMonth;

    @FXML
    private Text Time;

    @FXML
    private Text TextForYear;

    @FXML
    void initialize() {
        TextForYear.setText(Integer.toString(AppHelper.getYear()));
        TextForMonth.setText(AppHelper.getMonthName());
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
                    btn.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            openAddEventMenu(Integer.parseInt(btn.getText()));
                        }
                    });
                }else{
                    btn.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            doNotCorrectDate();                                 //<---
                        }
                    });
                }
                DaysTable.add(btn, i, j);
            }
        }
    }
    void openAddEventMenu(int date){
        DaysTable.getScene().getWindow().hide();

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

        AppHelper.setDate(date);
    }
    void doNotCorrectDate(){
        //InsertCodeHere
    }

}
