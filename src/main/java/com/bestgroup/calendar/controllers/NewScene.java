package com.bestgroup.calendar.controllers;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Class that helps in opening fxml files
 */
public class NewScene {
    /**
     * Method that opens fxml file by path
     *
     * @param path pass of fxml file
     */
    public void openNewScene(String path){
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource(path));
        javafx.scene.Scene scene = null;
        try {
            scene = new javafx.scene.Scene(fxmlLoader.load());
        } catch (IOException er) {
            System.err.println(er.getMessage());
        }
        Stage stage = new Stage();
        stage.setTitle("Calendar SPS");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    /**
     * Closes scene
     *
     * @param btn button from scene that should be closed
     */
    public void closeScene(Button btn){
        btn.getScene().getWindow().hide();
    }
}
