package com.bestgroup.calendar;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        //Parent fxmlLoader = FXMLLoader.load(getClass().getResource("com.bestgroup.calendar.Views.MainMenu.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MainMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 700);
        //Scene scene = new Scene(fxmlLoader, 400, 700);
        stage.setTitle("Попытка");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
