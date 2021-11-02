package com.bestgroup.calendar.Contollers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControllerMainMenu {

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
    private Button MainMenuCorrentDateButton;

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
    void initialize() {
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

