package com.bestgroup.calendar;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text Time;

    @FXML
    void initialize() {
        CurrentTime currentTime = new CurrentTime();
        Time.setText(currentTime.getCurrentTime());
    }
}

