package com.bestgroup.calendar;

import com.bestgroup.calendar.controllers.NewScene;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Main class
 * @version 1.0
 */
public class HelloApplication extends Application {
    /**
     *
     * @param stage
     * @throws IOException
     */
    @Override
    public void start(Stage stage) throws IOException {
        NewScene nw = new NewScene();
        nw.openNewScene("/com/bestgroup/calendar/hello-view.fxml");
    }

    /**
     * Program is launched here
     * @param args
     */
    public static void main(String[] args) {
        launch();
    }

}
