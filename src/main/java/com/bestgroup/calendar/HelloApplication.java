package com.bestgroup.calendar;

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
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500.0D, 600.0D);
        stage.setTitle("Calendar SPS");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Program is launched here
     * @param args
     */
    public static void main(String[] args) {
        launch();
    }

}
