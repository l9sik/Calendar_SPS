module com.bestgroup.calendar {
    requires javafx.controls;
    requires javafx.fxml;

    requires javafx.graphics;
    requires javafx.base;
    //requires poi;
    requires java.desktop;
    requires java.logging;
    requires org.apache.poi.poi;

    opens com.bestgroup.calendar to javafx.fxml;
    exports com.bestgroup.calendar;
    exports com.bestgroup.calendar.controllers;
    opens com.bestgroup.calendar.controllers to javafx.fxml;
}